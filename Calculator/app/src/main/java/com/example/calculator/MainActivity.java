package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText numberA;
    private EditText numberB;
    private Button btnAdd;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calulatorindex);

        numberA = findViewById(R.id.numberA);
        numberB = findViewById(R.id.numberB);
        btnAdd = findViewById(R.id.btnAdd);
        textViewResult = findViewById(R.id.textViewResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numAStr = numberA.getText().toString();
                String numBStr = numberB.getText().toString();

                if (!numAStr.isEmpty() && !numBStr.isEmpty()) {
                    double numA = Double.parseDouble(numAStr);
                    double numB = Double.parseDouble(numBStr);
                    double sum = numA + numB;
                    textViewResult.setText(String.valueOf(sum));
                } else {
                    textViewResult.setText("Please enter both numbers");
                }
            }
        });
    }
}
