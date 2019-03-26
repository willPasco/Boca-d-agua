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
    @Relation(parentColumn = "id", entityColumn = "ingredient_id", entity = Ingredient.class)
    private List<Ingredient> ingredients = null;
    @Relation(parentColumn = "id", entityColumn = "step_id", entity = Step.class)
    private List<Step> steps = null;
    @ColumnInfo(name = "servings")
    private Integer servings;
    @ColumnInfo(name = "image")
    private String image;

    @Ignore
    public Recipe(){
    }

    public Recipe(Integer id, String name, List<Ingredient> ingredients, List<Step> steps, Integer servings, String image) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
        this.servings = servings;
        this.image = image;
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
}

