package com.android.ioasys.boca_agua.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import com.android.ioasys.boca_agua.dao.BocaAguaDao;
import com.android.ioasys.boca_agua.dao.BocaAguaDatabase;
import com.android.ioasys.boca_agua.model.Recipe;
import com.android.ioasys.boca_agua.model.RecipeWithElements;

import java.util.List;

public class RecipeRepository {

    private final BocaAguaDao dao;

    public RecipeRepository(Application application) {
        BocaAguaDatabase db = BocaAguaDatabase.getDatabase(application);
        this.dao = db.getBocaAguaDao();
    }

    public LiveData<List<Recipe>> getAllRecipes() {
        return dao.getAllRecipes();
    }

    public LiveData<RecipeWithElements> getRecipeWithElements(int id) {
        return dao.getRecipeWithElements(id);
    }
}
