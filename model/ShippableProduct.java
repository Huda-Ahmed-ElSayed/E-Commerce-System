package model;

public class ShippableProduct extends Product implements Shippable {
    private double weight;

    public ShippableProduct(String name, double price, int quantity, boolean isExpired, double weight) {
        super(name, price, quantity, isExpired);
        this.weight = weight;
    }

    public double getWeight() { return weight; }
}