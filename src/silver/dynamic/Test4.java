package silver.dynamic;

import java.util.Scanner;

// ※ DP는 이해가 안 될때, 전체 함수가 호출되는 과정을 그림으로 그려보자.

// 점화식: min(a i-1, a i/2, a i/3, a i/5) + 1
public class Test4 {
    // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화

    // 즉, 각 d[i]는 f(i = 5), f(i = 4), .. 와 매칭
    // ex. i = 5, f(5)일 경우 연산을 하는 최솟값은 1.
    public static int[] d = new int[30000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        // ※ 1로 만드는 문제이므로 i = 1일 경우는 필요가 없다.
        // Bottom-up : 작은 문제부터 차근차근 도출 & for 반복문

        // i는 DB 테이블의 인덱스
        // 따라서 + 1은 함수의 호출 횟수를 구하기 위해 수행
        for (int i = 2; i <= x; i ++) {
            // (1) 현재 값 - 1
            // i - 1
            d[i] = d[i - 1] + 1;
            // (2) 현재 값 % 2 == 0
            if (i % 2 == 0)
                // 연산을 하는 횟수의 최솟값을 구하기 위해 min() 사용
                d[i] = Math.min(d[i], d[i / 2] + 1);
            // (3) 현재 값 % 3 == 0
            if (i % 3 == 0)
                d[i] = Math.min(d[i], d[i / 3] + 1);
            // (4) 현재 값 % 5 == 0
            if (i % 5 == 0)
                d[i] = Math.min(d[i], d[i / 5] + 1);
        }

        System.out.println(d[x]);
    }
}
