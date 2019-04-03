package com.android.ioasys.boca_agua.service;

import com.android.ioasys.boca_agua.model.Recipe;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface BocaAguaService {

    @GET("/topher/2017/May/59121517_baking/baking.json")
    Call<List<Recipe>> getRecipes();
}
