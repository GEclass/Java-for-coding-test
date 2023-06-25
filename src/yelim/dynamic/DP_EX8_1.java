package yelim.dynamic;

public class DP_EX8_1 {
    // 재귀 함수로 구현한 피보나치 수열
    public static int fibo(int x) {
        // 첫번째 수와 두번째 수는 1
        if (x == 1 || x == 2) {
            return 1;
        }
        // 그 이후 수는 재귀적으로 계산
        // fibo(3) = fibo(1) + fibo(2)
        // fibo(4) = fibo(2) + fibo(3) = fibo(2) + (fibo(1) + fibo(2))
        return fibo(x - 1) + fibo(x - 2);
    }
    public static void main(String[] args) {
        System.out.println(fibo(4));
    }
}
