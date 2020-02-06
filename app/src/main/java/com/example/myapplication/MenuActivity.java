package com.example.myapplication;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        crearCarpeta();
    }

    public void openCamera(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openNvegacion(View view){
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }

    //Creacion de la carpeta que será utilizada por la aplicación
    public void crearCarpeta(){
        File file = new File(Environment.getExternalStorageDirectory()+"/archivos/");
        if(!file.exists()){
            file.mkdirs();
            Toast.makeText(getApplicationContext(), "Creado: ", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Ya fue creado: "+file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        }
    }
}
