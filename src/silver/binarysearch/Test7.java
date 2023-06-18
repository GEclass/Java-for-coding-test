package silver.binarysearch;

import java.util.Scanner;

public class Test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N: 떡의 개수
        int n = sc.nextInt();
        // M: 요청한 떡의 길이(높이)
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = sc.nextInt();
        }

        // 시작점
        int start = 0;
        // 끝점
        // 1의 10의 9제곱
        // = 1,000,000,000
        int end = (int) 1e9;
        // 절단기의 최대 높이값
        // 절단기의 최댓값을 설정하면 요청한 떡의 길이 M을 얻을 수 있다.
        int result = 0;

        // 떡의 시작점이 절단기의 최댓값보다 작거나 같을 때까지
        // 즉, 시작점 = 중간값 같을 경우에 절단기의 최댓값(= 요청한 떡의 길이)을 구할 수 있음
        // 따라서 mid = result일 경우 while문을 탈출하며 종료
        while (start <= result) {
            // 자른 떡 높이의 총합
            long total = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < n; i ++) {
                // 잘랐을 때의 떡의 높이 계산
                // 즉, 각각의 떡 길이가 중간값보다 클 경우
                // 떡 길이가 중간값보다 작을 경우, 자르지 않음
                if (arr[i] > mid)
                    total += arr[i] - mid;
            }

            // 떡 높이의 총합이 요청한 떡의 높이보다 작다면
            if (total < m) {
                end = mid - 1;
            }
            // 떡 높이의 총합이 요청한 떡의 높이보다 크다면
            else {
                // 중간값을 결과값(절단기의 최대 높이 값)에 저장
                result = mid;
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
