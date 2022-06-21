package com.mhelrigo.data.di;

import static com.mhelrigo.data.di.NetworkDependencyProvider.provideRetrofit;

import android.content.Context;

import com.mhelrigo.data.forecast.ForecastRepositoryImpl;
import com.mhelrigo.data.forecast.datasource.local.LocalForecastDataSourceImpl;
import com.mhelrigo.data.forecast.datasource.remote.RemoteForecastDataSourceImpl;
import com.mhelrigo.domain.forecast.repository.RemoteForecastDataSource;
import com.mhelrigo.domain.forecast.repository.ForecastRepository;

public class RepositoryDependencyProvider {
   public static ForecastRepository provideForecastRepository(Context context) {
      return new ForecastRepositoryImpl(provideRemoteForecastDataSource(), provideLocalForecastDataSource(context));
   }

   public static RemoteForecastDataSource provideRemoteForecastDataSource() {
      return new RemoteForecastDataSourceImpl(provideRetrofit());
   }

   public static com.mhelrigo.domain.forecast.repository.LocalForecastDataSource provideLocalForecastDataSource(Context context) {
      return new LocalForecastDataSourceImpl(RoomDatabaseDependencyProvider.provideDatabase(context));
   }
}
