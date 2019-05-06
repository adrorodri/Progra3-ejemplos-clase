package com.programacion3.progra3ejemplos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.programacion3.progra3ejemplos.R;
import com.programacion3.progra3ejemplos.model.EstudianteUPB;
import com.programacion3.progra3ejemplos.model.LoginAttempt;

import java.util.List;

public class LoginAttemptsAdapter extends BaseAdapter {

    private List<LoginAttempt> loginAttemptList;
    private LayoutInflater inflater;

    // Constructor que nos pide el contexto (Para crear el Layout Inflater) y una lista de estudiantes
    public LoginAttemptsAdapter(Context context, List<LoginAttempt> loginAttemptList) {
        this.loginAttemptList = loginAttemptList;
        inflater = LayoutInflater.from(context);
    }

    public void setList(List<LoginAttempt> loginAttemptList) {
        this.loginAttemptList = loginAttemptList;
        notifyDataSetChanged();
    }

    // Obtenemos la vista para cada elemento en la posicion correspondiente
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        // Obtenemos la vista para cada elemento mediante el Layout Inflater
        view = inflater.inflate(R.layout.layout_simple_text, null);

        // Asignamos los valores del elemento de la lista en los widgets correspondientes
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(loginAttemptList.get(position).usuario + "    " +
                String.valueOf(loginAttemptList.get(position).successful));

        // Retornamos la vista que contiene los datos ya mostrados
        return view;
    }

    // Obtener un elemento de la lista
    @Override
    public Object getItem(int position) {
        return loginAttemptList.get(position);
    }

    // Representa el total de elementos que mostrará
    @Override
    public int getCount() {
        return loginAttemptList.size();
    }

    // Obtener el identificador de cada elemento, no es usado en este ejemplo
    @Override
    public long getItemId(int position) {
        return 0;
    }
}
