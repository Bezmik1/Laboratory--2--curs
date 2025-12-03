import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\ivanb\\OneDrive\\Рабочий стол\\6-я лаба\\text.txt";

        File file = new File(filePath);

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        

        Map<String, Integer> map = new HashMap<>();
        
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Zа-яА-Я]", "");
            if (!word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        
        scanner.close();
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            System.out.println(list.get(i).getKey());
        }
    }
}