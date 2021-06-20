package com.example.menuproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_help) {
            Intent help = new Intent(MainActivity.this, HelpActivity.class);
            startActivity(help);
            return false;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openSMS(View view) {
        try {
            String message = "Hi!";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.putExtra("sms_body", message);
            intent.setData(Uri.parse("sms:9175555555"));
            startActivity(intent);
        } catch (android.content.ActivityNotFoundException ActivityNotFoundException) {
            Log.d("Error" , "Error");
        }
    }

    public void openPhone(View view) {
        try {
            String number = "tel:9175555555";
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(number));
            startActivity(intent);
        } catch (android.content.ActivityNotFoundException ActivityNotFoundException) {
            Log.d("Error" , "Error");
        }
    }

    public void openWeb(View view) {
        try {
            String website = "https://www.youtube.com/watch?v=AFpmYE4XOO0";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(website));
            startActivity(intent);
        } catch (android.content.ActivityNotFoundException ActivityNotFoundException) {
            Log.d("Error" , "Error");
        }
    }

    public void openMap(View view) {
        try {
            String coordinates = "geo:40.918872178880065, -73.83903014635399";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(coordinates));
            startActivity(intent);
        } catch (android.content.ActivityNotFoundException ActivityNotFoundException) {
            Log.d("Error" , "Error");
        }
    }

    public void openShare(View view) {
        String txt = "Share the love";
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
//                .setChooserTitle(R.string.share_text_with)
                .setText(txt)
                .startChooser();
    }

    public void openNewActivity(View view) {
        Intent myIntent = new Intent(MainActivity.this, NewActivity.class);
        MainActivity.this.startActivity(myIntent);
    }
}