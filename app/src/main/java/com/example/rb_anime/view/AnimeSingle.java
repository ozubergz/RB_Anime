package com.example.rb_anime.view;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rb_anime.databinding.ActivityAnimeSingleBinding;
import com.example.rb_anime.model.AnimeModel;
import com.example.rb_anime.util.Constants;

public class AnimeSingle extends AppCompatActivity {

    private ActivityAnimeSingleBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = ActivityAnimeSingleBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        AnimeModel animeModel = (AnimeModel) getIntent().getSerializableExtra(Constants.ANIME_SINGLE_PARAM_MODEL);

        binding.tvTitle.setText(animeModel.getTitle());


    }
}
