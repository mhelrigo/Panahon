package com.mhelrigo.panahon.main;

import junit.framework.TestCase;

public class LocationPermissionPresenterImplTest extends TestCase {

    private FakeLocationPermissionView view;

    private static final String TITLE = "TITLE";
    private static final String MESSAGE = "MESSAGE";

    @Override
    public void setUp() throws Exception {
        view = new FakeLocationPermissionView();
        super.setUp();
    }

    public void testOnInit() {
        view.requestPermissionForLocation();
        assertTrue(view.isRequestedPermissionForLocation);
    }

    public void testOnLocationPermissionGranted() {
        view.permissionGranted(true);
        assertTrue(view.isPermissionGranted);
    }

    public void testOnLocationPermissionDenied() {
        view.permissionGranted(false);
        assertTrue(!view.isPermissionGranted);
    }

    public void testShowPermissionRationale() {
        view.showLocationPermissionRationale(TITLE, MESSAGE);
        assertEquals(TITLE, view.title);
        assertEquals(MESSAGE, view.message);
    }

    class FakeLocationPermissionView implements LocationPermissionContract.View {
        public Boolean isRequestedPermissionForLocation = false;
        public Boolean isPermissionGranted = false;

        public String title;
        public String message;

        @Override
        public void requestPermissionForLocation() {
            isRequestedPermissionForLocation = true;
        }

        @Override
        public void showLocationPermissionRationale(String title, String message) {
            this.title = title;
            this.message = message;
        }

        @Override
        public void permissionGranted(Boolean isGranted) {
            isPermissionGranted = isGranted;
        }
    }
}
