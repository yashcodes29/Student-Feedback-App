package com.example.student_feeback;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class CouFeedQ1 extends AppCompatActivity {
    TextView tvR, tvPython, tvCPP, tvJava ,que;
    PieChart pieChart;
    Button btn;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cou_feed_q1);
        // Link those objects with their respective
// id's that we have given in .XML file
        tvR = findViewById(R.id.tvR1);
        tvPython = findViewById(R.id.tvPython1);
        tvCPP = findViewById(R.id.tvCPP1);
        tvJava = findViewById(R.id.tvJava1);
        pieChart = findViewById(R.id.piechart1);
        que= findViewById(R.id.Question);
        btn = findViewById(R.id.btn_next);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CouFeedQ1.this, CouFeedQ2.class);
                startActivity(intent);
            }
        });

        setData();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("couQ1");
        mDatabase.child("couQ1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                que.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors
            }
        });



    }

    private void setData() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Course Question1");

        // Retrieve the counter values from the database and set them to TextViews
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    long excellentCount = snapshot.child("Excellent").getValue(Long.class);
                    long goodCount = snapshot.child("Good").getValue(Long.class);
                    long averageCount = snapshot.child("Average").getValue(Long.class);
                    long poorCount = snapshot.child("Poor").getValue(Long.class);

                    tvR.setText(Long.toString(excellentCount));
                    tvPython.setText(Long.toString(goodCount));
                    tvCPP.setText(Long.toString(averageCount));
                    tvJava.setText(Long.toString(poorCount));

                    // Set the data and color to the pie chart
                    pieChart.addPieSlice(
                            new PieModel(
                                    "Excellent",
                                    excellentCount,
                                    Color.parseColor("#FFA726")));
                    pieChart.addPieSlice(
                            new PieModel(
                                    "Good",
                                    goodCount,
                                    Color.parseColor("#66BB6A")));
                    pieChart.addPieSlice(
                            new PieModel(
                                    "Average",
                                    averageCount,
                                    Color.parseColor("#EF5350")));
                    pieChart.addPieSlice(
                            new PieModel(
                                    "Poor",
                                    poorCount,
                                    Color.parseColor("#29B6F6")));

                    // To animate the pie chart
                    pieChart.startAnimation();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle database error
            }
        });
    }
}
