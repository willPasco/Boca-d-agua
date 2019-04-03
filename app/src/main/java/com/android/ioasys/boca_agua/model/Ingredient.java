package com.android.ioasys.boca_agua.model;

import android.arch.persistence.room.*;
import android.support.annotation.NonNull;

@Entity(tableName = "ingredient_table",foreignKeys = @ForeignKey(entity = Recipe.class,
        parentColumns = "id",
        childColumns = "recipe_id",
        onDelete = ForeignKey.CASCADE))
public class Ingredient {

    @ColumnInfo(name = "ingredient")
    @PrimaryKey
    @NonNull
    private String ingredient;
    @ColumnInfo(name = "quantity")
    private float quantity;
    @ColumnInfo(name = "measure")
    private String measure;
    @ColumnInfo(name = "recipe_id")
    private int recipeId;

    @Ignore
    public Ingredient() {
    }

    public Ingredient(float quantity, String measure,@NonNull String ingredient, int recipeId) {
        this.quantity = quantity;
        this.measure = measure;
        this.ingredient = ingredient;
        this.recipeId = recipeId;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "quantity=" + quantity +
                ", measure='" + measure + '\'' +
                ", ingredient='" + ingredient + '\'' +
                ", recipeId=" + recipeId +
                '}';
    }
}
