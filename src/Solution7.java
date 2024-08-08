import java.util.Scanner;

public class Solution7 {
    public static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        System.out.println(getLucky(N));
    }

    public static String getLucky(String N) {
        String left = N.substring(0, N.length() / 2);
        String right = N.substring(N.length() / 2, N.length());

        for (int i = 0; i < left.length(); i++) {
            sum += Character.getNumericValue(left.charAt(i));
            System.out.println(left.charAt(i) - '0');
        }

        for (int i = 0; i < right.length(); i++) {
            sum -= Character.getNumericValue(left.charAt(i));
        }

        return sum == 0 ? "LUCKY" : "READY";
    }
}
