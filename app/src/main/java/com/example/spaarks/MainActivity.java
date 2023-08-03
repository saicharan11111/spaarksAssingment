package com.example.spaarks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.spaarks.databinding.ActivityMainBinding;
import com.example.spaarks.databinding.DialogAddItemBinding;

public class MainActivity extends AppCompatActivity {
    private MainViewModel viewModel;
    private MainAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        viewModel.getShowDialog().observe(this, showDialog -> {
            if (showDialog) {
                showDialog();
            }

        });

        adapter = new MainAdapter(viewModel.getItems());
        binding.mainRecyclerView.setAdapter(adapter);
    }

    private void showDialog() {
        DialogAddItemBinding dialogBinding = DialogAddItemBinding.inflate(getLayoutInflater());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogBinding.getRoot());

        AlertDialog dialog = builder.create();
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
        dialog.dismiss();
            }
        });
        dialogBinding.setViewModel(viewModel);
        dialogBinding.setLifecycleOwner(this);

        dialog.show();
    }



}