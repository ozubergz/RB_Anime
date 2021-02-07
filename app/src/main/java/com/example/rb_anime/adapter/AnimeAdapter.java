package com.example.rb_anime.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rb_anime.databinding.AnimeItemLayoutBinding;
import com.example.rb_anime.model.AnimeModel;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.ViewHolder> {
    private List<AnimeModel> animeModels;
    private AnimeClickListener listener;

    public AnimeAdapter(List<AnimeModel> animeModels, AnimeClickListener listener) {
        this.animeModels = animeModels;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AnimeItemLayoutBinding binding = AnimeItemLayoutBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding, listener);
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
        private final AnimeClickListener listener;

        public ViewHolder(AnimeItemLayoutBinding binding, AnimeClickListener listener) {
            super(binding.getRoot());
            this.binding = binding;
            this.listener = listener;
        }

        public void setAnime(AnimeModel animeModel) {
            binding.tvAnimeTitle.setText(animeModel.getTitle());
            Glide.with(this.itemView).load(animeModel.getImageUrl()).into(binding.ivAnimeUrl);

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null)
                        listener.itemClick(getAdapterPosition());
                }
            });
        }
    }
}


