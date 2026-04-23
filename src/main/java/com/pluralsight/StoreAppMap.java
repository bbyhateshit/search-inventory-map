package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StoreAppMap {

    public static void main(String[] args) {
        Map<String, Product> inventory = loadInventory();

        System.out.println("Inventory Loaded:");
        for (String key : inventory.keySet()) {
            Product p = inventory.get(key);
            System.out.printf("id: %d | %s | $%.2f%n",
                    p.getId(), p.getName(), p.getPrice());

            System.out.println(key);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nSearch for a product by name: ");
        String search = scanner.nextLine();

        Product found = inventory.get(search.trim());
        ;

        if (found != null) {
            System.out.printf("FOUND → id: %d | %s | $%.2f%n",
                    found.getId(), found.getName(), found.getPrice());
        } else {
            System.out.println("Product not found.");
        }
    }

    public static Map<String, Product> loadInventory() {
        Map<String, Product> inventory = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1].trim();
                double price = Double.parseDouble(parts[2]);

                Product p = new Product(id, name, price);

                inventory.put(name, p);
            }

        } catch (IOException e) {
            System.out.println("Error reading inventory file: " + e.getMessage());
        }

        return inventory;
    }
}

