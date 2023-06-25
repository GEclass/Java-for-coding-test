package yelim.dynamic;

public class DP_EX8_3 {
    // 피보나치 수열이 저장될 배열
    public static long[] d = new long[100];
    public static void main(String[] args) {
        // 첫번째 수와 두번째 수는 1
        // 피보나치 배열에 첫번째 수와 두번째 수 저장
        d[1] = 1;
        d[2] = 1;

        // 50번째 피보나치 수를 계산
        int n = 50;

        // 피보나치 수열을 반복문으로 구현
        // 보텀업 방식 : 작은 문제부터 차근차근 답을 도출하는 방식 -> 반복문으로 구현
        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        System.out.println(d[n]);
    }
}
