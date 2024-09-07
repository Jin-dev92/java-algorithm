package 다이나믹프로그래밍;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution34 {
    public static int n;
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (i + 1 < list.size() && list.get(i) > list.get(i + 1)) {
                list.remove(i + 1);
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
