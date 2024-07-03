package com.example.demoapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.ListView;

import android.widget.TextView;

import android.widget.Toast;

import java.util.List;

import retrofit2.Call;

import retrofit2.Callback;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tvcontent;

    String s="";

    Button btnload, btnins, btnedit, btndel;

    ListView lv;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.index);

        init();

        Events();
    }
    private void Events() { btnload.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) { eventgetAccounts(APIInterface.BASE_URL); } }); } private void eventgetAccounts(String baseurl) {
        // B1 tạo đối tượng retrofit, và thiết laaij url,...
        APIInterface accountApi = RetrofitClient.getClient(APIInterface.BASE_URL).create(APIInterface.class);
        //B3 Request tới server
        Call<List<Account>> call = accountApi.getTaiKhoans();
        // B4 get response qua Callback. get data và xử lý
        call.enqueue(new Callback<List<Account>>() {
            @Override
            public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
                if (response.isSuccessful()) {
                    List<Account> accountList = response.body();
                    // Xử lý danh sách account tại đây (ví dụ: hiển thị trong RecyclerView) //
                    // Example: print to log or Toast for (Account account : accountList) { s = s + account.toString() + "\n"; }
                    Toast.makeText(MainActivity.this, "successful Response code " + response.code(), Toast.LENGTH_SHORT).show();
                    tvcontent.setText("data load: " + s);
                } else {
                    Toast.makeText(MainActivity.this, "Response not successful" + response.code(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<Account>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "API call failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                tvcontent.setText("API call failed: " + t.getMessage());
            }
        });
    }
    private void init() {
        tvcontent = (TextView) findViewById(R.id.tvcontent);
        btnload = findViewById(R.id.btn_load);
        btnins = findViewById(R.id.btninsert);
        btnedit = findViewById(R.id.btnedit);
        btndel = findViewById(R.id.btndel);
        lv = findViewById(R.id.lv);
    }
}