package com.android.ioasys.boca_agua.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import com.android.ioasys.boca_agua.repository.InitialRequestRepository;

public class InitialRequestViewModel extends AndroidViewModel {

    private InitialRequestRepository repository;

    public InitialRequestViewModel(Application application) {
        super(application);
        this.repository = new InitialRequestRepository(application);
    }

    public MutableLiveData<Integer> loadInitialContent() {
        return repository.loadInitialContent();
    }
}
