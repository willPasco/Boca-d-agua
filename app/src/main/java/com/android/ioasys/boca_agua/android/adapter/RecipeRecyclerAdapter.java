package com.android.ioasys.boca_agua;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.ioasys.boca_agua.model.Recipe;

import java.util.List;

class RecipeRecyclerAdapter extends RecyclerView.Adapter<RecipeRecyclerAdapter.BaseViewHolder> {

    private List<Recipe> recipeList;

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recipe_item, viewGroup, false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int position) {
        baseViewHolder.onBind(recipeList.get(position));
    }

    @Override
    public int getItemCount() {
        return recipeList == null ? 0 : recipeList.size();
    }

    public void insertAll(List<Recipe> recipeList){
        this.recipeList = recipeList;
        notifyDataSetChanged();
    }

    class BaseViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewRecipeTitle;
        private View itemView;

        BaseViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.textViewRecipeTitle = itemView.findViewById(R.id.text_view_recipe_title);
        }

        void onBind(final Recipe model) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RecipeDetailsActivity_.intent(itemView.getContext()).recipeId(model.getId()).start();
                }
            });
            textViewRecipeTitle.setText(model.getName());
        }
    }
}
