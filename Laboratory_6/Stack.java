public class Stack<T> {
    private T[] data;
    private int size;

    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size < data.length) {
            data[size] = element;
            size++;
        }
    }

    public T pop() {
        if (size > 0) {
            size--;
            T element = data[size];
            data[size] = null;
            return element;
        }
        return null;
    }

    public T peek() {
        if (size > 0) {
            return data[size - 1];
        }
        return null;
    }
    
}