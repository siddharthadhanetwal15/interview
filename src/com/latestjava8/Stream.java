package com.latestjava8;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Product{
    int id;
    String name;
    int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
public class Stream {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "boxer", 300));
        productList.add(new Product(2, "tshirt", 500));
        productList.add(new Product(3, "mask", 10));
        // filter products where price greater then 250 and add to another list
        List<Product> filteredList = productList.stream()
                .filter(p->p.price>250)
                .collect(Collectors.toList());
        System.out.println(filteredList);

        //filtering and iterating - optimized and consised code
        productList.stream().filter(p->p.price>350).forEach(product -> System.out.println(product.name));

        //use reduce() to get sum of all products prices
        int total = productList.stream()
                .map(product -> product.price)
                .reduce(0, (sum, price)->sum+price);
        System.out.println(total);

        //optimized way
        int total2 = productList.stream()
                .map(product -> product.price)
                .reduce(0, Integer::sum);
        System.out.println(total2);

        //use collector() to get sum of all products prices
        int total3 = productList.stream()
                .collect(Collectors.summingInt(product-> product.price));
        System.out.println(total3);

        //find max
        Product product = productList.stream().max((product1, product2)->product1.price > product2.price ? 1:-1).get();
        System.out.println(product.price);

        //count
        long noOfProductsGT5 = productList.stream()
                .filter(p->p.price > 5)
                .count();
        System.out.println(noOfProductsGT5);

        //list to set
        Set<Product> productSet = productList.stream()
                .collect(Collectors.toSet());
        System.out.println(productSet);

        //foreach
        productList.forEach(System.out::println);
    }
}
