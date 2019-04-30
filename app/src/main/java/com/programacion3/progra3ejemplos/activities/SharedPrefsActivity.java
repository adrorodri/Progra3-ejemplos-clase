package com.programacion3.progra3ejemplos.activities;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.programacion3.progra3ejemplos.R;

public class SharedPrefsActivity extends AppCompatActivity {

    Switch sharedPrefsSwitch;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefs);

        sharedPrefsSwitch = findViewById(R.id.switchSharedPrefs);

        // Creamos nuestro objeto de Shared Preferences al inicio del Activity
        sharedPreferences = getSharedPreferences("DatosPrueba", MODE_PRIVATE);
    }

    public void escribir(View view) {
        // Obtenemos el valor actual de nuestro Switch
        boolean value = sharedPrefsSwitch.isChecked();

        // Abrimos nuestro Editor de Shared Preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // Escribimos los valores que necesitemos almacenar
        editor.putBoolean("switchValue", value);
        // Aplicamos y confirmamos los cambios.
        editor.apply();
        editor.commit();
    }

    public void leer(View view) {

        // Obtenemos el ultimo valor guardado del Switch de nuestro Shared Preferences
        boolean lastSwitchValue = sharedPreferences.getBoolean("switchValue", false);
        // Nuestra funcion para mostrar un Toast
        mostrarToast(String.valueOf(lastSwitchValue));
    }

    public void mostrarToast(String message) {
        // Mostraremos un custom toast con un textView dentro (Texto Grande)
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.layout_big_toast, null);

        TextView toastTextView = view.findViewById(R.id.toastText);
        toastTextView.setText(message);

        Toast toast = new Toast(this);
        toast.setView(view);
        toast.show();
    }
}
