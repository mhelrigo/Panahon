package com.mhelrigo.panahon.curentforecast.di;

import androidx.lifecycle.ViewModel;

import com.mhelrigo.domain.forecast.LocationProviderInteractor;
import com.mhelrigo.domain.forecast.repository.ForecastRepository;
import com.mhelrigo.domain.forecast.usecase.GetCurrentLocationUseCase;
import com.mhelrigo.domain.forecast.usecase.GetForecastUseCase;
import com.mhelrigo.panahon.curentforecast.ui.CurrentForecastUiContract;
import com.mhelrigo.panahon.curentforecast.ui.CurrentPresenterImpl;

public class CurrentForecastDependencyProvider {
    public static CurrentForecastUiContract.Presenter currentForecastPresenter(CurrentForecastUiContract.ViewModel viewModel,
                                                                               CurrentForecastUiContract.View view,
                                                                               LocationProviderInteractor locationProviderInteractor,
                                                                               ForecastRepository forecastRepository) {
        return new CurrentPresenterImpl(viewModel,
                view,
                new GetCurrentLocationUseCase(locationProviderInteractor),
                new GetForecastUseCase(forecastRepository));
    }
}
