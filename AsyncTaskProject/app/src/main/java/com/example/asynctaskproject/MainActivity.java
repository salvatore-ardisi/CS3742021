package com.example.asynctaskproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.view_image);
        imageView = (ImageView)findViewById(R.id.my_image);
    }

    public void displayImage(View view) throws MalformedURLException {
        URL url = new URL("https://i0.wp.com/bam.trending-in.com/wp-content/uploads/2018/12/" +
                "heavy_d_the_boyz_973x600.jpg?fit=973%2C600&ssl=1");
        new ImageDownloader(imageView).execute();
    }
}
