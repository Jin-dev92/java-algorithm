import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution4 {
    public static int N;
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            arrayList.add(scanner.nextInt());
        }
        Collections.sort(arrayList);
        int sum = 1;
        for (int i = 0; i < N; i++) {
            // 만들 수 없는 금액을 찾은 경우 반복 종료
            System.out.printf("sum:%d,   i:%d \n", sum, i);
            if (sum < arrayList.get(i)) break;
            sum += arrayList.get(i);
        }
    }
}
