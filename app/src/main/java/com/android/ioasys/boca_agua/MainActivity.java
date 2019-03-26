package com.android.ioasys.boca_agua;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.android.ioasys.boca_agua.viewmodel.InitialRequestViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitialRequestViewModel viewModel = ViewModelProviders.of(this).get(InitialRequestViewModel.class);

        viewModel.loadInitialContent();
    }
}
