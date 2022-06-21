package com.mhelrigo.domain.forecast.usecase;

import com.mhelrigo.domain.BaseUseCase;
import com.mhelrigo.domain.forecast.LocationProviderInteractor;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;

public class GetCurrentLocationUseCase extends BaseUseCase<Single<List<Double>>, Void> {

    private LocationProviderInteractor locationProviderInteractor;

    public GetCurrentLocationUseCase(LocationProviderInteractor locationProviderInteractor) {
        this.locationProviderInteractor = locationProviderInteractor;
    }

    @Override
    public Single<List<Double>> execute(Void unused) {
        return Single.create(new SingleOnSubscribe<List<Double>>() {
            @Override
            public void subscribe(@NonNull final SingleEmitter<List<Double>> emitter) throws Throwable {
                locationProviderInteractor.requestForCurrentLocation(new LocationProviderInteractor.OnLocationReceived() {
                    @Override
                    public void data(Double latitude, Double longitude) {
                        List<Double> coordinates = new ArrayList<>();
                        coordinates.add(latitude);
                        coordinates.add(longitude);
                        emitter.onSuccess(coordinates);
                    }

                    @Override
                    public void dataInvalid() {
                        emitter.onError(new IllegalArgumentException());
                    }
                });
            }
        });
    }
}
