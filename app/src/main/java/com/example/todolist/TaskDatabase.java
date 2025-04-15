package com.example.to_dolistapp;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

/**
 * TaskDatabase is a Room database class that holds the database.
 * It provides an instance of the TaskDao interface.
 */

@Database(entities = {Task.class}, version = 1)

public abstract class TaskDatabase extends RoomDatabase {
    private static TaskDatabase instance;
    public abstract TaskDao taskDao();
    public static synchronized TaskDatabase getInstance(Context context)
    {
        if (instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    TaskDatabase.class, "task_database")
                    .fallbackToDestructiveMigration() .build();
        }
        return instance;
    }
}