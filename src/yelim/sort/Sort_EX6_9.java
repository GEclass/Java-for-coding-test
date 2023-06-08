package yelim.sort;

import java.util.*;

public class Sort_EX6_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N과 K를 입력받기
        int n = sc.nextInt();
        int k = sc.nextInt();

        // 배열 A의 모든 원소를 입력받기
        int [] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        // 배열 B의 모든 원소를 입력받기
        int [] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        // 두 배열 모두 정렬해주기
        Arrays.sort(a);
        Arrays.sort(b);

        // 스와프할 때 쓸 변수
        int tmp = 0;

        // 배열 A의 K개 만큼 작은 수를 배열 B의 K개 만큼의 큰 수로 바꿔준다.
        for(int i=0;i < k;i++) {
            tmp = a[i];
            a[i] = b[n-1-i];
            b[n-1-i] = tmp;
            // System.out.println("a[" + i + "] : " + a[i] + ", b[" + (n-1-i) + "] : " + b[n-1-i]);
        }

        int result = 0;
        for(int i=0;i < a.length;i++){
            result += a[i];
        }

        System.out.println(result);

    }
}
