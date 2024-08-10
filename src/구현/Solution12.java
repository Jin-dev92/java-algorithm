package 구현;

class Solution12 {
    public static int n = 5;
    public static int[][] build_frame = {
            {1, 0, 0, 1},
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
        System.out.println(s.solution(n, build_frame).toString());
    }

    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        int[][] map = new int[n][n];

        return answer;
    }
}
