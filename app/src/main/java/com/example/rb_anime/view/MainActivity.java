package com.example.rb_anime.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.rb_anime.databinding.ActivityMainBinding;
import com.example.rb_anime.util.Constants;
import com.example.rb_anime.viewmodel.AnimeListViewModel;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AnimeListViewModel viewModel;
    private MaterialButton btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initViews();
    }

    private void initViews() {
        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNextActivity();
            }
        });
    }

    private void startNextActivity() {
        String animeTitle = binding.etSearchBar.getText().toString().trim();

        if(!animeTitle.isEmpty()) {
            Intent intent = new Intent(this, AnimeListActivity.class);
            intent.putExtra(Constants.ANIME_LIST_ACTIVITY_PARAM_STRING, animeTitle);
            startActivity(intent);
        }
    }

}