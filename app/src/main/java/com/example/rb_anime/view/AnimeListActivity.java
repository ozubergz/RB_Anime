package com.example.rb_anime.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.rb_anime.adapter.AnimeAdapter;
import com.example.rb_anime.databinding.ActivityAnimeListBinding;
import com.example.rb_anime.model.AnimeModel;
import com.example.rb_anime.util.Constants;
import com.example.rb_anime.viewmodel.AnimeListViewModel;

import java.util.List;

public class AnimeListActivity extends AppCompatActivity {

    private ActivityAnimeListBinding binding;
    private AnimeListViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnimeListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(AnimeListViewModel.class);

        initView();
        initObservers();

        String animeTitle = getIntent().getStringExtra(Constants.ANIME_LIST_ACTIVITY_PARAM_STRING);

        viewModel.fetchAnimeList(animeTitle);
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.rvAnimeList.setLayoutManager(linearLayoutManager);
    }

    private void initObservers() {
        viewModel.getAnimeModels().observe(this, new Observer<List<AnimeModel>>() {
            @Override
            public void onChanged(List<AnimeModel> animeModels) {
                AnimeAdapter adapter = new AnimeAdapter(animeModels);
                binding.rvAnimeList.setAdapter(adapter);
            }
        });
    }
}
