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
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String BUNDLE_CURRENT_INDEX = "BUNDLE_CURRENT_INDEX";
    ImageView placeImageView;
    TextView textName;
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

    private int mPlaceName [] = {
            R.string.beach,
            R.string.bicycle,
            R.string.football,
            R.string.museum,
            R.string.resturant,
            R.string.running,
            R.string.shop,
            R.string.swimming,
            R.string.walking,
    };

    int mCurrentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        placeImageView = findViewById(R.id.image_place);
        textName = findViewById(R.id.text_name);
        Log.i(TAG,"Created");
        mRandom = new Random();
    }
    public void displayRandomPlace(View view) {
        if(mCurrentIndex < 9) {
            Log.d(TAG, "display =" + mCurrentIndex);
            mCurrentIndex = mRandom.nextInt(9);
            showImageAndTitle();
        }else {
            mCurrentIndex = -1;
        }
    }
    private void showImageAndTitle() {
        Drawable placeDrawable = ContextCompat.getDrawable(this,mPlacePictures[mCurrentIndex]);
        placeImageView.setImageDrawable(placeDrawable);
        textName.setText(mPlaceName[mCurrentIndex]);
    }

    public void next(View view) {
        if(mCurrentIndex < 8) {
            mCurrentIndex++;
            showImageAndTitle();
        }else {
            Toast.makeText(this, R.string.no_places_to_display, Toast.LENGTH_SHORT).show();
        }
    }

    public void prev(View view) {
        if(mCurrentIndex > 0) {
            mCurrentIndex--;
            showImageAndTitle();
        }else {
            Toast.makeText(this, R.string.no_places_to_display, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            Log.d(TAG, "display =" + mCurrentIndex);
            mCurrentIndex = savedInstanceState.getInt(BUNDLE_CURRENT_INDEX);
            if (mCurrentIndex != -1) {
                Log.d(TAG, "display =" + mCurrentIndex);
                showImageAndTitle();
            }
        }
        Log.i(TAG, "onRestoreInstanceInstanceState");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_CURRENT_INDEX,mCurrentIndex);
        Log.i(TAG,"onSaveInstanceState");

    }
}
