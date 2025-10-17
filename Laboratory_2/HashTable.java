import java.util.LinkedList;

public class HashTable<K, V> {
    
    private static class Entry<K, V> {
        private K key;
        private V value;
        
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K getKey() { return key; }
        public V getValue() { return value; }
        public void setValue(V value) { this.value = value; }
    }
    
    
    private LinkedList<Entry<K, V>>[] table;  
    private int size;                         
    private static final int DEFAULT_CAPACITY = 16;  
    
    
    @SuppressWarnings("unchecked")
    public HashTable() {
        table = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }
    
    
    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }
    
    
    public void put(K key, V value) {
        int index = hash(key);  
        
        
        if (table[index] == null) {
            table[index] = new LinkedList<Entry<K, V>>();
        }
        
        
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                
                entry.setValue(value);
                return;
            }
        }
        
        table[index].add(new Entry<K, V>(key, value));
        size++;  
    }
    
    public V get(K key) {
        int index = hash(key);  
        
        if (table[index] == null) {
            return null;
        }
        
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();  
            }
        }
        return null;  
    }
    public boolean remove(K key) {
        int index = hash(key);  
        
        if (table[index] == null) {
            return false;
        }
        
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                
                table[index].remove(entry);
                size--;  
                
                
                if (table[index].isEmpty()) {
                    table[index] = null;
                }
                return true;  
            }
        }
        
        return false;  
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void display() {
        System.out.println("Содержимое хэш-таблицы:");
        System.out.println("Размер: " + size);
        System.out.println("Пуста: " + isEmpty());
        
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                System.out.print("Индекс " + i + ": ");
                for (Entry<K, V> entry : table[i]) {
                    System.out.print("[" + entry.getKey() + "=" + entry.getValue() + "] ");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("ДЕМОНСТРАЦИЯ РАБОТЫ ХЭШ-ТАБЛИЦЫ");
        System.out.println("================================\n");
        
        HashTable<String, Integer> studentGrades = new HashTable<>();
        
        System.out.println("1. Начальное состояние:");
        studentGrades.display();
        
        System.out.println("2. Добавляем оценки студентов:");
        studentGrades.put("Алексей", 85);
        studentGrades.put("Мария", 92);
        studentGrades.put("Иван", 78);
        studentGrades.put("Ольга", 95);
        studentGrades.display();
        
        System.out.println("3. Получаем оценки:");
        System.out.println("Оценка Алексея: " + studentGrades.get("Алексей"));
        System.out.println("Оценка Марии: " + studentGrades.get("Мария"));
        System.out.println("Оценка несуществующего студента: " + studentGrades.get("Петр"));
        System.out.println();
        
        System.out.println("4. Обновляем оценку Ивана:");
        studentGrades.put("Иван", 88); 
        System.out.println("Новая оценка Ивана: " + studentGrades.get("Иван"));
        studentGrades.display();
        
        System.out.println("5. Удаляем Ольгу:");
        boolean removed = studentGrades.remove("Ольга");
        System.out.println("Удаление выполнено: " + removed);
        System.out.println("Оценка Ольги после удаления: " + studentGrades.get("Ольга"));
        studentGrades.display();
        
        System.out.println("6. Финальная проверка:");
        System.out.println("Количество студентов: " + studentGrades.size());
        System.out.println("Таблица пуста: " + studentGrades.isEmpty());
    }
}