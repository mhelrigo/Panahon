package com.mhelrigo.panahon;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.mhelrigo.domain.forecast.entity.ForecastData;
import com.mhelrigo.domain.forecast.entity.Location;
import com.mhelrigo.panahon.curentforecast.ui.CurrentViewModelImpl;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class CurrentViewModelImplTest {
    private static Location LOCATION = new Location("2022-06-15 10:29", "Philippines", 1655260176, "Calamba", 121.17, "Laguna", 14.21, "Asia/Manila");

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    public CurrentViewModelImpl currentViewModel;

    @Before
    public void setUp() {
        currentViewModel = new CurrentViewModelImpl();
    }

    @Test
    public void testPersistForecastData() {
        ForecastData forecastData = new ForecastData();
        forecastData.setLocation(LOCATION);
        currentViewModel.persistForecastData(forecastData);

        currentViewModel.forecastDataLiveData.observeForever(forecastData1 -> {

        });

        TestCase.assertEquals(LOCATION.getLon(), currentViewModel.forecastDataLiveData.getValue().getLocation().getLon());
    }
}