package com.barmej.suggestaplace;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView placeImageView;
    TextView textName;
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String BUNDLE_CURRENT_INDEX = "BUNDLE_CURRENT_INDEX";
    private Random mRandom;



    int mPlacePictures [] = {
            R.drawable.beach,
            R.drawable.bike,
            R.drawable.football,
            R.drawable.museum,
            R.drawable.restaurant,
            R.drawable.running,
            R.drawable.shop,
            R.drawable.swimming,
            R.drawable.walking,
    };


    String mPlaceName [] ={
            "شاطئ","دراجة","كرة قدم","متحف","مطعم","الجري","السوق","السباحة","المشي"
    };

    int mCurrentIndex = -1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        placeImageView = findViewById(R.id.image_place);
        textName = findViewById(R.id.text_name);
        mRandom = new Random();

    }

    public void display(View view) {
        if(mCurrentIndex < 9) {
            Log.d(TAG, "display =" + mCurrentIndex);
            mCurrentIndex = mRandom.nextInt(9);
            showImage();
        }
    }
    private void showImage() {
        Drawable placeDrawable = ContextCompat.getDrawable(this,mPlacePictures[mCurrentIndex]);
        placeImageView.setImageDrawable(placeDrawable);
        textName.setText(mPlaceName[mCurrentIndex]);



    }


    public void next(View view) {
        if(mCurrentIndex < 8) {
            mCurrentIndex++;
            showImage();
        }
    }

    public void prev(View view) {
        if(mCurrentIndex > 0) {
            mCurrentIndex--;
            showImage();

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_CURRENT_INDEX,mCurrentIndex);
        Log.i(TAG,"onSaveInstanceState");

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            Log.d(TAG, "display =" + mCurrentIndex);
            mCurrentIndex = savedInstanceState.getInt(BUNDLE_CURRENT_INDEX);
            if (mCurrentIndex != -1) {
                Log.d(TAG, "display =" + mCurrentIndex);
                showImage();
            }
        }
        Log.i(TAG, "onRestoreInstanceInstanceState");
    }




    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"Restarted");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"Started");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"Resumed");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"Paused");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"Stopped");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"Destroyed");

    }
}
