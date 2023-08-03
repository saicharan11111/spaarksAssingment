    package com.example.spaarks;

import android.app.Application;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

    public class MainViewModel extends AndroidViewModel {
    private MutableLiveData<Boolean> showDialog = new MutableLiveData<>(false);
    private MutableLiveData<String> newTitle = new MutableLiveData<>();
        private List<ItemViewModel> items = new ArrayList<>();


    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getNewTitle() {
        return newTitle;
    }

    public void onFabClick(View view) {
        // Show the dialog when FAB is clicked
        showDialog.setValue(true);
    }


    public List<ItemViewModel> getItems() {
        return items;
    }

    public void addItem(ItemViewModel item) {
        items.add(item);
    }
    public void onAddTitleClick() {
        String title = newTitle.getValue();
        if (title != null && !title.isEmpty()) {
            addItemWithTitle(title);
            newTitle.setValue("");
            showDialog.setValue(false);
        }
    }

    private void addItemWithTitle(String title) {
        Toast.makeText(getApplication(),"item added",Toast.LENGTH_SHORT).show();
    }

    public MutableLiveData<Boolean> getShowDialog() {
        return showDialog;
    }
    public void onDialogDismissed() {

        showDialog.setValue(false);
    }
}
