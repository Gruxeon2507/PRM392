package com.example.menu;

public class MenuItem {
    private String name;
    private String description;
    private String price;
    private int image;

    public MenuItem(String name, String description, String price, int image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getPrice() { return price; }
    public int getImage() { return image; }
}
