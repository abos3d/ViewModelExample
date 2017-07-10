package com.example.musab.viewmodelexample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by Musab on 7/10/17.
 */

/**
 * this our View Model which will be shared between two fragments.
 * <p>
 * if we need a context we can make our view model extends {@link android.arch.lifecycle.AndroidViewModel AndroidViewModel} and we will get our context throw constructor as a parameter
 */

public class SharedDataViewModel extends ViewModel {
    /**
     * Here we define live data of selected item the beautiful thing in live data is:
     * * we can observe on it so any change on it will trigger the observer
     * * it will respect the lifecycle of our app components
     */

    private final MutableLiveData<DummyContent.DummyItem> selected = new MutableLiveData<>();

    public void select(DummyContent.DummyItem item) {
        selected.setValue(item);
    }

    public LiveData<DummyContent.DummyItem> getSelected() {
        return selected;
    }
}
