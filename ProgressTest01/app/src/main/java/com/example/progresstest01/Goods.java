package com.example.progresstest01;

public class Goods {
    private String code;
    private String name;
    private double price;
    private String type;
    private String details;

    public Goods(String code, String name, double price, String type, String details) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.type = type;
        this.details = details;
    }

    // Getters and setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPrice() { return price+""; }
    public void setPrice(double price) { this.price = price; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}
