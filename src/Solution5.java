import java.util.ArrayList;
import java.util.Scanner;

public class Solution5 {
    public static int N; // 볼링공의 갯수
    public static int M; // 공의 최대 무게
    public static ArrayList<Integer> arrayList = new ArrayList<>(); // 각 볼링공의 무게

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 0; i < N; i++) {
            arrayList.add(sc.nextInt());
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                if (arrayList.get(i) != arrayList.get(j)) {
                    result++;
//                    System.out.print("(" + arrayList.get(i) + ", " + arrayList.get(j) + ") ");
                }
            }
        }

        System.out.println(result / 2);
    }
}
