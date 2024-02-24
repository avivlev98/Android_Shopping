package com.example.AndroidFragments.Classes;

import java.util.ArrayList;
import java.util.List;

public class ProductData {
    public static List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();

        productList.add(new Product("Apple", 1.99, 0));
        productList.add(new Product("Banana", 0.99, 0));
        productList.add(new Product("Milk", 2.49, 0));
        productList.add(new Product("Bread", 1.79, 0));
        productList.add(new Product("Eggs", 3.99, 0));
        productList.add(new Product("Cheese", 4.49, 0));
        productList.add(new Product("Chicken", 5.99, 0));
        productList.add(new Product("Rice", 2.29, 0));
        productList.add(new Product("Potatoes", 1.49, 0));
        productList.add(new Product("Tomatoes", 2.99, 0));

        return productList;
    }
}
