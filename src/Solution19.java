import java.util.ArrayList;
import java.util.Scanner;

public class Solution19 {

    public static int n;
    // 연산을 수행하고자 하는 수 리스트
    public static ArrayList<Integer> numbers = new ArrayList<>();
    // 더하기, 빼기, 곱하기, 나누기 연산자 개수
    public static int add, sub, mul, div;



    // 최솟값과 최댓값 초기화
    public static int minValue = (int) 1e9;
    public static int maxValue = (int) -1e9;

    // 깊이 우선 탐색 (DFS) 메서드
    public static void dfs(int i, int now) {
        // 모든 연산자를 다 사용한 경우, 최솟값과 최댓값 업데이트
        if (i == n) {
            minValue = Math.min(minValue, now);
            maxValue = Math.max(maxValue, now);
        }
        else {
            // 각 연산자에 대하여 재귀적으로 수행
            if (add > 0) {
                add -= 1;
                dfs(i + 1, now + numbers.get(i));
                add += 1;
            }
            if (sub > 0) {
                sub -= 1;
                dfs(i + 1, now - numbers.get(i));
                sub += 1;
            }
            if (mul > 0) {
                mul -= 1;
                dfs(i + 1, now * numbers.get(i));
                mul += 1;
            }
            if (div > 0) {
                div -= 1;
                dfs(i + 1, now / numbers.get(i));
                div += 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            numbers.add(x);
        }

        add = sc.nextInt();
        sub = sc.nextInt();
        mul = sc.nextInt();
        div = sc.nextInt();

        // DFS 메서드 호출
        dfs(1, numbers.get(0));

        // 최댓값과 최솟값 차례대로 출력
        System.out.println(maxValue);
        System.out.println(minValue);
    }
}