package com.example.student_feeback;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.example.student_feeback.R;
import com.google.android.material.navigation.NavigationView;


// Trial

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;






// end

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;



//    // Trial
//    Spinner spinner;
//    ArrayList<String> arrIds = new ArrayList<>();

////    //end
    Button btn_coursesFeed,btn_CantFeed,btn_CampFeed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
        btn_coursesFeed = findViewById(R.id.btn_CouFeed);
        btn_CampFeed = findViewById(R.id.btn_CampFeed);
        btn_CantFeed = findViewById(R.id.btn_CantFeed);

        Toast.makeText(MainActivity.this,"Welcome to MET FEEDBACK SYSTEM",Toast.LENGTH_SHORT).show();

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar,R.string.OpenDrawer,R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.optHome){
                    Intent intent = new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intent);
                } else  if(id==R.id.opt_About){
                    Intent intent = new Intent(MainActivity.this,about.class);
                    startActivity(intent);
                } else if (id==R.id.opt_Campus) {
                    Toast.makeText(MainActivity.this,"Campus",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,CampusImages.class);
                    startActivity(intent);
                } else if (id==R.id.opt_Courses) {

                    Toast.makeText(MainActivity.this,"Available soon",Toast.LENGTH_SHORT).show();
                } else if (id==R.id.opt_logout) {
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();

                }

                drawerLayout.closeDrawer(GravityCompat.START);



                return true;

            }
        });
/////trial
//        spinner=findViewById(R.id.spinner_campus);
//
//        //spinner
//        arrIds.add("Good");
//        arrIds.add("Very Good");
//        arrIds.add("Poor");
//        arrIds.add("Excellent");
//
//        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arrIds);
//        spinner.setAdapter(spinnerAdapter);
//        // ENd

        btn_CampFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this,CampusFeedback.class);
                startActivity(intent);
                btn_CampFeed.setEnabled(false);
            }
        });
btn_coursesFeed.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {Intent intent = new Intent (MainActivity.this,CourseFeedback.class);
        startActivity(intent);
        btn_coursesFeed.setEnabled(false);
    }
});
btn_CantFeed.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this,"Canteen FeedBack Available Soon ",Toast.LENGTH_SHORT).show();
    }
});







    }
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
            moveTaskToBack(true);

    }



    //









}

