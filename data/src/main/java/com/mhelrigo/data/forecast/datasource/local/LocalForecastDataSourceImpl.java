package com.mhelrigo.data.forecast.datasource.local;

import com.mhelrigo.data.forecast.datasource.local.model.ForecastdayItemDatabaseEntity;
import com.mhelrigo.domain.forecast.entity.Current;
import com.mhelrigo.domain.forecast.entity.Forecast;
import com.mhelrigo.domain.forecast.entity.ForecastData;
import com.mhelrigo.domain.forecast.entity.ForecastdayItem;
import com.mhelrigo.domain.forecast.entity.HourItem;
import com.mhelrigo.domain.forecast.entity.Location;
import com.mhelrigo.domain.forecast.repository.LocalForecastDataSource;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public class LocalForecastDataSourceImpl implements LocalForecastDataSource {

    private ForecastDao forecastDao;

    public LocalForecastDataSourceImpl(PanahonDatabase panahonDatabase) {
        forecastDao = panahonDatabase.forecastDao();
    }

    @Override
    public Single<Long> saveForecast(ForecastData forecastData) {
        return forecastDao.saveForecastData(Mapper.transform(forecastData));
    }

    @Override
    public Single<Long> saveCurrent(Current current, int forecastId) {
        return forecastDao.saveCurrent(Mapper.transform(current, forecastId));
    }

    @Override
    public Single<Long> saveLocation(Location location, int forecastId) {
        return forecastDao.saveLocation(Mapper.transform(location, forecastId));
    }

    @Override
    public Completable saveForecastData(Forecast forecast, int forecastId) {
        return forecastDao.saveForecast(Mapper.transform(forecast, forecastId))
                .map(id -> {
                    List<ForecastdayItem> forecastdayItems = new ArrayList<>();

                    for (ForecastdayItem forecastdayItem : forecast.getForecastday()) {
                        forecastdayItem.setForecastDataId(id.intValue());
                        forecastdayItems.add(forecastdayItem);
                    }

                    return forecastdayItems;
                })
                .flatMapObservable((Function<List<ForecastdayItem>, ObservableSource<ForecastdayItem>>)
                        forecastdayItems -> Observable.fromIterable(forecastdayItems))
                .concatMap(forecastDayItem -> saveForecastDayItem(forecastDayItem).toObservable())
                .toList()
                .ignoreElement();
    }

    @Override
    public Completable saveForecastDayItem(ForecastdayItem forecastdayItem) {
        return forecastDao.saveForecastDayItem(Mapper.transform(forecastdayItem))
                .map(id -> {
                    for (HourItem hourItem : forecastdayItem.getHour()) {
                        hourItem.setDayItemId(id.intValue());
                    }
                    return forecastdayItem.getHour();
                }).flatMapObservable((Function<List<HourItem>, ObservableSource<HourItem>>)
                        hourItems -> Observable.fromIterable(hourItems))
                .concatMap(hourItem -> saveForecastHourItem(hourItem).toObservable())
                .toList().ignoreElement();
    }

    @Override
    public Single<Long> saveForecastHourItem(HourItem hourItem) {
        return forecastDao.saveForecastHourItem(Mapper.transform(hourItem));
    }

    @Override
    public Single<ForecastData> getCachedForecastData() {
        return forecastDao.getForecastData()
                .concatMap(forecastData -> forecastDao.getCurrentForecast(forecastData.id)
                        .map(currentDatabaseEntity -> {
                            forecastData.setCurrent(currentDatabaseEntity);
                            return forecastData;
                        })
                )
                .concatMap(forecastData -> forecastDao.getLocationForecast(forecastData.id)
                        .map(locationDatabaseEntity -> {
                            forecastData.setLocation(locationDatabaseEntity);
                            return forecastData;
                        })
                )
                .concatMap(forecastData -> forecastDao.getForecast(forecastData.id)
                        .concatMap(forecastDatabaseEntity -> forecastDao.getForecastDayItem(forecastDatabaseEntity.id)
                                .flatMapObservable((Function<List<ForecastdayItemDatabaseEntity>, ObservableSource<ForecastdayItemDatabaseEntity>>)
                                        forecastdayItemDatabaseEntities -> Observable.fromIterable(forecastdayItemDatabaseEntities))
                                .concatMap(forecastdayItemDatabaseEntity -> forecastDao.getForecastHourItem(forecastdayItemDatabaseEntity.id)
                                        .map(hourItemDatabaseEntities -> {
                                            forecastdayItemDatabaseEntity.setHour(hourItemDatabaseEntities);
                                            return forecastdayItemDatabaseEntity;
                                        }).toObservable())
                                .toList()
                                .map(forecastdayItemDatabaseEntities -> {
                                    forecastDatabaseEntity.setForecastday(forecastdayItemDatabaseEntities);
                                    return forecastDatabaseEntity;
                                })
                        )
                        .map(forecastDatabaseEntity -> {
                            forecastData.setForecast(forecastDatabaseEntity);
                            return forecastData;
                        })
                ).map(forecastData -> Mapper.transform(forecastData));
    }

    @Override
    public Completable deleteAll() {
        return forecastDao.deleteForecast()
                .andThen(forecastDao.deleteForecastData())
                .andThen(forecastDao.deleteCurrentForecast())
                .andThen(forecastDao.deleteLocationForecast())
                .andThen(forecastDao.deleteCurrentForecast())
                .andThen(forecastDao.deleteForecastDayItem())
                .andThen(forecastDao.deleteForecastHourItem());
    }
}
