package com.cardoza.foodcart;

public class Food {

    private int id;

    private String item;
    private float price;

    public Food(int id, String item, float price) {
        this.id = id;
        this.item = item;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
