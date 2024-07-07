package com.example.demoapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText edtid, edtname, edtpass, edtdetail;
    TextView tvcontent;

    Button btnload, btnins, btnedit, btndel;

    ListView lv;
    ArrayAdapter<Account> adapter;
    ArrayList<Account> accountList = new ArrayList<>();

    APIInterface accountApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        init();
        Events();
    }

    private void Events() {
        accountApi = RetrofitClient.getClient(APIInterface.BASE_URL).create(APIInterface.class);

        btnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventgetAccounts();
            }
        });

        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventDeleteAccount();
            }
        });

        btnins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventInsertAccount();
            }
        });

        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventEditAccount();
            }
        });
    }

    private void eventDeleteAccount() {
        int accountId = Integer.parseInt(edtid.getText().toString());
        accountApi.DeleteAccount(accountId+"").enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "successful Response code " + response.code(), Toast.LENGTH_SHORT).show();
                    Account createdAccount = response.body();
                    tvcontent.setText(createdAccount.toStringall());
                } else {
                    Toast.makeText(MainActivity.this, "Response not successful " + accountId, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Toast.makeText(MainActivity.this, "API call failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                tvcontent.setText("API call failed: " + t.getMessage());
            }
        });
    }

    private void eventInsertAccount() {
        Account newAccount = Views2Account();
        accountApi.PostAccount(newAccount).enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "successful Response code " + response.code(), Toast.LENGTH_SHORT).show();
                    Account createdAccount = response.body();
                    tvcontent.setText(createdAccount.toStringall());
                } else {
                    Toast.makeText(MainActivity.this, "Response not successful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Toast.makeText(MainActivity.this, "API call failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                tvcontent.setText("API call failed: " + t.getMessage());
            }
        });
    }

    private void eventEditAccount() {
        Account updatedAccount = Views2Account();
        int id = updatedAccount.getId();
        accountApi.PutAccount(id+"", updatedAccount).enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "successful Response code " + response.code(), Toast.LENGTH_SHORT).show();
                    Account createdAccount = response.body();
                    tvcontent.setText(createdAccount.toStringall());
                } else {
                    Toast.makeText(MainActivity.this, "Response not successful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Toast.makeText(MainActivity.this, "API call failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                tvcontent.setText("API call failed: " + t.getMessage());
            }
        });
    }

    private void eventgetAccounts() {
        Call<ArrayList<Account>> call = accountApi.getAccounts();
        call.enqueue(new Callback<ArrayList<Account>>() {
            @Override
            public void onResponse(Call<ArrayList<Account>> call, Response<ArrayList<Account>> response) {
                if (response.isSuccessful()) {
                    accountList = response.body();
                    list2ListView(accountList);
                    Toast.makeText(MainActivity.this, "successful Response code " + response.code(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Response not successful" + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Account>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "API call failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                tvcontent.setText("API call failed: " + t.getMessage());
            }
        });
    }

    private void init() {
        tvcontent = findViewById(R.id.tvcontent);
        edtid = findViewById(R.id.edtid);
        edtname = findViewById(R.id.edtname);
        edtpass = findViewById(R.id.edtpass);
        edtdetail = findViewById(R.id.edtdetail);
        btnload = findViewById(R.id.btn_load);
        btnins = findViewById(R.id.btninsert);
        btnedit = findViewById(R.id.btnedit);
        btndel = findViewById(R.id.btndel);
        lv = findViewById(R.id.lv);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Account tk = accountList.get(position);
                Account2Views(tk);
                Toast.makeText(MainActivity.this, "Bạn click " + position + " : " + tk.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void Account2Views(Account tk) {
        edtid.setText(String.valueOf(tk.getId()));
        edtname.setText(tk.getName());
        edtpass.setText(tk.getPass());
        edtdetail.setText(tk.getDetail());
    }

    private Account Views2Account() {
        Account tk = new Account(Integer.parseInt(edtid.getText().toString()), edtname.getText().toString(), edtpass.getText().toString(), edtdetail.getText().toString());
        Toast.makeText(MainActivity.this, "Đối tượng lấy được: " + tk.toStringall(), Toast.LENGTH_SHORT).show();
        return tk;
    }

    private void list2ListView(ArrayList<Account> list) {
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
    }
}
