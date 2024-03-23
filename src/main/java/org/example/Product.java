package org.example;

public class Product {
    protected String title;
    protected double price;
    protected double weight;
    protected TypeOfProduct type;
    protected String color;
    protected Manufacturer manufacturer;

    public Product(String title, double price, double weight, TypeOfProduct type, String color, Manufacturer manufacturer) {
        this.title = title;
        this.price = price;
        this.weight = weight;
        this.type = type;
        this.color = color;
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "" + title +
                ", по цене " + price +
                " тыс. руб., цвета: " + color +
                ", от производителя: " + manufacturer;
    }
}
