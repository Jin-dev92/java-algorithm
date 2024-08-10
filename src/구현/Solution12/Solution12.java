package 구현.Solution12;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Structure {
    private int[] point; // 설치 지점
    private int[] endPoint; // 설치 후 끝 좌표
    private int type; // 1 = 보, 0 = 기둥
    private int action; // 1 = 설치, 0 = 삭제
    private int[] movePaper = {1, 0};
    private int[] movePilar = {0, 1};

    public Structure(int[] point, int type, int action) {
        this.point = point;
        this.type = type;
        this.action = action;
        this.endPoint = new int[]{point[0] + type == 1 ? movePaper[0] : movePilar[0], point[1] + type == 1 ? movePaper[1] : movePilar[1]};
    }

    public int[] getPoint() {
        return this.point;
    }

    public int[] getEndPoint() {
        return this.endPoint;
    }

    public int getType() {
        return this.type;
    }

    public int getAction() {
        return this.action;
    }

    public int[] getAnswer() {
        return new int[]{this.point[0], this.point[1], this.type};
    }

}

class Solution12 {
    public static int n = 5;
    public static int[][] build_frame = {
            {1, 0, 0, 1}, // x,y,a,b  x,y 좌표  // a 구조물 종류 -> 0 기둥: 1 보: b -> 설치 혹은 삭제 0: 삭제 1:설치
            {1, 1, 1, 1},
            {2, 1, 0, 1},
            {2, 2, 1, 1},
            {5, 0, 0, 1},
            {5, 1, 0, 1},
            {4, 2, 1, 1},
            {3, 2, 1, 1}
    };

    public static void main(String[] args) {
        Solution12 s = new Solution12();
        System.out.println(Arrays.deepToString(s.solution(n, build_frame)));
    }

    public int[][] solution(int n, int[][] build_frame) {
        int[][] graph = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int[] frame : build_frame) {
            Structure st = new Structure(new int[]{frame[0], frame[1]}, frame[2], frame[3]);
            if (!check(st, graph)) { // 제작하려는 Structure 가 규칙에 위반됐는지 확인하기
                continue;
            }
            // answer 에 build_frame 정보 입력하기
            queue.offer(st.getAnswer()); // answer 가 규칙에 위반 되지 않았으므로 정답 큐에 입력.
        }
        System.out.println(Arrays.deepToString(graph));
        int[][] answer = {};
        return answer;
    }
    /*
     *   1. 기둥은 바닥 위에 있거나 보의 한쪽 끝부분 위에 있거나, 또는 다른 기둥 위에 있어야 합니다.
     *   2. 보는 한쪽 끝부분이 기둥 위에 있꺼나, 또는 양쪽 끝부분이 다른 보와 동시에 연결 되어 있어야 합니다.
     *   3. 벽면을 벗어나게 기둥 혹은 보를 설치하는 경우는 없습니다.
     *   4. 바닥에 보를 설치하는 경우는 없습니다.
     *   5. 구조물은 교차점 좌표를 기준으로 보는 오른쪽, 기둥은 위쪽 방향으로 설치 또는 삭제합니다.
     * */

    public boolean check(Structure st, int[][] cached) {
        for (int i = 0; i < cached.length; i++) {
            for (int j = 0; j < cached[i].length; j++) {

            }
        }
        return true;
    }
}