package com.mhelrigo.data.di;

import android.content.Context;

import androidx.room.Room;

import com.mhelrigo.data.forecast.datasource.local.PanahonDatabase;

public class RoomDatabaseDependencyProvider {
    public static PanahonDatabase provideDatabase(Context context) {
        return Room.databaseBuilder(context, PanahonDatabase.class, PanahonDatabase.DATABASE_NAME).build();
    }
}
