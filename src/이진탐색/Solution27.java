package 이진탐색;

import java.util.Scanner;
public class Solution27 {

    // 시작점과 끝점 사이에 중간점을 두고 찾으려는 값과 중간점을 비교하여 중간점이 크면 왼쪽 탐색, 작으면 오른쪽 탐색
    public static int lowerBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public static int upperBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    // 값이 [left_value, right_value]인 데이터의 개수를 반환하는 함수
    public static int countByRange(int[] arr, int leftValue, int rightValue) {
        // 유의: lowerBound와 upperBound는 end 변수의 값을 배열의 길이로 설정
        int rightIndex = upperBound(arr, rightValue, 0, arr.length);
        int leftIndex = lowerBound(arr, leftValue, 0, arr.length);
        return rightIndex - leftIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 데이터의 개수 N, 찾고자 하는 값 x 입력받기
        int n = sc.nextInt();
        int x = sc.nextInt();

        // 전체 데이터 입력받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 값이 [x, x] 범위에 있는 데이터의 개수 계산
        int cnt = countByRange(arr, x, x);

        // 값이 x인 원소가 존재하지 않는다면
        if (cnt == 0) System.out.println(-1);
            //  값이 x인 원소가 존재한다면
        else System.out.println(cnt); 
    }
}