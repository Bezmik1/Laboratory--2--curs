import java.util.Enumeration;
import java.util.Hashtable;

class Book {
    private String title;
    private String author;
    private int copies;
    
    public Book(String title, String author, int copies) {
        this.title = title;
        this.author = author;
        this.copies = copies;
    }
    
    // Геттеры
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getCopies() { return copies; }
    
    // Сеттеры
    public void setCopies(int copies) { this.copies = copies; }
    
    @Override
    public String toString() {
        return "Название: '" + title + "', Автор: '" + author + "', Копий: " + copies;
    }
}

public class Library {
    private Hashtable<String, Book> books;
    
    public Library() {
        books = new Hashtable<>();
    }
    
    // Вставка книги
    public void addBook(String isbn, String title, String author, int copies) {
        Book book = new Book(title, author, copies);
        books.put(isbn, book);
        System.out.println("Книга добавлена: " + title + " (ISBN: " + isbn + ")");
    }
    
    // Поиск книги по ISBN
    public Book findBook(String isbn) {
        Book book = books.get(isbn);
        if (book != null) {
            System.out.println("Найдена книга: " + book + " (ISBN: " + isbn + ")");
        } else {
            System.out.println("Книга с ISBN " + isbn + " не найдена");
        }
        return book;
    }
    
    // Удаление книги по ISBN
    public boolean removeBook(String isbn) {
        Book removedBook = books.remove(isbn);
        if (removedBook != null) {
            System.out.println("Книга удалена: " + removedBook.getTitle() + " (ISBN: " + isbn + ")");
            return true;
        } else {
            System.out.println("Книга с ISBN " + isbn + " не найдена для удаления");
            return false;
        }
    }
    
    // Показать все книги
    public void displayAllBooks() {
        System.out.println("\n=== ВСЕ КНИГИ В БИБЛИОТЕКЕ ===");
        if (books.isEmpty()) {
            System.out.println("Библиотека пуста");
            return;
        }
        
        Enumeration<String> isbns = books.keys();
        while (isbns.hasMoreElements()) {
            String isbn = isbns.nextElement();
            Book book = books.get(isbn);
            System.out.println("ISBN: " + isbn + " -> " + book);
        }
    }
    
    public static void main(String[] args) {
        Library library = new Library();
        
        // Добавление книг
        System.out.println("=== ДОБАВЛЕНИЕ КНИГ ===");
        library.addBook("978-5-389-07435-4", "Мастер и Маргарита", "Михаил Булгаков", 3);
        library.addBook("978-5-17-087885-8", "Преступление и наказание", "Федор Достоевский", 5);
        library.addBook("978-5-699-79890-5", "Война и мир", "Лев Толстой", 2);
        
        // Поиск книг
        System.out.println("\n=== ПОИСК КНИГ ===");
        library.findBook("978-5-389-07435-4");
        library.findBook("999-0-000-00000-0"); // Несуществующий ISBN
        
        // Показать все книги
        library.displayAllBooks();
        
        // Удаление книги
        System.out.println("\n=== УДАЛЕНИЕ КНИГИ ===");
        library.removeBook("978-5-699-79890-5");
        
        // Попытка удалить несуществующую книгу
        library.removeBook("999-0-000-00000-0");
        
        // Показать все книги после удаления
        library.displayAllBooks();
    }
}