package com.example.rb_anime.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rb_anime.databinding.AnimeItemLayoutBinding;
import com.example.rb_anime.model.AnimeModel;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.ViewHolder> {
    private List<AnimeModel> animeModels;

    public AnimeAdapter(List<AnimeModel> animeModels) {
        this.animeModels = animeModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AnimeItemLayoutBinding binding = AnimeItemLayoutBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AnimeModel animeModel = animeModels.get(position);
        holder.setAnime(animeModel);
    }

    @Override
    public int getItemCount() {
        return animeModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final AnimeItemLayoutBinding binding;

        public ViewHolder(AnimeItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setAnime(AnimeModel animeModel) {
            binding.tvAnimeTitle.setText(animeModel.getTitle());
            Glide.with(this.itemView).load(animeModel.getImageUrl()).into(binding.ivAnimeUrl);
        }
    }
}


