package com.mhelrigo.panahon.main;

import static com.mhelrigo.panahon.main.LocationPermissionContract.IS_GRANTED;
import static com.mhelrigo.panahon.main.LocationPermissionContract.LOCATION_PERMISSION_STATE_REQUEST_NAME;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.Manifest;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.mhelrigo.panahon.R;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements LocationPermissionContract.View {

    private LocationPermissionContract.Presenter locationPermissionPresenter;

    private AlertDialog alertDialogCoarseLocation;
    private LocationPermissionOperator locationPermissionOperator;

    private NavHostFragment navHostFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);

        locationPermissionPresenter = new LocationPermissionPresenterImpl(this);
        initLocationPermissionOperator();
        locationPermissionPresenter.onInit();
    }

    private void initLocationPermissionOperator() {
        locationPermissionOperator = new LocationPermissionOperator(this, (String permissionName) -> {
            if (permissionName == Manifest.permission.ACCESS_FINE_LOCATION) {
                locationPermissionPresenter.showPermissionRationale();
            }
        }, new LocationPermissionOperator.Result() {
            @Override
            public void granted(String permissionName) {
                locationPermissionPresenter.onLocationPermissionGranted();
            }

            @Override
            public void denied(String permissionName) {
                locationPermissionPresenter.onLocationPermissionDenied();
            }
        });

        locationPermissionOperator.initListener();
    }

    @Override
    public void requestPermissionForLocation() {
        locationPermissionOperator.verifyIfGivenPermissionIsGranted(Manifest.permission.ACCESS_FINE_LOCATION);
    }

    @Override
    public void showLocationPermissionRationale(String title, String message) {
        if (alertDialogCoarseLocation != null) {
            if (alertDialogCoarseLocation.isShowing()) {
                return;
            }
        }

        alertDialogCoarseLocation =
                new MaterialAlertDialogBuilder(this)
                        .setTitle(title)
                        .setMessage(message)
                        .setPositiveButton("Okay, Allow it.", (dialog, which) -> locationPermissionOperator.requestPermission())
                        .setNegativeButton("No", (dialog, which) -> alertDialogCoarseLocation.cancel())
                        .show();
    }

    @Override
    public void permissionGranted(Boolean isGranted) {
        Bundle locationPermissionStateBundle = new Bundle();
        locationPermissionStateBundle.putBoolean(IS_GRANTED, isGranted);
        navHostFragment.getChildFragmentManager().setFragmentResult(LOCATION_PERMISSION_STATE_REQUEST_NAME, locationPermissionStateBundle);
    }
}