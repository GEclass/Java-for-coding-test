package yelim.dynamic;


import java.util.*;
// 아직 이해하기 전 1로 만들기
public class DP_EX8_4 {
    // 한 번 계산된 결과를 저장하는 메모이제이션 배열
    // 입력된 정수 x의 범위는 1부터 30000까지이다.
    public static int[] d = new int[30001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        // 반복문을 이용한 보텀업 방식
        for (int i = 2; i <= x; i++) {
            // 입력 정수에서 1을 빼는 경우
            d[i] = d[i - 1] + 1;
            // 입력 정수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0)
                d[i] = Math.min(d[i], d[i / 2] + 1);
            // 입력 정수가 3으로 나누어 떨어지는 경우
            if (i % 3 == 0)
                d[i] = Math.min(d[i], d[i / 3] + 1);
            // 입력 정수가 5로 나누어 떨어지는 경우
            if (i % 5 == 0)
                d[i] = Math.min(d[i], d[i / 5] + 1);
        }
    }
}
