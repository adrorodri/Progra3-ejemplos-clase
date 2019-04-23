package com.programacion3.progra3ejemplos.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.programacion3.progra3ejemplos.R;

public class IntentImplicitoActivity extends AppCompatActivity {

    Button button;
    ImageView imageView;
    private int REQUEST_IMAGE_CAPTURE = 123; // Request code para nuestro OnActivityResult de la camara

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_implicito);

        button = findViewById(R.id.buttonCompartir);
        imageView = findViewById(R.id.imageViewFoto);

        // Si este activity fue llamado por alguna otra aplicación, verificamos que nos llegó la información compartida
        Intent intent = getIntent();
        if (intent.getAction() != null &&
                intent.getAction().equals(Intent.ACTION_SEND) &&
                intent.getType() != null &&
                intent.getType().equals("text/plain")) {
            // Obtenemos el intent extra que se compartió
            Toast.makeText(this, intent.getStringExtra(Intent.EXTRA_TEXT), Toast.LENGTH_SHORT).show();
        }
    }

    // Método para compartir un texto desde nuestra app
    public void compartir(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Comparte nuesta App con tus amigos! www.playstorelink.com");
        intent.setType("text/plain");
        startActivity(intent);
    }

    // Método para abrir la aplicación de la cámara y obtener una imagen como resultado
    public void capturePhoto(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE); // Start activity for result para obtener el resultado de la foto
        }
    }

    // On Activity Result donde obtendremos la imagen de la cámara
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bitmap thumbnail = data.getParcelableExtra("data"); // Obtenemos el Bitmap (imagen) capturada

            // Mostramos nuestra imagen en el imageView
            imageView.setImageBitmap(thumbnail);
        }
    }
}
