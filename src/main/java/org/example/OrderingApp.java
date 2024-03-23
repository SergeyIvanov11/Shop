package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderingApp implements Runnable {
    public static Map<Product, Long> productsFromStorage;
    private static Customer customer;
    private BufferedReader bufferedReader;

    @Override
    public void run() {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Здравствуйте! Введите ваше имя: ");
            String name = bufferedReader.readLine();
            System.out.print("Если хотите, введите вашу электронную почту, куда мы отправим данные о заказе и чек: ");
            String email = bufferedReader.readLine();
            if (email == null || !email.contains("@")) { //здесь может быть множество условий проверки правильного адреса почты
                customer = new Customer(name);
            } else {
                customer = new Customer(name, email);
            }
            System.out.printf("Добро пожаловать в наш магазин!\n", customer.getName());
            showMenu();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void showMenu() throws IOException {
        System.out.println("Выберите опцию: \n" +
                "1. Показать список доступных товаров\n" +
                "2. Сделать заказ\n" +
                "3. Показать товары в вашей корзине\n" +
                "4. Показать сведения о вашем аккаунте (ник, email, количество сделанных заказов, ваша скидка)\n" +
                "5. Оплатить товары из корзины\n" +
                "6. Выйти из магазина\n");
        while (true) {
            String input = bufferedReader.readLine();
            if (Integer.parseInt(input) == 1) {
                System.out.println(showProducts());
                showMenu();
            } else if (Integer.parseInt(input) == 2) {
                makeOrder();
            } else if (Integer.parseInt(input) == 3) {
                showListOfProducts();
                showMenu();
            } else if (Integer.parseInt(input) == 4) {
                showCustomerInfo();
                showMenu();
            } else if (Integer.parseInt(input) == 5) {
                showListOfProducts();
                System.out.println("Итого к оплате: " + calculateTotalCost() + "тыс. руб.");
                break;
            } else if (Integer.parseInt(input) == 6) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Такой опции пока нет, давайте попробуем еще раз");
                showMenu();
            }
        }
    }

    protected void makeOrder() throws IOException {
        System.out.println(showProducts());
        System.out.println("Пожалуйста, выберите номер товара: ");
        int choice = Integer.parseInt(bufferedReader.readLine());
        Product wantedProduct = (Product) productsFromStorage.keySet().toArray()[choice - 1];

        System.out.println("Вы выбрали: " + wantedProduct.title + "  за цену в " + wantedProduct.price + " тыс. руб.");
        System.out.println("Укажите количество товара: ");
        int amount = Integer.parseInt(bufferedReader.readLine());
        if (amount > productsFromStorage.get(wantedProduct)) {
            System.out.println("К сожалению, на складе нет такого количества товара");
        } else {
            for (int i = 0; i < amount; i++) {
                customer.listOfProducts.add(wantedProduct);
                productsFromStorage.put(wantedProduct, productsFromStorage.get(wantedProduct) - 1);
            }
            System.out.println("Добавлено в корзину!");
        }
        while (true) {
            System.out.println("Желаете продолжить покупки? y/n ");
            String answer = bufferedReader.readLine();
            if (answer.equals("y") || answer.equals("Y") || answer.equals("Yes") || answer.equals("yes")) {
                makeOrder();
            } else {
                System.out.println("Спасибо, теперь перейдите к опции оплаты");
                showMenu();
                break;
            }
        }
    }

    protected void showListOfProducts() throws IOException {
        if (customer.listOfProducts.size() == 0) {
            System.out.println("Ваша корзина пуста");
            showMenu();
        } else {
            System.out.println("В вашей корзине сейчас: ");
            for (Product product : customer.listOfProducts) {
                System.out.println(product.toString());
            }
        }
    }

    protected double checkDiscount() {
        if (customer.getNumberOfOrders() >= 5) {
            customer.setDiscount(0.0);
            return customer.getDiscount();
        } else {
            return customer.getDiscount();
        }
    }

    protected void showCustomerInfo() throws IOException {
        System.out.print("Имя вашего аккаунта: " + customer.getName() +
                "\nЭлектронная почта аккаунта: " + customer.getEmail() +
                "\nКоличество сделанных вами заказов: " + customer.getNumberOfOrders() +
                "\nВаша скидка составляет: " + checkDiscount() * 100 + "%\n");
    }

    protected String showProducts() {
        productsFromStorage = Storage.storage.stream()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        StringBuilder allProducts = new StringBuilder();
        allProducts.append("В настоящий момент мы можем предложить:\n");
        int num = 1;
        for (Product product : productsFromStorage.keySet()) {
            allProducts.append(num++ + " " + product.toString() + ", на складе имеется: " + productsFromStorage.get(product) + " штук\n");
        }
        return allProducts.toString();
    }

    protected double calculateTotalCost() {
        double totalCost = 0;
        for (Product product : customer.listOfProducts) {
            totalCost += product.price;
        }
        totalCost = totalCost - (totalCost * checkDiscount());
        customer.setNumberOfOrders(customer.getNumberOfOrders() + 1);
        return totalCost;
    }
}
