package com.mhelrigo.panahon.curentforecast.ui;

import static android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS;
import static com.mhelrigo.panahon.main.LocationPermissionContract.IS_GRANTED;
import static com.mhelrigo.panahon.main.LocationPermissionContract.LOCATION_PERMISSION_STATE_REQUEST_NAME;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.mhelrigo.data.di.RepositoryDependencyProvider;
import com.mhelrigo.domain.forecast.LocationProviderInteractor;
import com.mhelrigo.domain.forecast.entity.ForecastData;
import com.mhelrigo.domain.forecast.repository.ForecastRepository;
import com.mhelrigo.panahon.R;
import com.mhelrigo.panahon.main.LocationPermissionOperator;
import com.mhelrigo.panahon.curentforecast.core.LocationProviderImpl;
import com.mhelrigo.panahon.curentforecast.di.CurrentForecastDependencyProvider;
import com.mhelrigo.panahon.databinding.FragmentCurrentLocationForecastBinding;

import timber.log.Timber;

public class CurrentForecastFragment extends Fragment implements CurrentForecastUiContract.View {
    private FragmentCurrentLocationForecastBinding binding;

    private CurrentForecastUiContract.Presenter currentForecastPresenter;
    private CurrentViewModelImpl currentViewModel;
    private LocationProviderInteractor locationProviderInteractor;
    private ForecastRepository forecastRepository;

    private ActivityResultLauncher<Intent> detailsSettingsActivityResultLauncher;

    public CurrentForecastFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCurrentLocationForecastBinding.inflate(inflater);

        locationProviderInteractor = new LocationProviderImpl(getContext());
        forecastRepository = RepositoryDependencyProvider.provideForecastRepository(getContext());
        currentViewModel = new ViewModelProvider(this).get(CurrentViewModelImpl.class);
        currentForecastPresenter =
                CurrentForecastDependencyProvider
                        .currentForecastPresenter(currentViewModel, this, locationProviderInteractor, forecastRepository);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Glide.with(this)
                .load(R.drawable.loading)
                .into(binding.imageViewLoading);

        observeToData();
    }

    private void observeToData() {
        initFragmentResultListeners();
        initDataObservers();
        initViewEventListener();
        initDetailsSettingsActivityResultLauncher();
    }

    public void displayData(ForecastData forecastData) {
        binding.textViewLocation.setText(forecastData.getLocation().getName());
        binding.textViewDataTime.setText(forecastData.getLocation().getLocaltimeForDisplaying());
        binding.textViewTemperature.setText(forecastData.getCurrent().getTempCForDisplaying());
        binding.textViewCondition.setText(forecastData.getCurrent().getCondition().getText());
        binding.textViewFeelsLike.setText(forecastData.getCurrent().getFeelsLikeCForDisplaying());
        binding.textViewHumidity.setText(forecastData.getCurrent().getHumidityForDisplaying());
        binding.textViewDew.setText(forecastData.getCurrentHour().getDewPointCForDisplaying());
        binding.textViewHeatIndex.setText(forecastData.getCurrentHour().getHeatIndexCForDisplaying());
        binding.textViewUVIndex.setText(forecastData.getCurrent().getUv() + "");
        binding.textViewPressure.setText(forecastData.getCurrent().getPressureMb() + "");
        binding.textViewSunrise.setText(forecastData.getForecast().getForecastday().get(0).getAstro().getSunrise());
        binding.textViewSunset.setText(forecastData.getForecast().getForecastday().get(0).getAstro().getSunset());
    }

    public void initFragmentResultListeners() {
        getParentFragmentManager().setFragmentResultListener(LOCATION_PERMISSION_STATE_REQUEST_NAME, getViewLifecycleOwner(), (requestKey, result) -> {
            if (result.getBoolean(IS_GRANTED)) {
                getParentFragmentManager().clearFragmentResult(LOCATION_PERMISSION_STATE_REQUEST_NAME);
            }
            currentForecastPresenter.handleLocationPermissionStatus(result.getBoolean(IS_GRANTED));
        });
    }

    public void initDataObservers() {
        currentViewModel.forecastDataLiveData.observe(getViewLifecycleOwner(), forecastData -> {
            displayData(forecastData);
        });

        currentViewModel.currentForecastUiStateMutableLiveData.observe(getViewLifecycleOwner(), state -> {
            switch (state) {
                case RETRIEVING_LOCATION: {
                    binding.constraintLayoutLoading.setVisibility(View.VISIBLE);
                    binding.constraintLayoutEnableLocationPermission.setVisibility(View.GONE);
                    binding.constraintLayoutNoLocationRetrieved.setVisibility(View.GONE);
                    binding.constraintLayoutForecastData.setVisibility(View.GONE);
                    break;
                }
                case RETRIEVING_DATA: {
                    binding.constraintLayoutForecastData.setVisibility(View.VISIBLE);
                    binding.constraintLayoutNoLocationRetrieved.setVisibility(View.GONE);
                    binding.constraintLayoutEnableLocationPermission.setVisibility(View.GONE);
                    binding.constraintLayoutLoading.setVisibility(View.GONE);

                    break;
                }
                case NO_RETRIEVED_LOCATION: {
                    binding.constraintLayoutNoLocationRetrieved.setVisibility(View.VISIBLE);
                    binding.constraintLayoutEnableLocationPermission.setVisibility(View.GONE);
                    binding.constraintLayoutForecastData.setVisibility(View.GONE);
                    binding.constraintLayoutLoading.setVisibility(View.GONE);
                    break;
                }
                case RETRIEVING_LOCATION_NOT_PERMITTED: {
                    binding.constraintLayoutEnableLocationPermission.setVisibility(View.VISIBLE);
                    binding.constraintLayoutForecastData.setVisibility(View.GONE);
                    binding.constraintLayoutLoading.setVisibility(View.GONE);
                    break;
                }
            }
        });

        getContext().registerReceiver(broadcastReceiverLocationChanges, new IntentFilter(LocationManager.PROVIDERS_CHANGED_ACTION));
    }

    public void initViewEventListener() {
        binding.materialButtonEnableLocationPermission.setOnClickListener(v -> currentForecastPresenter.onGoToAppDetailSettings());
        binding.materialButtonEnableLocation.setOnClickListener(v -> currentForecastPresenter.onGoToLocationSettings());
    }

    public void initDetailsSettingsActivityResultLauncher() {
        detailsSettingsActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> currentForecastPresenter.handleLocationPermissionStatus(LocationPermissionOperator.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION, getContext())));
    }

    @Override
    public void navigateToAppDetailSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.fromParts("package", getContext().getPackageName(), null));
        detailsSettingsActivityResultLauncher.launch(intent);
    }

    @Override
    public void navigateToLocationSettings() {
        startActivity(new Intent(ACTION_LOCATION_SOURCE_SETTINGS));
    }

    private BroadcastReceiver broadcastReceiverLocationChanges = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().matches(LocationManager.PROVIDERS_CHANGED_ACTION)) {
                currentForecastPresenter.requestForCurrentLocation();
            }
        }
    };
}