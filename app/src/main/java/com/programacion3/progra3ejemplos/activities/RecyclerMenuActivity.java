package com.programacion3.progra3ejemplos.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.programacion3.progra3ejemplos.R;
import com.programacion3.progra3ejemplos.adapters.RecyclerMenuAdapter;
import com.programacion3.progra3ejemplos.model.MenuItem;
import com.programacion3.progra3ejemplos.model.OnMenuItemClickListener;

import java.util.LinkedList;
import java.util.List;

public class RecyclerMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_menu);

        // Obtengo la referencia de mi RecyclerView del Layout
        RecyclerView recyclerView = findViewById(R.id.recyclerViewMenu);

        // Creo una lista de Menu Items:
        // cada uno tiene un titulo para mostrarse y una clase (Activity) al cual apuntan
        List<MenuItem> menuItems = new LinkedList<>();
        menuItems.add(new MenuItem("Absolute Layout", AbsoluteLayoutActivity.class));
        menuItems.add(new MenuItem("Ejemplo Patito", EjemploPatitoActivity.class));

        // Creamos un Adapter para el menu
        RecyclerMenuAdapter recyclerMenuAdapter = new RecyclerMenuAdapter(this, menuItems);

        // Seteamos la interfaz del adaptador para manejar el Click en uno de los Menu Items
        recyclerMenuAdapter.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(RecyclerMenuActivity.this, menuItem.getClase());
                startActivity(intent);
            }
        });

        // Seteamos el adaptador al RecyclerView
        recyclerView.setAdapter(recyclerMenuAdapter);
        // Seteamos un Layout Manager (Lineal en este caso) para el RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
