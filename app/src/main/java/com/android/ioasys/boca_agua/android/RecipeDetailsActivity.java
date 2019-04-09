package com.android.ioasys.boca_agua.android;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ioasys.boca_agua.R;
import com.android.ioasys.boca_agua.android.adapter.IngredientsRecyclerAdapter;
import com.android.ioasys.boca_agua.android.adapter.StepsRecyclerAdapter;
import com.android.ioasys.boca_agua.model.Recipe;
import com.android.ioasys.boca_agua.model.RecipeWithElements;
import com.android.ioasys.boca_agua.viewmodel.RecipeViewModel;
import com.bumptech.glide.Glide;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_recipe_details)
public class RecipeDetailsActivity extends AppCompatActivity {

    @ViewById(R.id.image_view_recipe_image)
    ImageView recipeImage;

    @ViewById(R.id.text_view_recipe_name)
    TextView recipeName;

    @ViewById(R.id.text_view_recipe_serving)
    TextView recipeServings;

    @ViewById(R.id.recycler_view_ingredients)
    RecyclerView recyclerViewIngredients;

    @ViewById(R.id.recycler_view_steps)
    RecyclerView recyclerViewSteps;

    @Extra
    int recipeId;

    @AfterViews
    void afterViews(){
        RecipeViewModel viewModel = ViewModelProviders.of(this).get(RecipeViewModel.class);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        final IngredientsRecyclerAdapter adapterIngredient = new IngredientsRecyclerAdapter();
        recyclerViewIngredients.setLayoutManager(linearLayoutManager);
        recyclerViewIngredients.setAdapter(adapterIngredient);

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        final StepsRecyclerAdapter adapterStep = new StepsRecyclerAdapter();
        recyclerViewSteps.setLayoutManager(linearLayoutManager);
        recyclerViewSteps.setAdapter(adapterStep);

        viewModel.getRecipeWithElements(recipeId).observe(this, new Observer<RecipeWithElements>() {
            @Override
            public void onChanged(@Nullable RecipeWithElements recipeWithElements) {
                Recipe recipe = recipeWithElements.getRecipe();

                Glide.with(RecipeDetailsActivity.this).load(recipe.getImage()).placeholder(R.drawable.ic_launcher_background).into(recipeImage);

                recipeName.setText(recipe.getName());
                recipeServings.setText(recipe.getServings()+"");

                adapterIngredient.insertAll(recipeWithElements.getIngredientList());
                adapterStep.insertAll(recipeWithElements.getStepsList());

            }
        });

    }
}
