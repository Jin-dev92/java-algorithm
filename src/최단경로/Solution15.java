package 최단경로;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution15 {
    public static int N; // 도시의 개수
    public static int M; // 도로의 개수
    public static int K; // 최단 거리
    public static int X; // 출발 도시의 번호
    public static ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
    public static int[] d = new int[300001];

    // 간선의 길이가 같을 경우에는 BFS 사용.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        K = scanner.nextInt();
        X = scanner.nextInt();

        for (int i = 0; i <= N; i++) { // 맵 및 최단거리 테이블 초기화
            map.add(new ArrayList<Integer>());
            d[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();
            map.get(a).add(b);
        }
        // 출발도시의 거리는 0으로 고정
        d[X] = 0;

        // 너비 우선 탐색으로 수행
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(X);
        while (!q.isEmpty()) {
            int now = q.poll();
            // 현재 도시에서 이동할 수 있는 모든 도시를 확인
            for (int i = 0; i < map.get(now).size(); i++) {
                int nextNode = map.get(now).get(i);
                // 아직 방문하지 않은 도시 라면?
                if (d[nextNode] == -1) {
                    //최단 거리 갱신
                    d[nextNode] = d[now] + 1;
                    q.offer(nextNode);
                }
            }
        }


        // 최단 거리가 K 인 모든 도시의 번호를 오름차순으로 출력
        boolean check = false;
        for (int i = 1; i <= N; i++) {
            if (d[i] == K) {
                System.out.println(i);
                check = true;
            }
        }
        // 만약 최단 거리가 K인 도시가 없다면 -1 출력
        if (!check) System.out.println(-1);
    }
}
