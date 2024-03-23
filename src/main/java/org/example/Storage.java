package org.example;

import java.util.ArrayList;
import java.util.List;

public class Storage implements Runnable {
    public static final List<Product> storage = new ArrayList<>();

    @Override
    public void run() {
        //добавляем пока все товары здесь, потом можно сделать класс продавца, который будет добавлять товары
        Product iPhone15ProBlack = new Product("IPhone 15 Pro", 125.5, 1.2, TypeOfProduct.SMARTPHONE, "черный", Manufacturer.APPLE);
        Product redmiNote9Black = new Product("Redmi Note 9", 37.5, 1.0, TypeOfProduct.SMARTPHONE, "черный", Manufacturer.XIAOMI);
        Product iPhone15ProGrey = new Product("IPhone 15 Pro", 125.5, 1.2, TypeOfProduct.SMARTPHONE, "серый", Manufacturer.APPLE);
        Product iPhone15Black = new Product("IPhone 15", 100.7, 0.9, TypeOfProduct.SMARTPHONE, "черный", Manufacturer.APPLE);
        Product galaxyS24Red = new Product("Galaxy S24", 70.3, 1.3, TypeOfProduct.SMARTPHONE, "красный", Manufacturer.SAMSUNG);
        Product xiaomiTVA2 = new Product("Xiaomi TV A2", 15.8, 10.5, TypeOfProduct.TV, "черный", Manufacturer.XIAOMI);
        Product iPadAir2023Black = new Product("IPad Air 2023", 97.5, 2.0, TypeOfProduct.TABLET, "черный", Manufacturer.APPLE);

        storage.add(iPhone15ProBlack);
        storage.add(iPhone15ProBlack);
        storage.add(iPhone15ProBlack);
        storage.add(redmiNote9Black);
        storage.add(redmiNote9Black);
        storage.add(redmiNote9Black);
        storage.add(iPhone15ProGrey);
        storage.add(iPhone15Black);
        storage.add(iPhone15Black);
        storage.add(iPhone15Black);
        storage.add(galaxyS24Red);
        storage.add(galaxyS24Red);
        storage.add(galaxyS24Red);
        storage.add(xiaomiTVA2);
        storage.add(xiaomiTVA2);
        storage.add(iPadAir2023Black);
        storage.add(iPadAir2023Black);
    }
}
