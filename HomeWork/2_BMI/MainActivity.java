package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnbmi;
    EditText edtcancang, edtchieucao;
    TextView tvbmi, tvdanhgia;
    float chieucao, cannang, bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmiindex);
        Init();
        Event();
    }

    private void Event() {
        btnbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String heightStr = edtchieucao.getText().toString();
                    String weightStr = edtcancang.getText().toString();

                    if (heightStr.isEmpty() || weightStr.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Please enter both height and weight", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    chieucao = Float.parseFloat(heightStr) / 100; // convert cm to meters
                    cannang = Float.parseFloat(weightStr);
                    bmi = cannang / (chieucao * chieucao);

                    tvbmi.setText(String.format("%.2f", bmi));
                    if (bmi < 18.5) {
                        tvdanhgia.setText("GẦY - thiếu cân");
                    } else if (bmi <= 24.9) {
                        tvdanhgia.setText("BÌNH THƯỜNG");
                    } else {
                        tvdanhgia.setText("BÉO - thừa cân");
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid input. Please enter valid numbers.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Init() {
        btnbmi = findViewById(R.id.btnbmi);
        edtcancang = findViewById(R.id.cannang);
        edtchieucao = findViewById(R.id.chieucao);
        tvbmi = findViewById(R.id.tvbmi);
        tvdanhgia = findViewById(R.id.tvdanhgia);
    }
}
