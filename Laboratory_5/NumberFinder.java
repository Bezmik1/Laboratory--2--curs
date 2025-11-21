import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        try {
            String text = "The price of the product is $19.99, there are 25 items, and temperature is -5.5 degrees. Also 100 and 3.14 are numbers.";
            Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
            Matcher matcher = pattern.matcher(text);
            
            System.out.println("Number:");
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (Exception e) {
            System.out.println(": " + e.getMessage());
        }
    }
}