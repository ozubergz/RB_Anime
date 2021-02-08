package com.example.rb_anime.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rb_anime.databinding.AnimeItemLayoutBinding;
import com.example.rb_anime.databinding.TopAnimeItemLayoutBinding;
import com.example.rb_anime.model.AnimeModel;
import com.example.rb_anime.model.TopAnimeModel;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<?> animeModels;
    private AnimeClickListener listener;

    private static int TYPE_ANIME_SEARCH_LAYOUT = 1;
    private static int TYPE_ANIME_TOP_LAYOUT = 2;

    public AnimeAdapter(List<?> animeModels, AnimeClickListener listener) {
        this.animeModels = animeModels;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        int type = 0;
        if(animeModels.get(position) instanceof AnimeModel) {
            type = TYPE_ANIME_SEARCH_LAYOUT;
        } else if(animeModels.get(position) instanceof TopAnimeModel) {
            type = TYPE_ANIME_TOP_LAYOUT;
        }
        return type;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == TYPE_ANIME_SEARCH_LAYOUT) {
            AnimeItemLayoutBinding binding = AnimeItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.getContext()), parent, false);
            return new AnimeItemLayoutViewHolder(binding, listener);
        } else {
            TopAnimeItemLayoutBinding binding = TopAnimeItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.getContext()), parent, false);
            return new TopAnimeLayoutViewHolder(binding, listener);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(getItemViewType(position) == TYPE_ANIME_SEARCH_LAYOUT) {
            AnimeModel animeModel = (AnimeModel) animeModels.get(position);
            ((AnimeItemLayoutViewHolder) holder).setAnime(animeModel);
        } else {
            TopAnimeModel topAnimeModel = (TopAnimeModel) animeModels.get(position);
            ((TopAnimeLayoutViewHolder) holder).setAnime(topAnimeModel);
        }
    }


    @Override
    public int getItemCount() {
        return animeModels.size();
    }

    public static class AnimeItemLayoutViewHolder extends RecyclerView.ViewHolder {
        private final AnimeItemLayoutBinding binding;
        private final AnimeClickListener listener;

        AnimeItemLayoutViewHolder(AnimeItemLayoutBinding binding, AnimeClickListener listener) {
            super(binding.getRoot());
            this.binding = binding;
            this.listener = listener;
        }

        public void setAnime(AnimeModel animeModel) {
            binding.tvAnimeTitle.setText(animeModel.getTitle());
            binding.tvAnimeSynopsis.setText(animeModel.getSynopsis());
            Glide.with(this.itemView).load(animeModel.getImageUrl()).into(binding.ivAnimeImg);

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null)
                        listener.itemClick(getAdapterPosition());
                }
            });
        }
    }

    public static class TopAnimeLayoutViewHolder extends RecyclerView.ViewHolder {
        private final TopAnimeItemLayoutBinding binding;
        private final AnimeClickListener listener;

        TopAnimeLayoutViewHolder(TopAnimeItemLayoutBinding binding, AnimeClickListener listener) {
            super(binding.getRoot());
            this.binding = binding;
            this.listener = listener;
        }

        public void setAnime(TopAnimeModel animeModel) {

            binding.tvTopAnimeTitle.setText(animeModel.getTitle());
            Glide.with(this.itemView).load(animeModel.getImageUrl()).into(binding.ivTopAnimeUrl);

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


