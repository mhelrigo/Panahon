package com.mhelrigo.domain.di;

import com.mhelrigo.domain.forecast.repository.ForecastRepository;
import com.mhelrigo.domain.forecast.usecase.GetForecastUseCase;

public class UseCaseDependencyProvider {
    public static GetForecastUseCase provideGetForecastUseCase(ForecastRepository forecastRepository) {
        return new GetForecastUseCase(forecastRepository);
    }
}
