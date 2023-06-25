package yelim.dynamic;

public class DP_EX8_2 {
    // 한 번 계산된 결과를 저장하는 메모이제이션(Memoization) 배열
    public static long[] d = new long[100];

    // 피보나치 함수를 재귀함수로 구현
    public static long fibo(int x) {
        // 첫번째 수와 두번째 수는 1
        if (x == 1 || x == 2) {
            return 1;
        }
        // 메모이제이션(Memoization) : 이미 계산한 적 있는 문제라면 그대로 반환
        // fibo(3) = fibo(1) + fibo(2)
        // fibo(4) = fibo(2) + 메모이제이션의 fibo(3)
        if (d[x] != 0) {
            return d[x];
        }

        // 아직 계산하지 않은 문제라면 점화식에 따라서 피보나치 결과 반환
        // 탑다운 방식 : 큰 문제를 해결하기 위해 작은 문제를 호출하는 방식 -> 재귀함수
        d[x] = fibo(x - 1) + fibo(x - 2);

        return d[x];
    }

    public static void main(String[] args) {
        System.out.println(fibo(50));
    }
}
