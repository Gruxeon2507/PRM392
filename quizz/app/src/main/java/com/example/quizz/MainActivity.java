package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton option1, option2, option3, option4;
    private CheckBox checkbox1, checkbox2, checkbox3, checkBox4;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        radioGroup = findViewById(R.id.radioGroup);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        checkbox1 = findViewById(R.id.checkbox1);
        checkbox2 = findViewById(R.id.checkbox2);
        checkbox3 = findViewById(R.id.checkbox3);
        checkBox4 = findViewById(R.id.checkbox4);
        submitButton = findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers();
            }
        });
    }

    private void checkAnswers() {
        // Check first question
        int selectedId = radioGroup.getCheckedRadioButtonId();
        boolean q1Correct = selectedId == R.id.option1;

        // Check second question
        boolean q2Correct = checkbox1.isChecked() && checkbox2.isChecked() && !checkbox3.isChecked() && !checkBox4.isChecked();

        // Show results using Toast
        if (q1Correct && q2Correct) {
            Toast.makeText(MainActivity.this, "Both answers are correct!", Toast.LENGTH_LONG).show();
        } else {
            if (!q1Correct) {
                Toast.makeText(MainActivity.this, "Question 1 is incorrect.", Toast.LENGTH_LONG).show();
            }
            if (!q2Correct) {
                Toast.makeText(MainActivity.this, "Question 2 is incorrect.", Toast.LENGTH_LONG).show();
            }
        }
    }
}
