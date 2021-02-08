package com.example.rb_anime.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
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
    private List<AnimeModel> animeModels;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnimeListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(AnimeListViewModel.class);

        toggleViews();
        initLinearView();

        String animeTitle = getIntent().getStringExtra(Constants.ANIME_LIST_ACTIVITY_PARAM_STRING);
        viewModel.fetchAnimeSearchList(animeTitle);
    }

    private void toggleViews() {
        binding.btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initGridView();
            }
        });

        binding.btnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initLinearView();
            }
        });
    }

    private void initLinearView() {
        viewModel.getAnimeModels().observe(this, new Observer<List<AnimeModel>>() {
            @Override
            public void onChanged(List<AnimeModel> animeModels) {
                AnimeListActivity.this.animeModels = animeModels;
                AnimeAdapter adapter = new AnimeAdapter(animeModels, AnimeListActivity.this);

                binding.rvAnimeGridList.setVisibility(View.INVISIBLE);
                binding.rvAnimeLinearList.setVisibility(View.VISIBLE);

                adapter.setViewType(1);
                binding.rvAnimeLinearList.setAdapter(adapter);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.rvAnimeLinearList.setLayoutManager(linearLayoutManager);
    }

    private void initGridView() {
        viewModel.getAnimeModels().observe(this, new Observer<List<AnimeModel>>() {
            @Override
            public void onChanged(List<AnimeModel> animeModels) {
                AnimeListActivity.this.animeModels = animeModels;
                AnimeAdapter adapter = new AnimeAdapter(animeModels, AnimeListActivity.this);

                binding.rvAnimeGridList.setVisibility(View.VISIBLE);
                binding.rvAnimeLinearList.setVisibility(View.INVISIBLE);

                adapter.setViewType(0);
                binding.rvAnimeGridList.setAdapter(adapter);
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        binding.rvAnimeGridList.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void itemClick(int position) {
        AnimeModel animeModel = animeModels.get(position);

        Intent intent = new Intent(this, AnimeDetail.class);
        intent.putExtra(Constants.ANIME_SINGLE_ID, animeModel.getMalId());
        startActivity(intent);
    }
}
