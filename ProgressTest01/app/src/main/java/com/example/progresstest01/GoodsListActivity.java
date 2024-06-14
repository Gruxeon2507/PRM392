package com.example.progresstest01;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GoodsListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GoodsListAdapter adapter;
    private List<Goods> goodsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);

        recyclerView = findViewById(R.id.recyclerViewGoods);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize goodsList
        goodsList = new ArrayList<>();
        // Add sample data
        goodsList.add(new Goods("001", "Product A", 19.99, "Electronics", "Details about Product A"));
        goodsList.add(new Goods("002", "Product B", 29.99, "Clothing", "Details about Product B"));
        goodsList.add(new Goods("003", "Product C", 9.99, "Books", "Details about Product C"));
        goodsList.add(new Goods("004", "Product D", 39.99, "Home Goods", "Details about Product D"));
        goodsList.add(new Goods("005", "Product E", 49.99, "Toys", "Details about Product E"));
        // Add more data as needed
        
        // Initialize and set adapter
        adapter = new GoodsListAdapter(this, goodsList);
        recyclerView.setAdapter(adapter);
    }
}

