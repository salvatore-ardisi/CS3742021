package com.example.ardisisalvatoremidterm2021v1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int meters = 0;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void convertToMillimeters(View view) {
        EditText convert = (EditText)findViewById(R.id.conversion_input);
        int meters = Integer.parseInt(convert.getText().toString());
        int millimeters = meters * 1000;
//        Toast.makeText(getApplicationContext(), "conversion is: " + millimeters, Toast.LENGTH_SHORT).show();
        Toast toast= Toast.makeText(getApplicationContext(),
                "Conversion is: " + millimeters, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}