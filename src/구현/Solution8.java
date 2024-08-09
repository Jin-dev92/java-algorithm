package 구현;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution8 {
    public static String str;
    public static int sum;
    public static ArrayList<Character> characters = new ArrayList<Character>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                characters.add(str.charAt(i));
            } else {
                sum += Character.getNumericValue(str.charAt(i));
            }
        }

        Collections.sort(characters);
        if (sum > 0) {
            StringBuilder sb = new StringBuilder();
            for (char c : characters) {
                sb.append(c);
            }
            System.out.println(sb.toString() + sum);
        }
    }
}
