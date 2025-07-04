# 📦 E-Commerce System

A **Java-based e-commerce system** that simulates product management, cart operations, shipping, and checkout. This project showcases core object-oriented programming principles, validation logic, and real-world shopping workflows.

---

## 🚀 Features

- ✅ Define products with name, price, quantity, expiry status, and (optional) weight  
- 🛒 Add products to cart with quantity control  
- 📦 Calculate shipping cost for shippable items  
- 💰 Checkout with balance deduction and validation  
- 🚫 Handles edge cases like:
  - Empty cart
  - Expired products
  - Out-of-stock items
  - Insufficient balance  
- 📄 Console output includes:
  - Shipping notice
  - Itemized receipt
  - Total cost breakdown

---

## 🧠 Technologies Used

- **Java 8+**
- Object-Oriented Design (OOP)
- Java Collections (`List`, `Map`)
- Exception handling and input validation

---

## 📁 Project Structure

E-Commerce System/
├── Main.java
└── model/
├── Product.java
├── Shippable.java
├── ShippableProduct.java
├── Customer.java
├── Cart.java
├── CartItem.java
└── ShippingService.java
