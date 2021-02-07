package com.example.rb_anime.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.rb_anime.adapter.AnimeAdapter;
import com.example.rb_anime.adapter.AnimeClickListener;
import com.example.rb_anime.databinding.ActivityAnimeListBinding;
import com.example.rb_anime.model.AnimeModel;
import com.example.rb_anime.util.Constants;
import com.example.rb_anime.viewmodel.AnimeListViewModel;

import java.util.List;

public class AnimeListActivity extends AppCompatActivity implements AnimeClickListener {

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
                AnimeAdapter adapter = new AnimeAdapter(animeModels, AnimeListActivity.this);
                binding.rvAnimeList.setAdapter(adapter);
            }
        });
    }

    @Override
    public void itemClick(int position) {
        Toast.makeText(this, "" + position, Toast.LENGTH_SHORT).show();
    }
}
