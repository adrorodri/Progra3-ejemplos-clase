package com.programacion3.progra3ejemplos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class ProgramaticViewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programatic_views);

        // Obtenemos el elemento padre (tiene id)
        final LinearLayout parent = findViewById(R.id.parent);
        parent.setOrientation(LinearLayout.VERTICAL);

        // Creamos Boton 1
        Button button = new Button(this);
        button.setText("Bienvenidos");
        parent.addView(button); // Agregamos al elemento padre

        // Creamos Boton 2
        final Button button2 = new Button(this);
        button2.setText("Bienvenidos 2");
        // Podemos agregar un listener (interfaz) a nuestro boton y ejecutar algo cuando se haga click
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox checkBox = new CheckBox(ProgramaticViewsActivity.this);
                checkBox.setText("Recuerdameee");
                parent.addView(checkBox);
            }
        });
        parent.addView(button2); // Agregamos al elemento padre
    }
}
