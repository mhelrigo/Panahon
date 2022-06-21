package com.mhelrigo.data.di;

import android.util.Log;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkDependencyProvider {
    protected static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://api.weatherapi.com/v1/")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getUnsafeOkHttpClient())
                .build();
    }

    private static OkHttpClient getUnsafeOkHttpClient() {

        try {
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, null, new SecureRandom());

            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            builder.readTimeout(5, TimeUnit.SECONDS);
            builder.connectTimeout(5, TimeUnit.SECONDS);
            builder.writeTimeout(5, TimeUnit.SECONDS);

            builder.sslSocketFactory(sslSocketFactory, new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[]{};
                }
            });
            builder.hostnameVerifier((hostname, session) -> true);

            // For displaying received result.
            /*HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            builder.addInterceptor(interceptor);*/

            OkHttpClient okHttpClient = builder.build();

            return okHttpClient;
        }catch (Exception e){
            Log.e("Exception okHttpClient", e.getMessage());
            return null;
        }
    }
}
