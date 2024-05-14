package com.example.daraz_clone;

public class Category {
   private int subCategories;
   private String name;
   private String imgUrl; //

    public Category() {
    }

    public Category(int subCategories, String name, String imgUrl) {
        this.subCategories = subCategories;
        this.name = name;
        this.imgUrl = imgUrl;
    }

    public int getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(int subCategories) {
        this.subCategories = subCategories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
