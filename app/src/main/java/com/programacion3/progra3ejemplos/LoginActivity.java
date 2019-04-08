package com.programacion3.progra3ejemplos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    CheckBox checkBoxRememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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

    public void doLogin(View view){
        Toast.makeText(this, "Acabas de hacer login!!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, EjemploPatitoActivity.class);
        startActivity(intent);
    }
}
