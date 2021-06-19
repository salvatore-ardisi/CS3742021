package com.example.fragmentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.fragmentapplication.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

//    private static final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

//        Log.d(TAG, "onCreate: started");
//        ImageView firstImage = (ImageView) findViewById(R.id.imageView);
//
//        int imageResource = getResources().getIdentifier("@drawable/alabama", null, this.getPackageName());
//        firstImage.setImageResource(imageResource);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}