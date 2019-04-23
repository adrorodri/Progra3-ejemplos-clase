package com.programacion3.progra3ejemplos.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.programacion3.progra3ejemplos.R;
import com.programacion3.progra3ejemplos.adapters.viewholders.MenuViewHolder;
import com.programacion3.progra3ejemplos.model.MenuItem;
import com.programacion3.progra3ejemplos.model.OnMenuItemClickListener;

import java.util.List;

public class RecyclerMenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {

    Context context;
    List<MenuItem> menuItemList;
    LayoutInflater inflater;

    // Declaramos nuestra interfaz
    OnMenuItemClickListener onMenuItemClickListener;

    // Constructor que nos pide Contexto y una lista de MenuItems
    public RecyclerMenuAdapter(Context context, List<MenuItem> menuItemList) {
        this.context = context;
        this.menuItemList = menuItemList;
        this.inflater = LayoutInflater.from(context);
    }


    // Método que se llama una sola vez al crear un ViewHolder (Recuerda que se reciclan y
    // casi siempre solo se crearán la primera vez)
    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = this.inflater.inflate(R.layout.layout_menu_item, null);
        return new MenuViewHolder(view);
    }

    // Método que se llama cuando se recicla una de los ViewHolders, para actualizar sus datos con los
    // de la posición indicada
    @Override
    public void onBindViewHolder(MenuViewHolder holder, final int position) {
        // Actualizamos el textview con el texto
        holder.textView.setText(this.menuItemList.get(position).getTitulo());
        // Creamos un Click Listener al textview que llame a nuestra interfaz OnMenuItemClickListener
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Llamamos a la interfaz con el MenuItem de la posicion clickeada
                onMenuItemClickListener.onMenuItemClick(menuItemList.get(position));
            }
        });
        // Background Color del item
        holder.itemView.setBackgroundColor(Color.parseColor(menuItemList.get(position).getColor()));
    }

    // Cantidad Total de items
    @Override
    public int getItemCount() {
        return this.menuItemList.size();
    }

    // Setter para nuestra interfaz
    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.onMenuItemClickListener = onMenuItemClickListener;
    }

    // Definimos la clase de nuestro ViewHolder en un archivo diferente
}
