package br.com.designPatterns;

public class Product {

    private int id;
    private String name;
    private String price;
    private int quantity;

    public Product () {}

    public Product (int id, String name, String price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString ( ) {
        return "Product [id= " + this.id + ", name= " + this.name + ", price= " + this.price + "]";
    }
}
