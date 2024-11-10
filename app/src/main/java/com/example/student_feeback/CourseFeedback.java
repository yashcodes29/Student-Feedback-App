package com.example.student_feeback;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CourseFeedback extends AppCompatActivity {
    Spinner spinner1, spinner2, spinner3, spinner4, spinner5;
    Button btn_Submit;
    TextView CouQ1, CouQ2, CouQ3, CouQ4, CouQ5;
    FirebaseDatabase database = FirebaseDatabase.getInstance();




    ArrayList<String> arrIds = new ArrayList<>();

    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_course_feedback);





        spinner1 = findViewById(R.id.spinner_course_1);
        spinner2 = findViewById(R.id.spinner_course_2);
        spinner3 = findViewById(R.id.spinner_course_3);
        spinner4 = findViewById(R.id.spinner_course_4);
        spinner5 = findViewById(R.id.spinner_course_5);
        CouQ1 = findViewById(R.id.cou_Q1);
        CouQ2 = findViewById(R.id.cou_Q2);
        CouQ3 = findViewById(R.id.cou_Q3);
        CouQ4 = findViewById(R.id.cou_Q4);
        CouQ5 = findViewById(R.id.cou_Q5);
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
//    Intent intent = new Intent(couusFeedback.this,cou_Pie.class);
//    startActivity(intent);
//    }
//});
        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get spinner values QuestionWise
                String couQ1 = spinner1.getSelectedItem().toString();
                String couQ2 = spinner2.getSelectedItem().toString();
                String couQ3 = spinner3.getSelectedItem().toString();
                String couQ4 = spinner4.getSelectedItem().toString();
                String couQ5 = spinner5.getSelectedItem().toString();


                //Overall Values
//                String couusValue = spinner1.getSelectedItem().toString();
//                String couusBValue = spinner2.getSelectedItem().toString();
//                String couusFValue = spinner3.getSelectedItem().toString();
//                String couusDValue = spinner4.getSelectedItem().toString();
//                String couusEValue = spinner5.getSelectedItem().toString();

                // Update counter for each spinner item value
                DatabaseReference databaseReference1 = database.getReference("Course Question1");
                databaseReference1.child(couQ1).setValue(ServerValue.increment(1));

                DatabaseReference databaseReference2 = database.getReference("Course Question2");
                databaseReference2.child(couQ2).setValue(ServerValue.increment(1));

                DatabaseReference databaseReference3 = database.getReference("Course Question3");
                databaseReference3.child(couQ3).setValue(ServerValue.increment(1));

                DatabaseReference databaseReference4 = database.getReference("Course Question4");
                databaseReference4.child(couQ4).setValue(ServerValue.increment(1));

                DatabaseReference databaseReference5 = database.getReference("Course Question5");
                databaseReference5.child(couQ5).setValue(ServerValue.increment(1));


                DatabaseReference databaseReference = database.getReference("Course Feedback");
                databaseReference.child(couQ1).setValue(ServerValue.increment(1));
                databaseReference.child(couQ2).setValue(ServerValue.increment(1));
                databaseReference.child(couQ3).setValue(ServerValue.increment(1));
                databaseReference.child(couQ4).setValue(ServerValue.increment(1));
                databaseReference.child(couQ5).setValue(ServerValue.increment(1));


                Intent intent = new Intent(CourseFeedback.this, CouFeedQ1.class);
                startActivity(intent);


            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("couQ1");// Set the initial value of the message1
        mDatabase.child("couQ2");// Set the initial value of the message2
        mDatabase.child("couQ3");
        mDatabase.child("couQ4");
        mDatabase.child("couQ5");
        // Add a listener to update the text of the TextViews when the value in Firebase changes
        mDatabase.child("couQ1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                CouQ1.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors
            }
        });

        mDatabase.child("couQ2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                CouQ2.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors
            }
        });

        mDatabase.child("couQ3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                CouQ3.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors
            }
        });
        mDatabase.child("couQ4").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                CouQ4.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors
            }
        });
        mDatabase.child("couQ5").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                CouQ5.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors
            }
        });


//    @Override
//    public void onBackPressed(){
//        Toast.makeText(CourseFeedback.this,"NOT ALLOWED",Toast.LENGTH_SHORT).show();
//    }
    }
}