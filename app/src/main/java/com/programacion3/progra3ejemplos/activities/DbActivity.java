package com.programacion3.progra3ejemplos.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.programacion3.progra3ejemplos.R;
import com.programacion3.progra3ejemplos.adapters.LoginAttemptsAdapter;
import com.programacion3.progra3ejemplos.controller.DbController;
import com.programacion3.progra3ejemplos.model.LoginAttempt;

import java.util.LinkedList;

public class DbActivity extends AppCompatActivity {

    String correctUsername = "upb";
    String correctPassword = "abr2904";

    EditText editTextUsername;
    EditText editTextPassword;

    DbController controller;
    ListView listView;

    LoginAttemptsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        listView = findViewById(R.id.listViewRegistros);

        adapter = new LoginAttemptsAdapter(this, new LinkedList<LoginAttempt>());
        listView.setAdapter(adapter);

        controller = new DbController(this, "LoginHistory.db", null, 1);
    }

    public void doLogin(View view) {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();
        if(username.equals(correctUsername) &&
                password.equals(correctPassword)) {
            controller.addLoginAttempt(username, password, true);
        } else {
            controller.addLoginAttempt(username, password, false);
            Toast.makeText(this, "Error de validacion", Toast.LENGTH_SHORT).show();
        }
        updateList();
    }

    public void doUpdate(View view) {
        String username = editTextUsername.getText().toString();
        controller.updateLoginAttemptName(username);
        updateList();
    }

    public void doDelete(View view) {
        String username = editTextUsername.getText().toString();
        controller.deleteLoginAttempts(username);
        updateList();
    }

    public void showList(View view) {
        updateList();
    }

    private void updateList() {
        adapter.setList(controller.selectAllLoginAttempts());
    }
}
