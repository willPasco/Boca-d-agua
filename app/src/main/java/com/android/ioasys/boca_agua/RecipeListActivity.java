package com.android.ioasys.boca_agua;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.ioasys.boca_agua.model.Recipe;
import com.android.ioasys.boca_agua.viewmodel.RecipeViewModel;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EActivity(R.layout.activity_recipe_list)
public class RecipeListActivity extends AppCompatActivity {

    @ViewById(R.id.recycler_view)
    RecyclerView recyclerView;

    @AfterViews
    void afterViews() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        final RecipeRecyclerAdapter adapter = new RecipeRecyclerAdapter();
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        RecipeViewModel viewModel = ViewModelProviders.of(this).get(RecipeViewModel.class);

        viewModel.getRecipeLiveData().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(@Nullable List<Recipe> recipes) {
                adapter.insertAll(recipes);
            }
        });
    }

}
