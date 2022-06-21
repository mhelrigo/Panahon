package com.mhelrigo.panahon.curentforecast.core;

import static androidx.core.content.PermissionChecker.PERMISSION_DENIED;
import static com.google.android.gms.location.Priority.PRIORITY_BALANCED_POWER_ACCURACY;

import android.Manifest;
import android.content.Context;

import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.mhelrigo.domain.forecast.LocationProviderInteractor;

public class LocationProviderImpl implements LocationProviderInteractor {

    private FusedLocationProviderClient fusedLocationProviderClient;
    private Context context;

    public LocationProviderImpl(Context context) {
        this.context = context;

        fusedLocationProviderClient = new FusedLocationProviderClient(context);
    }

    @Override
    public void requestForCurrentLocation(OnLocationReceived onLocationReceived) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PERMISSION_DENIED) {
            return;
        }
        fusedLocationProviderClient.getCurrentLocation(PRIORITY_BALANCED_POWER_ACCURACY, null)
                .addOnSuccessListener(location -> {
                    if (location == null) {
                        onLocationReceived.dataInvalid();
                    } else {
                        onLocationReceived.data(location.getLatitude(), location.getLongitude());
                    }
                })
                .addOnFailureListener(e -> e.printStackTrace());
    }
}
