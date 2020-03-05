package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.io.IOException;

public class CargarImg extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar_img);
        crearCarpeta();

    }

    public void crearCarpeta(){
       // File file = new File(Environment.getExternalStorageDirectory()+"/archivos/MyDesign3D/IMG_20200304_110721.jpg");
        File file = new File(Environment.getExternalStorageDirectory()+"/archivos/MyDesign3D/engrane.jpg");
        if(!file.exists()){
            Toast.makeText(getApplicationContext(), "No existe... ", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(getApplicationContext(), "Ya fue creado: "+file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 4;
            Bitmap bmp = BitmapFactory.decodeFile(file.getAbsolutePath());
            if (bmp == null) {
                Toast.makeText(getApplicationContext(), "Error... ", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "xdxd... ", Toast.LENGTH_SHORT).show();
                ImageView imageView = (ImageView) findViewById(R.id.imagenCargar);

                Mat img = null;

               // imageView.setImageBitmap(bmp);
                   // Utils.bitmapToMat(bmp, img);
                try{
                 img =  Utils.loadResource(getApplicationContext(), R.drawable.engrane);

                }catch (IOException e){
                    e.printStackTrace();
                }


                Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2BGRA);
                Mat img_result = img.clone();
                Imgproc.Canny(img, img_result, 80, 90);
                Bitmap img_bitmap = Bitmap.createBitmap(img_result.cols(), img_result.rows(),Bitmap.Config.ARGB_8888);
                Utils.matToBitmap(img_result, img_bitmap);
                imageView.setImageBitmap(img_bitmap);

               // bmp = null; //importante cerrar las referencias para que no se queden en memoria
            }
            file = null;
        }





    }
}

