package com.march.turbojpeg;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        work();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        work();
    }

    private void work() {
        File fileSrc = new File(Environment.getExternalStorageDirectory(), "2.jpg");
        File fileDest = new File(Environment.getExternalStorageDirectory(), "3.jpg");

        Bitmap bitmap = BitmapFactory.decodeFile(fileSrc.getAbsolutePath());

        TurboJpegUtils.compress(bitmap, 100, fileDest.getAbsolutePath(), true);
    }


}
