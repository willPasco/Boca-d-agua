package com.android.ioasys.boca_agua.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import com.android.ioasys.boca_agua.dao.BocaAguaDao;
import com.android.ioasys.boca_agua.dao.BocaAguaDatabase;
import com.android.ioasys.boca_agua.model.Recipe;

import java.util.List;

public class RecipeRepository {

    private final BocaAguaDao dao;
    private LiveData<List<Recipe>> recipeListLiveData;

    public RecipeRepository(Application application) {
        BocaAguaDatabase db = BocaAguaDatabase.getDatabase(application);
        this.dao = db.getBocaAguaDao();
        this.recipeListLiveData = dao.getAllRecipes();
    }

    public LiveData<List<Recipe>> getAllRecipes() {
        return recipeListLiveData;
    }
}
