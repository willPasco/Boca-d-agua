package com.android.ioasys.boca_agua.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.android.ioasys.boca_agua.model.Ingredient;
import com.android.ioasys.boca_agua.model.Recipe;
import com.android.ioasys.boca_agua.model.Step;

@Database(entities = {Recipe.class, Ingredient.class, Step.class}, version = 1)
public abstract class BocaAguaDatabase extends RoomDatabase {

    private static volatile BocaAguaDatabase INSTANCE;

    public static BocaAguaDatabase getDatabase(final Context context) {
        if(INSTANCE == null){
            synchronized (BocaAguaDatabase.class) {
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BocaAguaDatabase.class,
                            "boca_agua_database")
                            .build();
                }
            }
        }

        return INSTANCE;
    }

    public abstract BocaAguaDao getBocaAguaDao();
}
