package com.example.progresstest01;

import java.util.ArrayList;
import java.util.List;

public class GoodsDatabase {
    private static List<Goods> goodsList = new ArrayList<>();

    public void addGoods(Goods goods) {
        goodsList.add(goods);
    }

    public static List<Goods> getGoodsList() {
        return goodsList;
    }

    // Other CRUD methods (delete, update)
}

