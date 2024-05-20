package com.example.projectandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    FirebaseAuth auth;
    Button button;
    TextView textView;
    CardView cardHome, cardMessaging, cardTasks, cardAnnouncements, cardDocuments, cardMap;

    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        button =findViewById(R.id.logoutButton);
        textView= findViewById(R.id.user_details);
        cardHome = findViewById(R.id.card_home);
        cardMessaging = findViewById(R.id.card_messaging);
        cardTasks = findViewById(R.id.card_tasks);
        cardAnnouncements = findViewById(R.id.card_announcements);
        cardDocuments = findViewById(R.id.card_documents);
        cardMap = findViewById(R.id.card_map);
        user = auth.getCurrentUser();
        if (user == null){
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }
        else {
            textView.setText(user.getEmail());
        }
// Set card click listeners
        cardHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle home card click
                // Example: Navigate to home screen
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        cardMessaging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle messaging card click
                // Example: Navigate to messaging screen
                Intent intent = new Intent(MainActivity.this, MessagingActivity.class);
                startActivity(intent);
            }
        });

        cardTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle tasks card click
                // Example: Navigate to tasks screen
                Intent intent = new Intent(MainActivity.this, TasksActivity.class);
                startActivity(intent);
            }
        });

        cardAnnouncements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle announcements card click
                // Example: Navigate to announcements screen
                Intent intent = new Intent(MainActivity.this, AnnouncementsActivity.class);
                startActivity(intent);
            }
        });

        cardDocuments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle documents card click
                // Example: Navigate to documents screen
                Intent intent = new Intent(MainActivity.this, DocumentsActivity.class);
                startActivity(intent);
            }
        });

        cardMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle map card click
                // Example: Navigate to map screen
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}