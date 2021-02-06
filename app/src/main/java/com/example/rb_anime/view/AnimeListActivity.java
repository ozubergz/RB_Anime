package com.example.rb_anime.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.rb_anime.databinding.ActivityAnimeListBinding;
import com.example.rb_anime.util.Constants;
import com.example.rb_anime.viewmodel.AnimeListViewModel;

public class AnimeListActivity extends AppCompatActivity {

    private ActivityAnimeListBinding binding;
    private AnimeListViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnimeListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(AnimeListViewModel.class);

        String animeTitle = getIntent().getStringExtra(Constants.ANIME_LIST_ACTIVITY_PARAM_STRING);

        viewModel.fetchAnimeList(animeTitle);
    }

}
