package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Item mitem;
    private ArrayList<Item> listitem = new ArrayList<>();
    private ItemAdapter mitemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recycleview);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
//
//        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        Init();
        Event();
    }

    private void Event() {

        mitemAdapter = new ItemAdapter(listitem, this);
//        this, getApplicationContext(), MainActivity.this
        recyclerView.setAdapter(mitemAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//sd pthuc 1 tham số context cũng ok. sd pthuc 3 tham số, tham số thứ 2 kiểu dọc (horizontal) hoặc chiều ngang ( Vertical).
        //        ?GridLayoutManager : hiển thị các item trong danh sách theo dạng lưới .
//        StaggeredGridLayoutManager : hiển thị các item trong danh sách theo dạng lưới so le nhau. Để tạo ra một custom layout manager, thì phải kế thừa RecyclerView.LayoutManager class.
    }

    private void Init() {
        listitem.add(new Item("item1", R.drawable.hhvn_all));
        listitem.add(new Item("item4", R.drawable.hhvn_ngockhanh));
        listitem.add(new Item("item4", R.drawable.hhvn_hakieuanh));
        listitem.add(new Item("item5", R.drawable.hhvn_ngthihuyen));

    }
}