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
    private Button button;

//    https://user-images.githubusercontent.com/7751641/123351798-f7a49300-d52b-11eb-92c1-b15a357904ca.png

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.view_image);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageDownloader myImage = new ImageDownloader(com.example.asynctaskproject.MainActivity.this);
                myImage.execute("https://user-images.githubusercontent.com/7751641/123351798-f7a49300-d52b-11eb-92c1-b15a357904ca.png");
            }
        });
    }
}
