import java.util.Scanner;
import java.util.regex.*;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("Enter password:");
            
            String password = scanner.nextLine();

            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
            Matcher matcher = pattern.matcher(password);
            
            if (matcher.matches()) {
                System.out.println("Password correct");
            } else {
                System.out.println("Password NOT correct");
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
 
        }
    }
}