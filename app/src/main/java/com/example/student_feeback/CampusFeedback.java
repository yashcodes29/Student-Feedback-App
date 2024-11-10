package com.example.student_feeback;

import static android.content.ContentValues.TAG;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CampusFeedback extends AppCompatActivity {
    Spinner  spinner1, spinner2, spinner3, spinner4, spinner5;
    Button btn_Submit;
    TextView CampQ1, CampQ2, CampQ3, CampQ4, CampQ5;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    ArrayList<String> arrIds = new ArrayList<>();

    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_campus_feedback);

        spinner1 = findViewById(R.id.spinner_campus_1);
        spinner2 = findViewById(R.id.spinner_campus_2);
        spinner3 = findViewById(R.id.spinner_campus_3);
        spinner4 = findViewById(R.id.spinner_campus_4);
        spinner5 = findViewById(R.id.spinner_campus_5);
        CampQ1 = findViewById(R.id.camp_Q1);
        CampQ2 = findViewById(R.id.camp_Q2);
        CampQ3 = findViewById(R.id.camp_Q3);
        CampQ4 = findViewById(R.id.camp_Q4);
        CampQ5 = findViewById(R.id.camp_Q5);
        //spinner
        arrIds.add("Excellent");
        arrIds.add("Good");
        arrIds.add("Average");
        arrIds.add("Poor");


        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrIds);

        spinner1.setAdapter(spinnerAdapter);
        spinner2.setAdapter(spinnerAdapter);
        spinner3.setAdapter(spinnerAdapter);
        spinner4.setAdapter(spinnerAdapter);
        spinner5.setAdapter(spinnerAdapter);
        btn_Submit = findViewById(R.id.btn_ShowPie);

//btn_Submit.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//    Intent intent = new Intent(CampusFeedback.this,camp_Pie.class);
//    startActivity(intent);
//    }
//});
        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get spinner values QuestionWise
                String CampQ1 = spinner1.getSelectedItem().toString();
                String CampQ2 = spinner2.getSelectedItem().toString();
                String CampQ3 = spinner3.getSelectedItem().toString();
                String CampQ4 = spinner4.getSelectedItem().toString();
                String CampQ5 = spinner5.getSelectedItem().toString();

                //Overall Values
//                String campusValue = spinner1.getSelectedItem().toString();
//                String campusBValue = spinner2.getSelectedItem().toString();
//                String campusFValue = spinner3.getSelectedItem().toString();
//                String campusDValue = spinner4.getSelectedItem().toString();
//                String campusEValue = spinner5.getSelectedItem().toString();

                // Update counter for each spinner item value
                DatabaseReference databaseReference1 = database.getReference("Campus Question1");
                databaseReference1.child(CampQ1).setValue(ServerValue.increment(1));

                DatabaseReference databaseReference2 = database.getReference("Campus Question2");
                databaseReference2.child(CampQ2).setValue(ServerValue.increment(1));

                DatabaseReference databaseReference3 = database.getReference("Campus Question3");
                databaseReference3.child(CampQ3).setValue(ServerValue.increment(1));

                DatabaseReference databaseReference4 = database.getReference("Campus Question4");
                databaseReference4.child(CampQ4).setValue(ServerValue.increment(1));

                DatabaseReference databaseReference5 = database.getReference("Campus Question5");
                databaseReference5.child(CampQ5).setValue(ServerValue.increment(1));



                DatabaseReference databaseReference = database.getReference("Campus Feedback");
                databaseReference.child(CampQ1).setValue(ServerValue.increment(1));
                databaseReference.child(CampQ2).setValue(ServerValue.increment(1));
                databaseReference.child(CampQ3).setValue(ServerValue.increment(1));
                databaseReference.child(CampQ4).setValue(ServerValue.increment(1));
                databaseReference.child(CampQ5).setValue(ServerValue.increment(1));

                // Start the camp_Pie activity
                Intent intent = new Intent(CampusFeedback.this, CampFeedQ1.class);
                startActivity(intent);


            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("CAMPQ1");// Set the initial value of the message1
        mDatabase.child("CAMPQ2");// Set the initial value of the message2
        mDatabase.child("CAMPQ3");
        mDatabase.child("CAMPQ4");
        mDatabase.child("CAMPQ5");
        // Add a listener to update the text of the TextViews when the value in Firebase changes
        mDatabase.child("CAMPQ1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                CampQ1.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors
            }
        });

        mDatabase.child("CAMPQ2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                CampQ2.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors
            }
        });

        mDatabase.child("CAMPQ3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                CampQ3.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors
            }
        });
        mDatabase.child("CAMPQ4").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                CampQ4.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors
            }
        });
        mDatabase.child("CAMPQ5").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                CampQ5.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors
            }
        });


        // Extended


    }
}




