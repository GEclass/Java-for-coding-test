package silver.dynamic;

public class Test3 {
    public static long[] d = new long[100];

    // Bottom-up: 피보나치 함수를 반복문으로 구현
    public static void main(String[] args) {
        // 첫 번째 피보나치 수 = 1
        d[1] = 1;
        // 두 번째 피보나치 수 = 2
        d[2] = 1;
        // 50번째 피보나치 수를 계산
        int n = 50;

        for (int i = 3; i <= n; i ++) {
            d[i] = d[i - 1] + d[i - 2];
        }

        System.out.println(d[n]);

    }
}
