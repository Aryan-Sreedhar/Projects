package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UnderWorkActivity extends AppCompatActivity {

    private TextView homeBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under_work);

        homeBack = findViewById(R.id.homeback);

        homeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UnderWorkActivity.this, HomePageActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}