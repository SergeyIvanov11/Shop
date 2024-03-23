# Реализация задания "Магазин"

Постарался максимально следовать принципам Magics, DRY, SOLID. Приведу примеры из кода:
* [Magics](https://github.com/SergeyIvanov11/Shop/blob/dc25ffbe3f76462f6799cb304c70db1d1e43dc4f/src/main/java/org/example/Customer.java#L12) - значения скидки зависят от верификации аккаунта и кол-ва заказов
* [DRY](https://github.com/SergeyIvanov11/Shop/blob/dc25ffbe3f76462f6799cb304c70db1d1e43dc4f/src/main/java/org/example/OrderingApp.java#L35) - для отображения меню и различных опций созданы свои методы
* S - [принцип единственной ответственности](https://github.com/SergeyIvanov11/Shop/blob/dc25ffbe3f76462f6799cb304c70db1d1e43dc4f/src/main/java/org/example/Product.java#L3) - созданы отдельные классы товара, покупателя,
склада, самой программы заказов, в будущем можно добавить классы продавца, того же логгера
* O - [принцип открытости/закрытости](https://github.com/SergeyIvanov11/Shop/blob/dc25ffbe3f76462f6799cb304c70db1d1e43dc4f/src/main/java/org/example/OrderingApp.java#L35) - в функционал класса самой программы заказов можно
дополнительно добавить функции сортировки товаров (просто добавив новые методы по обработке внутренней мапы)
* L - принцип замены Барбары Лисков
* I - [принцип сегрегации (разделения) интерфейса](https://github.com/SergeyIvanov11/Shop/blob/dc25ffbe3f76462f6799cb304c70db1d1e43dc4f/src/main/java/org/example/Storage.java#L6)
* D - [принцип инверсии зависимостей](https://github.com/SergeyIvanov11/Shop/blob/dc25ffbe3f76462f6799cb304c70db1d1e43dc4f/src/main/java/org/example/Storage.java#L6) - опять же отдельные классы для разных участников бизнеса,
решил реализовать через многопоточность, поэтому интерфейсы кроме Runnable не использовал, можно добавить логгер в будущем чтобы вместо консоли использовать браузер
