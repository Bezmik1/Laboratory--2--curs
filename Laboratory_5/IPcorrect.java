import java.util.regex.*;

public class IPcorrect {

    public static void main(String[] args) {

        try {

            String ip = "119.168.255.200";

            if (ip == null || ip.isEmpty()) {
                throw new IllegalArgumentException("IP is empty!!!!");
            }
            String regex = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}"+"(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(ip);

            if (matcher.matches()) {
                System.out.println("CORRECT IP");
            } else {
                System.out.println("NOT CORRECT IP");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}