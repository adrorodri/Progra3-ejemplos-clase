package com.programacion3.progra3ejemplos.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.gson.Gson;
import com.programacion3.progra3ejemplos.R;
import com.programacion3.progra3ejemplos.model.EstudianteUPB;

public class PasoParametrosActivity extends AppCompatActivity {

    EditText editTextParametro1;
    EditText editTextParametro2;
    CheckBox checkBoxParametro3;

    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paso_parametros);

        // Obtenemos la referencia de nuestros widgets del layout
        editTextParametro1 = findViewById(R.id.editTextParametro1);
        editTextParametro2 = findViewById(R.id.editTextParametro2);
        checkBoxParametro3 = findViewById(R.id.checkBoxParametro3);
    }

    public void pasarParametros(View view) {
        // Creamos un intent para pasar parametros
        Intent intent = new Intent(this, RecibirParametrosActivity.class);

        // Podemos pasar parametros con tipos de dato primitivos
        String parametro1 = editTextParametro1.getText().toString();
        String parametro2 = editTextParametro2.getText().toString();
        boolean parametro3 = checkBoxParametro3.isChecked();
        intent.putExtra("parametro1", parametro1);
        intent.putExtra("parametro2", parametro2);
        intent.putExtra("parametro3", parametro3);

        // Tambien podemos pasar objetos, siempre y cuando su clase implemente a Serializable
        EstudianteUPB estudianteUPB = new EstudianteUPB("Juan", "Perez", 12345);
        intent.putExtra("estudiante", this.gson.toJson(estudianteUPB));

        // Iniciamos un nuevo activity y esperamos un resultado de este (con el codigo de referencia 123)
        startActivityForResult(intent, 123);
    }


    // Esta funcion se llama automaticamente cuando el siguiente activity (que fue iniciado con startActivityForResult) se destruye
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // Verificamos el requestCode coincida con el requestCode
        switch (requestCode) {
            case 123: {
                if (resultCode == RESULT_OK) { // Si el resultado indica que todo esta OK, actualizamos el UI
                    String parametro1 = data.getStringExtra("parametro1");
                    editTextParametro1.setText(parametro1);
                }
                break;
            }
        }
    }
}
