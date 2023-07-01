package silver.binarysearch;

import java.util.Scanner;

public class Test2 {
    // 재귀함수를 이용한 이진 탐색
    public static int binarySearch(int[] arr, int target, int start, int end) {
        // 시작값이 끝값보다 크다면
        // 즉, 있을 수 없는 경우에는 -1을 return함으로써 binarySearch() 메소드를 탈출
        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        // 중간값과 목표값이 같을 경우
        if (arr[mid] == target)
            return mid;
        // 중간값이 목표값보다 클 경우
        else if (arr[mid] > target)
            // 끝값을 중간값 이전(mid index - 1)으로 이동
            return binarySearch(arr, target, start, mid - 1);
        // 중간값이 목표값보다 작을 경우
        else
            // 시작값을 중간값 이후(mid index + 1)로 이동
            return binarySearch(arr, target, mid + 1, end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 원소의 개수
        int n = sc.nextInt();
        // 목표값
        int target = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = sc.nextInt();
        }

        // 이진 탐색 수행 결과 출력
        int result = binarySearch(arr, target, 0, n - 1);
        if (result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        }
        else {
            System.out.println(result + 1);
        }
    }
}
