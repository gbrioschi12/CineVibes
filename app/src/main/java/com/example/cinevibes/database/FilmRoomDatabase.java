package com.example.cinevibes.database;

import static com.example.cinevibes.util.Constants.DATABASE_VERSION;

import android.content.Context;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


import com.example.cinevibes.model.Film;
import com.example.cinevibes.util.Constants;
import com.example.cinevibes.util.Converters;



@TypeConverters(Converters.class)

@Database(entities = {Film.class}, version = DATABASE_VERSION, exportSchema = true)

public abstract class FilmRoomDatabase extends RoomDatabase {

    public abstract FilmDao filmDao();

    private static volatile FilmRoomDatabase INSTANCE;


    public static FilmRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FilmRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    FilmRoomDatabase.class, Constants.SAVED_FILMS_DATABASE)
                            .allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
