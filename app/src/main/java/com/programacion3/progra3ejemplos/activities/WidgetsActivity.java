package com.programacion3.progra3ejemplos.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.programacion3.progra3ejemplos.R;

public class WidgetsActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    ImageView imageViewQueen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets);
        initViews();

        this.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean status) {
                if(status) {
                    Toast.makeText(WidgetsActivity.this, "Toggle Encendido", Toast.LENGTH_SHORT).show();
                    imageViewQueen.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                } else {
                    Toast.makeText(WidgetsActivity.this, "Toggle Apagado", Toast.LENGTH_SHORT).show();
                    imageViewQueen.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
            }
        });
    }

    private void initViews() {
        this.toggleButton = findViewById(R.id.toggleButton);
        this.imageViewQueen = findViewById(R.id.imageviewQueen);
    }
}
