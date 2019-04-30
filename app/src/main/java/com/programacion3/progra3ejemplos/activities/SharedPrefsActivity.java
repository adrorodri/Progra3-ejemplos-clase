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

        sharedPreferences = getSharedPreferences("DatosPrueba", MODE_PRIVATE);
    }

    public void escribir(View view) {
        boolean value = sharedPrefsSwitch.isChecked();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("switchValue", value);
        editor.apply();
        editor.commit();
    }

    public void leer(View view) {
        boolean lastSwitchValue = sharedPreferences.getBoolean("switchValue", false);
        mostrarToast(String.valueOf(lastSwitchValue));
    }

    public void mostrarToast(String message) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.layout_big_toast, null);

        TextView toastTextView = view.findViewById(R.id.toastText);
        toastTextView.setText(message);

        Toast toast = new Toast(this);
        toast.setView(view);
        toast.show();
    }
}
