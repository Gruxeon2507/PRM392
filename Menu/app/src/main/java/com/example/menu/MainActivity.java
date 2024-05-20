package com.example.menu;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private MenuAdapter menuAdapter;
    private List<MenuItem> menuItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        menuItemList = new ArrayList<>();
        menuItemList.add(new MenuItem("Burger", "Delicious beef burger", "$5.99", R.drawable.burger));
        menuItemList.add(new MenuItem("Fries", "Crispy french fries", "$2.99", R.drawable.fries));
        menuItemList.add(new MenuItem("Pizza", "Cheesy pepperoni pizza", "$8.99", R.drawable.pizza));
        menuItemList.add(new MenuItem("Soda", "Refreshing cola drink", "$1.49", R.drawable.soda));

        menuAdapter = new MenuAdapter(this, menuItemList);
        listView.setAdapter(menuAdapter);
    }
}
