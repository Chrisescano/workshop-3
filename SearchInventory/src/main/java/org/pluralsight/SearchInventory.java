package org.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class SearchInventory {
    public static void main(String[] args) {
        System.out.println("Hello and Welcome!");

        ArrayList<Product> inventory = readInventory();

        inventory.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getId() - o2.getId();
            }
        });

        for(Product product : inventory) {
            System.out.println(product);
        }

    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(1, "Snickers", 2.50));
        products.add(new Product(2, "Debbie Cakes", 1.10));
        products.add(new Product(3, "Recess", 0.50));
        products.add(new Product(4, "Mars Choco Bar", 0.75));
        products.add(new Product(5, "Hershey Milk Chocolate", 1.50));

        return products;
    }

    public static ArrayList<Product> readInventory() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));

            String fileLine;
            while((fileLine = bufferedReader.readLine()) != null) {
                String[] tokens = fileLine.split(",");
                products.add(new Product(
                        Integer.parseInt(tokens[0]),
                        tokens[1],
                        Double.parseDouble(tokens[2])
                ));
            }

            bufferedReader.close();
        } catch(IOException e) {
            System.out.println("Oops, could not read the file: inventory.csv");
            e.printStackTrace();
        }

        return products;
    }
}
