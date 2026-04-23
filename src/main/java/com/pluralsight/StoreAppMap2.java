package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.pluralsight.StoreAppMap.loadInventory;

public class StoreAppMap2 {

    public static void main(String[] args) {
        Map<String, Product> inventory = loadInventory();

        System.out.println("Inventory Loaded:");
        Scanner scanner = new Scanner(System.in);
        String again = "yes";

        while (again.equalsIgnoreCase("yes")) {

            System.out.print("\nSearch for a product by name: ");
            String search = scanner.nextLine();

            Product found = inventory.get(search);

            if (found != null) {
                System.out.printf("FOUND → id: %d | %s | $%.2f%n",
                        found.getId(), found.getName(), found.getPrice());
            } else {
                System.out.println("Product not found.");
            }

            System.out.print("Do you want to search again? (yes/no): ");
            again = scanner.nextLine();
        }

        System.out.println("Goodbye!");

        class Inventory {

            public static void main2(String[] args) {
                try (BufferedReader reader = new BufferedReader(new FileReader("src/..."))) {
                    String line;

                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split("\\|");

                        int id = Integer.parseInt(parts[0]);
                        String name = parts[1].trim();
                        double price = Double.parseDouble(parts[2]);

                        Product p = new Product(id, name, price);
                    }

                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

        }
    }
    }

