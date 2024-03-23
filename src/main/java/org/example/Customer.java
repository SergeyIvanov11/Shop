package org.example;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String email;
    private int numberOfOrders;
    private double discount;
    protected List<Product> listOfProducts;
    final static double DISCOUNT_FOR_NEW_CUSTOMERS = 0.01;
    final static double DISCOUNT_FOR_VERIFIED_CUSTOMERS = 0.05;

    public Customer(String name) {
        this.name = name;
        this.email = null;
        this.numberOfOrders = 0;
        this.discount = DISCOUNT_FOR_NEW_CUSTOMERS;
        this.listOfProducts = new ArrayList<Product>();
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.numberOfOrders = 0;
        this.discount = DISCOUNT_FOR_VERIFIED_CUSTOMERS;
        this.listOfProducts = new ArrayList<Product>();
    }

    protected String getName() {
        return name;
    }

    protected String getEmail() {
        return email;
    }

    protected int getNumberOfOrders() {
        return numberOfOrders;
    }

    protected void setNumberOfOrders(int numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    protected double getDiscount() {
        return discount;
    }

    protected void setDiscount(double discount) {
        this.discount = discount;
    }
}
