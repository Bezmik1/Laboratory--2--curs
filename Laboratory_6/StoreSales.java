import java.util.*;

public class StoreSales {
    // TreeSet для хранения списка проданных товаров
    private TreeSet<String> soldProducts;
    // TreeMap для подсчета количества продаж каждого товара
    private TreeMap<String, Integer> productCount;
    private double totalSales;
    
    public StoreSales() {
        soldProducts = new TreeSet<>();
        productCount = new TreeMap<>();
        totalSales = 0;
    }
    
    // Добавить проданный товар
    public void addProduct(String productName, double price) {
        // Добавляем товар в TreeSet
        soldProducts.add(productName);
        
        // Обновляем счетчик продаж в TreeMap
        productCount.put(productName, productCount.getOrDefault(productName, 0) + 1);
        
        // Обновляем общую сумму продаж
        totalSales += price;
    }
    
    // Вывести список проданных товаров (отсортированный по алфавиту)
    public void printSoldProducts() {
        System.out.println("Список проданных товаров (отсортированный по алфавиту):");
        for (String product : soldProducts) {
            System.out.println(product + " - продано " + productCount.get(product) + " раз(а)");
        }
    }
    
    // Посчитать общую сумму продаж
    public double getTotalSales() {
        return totalSales;
    }
    
    // Найти самый популярный товар
    public String findMostPopularProduct() {
        if (productCount.isEmpty()) {
            return "Нет проданных товаров";
        }
        
        String mostPopular = null;
        int maxCount = 0;
        
        for (Map.Entry<String, Integer> entry : productCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostPopular = entry.getKey();
            }
        }
        
        return mostPopular;
    }
    
    public static void main(String[] args) {
        StoreSales store = new StoreSales();
        
        // Добавляем проданные товары
        store.addProduct("Хлеб", 50);
        store.addProduct("Молоко", 80);
        store.addProduct("Хлеб", 50);
        store.addProduct("Масло", 120);
        store.addProduct("Молоко", 80);
        store.addProduct("Хлеб", 50);
        store.addProduct("Сахар", 60);
        store.addProduct("Яблоки", 100);
        store.addProduct("Масло", 120);
        
        // Выводим список проданных товаров
        store.printSoldProducts();
        
        // Считаем общую сумму продаж
        System.out.println("\nОбщая сумма продаж: " + store.getTotalSales() + " руб.");
        
        // Находим самый популярный товар
        System.out.println("Самый популярный товар: " + store.findMostPopularProduct());
    }
}