package 정렬;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution24 {
    public static int n;
    public static List<Integer> list = new ArrayList<>();
    public static int[] distance = new int[(int) 1e5]; // x에 안테나를 세웠을 경우에 총 거리 값

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int min = (int) 1e9;
        int answer = -1;

        for (int i = 1; i < distance.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                distance[i] = distance[i] + Math.abs(list.get(j) - i);
            }
            if (distance[i] < min) {
                min = distance[i];
                answer = i;
            }
        }
        System.out.print(answer);
    }
}
