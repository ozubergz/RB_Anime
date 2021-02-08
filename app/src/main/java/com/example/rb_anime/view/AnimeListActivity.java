package com.example.rb_anime.view;

import android.content.Intent;
import android.os.Bundle;

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

        initLinearView();
//        initGridView();
        initObservers();

        String animeTitle = getIntent().getStringExtra(Constants.ANIME_LIST_ACTIVITY_PARAM_STRING);

        viewModel.fetchAnimeSearchList(animeTitle);
    }

    private void initLinearView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.rvAnimeLinearList.setLayoutManager(linearLayoutManager);
    }

//    private void initGridView(){
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
//        binding.rvAnimeGridList.setLayoutManager(gridLayoutManager);
//    }

    private void initObservers() {
        viewModel.getAnimeModels().observe(this, new Observer<List<AnimeModel>>() {
            @Override
            public void onChanged(List<AnimeModel> animeModels) {

                AnimeListActivity.this.animeModels = animeModels;

                AnimeAdapter adapter = new AnimeAdapter(animeModels, AnimeListActivity.this);
                binding.rvAnimeLinearList.setAdapter(adapter);
//                binding.rvAnimeGridList.setAdapter(adapter);
            }
        });

    }

    @Override
    public void itemClick(int position) {
        AnimeModel animeModel = animeModels.get(position);

        Intent intent = new Intent(this, AnimeDetail.class);
        intent.putExtra(Constants.ANIME_SINGLE_ID, animeModel.getMalId());
        startActivity(intent);
    }
}
