package com.android.ioasys.boca_agua.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import com.android.ioasys.boca_agua.model.Recipe;
import com.android.ioasys.boca_agua.model.RecipeWithElements;
import com.android.ioasys.boca_agua.repository.RecipeRepository;

import java.util.List;

public class RecipeViewModel extends AndroidViewModel {

    private RecipeRepository repository;

    public RecipeViewModel(@NonNull Application application) {
        super(application);
        this.repository = new RecipeRepository(application);
    }


    public LiveData<List<Recipe>> getAllRecipes() {
        return repository.getAllRecipes();
    }

    public LiveData<RecipeWithElements> getRecipeWithElements(int id){
        return repository.getRecipeWithElements(id);
    }
}
