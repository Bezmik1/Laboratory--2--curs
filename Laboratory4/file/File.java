import java.io.*;
import java.nio.file.*;

public class File {
    public static void main(String[] args) {
        Path file = Paths.get("Basket.txt");
        Path copy = Paths.get("CopyBasket.txt");

        try {
            Files.copy(file, copy, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл Basket.txt скопирован в CopyBasket.txt");
        } catch (NoSuchFileException e) {
            System.out.println("Ошибка: файл " + e.getMessage() + " не найден.");
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.toString());
        }
    }
}
// Не сущ файл - выдать ошибку