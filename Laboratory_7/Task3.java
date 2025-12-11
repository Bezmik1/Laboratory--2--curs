import java.util.concurrent.*;
import java.util.*;

public class Task3 {
    static class Warehouse {
        private List<Integer> goods = new ArrayList<>();
        private Semaphore semaphore = new Semaphore(3); // 3 грузчика
        private int currentWeight = 0;
        private final int MAX_WEIGHT = 150;
        
        public Warehouse() {
            // Добавляем товары разного веса
            goods.addAll(Arrays.asList(20, 30, 40, 50, 10, 25, 35, 45, 15, 60));
        }
        
        public void loadGoods() {
            while (!goods.isEmpty()) {
                try {
                    semaphore.acquire(); // Грузчик берет товар
                    
                    synchronized (this) {
                        if (!goods.isEmpty() && currentWeight + goods.get(0) <= MAX_WEIGHT) {
                            int weight = goods.remove(0);
                            currentWeight += weight;
                            System.out.println(Thread.currentThread().getName() + 
                                             " взял товар весом " + weight + " кг. " +
                                             "Текущий вес: " + currentWeight + " кг");
                            
                            if (currentWeight >= MAX_WEIGHT) {
                                deliverGoods();
                            }
                        }
                    }
                    
                    Thread.sleep(500); // Время на взятие товара
                    semaphore.release();
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            // Доставляем остатки
            synchronized (this) {
                if (currentWeight > 0) {
                    deliverGoods();
                }
            }
        }
        
        private synchronized void deliverGoods() {
            System.out.println("=== Грузчики везут " + currentWeight + " кг на другой склад ===");
            try {
                Thread.sleep(1000); // Время на доставку
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("=== Товары доставлены! ===");
            currentWeight = 0;
        }
    }
    
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        
        // Создаем 3 грузчика (потока)
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        for (int i = 1; i <= 3; i++) {
            final int loaderId = i;
            executor.execute(() -> {
                System.out.println("Грузчик " + loaderId + " начал работу");
                warehouse.loadGoods();
                System.out.println("Грузчик " + loaderId + " закончил работу");
            });
        }
        
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}