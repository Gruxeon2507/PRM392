package com.prm392.mobile_he170996_khieuminhduc;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ChiTietSanPhamActivity extends AppCompatActivity {

    private EditText etMaSanPham, etMaDanhMuc, etTenSanPham, etGiaSanPham;
    private Button btnInsert, btnUpdate, btnDelete;
    private String originalMaSanPham, originalMaDanhMuc, originalTenSanPham, originalDonGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietsanpham);

        etMaSanPham = findViewById(R.id.etMaSanPham);
        etMaDanhMuc = findViewById(R.id.etMaDanhMuc);
        etTenSanPham = findViewById(R.id.etTenSanPham);
        etGiaSanPham = findViewById(R.id.etGiaSanPham);
        btnInsert = findViewById(R.id.btnInsert);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        // Lấy dữ liệu từ Intent
        originalMaSanPham = getIntent().getStringExtra("maSanPham");
        originalMaDanhMuc = getIntent().getStringExtra("maDanhMuc");
        originalTenSanPham = getIntent().getStringExtra("tenSanPham");
        originalDonGia = getIntent().getStringExtra("donGia");

        // Hiển thị dữ liệu
        etMaSanPham.setText(originalMaSanPham);
        etMaDanhMuc.setText(originalMaDanhMuc);
        etTenSanPham.setText(originalTenSanPham);
        etGiaSanPham.setText(originalDonGia);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleInsert();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleUpdate();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDelete();
            }
        });
    }

    private void handleInsert() {
        String newMaSanPham = etMaSanPham.getText().toString();
        String newMaDanhMuc = etMaDanhMuc.getText().toString();
        String newTenSanPham = etTenSanPham.getText().toString();
        String newDonGia = etGiaSanPham.getText().toString();

        if (newMaSanPham.isEmpty() || newMaDanhMuc.isEmpty() || newTenSanPham.isEmpty() || newDonGia.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin để thêm sản phẩm.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Gửi dữ liệu về cho Activity DanhSachSanPhamActivity
        Intent intent = new Intent();
        intent.putExtra("action", "insert");
        intent.putExtra("maSanPham", newMaSanPham);
        intent.putExtra("maDanhMuc", newMaDanhMuc);
        intent.putExtra("tenSanPham", newTenSanPham);
        intent.putExtra("donGia", newDonGia);
        setResult(RESULT_OK, intent);
        finish();
    }

    private void handleUpdate() {
        String newMaSanPham = etMaSanPham.getText().toString();
        String newMaDanhMuc = etMaDanhMuc.getText().toString();
        String newTenSanPham = etTenSanPham.getText().toString();
        String newDonGia = etGiaSanPham.getText().toString();

        if (newMaSanPham.isEmpty() || newMaDanhMuc.isEmpty() || newTenSanPham.isEmpty() || newDonGia.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin để sửa.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (newMaSanPham.equals(originalMaSanPham) && newMaDanhMuc.equals(originalMaDanhMuc)
                && newTenSanPham.equals(originalTenSanPham) && newDonGia.equals(originalDonGia)) {
            Toast.makeText(this, "Dữ liệu không có thay đổi.", Toast.LENGTH_SHORT).show();
        } else {
            // Gửi dữ liệu về cho Activity DanhSachSanPhamActivity
            Intent intent = new Intent();
            intent.putExtra("action", "update");
            intent.putExtra("maSanPham", newMaSanPham);
            intent.putExtra("maDanhMuc", newMaDanhMuc);
            intent.putExtra("tenSanPham", newTenSanPham);
            intent.putExtra("donGia", newDonGia);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    private void handleDelete() {
        new AlertDialog.Builder(this)
                .setTitle("Xóa sản phẩm")
                .setMessage("Bạn có chắc chắn muốn xóa sản phẩm này không?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Gửi dữ liệu về cho Activity DanhSachSanPhamActivity
                        Intent intent = new Intent();
                        intent.putExtra("action", "delete");
                        intent.putExtra("maSanPham", originalMaSanPham);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                })
                .setNegativeButton("NO", null)
                .show();
    }
}
