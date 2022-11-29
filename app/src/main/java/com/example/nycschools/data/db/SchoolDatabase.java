package com.example.nycschools.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.nycschools.data.model.SchoolProfile;
import com.example.nycschools.data.model.SchoolSATScores;

/**
 * Actual DB class that is abstracted via Room API. Interactions happen via Data access objects.
 */
@Database(entities = {SchoolProfile.class, SchoolSATScores.class}, version = 1, exportSchema =
        false)
public abstract class SchoolDatabase extends RoomDatabase {

    public abstract SchoolProfileDao schoolProfileDao();

    public abstract SchoolSATScoresDao schoolSATScoresDao();

    private static volatile SchoolDatabase INSTANCE;

    public static SchoolDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (SchoolDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SchoolDatabase.class, "schools_db").build();
                }
            }
        }
        return INSTANCE;
    }
}
