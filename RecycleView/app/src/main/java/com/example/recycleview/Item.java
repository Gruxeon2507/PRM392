package com.example.recycleview;

public class Item {
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public Item(String mName, int mImage) {
        this.mName = mName;
        this.mImage = mImage;
    }

    private String mName;
    private int mImage;
}
