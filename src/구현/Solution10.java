package 구현;

import java.util.Arrays;

class Solution10 {

    public static void main(String[] args) {
        Solution10 s = new Solution10();
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(s.solution(key, lock));
    }

    public boolean solution(int[][] key, int[][] lock) {
        int flatKey = Arrays.stream(key)
                .flatMapToInt(Arrays::stream)
                .filter(k -> k == 1).sum();

        int flatLock = Arrays.stream(lock)
                .flatMapToInt(Arrays::stream)
                .filter(l -> l == 0).sum();

        if (flatLock > flatKey) return false; // 열쇠보다 열쇠 홈이 더 큰 경우에는 어떻게든 불가능하므로 false 를 리턴해준다.

        // 1. x,y 축으로 이동해 가며 열쇠 홈에 맞는지 확인한다.
        // 2. 열쇠가 맞지 않은 경우 열쇠를 시계방향으로 돌려본다.

        int lockSize = lock.length;
        int keySize = key.length;
        // 자물쇠의 크기를 기존의 3배로 변환
        int[][] newLock = new int[lockSize * 3][lockSize * 3];
        // 새로운 자물쇠의 중앙 부분에 기존의 자물쇠 넣기
        for (int i = 0; i < lockSize; i++) {
            for (int j = 0; j < lockSize; j++) {
                newLock[i + lockSize][j + lockSize] = lock[i][j];
            }
        }

        // 4가지 방향에 대해서 확인
        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotateMatrixBy90Degree(key); // 열쇠 회전
            for (int x = 0; x < lockSize * 2; x++) {
                for (int y = 0; y < lockSize * 2; y++) {
                    // 자물쇠에 열쇠를 끼워 넣기
                    for (int i = 0; i < keySize; i++) {
                        for (int j = 0; j < keySize; j++) {
                            newLock[x + i][y + j] += key[i][j];
                        }
                    }
                    // 새로운 자물쇠에 열쇠가 정확히 들어 맞는지 검사
                    if (check(newLock)) return true;
                    // 자물쇠에서 열쇠를 다시 빼기
                    for (int i = 0; i < keySize; i++) {
                        for (int j = 0; j < keySize; j++) {
                            newLock[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }
        }
        return false;
    }

    public static int[][] rotateMatrixBy90Degree(int[][] a) {
        // 끝까지 못 채운 경우엔 열쇠를 시계방향 90도로 돌린다.
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[n][m]; // 결과 리스트
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][n - i - 1] = a[i][j];
            }
        }
        return result;
    }

    public static boolean check(int[][] newLock) {
        int lockSize = newLock.length / 3;
        for (int i = lockSize; i < lockSize * 2; i++) {
            for (int j = lockSize; j < lockSize * 2; j++) {
                if (newLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

}