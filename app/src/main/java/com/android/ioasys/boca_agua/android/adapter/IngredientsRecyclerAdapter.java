package com.android.ioasys.boca_agua.android.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.ioasys.boca_agua.R;
import com.android.ioasys.boca_agua.model.Ingredient;

import java.util.List;

public class IngredientsRecyclerAdapter extends RecyclerView.Adapter<IngredientsRecyclerAdapter.BaseViewHolder> {

    private List<Ingredient> ingredientList;

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ingredient_item, viewGroup, false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int position) {
        baseViewHolder.onBind(ingredientList.get(position));
    }

    @Override
    public int getItemCount() {
        return ingredientList == null ? 0 : ingredientList.size();
    }

    public void insertAll(List<Ingredient> ingredientList){
        this.ingredientList = ingredientList;
        notifyDataSetChanged();
    }

    class BaseViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewIngredient;
        private View itemView;

        BaseViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.textViewIngredient = itemView.findViewById(R.id.text_view_ingredient);
        }

        void onBind(final Ingredient model) {
            String ingredient = model.getQuantity()+" "+model.getMeasure() +" "+model.getIngredient();
            textViewIngredient.setText(ingredient);
        }
    }
}
