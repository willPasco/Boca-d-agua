package com.android.ioasys.boca_agua.android;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.android.ioasys.boca_agua.R;
import com.android.ioasys.boca_agua.android.adapter.StepAdapter;
import com.android.ioasys.boca_agua.model.Step;
import com.google.android.exoplayer2.SimpleExoPlayer;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_step_activity)
public class StepActivity extends AppCompatActivity {

    @ViewById(R.id.view_pager)
    ViewPager viewPager;

    @Extra
    ArrayList<Step> stepList;

    @AfterViews
    void afterViews() {
        viewPager.setAdapter(new StepAdapter(getSupportFragmentManager(), stepList));
    }

}
