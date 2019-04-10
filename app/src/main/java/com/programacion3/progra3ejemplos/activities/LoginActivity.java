package com.programacion3.progra3ejemplos.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.programacion3.progra3ejemplos.R;

public class LoginActivity extends AppCompatActivity {

    CheckBox checkBoxRememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Obtener la referencia de un objeto del Layout
        checkBoxRememberMe = findViewById(R.id.checkboxRememberMe);

        Log.d("LIFE_CYCLE", "ON CREATE");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LIFE_CYCLE", "ON START");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LIFE_CYCLE", "ON RESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LIFE_CYCLE", "ON PAUSE");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LIFE_CYCLE", "ON STOP");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LIFE_CYCLE", "ON RESTART");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LIFE_CYCLE", "ON DESTROY");
    }

    // Metodo que puede ser llamado desde onClick en algun elemento del layout, en este caso un botón
    public void doLogin(View view){
        Toast.makeText(this, "Acabas de hacer login!!", Toast.LENGTH_LONG).show();
        // Creamos un intent para ir a otro activity
        Intent intent = new Intent(this, EjemploPatitoActivity.class);
        startActivity(intent);
    }
}
