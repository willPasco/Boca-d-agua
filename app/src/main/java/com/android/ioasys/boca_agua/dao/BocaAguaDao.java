package com.android.ioasys.boca_agua.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import com.android.ioasys.boca_agua.model.Recipe;

import java.util.List;

@Dao
interface BocaAguaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<Recipe> recipes);
}
