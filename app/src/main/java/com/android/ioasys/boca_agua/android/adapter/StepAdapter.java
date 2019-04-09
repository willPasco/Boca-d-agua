package com.android.ioasys.boca_agua.android.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.ioasys.boca_agua.android.fragment.StepFragment_;
import com.android.ioasys.boca_agua.model.Step;

import java.util.List;

public class StepAdapter extends FragmentPagerAdapter {

    private List<Step> stepList;

    public StepAdapter(FragmentManager fm, List<Step> stepList) {
        super(fm);
        this.stepList = stepList;
    }

    @Override
    public Fragment getItem(int position) {
        return StepFragment_.builder().url(stepList.get(position).getVideoURL()).build();
    }

    @Override
    public int getCount() {
        return stepList == null ? 0 : stepList.size();
    }
}
