package com.programacion3.progra3ejemplos.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.programacion3.progra3ejemplos.R;
import com.programacion3.progra3ejemplos.model.EstudianteUPB;

public class RecibirParametrosActivity extends AppCompatActivity {

    EditText editText;

    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibir_parametros);

        // Obtenemos los valores que nos paso el Intent que abrió este activity
        Intent intent = getIntent();
        String parametro1 = intent.getStringExtra("parametro1");
        String parametro2 = intent.getStringExtra("parametro2");
        boolean parametro3 = intent.getBooleanExtra("parametro3", false);

        // Podemos obtener el objeto estudiante que es serializable
        EstudianteUPB estudianteUPB = this.gson.fromJson(intent.getStringExtra("estudiante"), EstudianteUPB.class);

        // Actualizamos el UI
        TextView textView = findViewById(R.id.textViewParametros);
//        textView.setText(parametro1 + "\n" + parametro2 + "\n" + String.valueOf(parametro3));
        textView.setText(intent.getStringExtra("estudiante"));

        editText = findViewById(R.id.editTextEditarParametro1);
        editText.setText(parametro1);

        Toast.makeText(this, estudianteUPB.getNombre(), Toast.LENGTH_LONG).show();
    }

    // Podemos sobreescribir la funcionalidad del botón de back
    @Override
    public void onBackPressed() {
        // Creamos un Intent de respuesta
        Intent intent = new Intent();
        intent.putExtra("parametro1", editText.getText().toString());
        setResult(RESULT_OK, intent); // Indicamos un resultCode = OK (Tenemos otras opciones RESULT_OK, RESULT_CANCELLED, RESULT_FIRST_USER)
        finish(); // Finalizamos o destruimos manualmente nuestro activity. Este ya retornará el intent de resultado
    }
}
