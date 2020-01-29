package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void openCamera(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openNvegacion(View view){
        Intent intent = new Intent(this, MenuNavegacionActivity.class);
        startActivity(intent);
    }
}

/*
    <item
        android:id="@+id/ventanaUno"
        android:orderInCategory="100"
        android:tittle="@string/ventana1"
        app:showAsAction="never"
        />

    <item
        android:id="@+id/ventanaDos"
        android:orderInCategory="100"
        android:tittle="@string/ventana2"
        app:showAsAction="never"
        />

    <item
        android:id="@+id/ventanaTres"
        android:orderInCategory="100"
        android:tittle="@string/ventana3"
        app:showAsAction="never"
        />
 */
