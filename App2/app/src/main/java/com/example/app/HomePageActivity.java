package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomePageActivity extends AppCompatActivity {

    private Button button;
    private ImageView imageView4, imageView5, imageView6, imageView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        button = findViewById(R.id.survey);
        imageView4 = findViewById(R.id.searchbtn);
        imageView5 = findViewById(R.id.combtn);
        imageView6 = findViewById(R.id.morebtn);
        imageView7 = findViewById(R.id.profbtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, SurveyActivity.class);
                startActivity(intent);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToUnderWorkActivity();
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToUnderWorkActivity();
            }
        });

        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToUnderWorkActivity();
            }
        });

        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToProfileActivity();
            }
        });
    }

    private void navigateToUnderWorkActivity() {
        Intent intent = new Intent(HomePageActivity.this, UnderWorkActivity.class);
        startActivity(intent);
    }

    private void navigateToProfileActivity() {
        Intent intent = new Intent(HomePageActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
}