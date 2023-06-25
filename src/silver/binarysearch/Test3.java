package silver.binarysearch;

import java.util.Scanner;

public class Test3 {
    // 반복문을 통한 이진 탐색
    public static int binarySearch(int[] arr, int target, int start, int end) {
        // 시작값이 끝값보다 작거나 같을 때까지
        while (start <= end) {
            // 중간값 구하기
            int mid = (start + end) / 2;
            // 중간값과 목표값과 같을 때
            if (arr[mid] == target)
                return mid;
            // 중간값이 목표값보다 클 때
            else if (arr[mid] > target)
                // 끝값을 중간값 이전으로 이동
                end = mid - 1;
            // 중간값이 목표값보다 작을 때
            else
                // 시작값을 중간값 이후로 이동
                start = mid + 1;
        }

        // 시작값이 끝값보다 클 경우라면
        // 즉, 말이 안되는 경우라면
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 원소의 개수
        int n = sc.nextInt();
        // 목표값
        int target = sc.nextInt();

        // 전체 원소 입력받기
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
