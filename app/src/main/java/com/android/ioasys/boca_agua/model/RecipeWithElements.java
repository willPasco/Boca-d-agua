package com.android.ioasys.boca_agua.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class RecipeWithElements {

    @Embedded
    private Recipe recipe;

    @Relation(parentColumn = "id", entityColumn = "recipe_id", entity = Ingredient.class)
    private List<Ingredient> ingredientList;

    @Relation(parentColumn = "id", entityColumn = "recipe_id", entity = Step.class)
    private List<Step> stepsList;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public List<Step> getStepsList() {
        return stepsList;
    }

    public void setStepsList(List<Step> stepsList) {
        this.stepsList = stepsList;
    }
}
