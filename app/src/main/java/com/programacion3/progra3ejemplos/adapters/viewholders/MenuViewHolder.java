package com.programacion3.progra3ejemplos.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.programacion3.progra3ejemplos.R;

public class MenuViewHolder extends RecyclerView.ViewHolder {

    public TextView textView;

    public MenuViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textViewMenuItem);
    }
}