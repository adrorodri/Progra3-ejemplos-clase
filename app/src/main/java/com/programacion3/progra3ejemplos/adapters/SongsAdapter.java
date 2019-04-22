package com.programacion3.progra3ejemplos.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.programacion3.progra3ejemplos.R;
import com.programacion3.progra3ejemplos.model.Song;

import java.util.List;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongViewHolder> {

    List<Song> songList;
    LayoutInflater inflater;

    public SongsAdapter(Context context, List<Song> songList) {
        this.songList = songList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public SongsAdapter.SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = this.inflater.inflate(R.layout.song_item, null);
        SongsAdapter.SongViewHolder songViewHolder = new SongsAdapter.SongViewHolder(view);
        return songViewHolder;
    }

    @Override
    public void onBindViewHolder(SongsAdapter.SongViewHolder holder, int position) {
        holder.textView.setText(this.songList.get(position).titulo);
    }

    @Override
    public int getItemCount() {
        return this.songList.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public SongViewHolder(View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.textViewTitulo);
        }
    }
}
