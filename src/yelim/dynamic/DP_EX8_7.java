package yelim.dynamic;

import java.util.*;

public class DP_EX8_7 {
    // 2 X N 크기 바닥을 채우는 방법의 수를 저장한 DP 테이블 - 메모이제이션
    public static int[] d = new int[1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 가로 길이 N (1 <= N <= 1000)
        int n = sc.nextInt();

        // N X 2 바닥을 1 X 2, 2 X 1, 2 X 2 모양의 덮개로 덮을 수 있는 방법의 수
        // 다이나믹 프로그래밍 - 보텀업
        // ai = ai-1 + ai-2 * 2

        // N이 3인 3 X 2 바닥을 덮는다면,
        // a3 = a2 + a1 X 2
        // 가로 길이 3일 때, 덮은 방법 수는 가로 길이 2일 때 덮은 수와 가로 길이 1일때 덮는 수의 2배 한 것과 같다.
        // > a2 (가로 길이 2일 때, 덮는 수는 3가지이다. -> 각 덮개 당 1개씩 존재한다.)
        // > a1 (가로 길이가 1일 때, 덮는 수는 1가지이다. -> 2 X 1 덮개 1개만 덮을 수 있다.)
        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i <= n; i++) { // 가로 길이 3부터 가로 길이 N까지 바닥을 덮는 방법의 수를 구하기 위한 반복문
            d[i] = (d[i - 1] + 2 * d[i - 2]) % 796796;
        }

        // 계산된 결과 출력
        System.out.println(d[n]);
    }
}
