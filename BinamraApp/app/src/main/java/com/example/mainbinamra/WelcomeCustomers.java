package com.example.mainbinamra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class WelcomeCustomers extends AppCompatActivity {

    private Button button_my_profile,
            button_organic_waste,
            button_my_schedule,
            button_my_location,
            button_signout;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_customers);

        firebaseAuth= FirebaseAuth.getInstance();


        button_my_profile = findViewById(R.id.buttonmyprofile);
        button_organic_waste = findViewById(R.id.buttonOrganicWaste);
        button_my_schedule = findViewById(R.id.buttonmyschedule);
        button_my_location = findViewById(R.id.buttonmylocation);

        button_signout = findViewById(R.id.buttonSignOut);


        button_my_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(WelcomeCustomers.this, "Nepali Food", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(WelcomeCustomers.this, food.class);
                startActivity(intent);
            }
        });
        button_organic_waste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(WelcomeCustomers.this, "Chinese Food", Toast.LENGTH_SHORT).show();
              /*  Intent intent = new Intent(WelcomeCustomers.this, Organic_Waste.class);
                startActivity(intent);*/
            }
        });

        button_my_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(WelcomeCustomers.this, "Italian Food", Toast.LENGTH_SHORT).show();
            /*    Intent intent = new Intent(WelcomeCustomers.this, mySchedule.class);
                startActivity(intent);*/
            }
        });
        button_my_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(WelcomeCustomers.this, "Indian Food", Toast.LENGTH_SHORT).show();
          /*      Intent intent = new Intent(WelcomeCustomers.this, MainActivity.class);
                startActivity(intent);*/
            }
        });

        button_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(WelcomeCustomers.this,userLogin.class));
                Toast.makeText(WelcomeCustomers.this, "SignOut ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
