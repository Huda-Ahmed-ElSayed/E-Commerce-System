package model;

import java.util.*;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product p, int qty) {
        if (p.getQuantity() < qty) {
            throw new IllegalArgumentException("Not enough stock for " + p.getName());
        }
        if (p.isExpired()) {
            throw new IllegalArgumentException("Product " + p.getName() + " is expired");
        }
        items.add(new CartItem(p, qty));
    }

    public List<CartItem> getItems() { return items; }

    public boolean isEmpty() { return items.isEmpty(); }

    public void clear() { items.clear(); }
}