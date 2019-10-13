package com.android.ioasys.boca_agua.android;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.ioasys.boca_agua.R;
import com.android.ioasys.boca_agua.viewmodel.InitialRequestViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitialRequestViewModel viewModel = ViewModelProviders.of(this).get(InitialRequestViewModel.class);

        final MutableLiveData<Integer> requestCode = viewModel.loadInitialContent();

        requestCode.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer code) {
                Log.i("Test", code+"");
                if (code == 200) {
                    RecipeListActivity_.intent(MainActivity.this).start();
                }
            }
        });
    }
}
