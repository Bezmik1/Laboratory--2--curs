public class Task2 {
    
    static class MaxThread extends Thread {
        int[] row;
        int max;
        
        MaxThread(int[] row) {
            this.row = row;
        }
        
        public void run() {
            max = row[0];
            for (int i = 1; i < row.length; i++) {
                if (row[i] > max) {
                    max = row[i];
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 5, 3, 8, 2},
            {9, 4, 7, 1, 6},
            {3, 2, 9, 4, 5},
            {7, 8, 6, 2, 1}
        };
        
        MaxThread[] threads = new MaxThread[matrix.length];
        
        for (int i = 0; i < matrix.length; i++) {
            threads[i] = new MaxThread(matrix[i]);
            threads[i].start();
        }
        
        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int globalMax = threads[0].max;
        for (int i = 1; i < threads.length; i++) {
            if (threads[i].max > globalMax) {
                globalMax = threads[i].max;
            }
        }
       
        System.out.println("Наибольший элемент в матрице: " + globalMax);
    }
}