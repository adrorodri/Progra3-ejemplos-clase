package com.programacion3.progra3ejemplos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.programacion3.progra3ejemplos.R;
import com.programacion3.progra3ejemplos.activities.EstudianteUPB;

import java.util.List;

public class EstudiantesAdapter extends BaseAdapter {

    private List<EstudianteUPB> estudianteUPBList;
    private LayoutInflater inflater;

    // Constructor que nos pide el contexto (Para crear el Layout Inflater) y una lista de estudiantes
    public EstudiantesAdapter(Context context, List<EstudianteUPB> estudianteUPBList) {
        this.estudianteUPBList = estudianteUPBList;
        inflater = LayoutInflater.from(context);
    }

    // Obtenemos la vista para cada elemento en la posicion correspondiente
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        // Obtenemos la vista para cada elemento mediante el Layout Inflater
        view = inflater.inflate(R.layout.layout_estudiante_upb, null);

        // Asignamos los valores del elemento de la lista en los widgets correspondientes
        TextView textView = view.findViewById(R.id.textViewNombreEstudiante);
        textView.setText(estudianteUPBList.get(position).getNombre());

        // Si tiene imagen, la asignamos
        if (estudianteUPBList.get(position).getFoto() > 0) {
            ImageView imageView = view.findViewById(R.id.imageViewEstudiante);
            imageView.setImageResource(estudianteUPBList.get(position).getFoto());
        }

        // Retornamos la vista que contiene los datos ya mostrados
        return view;
    }

    // Obtener un elemento de la lista
    @Override
    public Object getItem(int position) {
        return estudianteUPBList.get(position);
    }

    // Representa el total de elementos que mostrará
    @Override
    public int getCount() {
        return estudianteUPBList.size();
    }

    // Obtener el identificador de cada elemento, no es usado en este ejemplo
    @Override
    public long getItemId(int position) {
        return 0;
    }
}
