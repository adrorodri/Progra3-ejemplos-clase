package com.programacion3.progra3ejemplos.activities;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.programacion3.progra3ejemplos.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FilesActivity extends AppCompatActivity {

    TextView textViewArchivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);

        textViewArchivo = findViewById(R.id.textViewArchivo);
    }

    /**
     * Funcion para escribir un archivo en la memoria interna del telefono
     * @param view
     */
    public void escribirArchivo(View view) {
        try {
            // Hacemos referencia al archivo que queremos escribir, en este caso, en modo privado
            FileOutputStream fileOutputStream = openFileOutput("menuComidas.txt", MODE_PRIVATE);
            // Usamos el fileOutputStream para escribir los bytes
            fileOutputStream.write("cafe,15,100".getBytes());
            fileOutputStream.close();
            Toast.makeText(this, "Escritura correcta", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Funcion para leer un archivo de la memoria interna del telefono
     * @param view
     */
    public void leerArchivo(View view) {
        try {
            // Hacemos referencia al archivo que queremos leer del modo privado
            FileInputStream fileInputStream = openFileInput("menuComidas.txt");

            // Objetos que nos ayudarán a leer el archivo de manera progresiva
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Mientras haya nuevas lineas del archivo, entonces las leemos y las agregamos a un String Buffer
            StringBuffer stringBuffer = new StringBuffer();
            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }
            // Si la lectura fue correcta, entonces mostramos el Text View
            textViewArchivo.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Funcion para escribir un archivo de la memoria externa del telefono (tarjeta SD)
     * @param view
     */
    public void escribirArchivoSD(View view) {
        try {
            // Verificamos que la tarjeta SD exista y se pueda escribir
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                // La unica diferencia para obtener una referencia a un archivo de la memoria externa
                File file = new File(
                        Environment.getExternalStoragePublicDirectory(
                                Environment.DIRECTORY_DOCUMENTS),
                        "menuComidas.txt"
                );
                // Escribimos al igual que en la memoria interna
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write("hamburguesa,30,300".getBytes());
                fileOutputStream.close();
                Toast.makeText(this, "Escritura correcta", Toast.LENGTH_SHORT).show();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Funcion para leer un archivo de la memoria externa del telefono (tarjeta SD)
     * @param view
     */
    public void leerArchivoSD(View view) {
        try {
            // Verificamos que la tarjeta SD exista y se pueda leer
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                // La unica diferencia para obtener una referencia a un archivo de la memoria externa
                File file = new File(
                        Environment.getExternalStoragePublicDirectory(
                                Environment.DIRECTORY_DOCUMENTS),
                        "menuComidas.txt"
                );
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                // Leemos linea por linea el archivo
                StringBuffer stringBuffer = new StringBuffer();
                String lines;
                while ((lines = bufferedReader.readLine()) != null) {
                    stringBuffer.append(lines + "\n");
                }
                // Si fue correcta la lectura, entonces asignamos al textView el texto
                textViewArchivo.setText(stringBuffer.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
