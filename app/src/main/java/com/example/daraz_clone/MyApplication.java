package com.example.daraz_clone;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {
    public static ArrayList<Category> categories;

    @Override
    public void onCreate() {
        super.onCreate();
        categories = new ArrayList<>();
        categories.add(new Category(12, "Shoes", "shoes"));
        categories.add(new Category(2, "Shirts", "shirts"));
        categories.add(new Category(12, "Pents", "pents"));
        categories.add(new Category(12, "Clothes", "clothes"));

    }
}
