package com.android.ioasys.boca_agua.repository;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.ioasys.boca_agua.dao.BocaAguaDao;
import com.android.ioasys.boca_agua.dao.BocaAguaDatabase;
import com.android.ioasys.boca_agua.model.Ingredient;
import com.android.ioasys.boca_agua.model.Recipe;
import com.android.ioasys.boca_agua.model.Step;
import com.android.ioasys.boca_agua.service.BocaAguaService;
import com.android.ioasys.boca_agua.service.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class InitialRequestRepository {

    private static final int REQUEST_OK = 200;
    private static final String TAG = "InitialRequestRepo";
    private MutableLiveData<Integer> requestCodeMutableLiveData;
    private BocaAguaDao dao;

    public InitialRequestRepository(Application application) {
        this.requestCodeMutableLiveData = new MutableLiveData<>();
        BocaAguaDatabase db = BocaAguaDatabase.getDatabase(application);
        this.dao = db.getBocaAguaDao();
    }

    public MutableLiveData<Integer> loadInitialContent() {
        final BocaAguaService service = ServiceGenerator.createService(BocaAguaService.class);

        Call<List<Recipe>> call = service.getRecipes();

        call.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(@NonNull Call<List<Recipe>> call, @NonNull Response<List<Recipe>> response) {


                if (response.code() == REQUEST_OK) {

                    if (response.body() != null) {
                        List<Recipe> recipeList = response.body();

                        for (Recipe recipe : recipeList) {

                            new RecipeInsertAsyncTask().execute(recipe);

                            for (Step step : recipe.getSteps()) {
                                step.setRecipeId(recipe.getId());
                                new StepAsyncTask().execute(step);
                            }
                            for (Ingredient ingredient : recipe.getIngredients()) {
                                ingredient.setRecipeId(recipe.getId());
                                new IngredientAsyncTask().execute(ingredient);
                            }

                        }

                        requestCodeMutableLiveData.setValue(REQUEST_OK);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Recipe>> call, @NonNull Throwable error) {
                Log.i(TAG, error.getMessage());

            }
        });

        return requestCodeMutableLiveData;
    }

    @SuppressLint("StaticFieldLeak")
    private class RecipeInsertAsyncTask extends AsyncTask<Recipe, Void, Integer> {

        @Override
        protected final Integer doInBackground(Recipe... recipes) {
            dao.insertRecipe(recipes[0]);
            return 200;
        }

    }

    @SuppressLint("StaticFieldLeak")
    private class StepAsyncTask extends AsyncTask<Step, Void, Integer> {

        @Override
        protected final Integer doInBackground(Step... steps) {
            dao.insertStep(steps[0]);
            return 200;
        }

    }

    @SuppressLint("StaticFieldLeak")
    private class IngredientAsyncTask extends AsyncTask<Ingredient, Void, Integer> {

        @Override
        protected final Integer doInBackground(Ingredient... ingredients) {
            dao.insertIngredient(ingredients[0]);
            return 200;
        }

    }
}
