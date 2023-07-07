package org.example;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class Main {
    record Product(String name, double price, int amount) {
    }

    public static void main(String[] args) {
        task1WithoutLambda();
        task1WithLambda();
        task2WithoutLambda();
        task2WithLambda();
        task3WithoutLambda();
        task3WithLambda();
    }

    public static void task1WithoutLambda() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter te line: ");
        // Keep lambda expressions short and simple
        String str = scanner.nextLine();
        ArrayList<String> list = new ArrayList<>();
        for (String s : str.split(" ")) {
            list.add(s);
        }
        Comparator<String> stringComparator = (s1, s2) -> s1.length() - s2.length();
        list.sort(stringComparator);
        System.out.println(list);
    }

    public static void task2WithoutLambda() {
        Random random = new Random(0);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(1, 12));
        }
        List<Integer> list2 = new ArrayList<>();
        for (Integer i : list) {
            list2.add(i * i);
        }
        System.out.println(list2);
    }

    public static void task3WithoutLambda() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Name1", 12.5, 20));
        products.add(new Product("Name2", 300.7, 12));
        products.add(new Product("Name3", 100.2, 21));
        products.add(new Product("Name4", 700.1, 22));
        List<Product> list = new ArrayList<>();
        for (Product p : products) {
            if (p.price < 100) {
                list.add(p);
            }
        }
        products.removeAll(list);
        System.out.println(products);
    }

    public static void task1WithLambda() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter te line: ");
        String str = scanner.nextLine();
        List<String> list = Arrays.stream(str.split(" ")).sorted().toList();
        System.out.println(list);

    }

    public static void task2WithLambda() {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        List<Integer> list = random.ints(10, 1, 10)
                .map(i -> i * i)
                .boxed()
                .toList();
        System.out.println(list);
    }

    public static void task3WithLambda() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Name1", 12.5, 20));
        products.add(new Product("Name2", 300.7, 12));
        products.add(new Product("Name3", 100.2, 21));
        products.add(new Product("Name4", 700.1, 22));
        products.stream().filter(p -> p.price > 100).forEach(s -> System.out.println(s));
    }
}

