import java.util.regex.*;

public class CaseFinder {
    public static void main(String[] args) {
        
        try {

            String text = "StEfen CuRRy iS a ProFFeSsional basketBaLl in woRlD";
            
            if (text == null || text.isEmpty()) {
                throw new IllegalArgumentException("Text is empty");
            }
            
            Pattern pattern = Pattern.compile("([a-z])([A-Z])");
            Matcher matcher = pattern.matcher(text);

            String result = matcher.replaceAll("!$1$2!");

            System.out.println(result);

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }
}