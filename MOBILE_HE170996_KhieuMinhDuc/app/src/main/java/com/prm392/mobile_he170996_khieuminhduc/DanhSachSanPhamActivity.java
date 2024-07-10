package com.prm392.mobile_he170996_khieuminhduc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DanhSachSanPhamActivity extends AppCompatActivity {

    private ArrayList<SanPham> sanPhamList;
    private RecyclerView recyclerView;
    private SanPhamAdapter adapter;

    private static final int REQUEST_CHI_TIET_SAN_PHAM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danhsachsanpham);

        sanPhamList = new ArrayList<>(); // Initialize your product list
        sanPhamList.add(new SanPham("SP001", "DM001", "Điện thoại Samsung Galaxy S21", "20000000"));
        sanPhamList.add(new SanPham("SP002", "DM002", "Laptop Dell XPS 15", "35000000"));
        sanPhamList.add(new SanPham("SP003", "DM001", "Điện thoại iPhone 13 Pro Max", "35000000"));
        sanPhamList.add(new SanPham("SP004", "DM003", "Tai nghe Bluetooth Sony WH-1000XM4", "7000000"));
        sanPhamList.add(new SanPham("SP005", "DM002", "Laptop MacBook Pro 16-inch", "50000000"));
        recyclerView = findViewById(R.id.recyclerViewSanPham);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SanPhamAdapter(this, sanPhamList);
        recyclerView.setAdapter(adapter);

        // Handle item click to edit product details
        adapter.setOnItemClickListener(new SanPhamAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                openChiTietSanPham(sanPhamList.get(position));
            }
        });

        // Handle add product button click
        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChiTietSanPham(null); // Passing null to create new product
            }
        });
    }

    private void openChiTietSanPham(SanPham sanPham) {
        Intent intent = new Intent(this, ChiTietSanPhamActivity.class);
        if (sanPham != null) {
            // Pass existing product details to edit
            intent.putExtra("maSanPham", sanPham.getMa());
            intent.putExtra("maDanhMuc", sanPham.getMaDanhMuc());
            intent.putExtra("tenSanPham", sanPham.getTen());
            intent.putExtra("donGia", sanPham.getDonGia());
        }
        startActivityForResult(intent, REQUEST_CHI_TIET_SAN_PHAM);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CHI_TIET_SAN_PHAM && resultCode == RESULT_OK && data != null) {
            String action = data.getStringExtra("action");
            String maSanPham = data.getStringExtra("maSanPham");
            String maDanhMuc = data.getStringExtra("maDanhMuc");
            String tenSanPham = data.getStringExtra("tenSanPham");
            String donGia = data.getStringExtra("donGia");

            switch (action) {
                case "insert":
                    // Add new product to list
                    SanPham newProduct = new SanPham(maSanPham, maDanhMuc, tenSanPham, donGia);
                    sanPhamList.add(newProduct);
                    break;
                case "update":
                    // Update existing product in list
                    for (SanPham sp : sanPhamList) {
                        if (sp.getMa().equals(maSanPham)) {
                            sp.setMaDanhMuc(maDanhMuc);
                            sp.setTen(tenSanPham);
                            sp.setDonGia(donGia);
                            break;
                        }
                    }
                    break;
                case "delete":
                    // Delete product from list
                    for (SanPham sp : sanPhamList) {
                        if (sp.getMa().equals(maSanPham)) {
                            sanPhamList.remove(sp);
                            break;
                        }
                    }
                    break;
            }

            // Update RecyclerView
            adapter.notifyDataSetChanged();
        }
    }
}
