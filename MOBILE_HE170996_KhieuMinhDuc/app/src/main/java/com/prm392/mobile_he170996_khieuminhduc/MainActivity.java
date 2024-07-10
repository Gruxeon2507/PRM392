package com.prm392.mobile_he170996_khieuminhduc;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnDanhSachSanPham, btnDanhSachSanPhamTheoDanhMuc, btnTimKiemSanPham, btnLienHe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnDanhSachSanPham = findViewById(R.id.btnDanhSachSanPham);
        btnDanhSachSanPhamTheoDanhMuc = findViewById(R.id.btnDanhSachSanPhamTheoDanhMuc);
        btnTimKiemSanPham = findViewById(R.id.btnTimKiemSanPham);
        btnLienHe = findViewById(R.id.btnLienHe);

        btnDanhSachSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DanhSachSanPhamActivity.class);
                startActivity(intent);
            }
        });

        btnDanhSachSanPhamTheoDanhMuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TimKiemSanPhamTheoDanhMucActivity.class);
                startActivity(intent);
            }
        });

        btnTimKiemSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Chức năng đang xây dựng", Toast.LENGTH_SHORT).show();
            }
        });

        btnLienHe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông tin liên hệ")
                        .setMessage("Tên chủ cửa hàng: Nguyễn Văn A\nSố điện thoại: 0123456789")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                builder.show();
            }
        });
    }
}

