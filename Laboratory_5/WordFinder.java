import java.util.Scanner;
import java.util.regex.*;

public class WordFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            String text = "Java is a powerful programming language. JavaScript is also popular. " +
                         "Many developers enjoy programming in Java.";
            
            System.out.println("Текст для поиска: " + text);
            System.out.println("\nВведите букву для поиска слов:");
            String letter = scanner.nextLine();
            
            if (letter.length() != 1) {
                System.out.println("Ошибка: введите одну букву!");
                return;
            }
            Pattern pattern = Pattern.compile("\\b[" + letter + "][a-zA-Z]*\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            
            System.out.println("\nСлова, начинающиеся с буквы '" + letter + "':");

            while (matcher.find()) {
                System.out.println("- " + matcher.group());
                
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}