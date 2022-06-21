package com.mhelrigo.buildsrc;

public class Dependencies {
    public static class AndroidBuildDetails {
        public static final String APPLICATION_ID = "com.mhelrigo.panahon";
        public static final int COMPILED_SDK = 31;
        public static final int MIN_SDK = 21;
        public static final int TARGET_SDK = 31;
        public static final int VERSION_CODE = 1;
        public static final String VERSION_NAME = "0.0.1";

        public static class BuildTypes {
            public static final boolean IS_MINIFY = false;
        }
    }

    public static class AndroidX {
        public static final String APP_COMPAT = "androidx.appcompat:appcompat:1.4.1";
        public static final String CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.1.4";
        public static final String ACTIVITY = "androidx.activity:activity:1.4.0";

        private static final String LIFECYCLER_VERSION = "2.5.0-rc01";
        public static final String VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel:" + LIFECYCLER_VERSION;
        public static final String VIEW_MODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:" + LIFECYCLER_VERSION;

        private static final String NAVIGATION_VERSION = "2.4.2";
        public static final String NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment:" + NAVIGATION_VERSION;
        public static final String NAVIGATION_UI = "androidx.navigation:navigation-ui:" + NAVIGATION_VERSION;
    }

    public static class AndroidUi {
        public static final String MATERIAL_DESIGN = "com.google.android.material:material:1.6.1";

        private static final String GLIDE_VERSION = "4.13.0";
        public static final String GLIDE = "com.github.bumptech.glide:glide:" + GLIDE_VERSION;
        public static final String GLIDE_ANNOTATION_COMPILER = "com.github.bumptech.glide:compiler:" + GLIDE_VERSION;
    }

    public static class TestImpl {
        public static final String JUNIT = "junit:junit:4.13.2";
    }

    public static class AndroidTestImpl {
        public static final String EXT_JUNIT = "androidx.test.ext:junit:1.1.3";
        public static final String ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.4.0";
        public static final String TEST_CORE = "androidx.test:core:1.4.0";
        public static final String ROBOELECTRIC = "org.robolectric:robolectric:4.8.1";
        public static final String ARCH_CORE_TESTING = "androidx.arch.core:core-testing:2.1.0";
    }

    public static class NetworkConnection {
        private static final String VERSION = "2.9.0";
        public static final String RETROFIT = "com.squareup.retrofit2:retrofit:" + VERSION;
        public static final String GSON = "com.google.code.gson:gson:" + VERSION;
        public static final String RETROFIT_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:" + VERSION;
        public static final String RETROFIT_ADAPTER_RXJAVA3 = "com.squareup.retrofit2:adapter-rxjava3:" + VERSION;
        public static final String OKHTTP_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:4.4.0";
    }

    public static class RxJava {
        private static final String VERSION = "3.0.0";
        public static final String RX_ANDROID = "io.reactivex.rxjava3:rxandroid:" + VERSION;
        public static final String RX_JAVA = "io.reactivex.rxjava3:rxjava:" + VERSION;
    }

    public static class Room {
        private static final String VERSION = "2.4.2";
        public static final String ROOM_RUNTIME = "androidx.room:room-runtime:" + VERSION;
        public static final String ROOM_COMPILER = "androidx.room:room-compiler:" + VERSION;
        public static final String ROOM_RX_JAVA_3 = "androidx.room:room-rxjava3:" + VERSION;
        public static final String ROOM_TEST_HELPER = "androidx.room:room-testing:" + VERSION;
    }

    public static class GoogleServices {
        public static final String LOCATION = "com.google.android.gms:play-services-location:20.0.0";
    }

    public static class Logging {
        public static final String TIMBER = "com.jakewharton.timber:timber:4.7.1";
    }
}