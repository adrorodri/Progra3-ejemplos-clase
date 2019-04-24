package com.programacion3.progra3ejemplos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

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
        menuItems.add(new MenuItem("Frame Layout", FrameLayoutActivity.class, "#e1f7d5"));
        menuItems.add(new MenuItem("Linear Layout", LinearLayoutActivity.class, "#ffbdbd"));
        menuItems.add(new MenuItem("Relative Layout", RelativeLayoutActivity.class, "#c9c9ff"));
        menuItems.add(new MenuItem("Table Layout", TableLayoutActivity.class, "#f1cbff"));
        menuItems.add(new MenuItem("Absolute Layout", AbsoluteLayoutActivity.class, "#e1f7d5"));
        menuItems.add(new MenuItem("Margin Padding", MarginPaddingActivity.class, "#ffbdbd"));
        menuItems.add(new MenuItem("Grid Layout", GridLayoutActivity.class, "#c9c9ff"));
        menuItems.add(new MenuItem("Ejemplo Login", LoginActivity.class, "#f1cbff"));
        menuItems.add(new MenuItem("Ejemplo Patito", EjemploPatitoActivity.class, "#e1f7d5"));
        menuItems.add(new MenuItem("Widgets/Events", WidgetsActivity.class, "#ffbdbd"));
        menuItems.add(new MenuItem("Programmatic Views", ProgramaticViewsActivity.class, "#c9c9ff"));
        menuItems.add(new MenuItem("Envio Parametros", PasoParametrosActivity.class, "#f1cbff"));
        menuItems.add(new MenuItem("Recepcion Parametros", RecibirParametrosActivity.class, "#e1f7d5"));
        menuItems.add(new MenuItem("Ejemplo Listas 1", ListActivity.class, "#ffbdbd"));
        menuItems.add(new MenuItem("Ejemplo Listas 2", ListExampleActivity.class, "#c9c9ff"));
        menuItems.add(new MenuItem("Intent Implicito", IntentImplicitoActivity.class, "#f1cbff"));
        menuItems.add(new MenuItem("Notificaciones", NotificationActivity.class, "#e1f7d5"));

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
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }
}
