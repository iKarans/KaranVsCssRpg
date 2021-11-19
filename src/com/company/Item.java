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

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProp() {
        return prop;
    }

    public void setProp(int prop) {
        this.prop = prop;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
