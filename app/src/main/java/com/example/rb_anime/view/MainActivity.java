package com.example.rb_anime.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.rb_anime.adapter.AnimeAdapter;
import com.example.rb_anime.adapter.AnimeClickListener;
import com.example.rb_anime.databinding.ActivityMainBinding;
import com.example.rb_anime.model.TopAnimeModel;
import com.example.rb_anime.util.Constants;
import com.example.rb_anime.viewmodel.AnimeListViewModel;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AnimeClickListener {

    private ActivityMainBinding binding;
    private AnimeListViewModel viewModel;
    private List<TopAnimeModel> animeModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(AnimeListViewModel.class);

        viewModel.fetchTopAnimeList("anime", 1, "upcoming");

        initViews();
        initObservers();
    }

    private void initViews() {
        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNextActivity();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.rvAnimeList.setLayoutManager(linearLayoutManager);

    }

    private void initObservers() {
        viewModel.getTopAnimes().observe(this, new Observer<List<TopAnimeModel>>() {
            @Override
            public void onChanged(List<TopAnimeModel> animeModels) {
                MainActivity.this.animeModels = animeModels;

                AnimeAdapter adapter = new AnimeAdapter(animeModels, MainActivity.this);
                binding.rvAnimeList.setAdapter(adapter);
            }
        });

        viewModel.getFirstTopAnime().observe(this, new Observer<TopAnimeModel>() {
            @Override
            public void onChanged(TopAnimeModel topAnimeModel) {
                Glide.with(getApplicationContext()).load(topAnimeModel.getImageUrl()).into(binding.ivMainImg);
                binding.tvMainTitle.setText(topAnimeModel.getTitle());
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

    @Override
    public void itemClick(int position) {
        TopAnimeModel animeModel = animeModels.get(position);

        Intent intent = new Intent(this, AnimeDetail.class);
        intent.putExtra(Constants.ANIME_SINGLE_ID, animeModel.getMalId());
        startActivity(intent);
    }

}