package com.mhelrigo.domain.forecast.usecase;

import com.mhelrigo.domain.BaseUseCase;
import com.mhelrigo.domain.forecast.entity.ForecastData;
import com.mhelrigo.domain.forecast.repository.ForecastRepository;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class GetForecastUseCase extends BaseUseCase<Single<ForecastData>, GetForecastUseCase.Params> {
    public static class Params {
        private final String location;
        private final int dayRange;
        private final String getAirQuality;
        private final String getAlerts;

        private Params(String location, int dayRange, String getAirQuality, String getAlerts) {
            this.location = location;
            this.dayRange = dayRange;
            this.getAirQuality = getAirQuality;
            this.getAlerts = getAlerts;
        }

        public static Params setter(String location, int dayRange, String getAirQuality, String getAlerts) {
            return new Params(location, dayRange, getAirQuality, getAlerts);
        }
    }

    private ForecastRepository forecastRepository;

    public GetForecastUseCase(ForecastRepository forecastRepository) {
        this.forecastRepository = forecastRepository;
    }

    @Override
    public Single<ForecastData> execute(GetForecastUseCase.Params params) {
        return forecastRepository.fetchForecastData(params.location, params.dayRange, params.getAirQuality, params.getAlerts)
                .map(new Function<ForecastData, ForecastData>() {
                    @Override
                    public ForecastData apply(ForecastData forecastData) throws Throwable {
                        if (forecastData.getForecast() != null) {
                            forecastData.setCurrentHour(forecastData.findCurrentHour());
                        }
                        return forecastData;
                    }
                }).subscribeOn(Schedulers.io());
    }
}
