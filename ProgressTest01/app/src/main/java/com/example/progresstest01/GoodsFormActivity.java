package com.example.progresstest01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class GoodsFormActivity extends AppCompatActivity {
    private EditText editTextCode, editTextName, editTextPrice, editTextType, editTextDetails;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ctivity_goods_form);

        editTextName = findViewById(R.id.editTextName);
        editTextPrice = findViewById(R.id.editTextPrice);
        editTextType = findViewById(R.id.editTextType);
        editTextDetails = findViewById(R.id.editTextDetails);
        buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(v -> {
            String code = editTextCode.getText().toString();
            String name = editTextName.getText().toString();
            double price = Double.parseDouble(editTextPrice.getText().toString());
            String type = editTextType.getText().toString();
            String details = editTextDetails.getText().toString();

            Goods newGoods = new Goods(code, name, price, type, details);
            // Save to database or list
            // ...
        });
    }
}

