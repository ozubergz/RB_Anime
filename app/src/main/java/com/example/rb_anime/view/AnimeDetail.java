package com.example.rb_anime.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rb_anime.databinding.ActivityAnimeDetailBinding;
import com.example.rb_anime.model.AnimeModel;
import com.example.rb_anime.util.Constants;

public class AnimeDetail extends AppCompatActivity {

    private ActivityAnimeDetailBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = ActivityAnimeDetailBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        AnimeModel animeModel = (AnimeModel) getIntent().getSerializableExtra(Constants.ANIME_SINGLE_PARAM_MODEL);

        binding.tvAnimeDetailTitle.setText(animeModel.getTitle());


    }
}
