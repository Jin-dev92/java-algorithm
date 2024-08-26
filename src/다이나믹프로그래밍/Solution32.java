package 다이나믹프로그래밍;

import java.util.Scanner;

public class Solution32 {
    public static int[][] map;
    public static int[][] dp;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                dp[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (j >= 1 && i >= 1) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 1]) + map[i][j];
                }
            }
        }
//        System.out.print(Arrays.deepToString(dp));
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                result = Math.max(result, dp[i][j]);
            }
        }
        System.out.print(result);
    }
}
