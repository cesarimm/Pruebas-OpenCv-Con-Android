package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.io.IOException;

public class CargarImg extends AppCompatActivity {

    ImageView imageView;
    Bitmap grayBitmap, imagenBitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar_img);

        imageView = (ImageView) findViewById(R.id.imagenCargar);
        OpenCVLoader.initDebug();
        crearCarpeta();

    }

    public void crearCarpeta() {
        // File file = new File(Environment.getExternalStorageDirectory()+"/archivos/MyDesign3D/IMG_20200304_110721.jpg");
        File file = new File(Environment.getExternalStorageDirectory() + "/archivos/MyDesign3D/engrane.jpg");
        if (!file.exists()) {
            Toast.makeText(getApplicationContext(), "No existe... ", Toast.LENGTH_SHORT).show();
        } else {
            Uri uri = Uri.parse(file.getAbsolutePath());


            try{
                imagenBitmap =BitmapFactory.decodeFile(file.getAbsolutePath());
            }catch (Exception e){
                e.printStackTrace();
            }

            imageView.setImageBitmap(imagenBitmap);

            grayBitmap = Bitmap.createBitmap(imagenBitmap.getWidth(), imagenBitmap.getHeight(), Bitmap.Config.RGB_565);


            Mat rgba = new Mat();
            Mat grayMat = new Mat();

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDither = false;
            options.inSampleSize = 4;


            //BITMAP TO MAP
            Utils.bitmapToMat(imagenBitmap, rgba);
            Imgproc.cvtColor(rgba,grayMat,Imgproc.COLOR_RGB2BGRA);
            Imgproc.Canny(grayMat, rgba, 80, 90);

            Utils.matToBitmap(rgba, this.grayBitmap);
            imageView.setImageBitmap(this.grayBitmap);

        }
        file = null;
    }


    public void crearCarpeta2(){
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
                imageView = (ImageView) findViewById(R.id.imagenCargar);

                Mat img = null;

               // imageView.setImageBitmap(bmp);
                   // Utils.bitmapToMat(bmp, img);



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

