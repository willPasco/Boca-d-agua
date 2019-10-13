package com.android.ioasys.boca_agua.model;

import android.arch.persistence.room.*;
import retrofit2.http.Field;

import java.util.List;

@Entity(tableName = "recipe_table")
public class Recipe {

    @ColumnInfo(name = "id")
    @PrimaryKey
    private Integer id;
    @ColumnInfo(name = "name")
    private String name;
    @Ignore
    private List<Ingredient> ingredients = null;
    @Ignore
    private List<Step> steps = null;
    @ColumnInfo(name = "servings")
    private Integer servings;
    @ColumnInfo(name = "image")
    private String image;
    @ColumnInfo(name = "ingredient_id")
    private String ingredientId;
    @ColumnInfo(name = "step_id")
    private String stepId;

    @Ignore
    public Recipe(){
    }

    public Recipe(Integer id, String name, Integer servings, String image, String ingredientId, String stepId) {
        this.id = id;
        this.name = name;
        this.servings = servings;
        this.image = image;
        this.ingredientId = ingredientId;
        this.stepId = stepId;
    }

    public String getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(String ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", steps=" + steps +
                ", servings=" + servings +
                ", image='" + image + '\'' +
                ", ingredientId='" + ingredientId + '\'' +
                ", stepId='" + stepId + '\'' +
                '}';
    }
}

