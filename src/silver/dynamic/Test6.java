package silver.dynamic;

import java.util.Scanner;

public class Test6 {
    public static int[] d = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N: 타일의 가로 길이
        int n = sc.nextInt();

        // Bottom-up
        // Q. 왜 이렇게 초기화를 수행하는 것일까?
        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i <= n; i ++) {
            // (핵심) DP는 for문 안에 점화식을 삽입하면 된다.
            d[i] = (d[i - 1] + 2 * d[i - 2]) % 796796;
        }

        System.out.println(d[n]);
    }
}
