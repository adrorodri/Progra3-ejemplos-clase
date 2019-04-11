package com.programacion3.progra3ejemplos.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.programacion3.progra3ejemplos.R;
import com.programacion3.progra3ejemplos.adapters.EstudiantesAdapter;
import com.programacion3.progra3ejemplos.model.EstudianteUPB;

import java.util.LinkedList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Obtenemos la referencia del ListView del layout
        ListView listView = findViewById(R.id.listViewEstudiantes);

        // Creamos y llenamos una lista de Estudiantes
        List<EstudianteUPB> listaEstudiantes = new LinkedList<>();
        listaEstudiantes.add(new EstudianteUPB("Pablo", "Perez", 1001, R.drawable.pollito));
        listaEstudiantes.add(new EstudianteUPB("Sergio", "Perez", 1002, R.drawable.upb));
        listaEstudiantes.add(new EstudianteUPB("Daniela", "Perez", 1003, R.drawable.pato_dolares));
        listaEstudiantes.add(new EstudianteUPB("Ivan", "Perez", 1004));
        listaEstudiantes.add(new EstudianteUPB("Andres", "Perez", 1005));
        listaEstudiantes.add(new EstudianteUPB("Miguel", "Perez", 1006));
        listaEstudiantes.add(new EstudianteUPB("Viviana", "Perez", 1007));
        listaEstudiantes.add(new EstudianteUPB("Saúl", "Perez", 1008));
        listaEstudiantes.add(new EstudianteUPB("Alberto", "Perez", 1009));

        // Creamos un objeto de nuestro Adapter, donde le pasamos contexto y la lista
        EstudiantesAdapter adapter = new EstudiantesAdapter(this, listaEstudiantes);

        // Asignamos el adapter al ListView de la pantalla
        listView.setAdapter(adapter);
    }
}
