package com.android.ioasys.boca_agua;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.ioasys.boca_agua.model.Step;

import java.util.List;

class StepsRecyclerAdapter extends RecyclerView.Adapter<StepsRecyclerAdapter.BaseViewHolder> {

    private List<Step> stepList;

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.step_item, viewGroup, false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int position) {
        baseViewHolder.onBind(stepList.get(position));
    }

    @Override
    public int getItemCount() {
        return stepList == null ? 0 : stepList.size();
    }

    public void insertAll(List<Step> stepList){
        this.stepList = stepList;
        notifyDataSetChanged();
    }

    class BaseViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewStepTitle;
        private View itemView;

        BaseViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.textViewStepTitle = itemView.findViewById(R.id.text_view_step_title);
        }

        void onBind(final Step model) {
            textViewStepTitle.setText(model.getShortDescription());
        }
    }
}