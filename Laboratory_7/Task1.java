public class Task1 {
    
    static class SumThread extends Thread {
        int[] arr;
        int start, end;
        long sum = 0;
        
        SumThread(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }
        
        public void run() {
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
        }
    }
    
    public static void main(String[] args) {
        
        int[] numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = i + 1; 
        }
        
        SumThread t1 = new SumThread(numbers, 0, 5);
        SumThread t2 = new SumThread(numbers, 5, 10);
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        long total = t1.sum + t2.sum;
        System.out.println("Сумма 1-ой половины: " + t1.sum);
        System.out.println("Сумма 2-ой половины: " + t2.sum);
        System.out.println("Итого: " + total);
    }
}