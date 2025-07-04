package model;

import java.util.*;

public class ShippingService {
    public static void ship(List<Shippable> shippables, Map<String, Integer> quantities) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (Shippable item : shippables) {
            int qty = quantities.get(item.getName());
            double weight = item.getWeight() * qty;
            System.out.printf("%dx %-12s %.0fg%n", qty, item.getName(), weight * 1000);
            totalWeight += weight;
        }
        System.out.printf("Total package weight %.1fkg%n%n", totalWeight);
    }
}