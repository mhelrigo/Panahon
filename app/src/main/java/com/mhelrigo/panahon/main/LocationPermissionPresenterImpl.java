package com.mhelrigo.panahon.main;

public class LocationPermissionPresenterImpl implements LocationPermissionContract.Presenter {

    private LocationPermissionContract.View view;

    public LocationPermissionPresenterImpl(LocationPermissionContract.View view) {
        this.view = view;
    }

    @Override
    public void onInit() {
        view.requestPermissionForLocation();
    }

    @Override
    public void onLocationPermissionGranted() {
        view.permissionGranted(true);
    }

    @Override
    public void onLocationPermissionDenied() {
        view.permissionGranted(false);
    }

    @Override
    public void showPermissionRationale() {
        view.showLocationPermissionRationale("You op-ted out on providing \"Panahon\" permission to access your location.",
                "Panahon application will not be able to give the data of your current location.\nWould you like to reconsider?.");
    }
}
