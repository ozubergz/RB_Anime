package com.example.rb_anime.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.rb_anime.R;
import com.example.rb_anime.viewmodel.MainViewModel;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private MaterialButton btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        btnClick = findViewById(R.id.btn_fetch);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setAnimeTitle("cowboybebop");
                viewModel.fetchAnimeList("cowboybebop");
            }
        });


    }
}