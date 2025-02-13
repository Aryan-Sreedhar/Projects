package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SurveyNum2Activity extends AppCompatActivity {
    private AutoCompleteTextView autoCompleteTextView1, autoCompleteTextView2, autoCompleteTextView3;
    private EditText editText4, editText5;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_num2);

        autoCompleteTextView1 = findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView2 = findViewById(R.id.autoCompleteTextView1);
        autoCompleteTextView3 = findViewById(R.id.autoCompleteTextView2);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);

        String[] items1 = {"Theory", "Practical", "Both"};
        String[] items2 = {"STEM field", "Non-STEM field"};
        String[] items3 = {"Academics", "Extra Curricular Activities"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, R.layout.dropdown_menu, items1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, R.layout.dropdown_menu, items2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, R.layout.dropdown_menu, items3);

        autoCompleteTextView1.setAdapter(adapter1);
        autoCompleteTextView2.setAdapter(adapter2);
        autoCompleteTextView3.setAdapter(adapter3);

        ImageButton backBtn = findViewById(R.id.backbtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        nextButton = findViewById(R.id.next1);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasAllAnswers()) {
                    Intent intent = null;
                    if (autoCompleteTextView2.getText().toString().equals("STEM field")) {
                        intent = new Intent(SurveyNum2Activity.this, ResultsActivity.class);
                    } else if (autoCompleteTextView3.getText().toString().equals("Extra Curricular Activities")) {
                        intent = new Intent(SurveyNum2Activity.this, Results4Activity.class);
                    } else {
                        int randomNumber = (int) (Math.random() * 4) + 1;
                        switch (randomNumber) {
                            case 1:
                                intent = new Intent(SurveyNum2Activity.this, ResultsActivity.class);
                                break;
                            case 2:
                                intent = new Intent(SurveyNum2Activity.this, Results2Activity.class);
                                break;
                            case 3:
                                intent = new Intent(SurveyNum2Activity.this, Results3Activity.class);
                                break;
                            case 4:
                                intent = new Intent(SurveyNum2Activity.this, Results4Activity.class);
                                break;
                        }
                    }
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(SurveyNum2Activity.this, "Please answer all the questions", Toast.LENGTH_SHORT).show();
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