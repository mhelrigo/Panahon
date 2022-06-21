package com.mhelrigo.domain.forecast;

import jdk.internal.vm.compiler.collections.Pair;

public interface LocationProviderInteractor {
    interface OnLocationReceived {
        void data(Double latitude, Double longitude);
        void dataInvalid();
    }
    void requestForCurrentLocation(OnLocationReceived onLocationReceived);
}
