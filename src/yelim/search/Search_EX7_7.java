package yelim.search;

import java.util.*;

public class Search_EX7_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 떡의 개수
        // 요청한 떡의 길이
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 각 떡의 높이 정보
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 이진 탐색을 위한 시작점과 끝점 설정
        int start = 0;
        int end = (int) 1e9;

        // 이진 탐색 수행
        int result = 0;
        while (start <= end) {
            long total = 0;

            // 중간 값
            int mid = (start + end) / 2;

            for (int i = 0; i < n; i++) {
                // 떡마다 중간 값보다 크다면 잘려진 떡 길이 저장
                if (arr[i] > mid) total += arr[i] - mid;
            }
            // 잘려진 떡 길이 합이 요청한 길이 합보다 작다면
            if (total < m) {
                // 더 많이 자르기 위해 끝점을 감소시켜 잘릴 길이를 줄인다.
                end = mid - 1;
            }
            else { // 떡의 양이 충분한 경우 덜 자르기
                result = mid; // 최대한 덜 잘랐을 때가 정답이므로, 여기에서 result에 기록
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
