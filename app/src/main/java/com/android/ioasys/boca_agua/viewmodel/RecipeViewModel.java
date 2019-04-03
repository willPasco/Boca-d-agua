package com.android.ioasys.boca_agua.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import com.android.ioasys.boca_agua.model.Recipe;
import com.android.ioasys.boca_agua.repository.RecipeRepository;

import java.util.List;

public class RecipeViewModel extends AndroidViewModel {

    private RecipeRepository repository;
    private LiveData<List<Recipe>> recipeLiveData;

    public RecipeViewModel(@NonNull Application application) {
        super(application);
        this.repository = new RecipeRepository(application);
        this.recipeLiveData = repository.getAllRecipes();
    }


    public LiveData<List<Recipe>> getRecipeLiveData() {
        return recipeLiveData;
    }
}
