package 구현;
//
//
//class Node {
//    private int time;
//    private char direction;
//
//    public Node(int time, char direction) {
//        this.time = time;
//        this.direction = direction;
//    }
//
//    public int getTime() {
//        return this.time;
//    }
//
//    public char getDirection() {
//        return this.direction;
//    }
//}
//
//public class Solution11 {
//    public static int N; // 보드의 크기
//    public static int K; // 사과의 갯수
//    public static int L; // 뱀의 방향 변환 횟수
//    public static ArrayList<Node> info = new ArrayList<>();
//    public static int[][] map = new int[101][101];
//
//    public static void main(String[] args) {
////        데이터 세팅
//        Scanner sc = new Scanner(System.in);
//        N = sc.nextInt();
//        K = sc.nextInt();
//        for (int i = 0; i < K; i++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            map[a][b] = 1;
//        }
//        L = sc.nextInt();
//        for (int i = 0; i < L; i++) {
//            int x = sc.nextInt();
//            char c = sc.next().charAt(0);
//            info.add(new Node(x, c));
//        }
//        // 문제 풀이 시작
//        int[] head = {0, 0};
//        int headDirection = 0; // 처음 뱀의 머리는 동쪽을 보고 있음.
//        for (Node i : info) {
//            turn(headDirection, i.getDirection());
//            for (int j = 0; j < i.getTime(); j++) {
//                go(headDirection, head);
//            }
//        }
//    }
//
//    public static void go(int direction, int[] head) {
//        switch (direction) {
//            case 0:
//                head[0] += 1;
//                break;
//            case 1:
//                head[1] += 1;
//                break;
//            case 2:
//                head[0] -= 1;
//                break;
//            case 3:
//                head[1] -= 1;
//                break;
//            default:
//                break;
//        }
//    }
//
//    public static int turn(int direction, char c) { // 동=0 , 남=1, 서=2, 북=3
//        if (c == 'L') direction = (direction == 0) ? 3 : direction - 1;
//        else direction = (direction + 1) % 4;
//        return direction;
//    }
//}
/*
*  정답 풀이
*
* */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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

class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class Solution11 {

    public static int n, k, l;
    public static int[][] arr = new int[101][101]; // 맵 정보
    public static ArrayList<Node> info = new ArrayList<>(); // 방향 회전 정보

    // 처음에는 오른쪽을 보고 있으므로(동, 남, 서, 북)
    public static int dx[] = {0, 1, 0, -1};
    public static int dy[] = {1, 0, -1, 0};

    public static int turn(int direction, char c) {
        if (c == 'L') direction = (direction == 0) ? 3 : direction - 1;
        else direction = (direction + 1) % 4;
        return direction;
    }

    public static int simulate() {
        int x = 1, y = 1; // 뱀의 머리 위치
        arr[x][y] = 2; // 뱀이 존재하는 위치는 2로 표시
        int direction = 0; // 처음에는 동쪽을 보고 있음
        int time = 0; // 시작한 뒤에 지난 '초' 시간
        int index = 0; // 다음에 회전할 정보
        // 뱀이 차지하고 있는 위치 정보(꼬리가 앞쪽)
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x, y)); // offer 와 add 의 차이는 add 는 큐의 용량 제한에 걸리면 예외가 발생하고 offer 는 false 반환.

        while (true) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            // 맵 범위 안에 있고, 뱀의 몸통이 없는 위치라면
            if (1 <= nx && nx <= n && 1 <= ny && ny <= n && arr[nx][ny] != 2) {
                // 사과가 없다면 이동 후에 꼬리 제거
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = 2;
                    q.offer(new Position(nx, ny));
                    Position prev = q.poll();
                    arr[prev.getX()][prev.getY()] = 0;
                }
                // 사과가 있다면 이동 후에 꼬리 그대로 두기
                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = 2;
                    q.offer(new Position(nx, ny));
                }
            }
            // 벽이나 뱀의 몸통과 부딪혔다면
            else {
                time += 1;
                break;
            }
            // 다음 위치로 머리를 이동
            x = nx;
            y = ny;
            time += 1;
            if (index < l && time == info.get(index).getTime()) { // 회전할 시간인 경우 회전
                direction = turn(direction, info.get(index).getDirection());
                index += 1;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        // 맵 정보(사과 있는 곳은 1로 표시)
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
        }

        // 방향 회전 정보 입력
        l = sc.nextInt();
        for (int i = 0; i < l; i++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0);
            info.add(new Node(x, c));
        }

        System.out.println(simulate());
    }

}