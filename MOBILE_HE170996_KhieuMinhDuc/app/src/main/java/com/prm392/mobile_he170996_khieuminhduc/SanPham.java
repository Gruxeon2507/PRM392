package com.prm392.mobile_he170996_khieuminhduc;

public class SanPham {
    private String ma;
    private String maDanhMuc;
    private String ten;
    private String donGia;

    public SanPham(String ma, String maDanhMuc, String ten, String donGia) {
        this.ma = ma;
        this.maDanhMuc = maDanhMuc;
        this.ten = ten;
        this.donGia = donGia;
    }

    public String getMa() {
        return ma;
    }

    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    public String getTen() {
        return ten;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setMaDanhMuc(String s){
        this.maDanhMuc =s;
    }

    public void setTen(String s){
        this.ten =s;
    }
    public void setDonGia(String s){
        this.donGia =s;
    }
}
