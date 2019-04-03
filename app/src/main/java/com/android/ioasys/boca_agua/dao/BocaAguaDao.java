package com.android.ioasys.boca_agua.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.android.ioasys.boca_agua.model.Ingredient;
import com.android.ioasys.boca_agua.model.Recipe;
import com.android.ioasys.boca_agua.model.Step;

import java.util.List;

@Dao
public interface BocaAguaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertRecipe(Recipe recipe);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertStep(Step step);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertIngredient(Ingredient ingredient);

    @Query("SELECT * FROM recipe_table ORDER by id ASC")
    LiveData<List<Recipe>> getAllRecipes();
}
