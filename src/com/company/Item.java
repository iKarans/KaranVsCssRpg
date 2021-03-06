package com.company;

public class Item {
    private String name;
    private String type;
    private String description;
    private int prop;
    private int quantity;

    public Item(String name, String type, String description, int prop, int quantity) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.prop = prop;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getProp() {
        return prop;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
