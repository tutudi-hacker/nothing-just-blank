package Lab06ex8;

import java.util.ArrayList;
import java.util.List;

public class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String get_info() {
        return "Product: " + this.name + " | Price: $" + this.price;
    }

    public static void main(String[] args) {
        List<Product> catalog = new ArrayList<>();
        catalog.add(new Electronics("Laptop", 999.99, "2 Years"));
        catalog.add(new Clothing("T-Shirt", 24.50, "L"));
        catalog.add(new Book("Effective Java", 45.00, "Joshua Bloch"));

        for (Product product : catalog) {
            System.out.println(product.get_info());
        }
    }
}

class Electronics extends Product {
    private String warranty;

    public Electronics(String name, double price, String warranty) {
        super(name, price);
        this.warranty = warranty;
    }

    @Override
    public String get_info() {
        return "Electronics: " + this.name + " | Price: $" + this.price + " | Warranty: " + this.warranty;
    }
}

class Clothing extends Product {
    private String size;

    public Clothing(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

    @Override
    public String get_info() {
        return "Clothing: " + this.name + " | Price: $" + this.price + " | Size: " + this.size;
    }
}

class Book extends Product {
    private String author;

    public Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

    @Override
    public String get_info() {
        return "Book: " + this.name + " | Price: $" + this.price + " | Author: " + this.author;
    }
}
