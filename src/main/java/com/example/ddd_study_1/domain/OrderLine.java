package com.example.ddd_study_1.domain;

public class OrderLine {
    private Product product;
    private Money price;
    private int quantity;
    private Money amounts;

    public OrderLine(Product product, int price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmount();
    }

    private int calculateAmount() {
        return price.multiply(quantity);
    }

    public int getAmounts() {

    }
}
