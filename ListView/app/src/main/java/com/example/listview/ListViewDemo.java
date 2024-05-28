package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListViewDemo extends AppCompatActivity {
    ArrayList<Account> arr = new ArrayList<>();
    ListView lv;
    ArrayAdapter<Account> adap;
    EditText name, pass;
    TextView tvid;
    ImageButton imgadd, imgedit, imgdel;
    int pos;

    //    String [] arrsp=new String[]{"LT HDT","LT thủ tục","LT Event"};
//    Spinner sp;
//    ArrayAdapter<String> adapsp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_spinner);
        ListviewEvent();
        Events();
    }

    private void Events() {
        imgadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tkid= 0;
                String tkname=name.getText()+"";
                String tkpass=pass.getText()+"";
                Account tk=new Account(tkid,tkname,tkpass);
                arr.add(0,tk);
                adap.notifyDataSetChanged();
                Toast.makeText(ListViewDemo.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
            }
        });
        imgedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imgdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void Init() {
        lv = (ListView) findViewById(R.id.lv);
        tvid = findViewById(R.id.tvid);
        name = findViewById(R.id.edtname);
        pass = findViewById(R.id.edtpass);
        imgadd = findViewById(R.id.imgadd);
        imgedit = findViewById(R.id.imgedit);
        imgdel = findViewById(R.id.imgdel);
    }

    private void ListviewEvent() {
//        B1 Tạo nguồn data
        arr.add(new Account(1, "DiepNH", "123"));
        arr.add(new Account(10, "SE1909", "swr"));
        arr.add(new Account(12, "SE1709", "prm"));
        arr.add(new Account(4, "SE1719", "392"));
//        Binding View
        Init();
//        B3 Khai báo khởi tạo adapter, kết nối với nguồn dữ liệu
        adap = new ArrayAdapter<Account>(ListViewDemo.this, android.R.layout.simple_list_item_1, arr);
//        B3.2 Đẩy dữ liệu lên view
        lv.setAdapter(adap);
//        B4 Viết event
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pos = position;
                Account tk = arr.get(position);
                tvid.setText(tk.getId() + "");
                name.setText(tk.getName() + "");
                pass.setText(tk.getPassword() + "");
                Toast.makeText(ListViewDemo.this, "b click " + position + ": " + tk.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

//    private void SpinnerEvent() {
//        //        B1 Tạo nguồn data
////        Binding View
//        sp = findViewById(R.id.sp);
////        B3 Khai báo khởi tạo adapter, kết nối với nguồn dữ liệu
//        adapsp = new ArrayAdapter<String>(DemoLV_SP.this, android.R.layout.simple_list_item_1, arrsp);
////        B3.2 Đẩy dữ liệu lên view
//        sp.setAdapter(adapsp);
////        B4 Viết event
//        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(DemoLV_SP.this,"b click "+position+": "+arrsp[position],Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//    }

}