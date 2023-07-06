package yelim.search;

import java.util.*;

public class Search_EX7_4 {
    // 이진 탐색을 이용한 부품 찾기
    // 탐색할 배열, 찾을 값, 시작 값, 끝 값
    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            // 이진 탐색을 위한 중간 값
            int mid = (start + end) / 2;

            // 찾은 경우 중간 값 인덱스 반환
            if (arr[mid] == target) return mid;

            // 중간 값보다 찾을 값이 작은 경우 끝을 중간 값으로 설정하여 중간 값의 왼쪽 배열(start ~ (mid - 1))에서 다시 반복(이진 탐색)하기
            else if (arr[mid] > target) end = mid - 1;

            // 중간점의 값보다 찾고자 하는 값이 큰 경우 시작을 중간 값으로 설정하여 중간 값의 오른쪽 배열((mid + 1) ~ end)에서 다시 반복(이진 탐색)하기
            else start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 가게의 부품 개수
        // 가게 부품 목록
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 이진 탐색을 수행하기 위해 가계 부품 목록 정렬 수행
        Arrays.sort(arr);

        // 손님이 확인 요청한 부품 개수
        // 손님이 확인 요청한 부품 목록
        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        // 손님이 확인 요청한 부품 번호를 하나씩 확인
        for (int i = 0; i < m; i++) {
            // 가게 부품 목록에 해당 부품이 존재하는지 확인
            int result = binarySearch(arr, targets[i], 0, n - 1);
            if (result != -1) {
                System.out.print("yes ");
            }
            else {
                System.out.print("no ");
            }
        }
    }
}
