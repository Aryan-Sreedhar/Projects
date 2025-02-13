package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class SurveyActivity extends AppCompatActivity {
    private AutoCompleteTextView autoCompleteTextView1, autoCompleteTextView2, autoCompleteTextView3;
    private EditText editText4, editText5;
    private Button nextButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        autoCompleteTextView1 = findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView2 = findViewById(R.id.autoCompleteTextView1);
        autoCompleteTextView3 = findViewById(R.id.autoCompleteTextView2);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);

        String[] items = {"Mathematics", "Physics", "Chemistry", "Biology", "Geography", "History", "Civics", "Economics", "Hindi", "Regional Language", "Computer Science"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dropdown_menu, items);

        autoCompleteTextView1.setAdapter(adapter);
        autoCompleteTextView2.setAdapter(adapter);
        autoCompleteTextView3.setAdapter(adapter);

        nextButton = findViewById(R.id.next1);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasAllAnswers()) {
                    Intent intent = new Intent(SurveyActivity.this, SurveyNum2Activity.class);
                    startActivity(intent);
                    finish();
            } else {
                    Toast.makeText(SurveyActivity.this, "Please answer all the questions", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean hasAllAnswers() {
        if (autoCompleteTextView1.getText().toString().isEmpty() ||
                autoCompleteTextView2.getText().toString().isEmpty() ||
                autoCompleteTextView3.getText().toString().isEmpty() ||
                editText4.getText().toString().isEmpty() ||
                editText5.getText().toString().isEmpty()) {
            return false;
        }
        return true;
    }
}