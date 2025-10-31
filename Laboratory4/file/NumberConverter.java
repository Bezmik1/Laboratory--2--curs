import java.io.*;
import java.util.logging.*;

class CustomNumberFormatException extends Exception {
    public CustomNumberFormatException(String message) {
        super(message);
    }
    
    public CustomNumberFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}

class ExceptionLogger {
    private static final Logger logger = Logger.getLogger(ExceptionLogger.class.getName());
    
    static {
        try {
            // Настраиваем запись ошибок в файл
            FileHandler fileHandler = new FileHandler("errors.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false); // Не выводим в консоль
        } catch (IOException e) {
            System.out.println("Ошибка создания файла для логов: " + e.getMessage());
        }
    }
    
    public static void logException(Exception e) {
        logger.log(Level.SEVERE, "Ошибка", e);
    }
}

public class NumberConverter {
    
    // Метод преобразует строку в число
    public static int convertToNumber(String text) throws CustomNumberFormatException {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            // Создаем наше исключение
            CustomNumberFormatException myException = 
                new CustomNumberFormatException(
                    "Строка '" + text + "' не является числом", 
                    e
                );
            
            // Записываем в файл
            ExceptionLogger.logException(myException);
            
            // Показываем ошибку
            throw myException;
        }
    }
    
    // Проверяем разные строки
    public static void testConversion(String[] texts) {
        for (String text : texts) {
            try {
                int result = convertToNumber(text);
                System.out.println("Успех: '" + text + "' = " + result);
            } catch (CustomNumberFormatException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Проверка преобразования строк:");
        
        String[] testTexts = {
            "123",       
            "45.6",      
            "hello",     
            "999",       
            "12a34",     
            "",         
            "3000000000" 
        };
        
        testConversion(testTexts);
        
        System.out.println("\nОшибки сохранены в файле errors.log");
    }
}