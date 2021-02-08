package com.example.rb_anime.view;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.rb_anime.databinding.ActivityAnimeDetailBinding;
import com.example.rb_anime.model.AnimeModel;
import com.example.rb_anime.model.TopAnimeModel;
import com.example.rb_anime.util.Constants;
import com.example.rb_anime.viewmodel.AnimeListViewModel;

public class AnimeDetail extends AppCompatActivity {

    private AnimeListViewModel viewModel;
    private ActivityAnimeDetailBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = ActivityAnimeDetailBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(AnimeListViewModel.class);

        int id = getIntent().getIntExtra(Constants.ANIME_SINGLE_ID, 0);
        viewModel.fetchAnimeDetail(id);

        initObservers();

        binding.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
    }

    private void initObservers() {
        viewModel.getAnime().observe(this, new Observer<AnimeModel>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onChanged(AnimeModel animeModel) {
                Glide.with(getApplicationContext()).load(animeModel.getImageUrl()).into(binding.ivAnimeDetailImg);
                binding.tvAnimeDetailTitle.setText(animeModel.getTitle());
                binding.tvAnimeDetailSynopsis.setText(animeModel.getSynopsis());
                binding.tvJapaneseTitle.setText(animeModel.getTitleJapanese());
            }
        });
    }
}
