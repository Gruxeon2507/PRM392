package com.prm392.mobile_he170996_khieuminhduc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TimKiemSanPhamTheoDanhMucActivity extends AppCompatActivity {

    private EditText edtdanhmuc;
    private Button btnXemSanPham;
    private RecyclerView recyclerViewKetQua;
    private TextView tvKetQua, tvKhongTimThay;
    private SanPhamAdapter sanPhamAdapter;
    private List<SanPham> sanPhamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timkiemsanphamtheodm);

        edtdanhmuc = findViewById(R.id.edtdanhmuc);
        btnXemSanPham = findViewById(R.id.btnXemSanPham);
        recyclerViewKetQua = findViewById(R.id.recyclerViewKetQua);
        tvKetQua = findViewById(R.id.tvKetQua);
        tvKhongTimThay = findViewById(R.id.tvKhongTimThay);

        // Initialize RecyclerView
        recyclerViewKetQua.setLayoutManager(new LinearLayoutManager(this));

        // Sample data
        sanPhamList = new ArrayList<>();
        sanPhamList.add(new SanPham("SP001", "DM001", "Điện thoại Samsung Galaxy S21", "20000000"));
        sanPhamList.add(new SanPham("SP002", "DM002", "Laptop Dell XPS 15", "35000000"));
        sanPhamList.add(new SanPham("SP003", "DM001", "Điện thoại iPhone 13 Pro Max", "35000000"));
        sanPhamList.add(new SanPham("SP004", "DM003", "Tai nghe Bluetooth Sony WH-1000XM4", "7000000"));
        sanPhamList.add(new SanPham("SP005", "DM002", "Laptop MacBook Pro 16-inch", "50000000"));

        // Set up adapter with empty list initially
        sanPhamAdapter = new SanPhamAdapter(this, new ArrayList<>());
        recyclerViewKetQua.setAdapter(sanPhamAdapter);

        btnXemSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleXemSanPham();
            }
        });
    }

    private void handleXemSanPham() {
        String keyword = edtdanhmuc.getText().toString().trim();

        if (keyword.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập từ khóa cần tìm.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Tìm kiếm các sản phẩm thỏa mãn từ khóa
        ArrayList<SanPham> ketQuaTimKiem = new ArrayList<>();
        for (SanPham sanPham : sanPhamList) {
            if (sanPham.getMaDanhMuc().toLowerCase().contains(keyword.toLowerCase()) || sanPham.getTen().toLowerCase().contains(keyword.toLowerCase())) {
                ketQuaTimKiem.add(sanPham);
            }
        }

        if (ketQuaTimKiem.isEmpty()) {
            // Hiển thị thông báo không tìm thấy sản phẩm
            tvKetQua.setVisibility(View.GONE);
            tvKhongTimThay.setVisibility(View.VISIBLE);
            recyclerViewKetQua.setVisibility(View.GONE);
        } else {
            // Hiển thị kết quả tìm kiếm trên RecyclerView
            tvKetQua.setVisibility(View.VISIBLE);
            tvKhongTimThay.setVisibility(View.GONE);
            recyclerViewKetQua.setVisibility(View.VISIBLE);

            // Cập nhật danh sách sản phẩm tìm thấy vào RecyclerView
            sanPhamAdapter.updateList(ketQuaTimKiem);
        }
    }
}
