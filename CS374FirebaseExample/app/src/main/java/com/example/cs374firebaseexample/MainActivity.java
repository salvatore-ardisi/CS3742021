package com.example.cs374firebaseexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button add;
    private ListView listView;
    private EditText firstName;
    private EditText lastName;
//    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        add = findViewById(R.id.add);
        firstName = (EditText)findViewById(R.id.edit_first_name);
        lastName = (EditText)findViewById(R.id.edit_last_name);
        listView = findViewById(R.id.listView);

        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String fName = firstName.getText().toString();
                String lName = lastName.getText().toString();
//                String counterToString = String.valueOf(counter);

                if (fName.isEmpty() || lName.isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter both fields!", Toast.LENGTH_SHORT).show();
                } else {
                    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("employees");

                    Employee emp = new Employee(fName, lName);
                    myRef.push().setValue(emp);
//                    counter++;
//                    myRef.child(counterToString).setValue(new Employee(fName, lName));
//                    myRef.push();

                    clear(firstName);
                    clear(lastName);
                }
                try {
                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        final ArrayList<String> list = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter<String>(this , R.layout.list_employee , list);
        listView.setAdapter(adapter);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("employees");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Employee info = snapshot.getValue(Employee.class);
                    assert info != null;
                    String txt = "First Name: " + info.getFirstName() + " \nLast Name: " + info.getLastName();
                    list.add(txt);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
    public void clear(View v) {
        firstName.setText("");
        lastName.setText("");
    }
    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }
}





//    TextView tv = (TextView)findViewById(R.id.tv);
//
//    // Write a message to the database
//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//        Log.i("MAINACTIVITY", database.toString());
//                DatabaseReference myRef = database.getReference("message");
//                Log.i("MAINACTIVITY", myRef.toString());
//
//                myRef.setValue("Hello, World!");
//
//                // Read from the database
//                myRef.addValueEventListener(new ValueEventListener() {
//@Override
//public void onDataChange(DataSnapshot dataSnapshot) {
//        // This method is called once with the initial value and again
//        // whenever data at this location is updated.
//        String value = dataSnapshot.getValue(String.class);
//        Log.d("MAINACTIVITY", "Value is: " + value);
//
//        tv.setText(value);
//        }
//
//@Override
//public void onCancelled(DatabaseError error) {
//        // Failed to read value
//        Log.w("MAINACTIVITY", "Failed to read value.", error.toException());
//        }
//        });