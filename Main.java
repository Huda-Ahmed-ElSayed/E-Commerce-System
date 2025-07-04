import model.*;

import java.util.*;

public class Main {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        double subtotal = 0;
        double shipping = 0;
        List<Shippable> shippables = new ArrayList<>();
        Map<String, Integer> shippingQuantities = new HashMap<>();

        for (CartItem item : cart.getItems()) {
            Product p = item.product;
            int q = item.quantity;
            subtotal += p.getPrice() * q;

            if (p instanceof Shippable) {
                shippables.add((Shippable) p);
                shippingQuantities.put(p.getName(), shippingQuantities.getOrDefault(p.getName(), 0) + q);
                shipping += 15; 
            }
        }

        double total = subtotal + shipping;
        if (customer.getBalance() < total) {
            System.out.println("Insufficient balance!");
            return;
        }

        if (!shippables.isEmpty()) {
            ShippingService.ship(shippables, shippingQuantities);
        }

        for (CartItem item : cart.getItems()) {
            item.product.reduceQuantity(item.quantity);
        }

        customer.deduct(total);

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %-12s %.0f%n", item.quantity, item.product.getName(),
                    item.quantity * item.product.getPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal         %.0f%n", subtotal);
        System.out.printf("Shipping         %.0f%n", shipping);
        System.out.printf("Amount           %.0f%n", total);
        System.out.printf("Remaining Balance: %.0f%n", customer.getBalance());

        cart.clear();
    }

    public static void main(String[] args) {
        Product cheese = new ShippableProduct("Cheese", 100, 5, false, 0.2);
        Product biscuits = new ShippableProduct("Biscuits", 150, 3, false, 0.7);
        Product tv = new ShippableProduct("TV", 4000, 2, false, 7);
        Product scratchCard = new Product("ScratchCard", 50, 10, false);

        Customer customer = new Customer("Huda", 1000);
        Cart cart = new Cart();

        try {
            cart.add(cheese, 2);
            cart.add(biscuits, 1);
            cart.add(scratchCard, 1);

            checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Checkout error: " + e.getMessage());
        }
    }
}