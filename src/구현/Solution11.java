package 구현;

import java.util.ArrayList;
import java.util.Scanner;

class Node {
    private int time;
    private char direction;

    public Node(int time, char direction) {
        this.time = time;
        this.direction = direction;
    }

    public int getTime() {
        return this.time;
    }

    public char getDirection() {
        return this.direction;
    }
}

public class Solution11 {
    public static int N; // 보드의 크기
    public static int K; // 사과의 갯수
    public static int L; // 뱀의 방향 변환 횟수
    public static ArrayList<Node> info = new ArrayList<>();
    public static int[][] map = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = 1;
        }
        L = sc.nextInt();
        for (int i = 0; i < L; i++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0);
            info.add(new Node(x, c));
        }
    }
}
