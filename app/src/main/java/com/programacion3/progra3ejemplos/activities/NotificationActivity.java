package com.programacion3.progra3ejemplos.activities;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.programacion3.progra3ejemplos.R;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.popup_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Mostrar un Toast simple
     * @param view
     */
    public void mostrarToast(View view) {
        mostrarToast("Este es un Toast");
    }

    // Funcion para reutilizar en los otros ejemplos
    private void mostrarToast(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    /**
     * Mostrar un Toast con un Layout personalizado
     * @param view
     */
    public void mostrarCustomToast(View view) {
        Toast toast = new Toast(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View layout = inflater.inflate(R.layout.layout_custom_toast, null);
        toast.setView(layout);
        toast.show();
    }

    /**
     *  Mostrar un AlertDialog por defecto de android
     * @param view
     */
    public void mostrarDialog(View view) {
        AlertDialog.Builder alertDialogBuilder =
                new AlertDialog.Builder(this); // Es necesario crear un "builder" para agregarle opciones
        alertDialogBuilder.setTitle("Avast");
        alertDialogBuilder.setMessage("La base de datos de virus ha sido actualizada");
        alertDialogBuilder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(NotificationActivity.this, "Aceptaste", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialogBuilder.setCancelable(false);
        // Generamos nuestro AlertDialog desde el builder, y lo mostramos
        alertDialogBuilder.create().show();
    }


    /**
     * Mostrar un AlertDialog personalizado con un Layout
     * @param view
     */
    public void mostrarCustomDialog(View view) {
        AlertDialog.Builder alertDialogBuilder =
                new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View layout = inflater.inflate(R.layout.layout_custom_alert, null);
        alertDialogBuilder.setView(layout);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.create().show();
    }

    /**
     * Mostrar un menu emergente con elementos que podremos hacer click
     * @param view
     */
    public void mostrarPopup(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.elem1: {
                        mostrarToast("Elemento 1");
                        break;
                    }
                    case R.id.elem2: {
                        mostrarToast("Elemento 2");
                        break;
                    }
                    case R.id.elem3: {
                        mostrarToast("Elemento 3");
                        break;
                    }
                    case R.id.elem4: {
                        mostrarToast("Elemento 4");
                        break;
                    }
                }
                return true;
            }
        });
        popupMenu.show();
    }

    // Muesta un snackbar de la misma forma que un Toast
    public void mostrarSnackbar(View view) {
        Snackbar.make(view, "Esto es un snackbar", Snackbar.LENGTH_LONG).show();
    }
}
