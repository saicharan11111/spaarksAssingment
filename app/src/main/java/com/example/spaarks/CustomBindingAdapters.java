package com.example.spaarks;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomBindingAdapters {
    @BindingAdapter("app:items")
    public static void setItems(RecyclerView recyclerView, List<ItemViewModel> items) {
        RecyclerView.Adapter<?> adapter = recyclerView.getAdapter();
        if (adapter == null) {
            adapter = new MainAdapter(items); // Replace with your adapter class
            recyclerView.setAdapter(adapter);
        }

        // Update the list of items in the adapter and notify data changes
        if (adapter instanceof MainAdapter) {
            MainAdapter myAdapter = (MainAdapter) adapter;
            myAdapter.setItems(items);
        }
    }
    }
