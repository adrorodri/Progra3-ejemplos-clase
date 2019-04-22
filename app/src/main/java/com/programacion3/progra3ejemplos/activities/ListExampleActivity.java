package com.programacion3.progra3ejemplos.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.programacion3.progra3ejemplos.R;
import com.programacion3.progra3ejemplos.model.Song;
import com.programacion3.progra3ejemplos.adapters.SongsAdapter;

import java.util.LinkedList;
import java.util.List;

public class ListExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_example);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        List<Song> songList = new LinkedList<>();
        songList.add(new Song("Bohemian Rhapsody", "Queen", R.drawable.bohemian));

        SongsAdapter adapter = new SongsAdapter(this, songList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
