package com.example.spaarks;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class ItemViewModel extends ViewModel {
    private MutableLiveData<String> title = new MutableLiveData<>();
    private MutableLiveData<List<String>> images = new MutableLiveData<>(new ArrayList<>());


    public MutableLiveData<String> getTitle() {
        return title;
    }

    public MutableLiveData<List<String>> getImages() {
        return images;
    }
}
