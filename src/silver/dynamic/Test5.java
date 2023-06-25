package silver.dynamic;

import java.util.Scanner;

// 점화식: max(a i-1, a i-2 + k)
public class Test5 {
    // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
    // 최대 식량 창고의 크기만큼 초기화

    // d[]: k(각 식량 창고에 저장된 식량의 개수)에 대해 i - 1번째와 i - 2 + i번째 중 얻을 수 있는 식량의 최댓값을 기록한 배열
    public static int[] d = new int[10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N: 식량 창고의 수
        int n = sc.nextInt();

        // K: 각 식량 창고에 저장된 식량의 개수
        int[] k = new int[n];
        for (int i = 0; i < n; i ++) {
            k[i] = sc.nextInt();
        }

        // DP 진행(Bottom-up): 작은 문제부터 차근차근 도출
        // Q. 왜 같다고 놓고 시작하는 걸까?
        d[0] = k[0];
        // 얻을 수 있는 식량의 최댓값을 구하기 위해 max() 사용
        d[1] = Math.max(k[0], k[1]);
        // i - 2인 경우를 대비해 i = 2부터 시작
        for (int i = 2; i < n; i ++) {
            // a i-1번째 식량 창고 털기 vs a i-2번째 식량 창고 + 특정한 식량 창고 털기
            d[i] = Math.max(d[i - 1], d[i - 2] + k[i]);
        }

        // 얻을 수 있는 식량의 최댓값
        // Q. 위치에 따른 모든 식량의 최댓값을 기록한 배열인 d에서 식량의 개수 - 1을 했더니 어떻게 식량의 최댓값이 나오는거지?
        System.out.println(d[n - 1]);
    }
}
