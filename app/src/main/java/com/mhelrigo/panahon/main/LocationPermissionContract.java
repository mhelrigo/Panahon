package com.mhelrigo.panahon.main;

public interface LocationPermissionContract {

    String LOCATION_PERMISSION_STATE_REQUEST_NAME = "LOCATION_PERMISSION_STATE_REQUEST_NAME";
    String IS_GRANTED = "IS_GRANTED";

    interface Presenter {
        void onInit();

        void onLocationPermissionGranted();

        void onLocationPermissionDenied();

        void showPermissionRationale();
    }

    interface View {
        void requestPermissionForLocation();

        void showLocationPermissionRationale(String title,
                                             String message);

        void permissionGranted(Boolean isGranted);
    }
}
