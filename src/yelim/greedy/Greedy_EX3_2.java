package yelim.greedy;

import java.util.*;

public class Greedy_EX3_2 {
    public static void main(String[] args) {
        int N = 5;
        int M = 7;
        int K = 2;

        // int[] arr = { 2, 4, 5, 4, 6 };
        int[] arr = { 3, 4, 3, 4, 3 };

        int res = 0;

        Arrays.sort(arr);
        int max_1 = arr[N-1];
        int max_2 = arr[N-2];

        // 첫번째로 큰 수는 얼마나 더하고 두번째로 큰 수는 얼마나 더해야하는지
        // 첫번째로 큰 수 - M번 더하는 횟수에서 차지하는 횟수는 더하는 횟수 나누기 최대 큰 수 더하는 횟수의 몫
        // 두번째로 큰 수 - 첫번째로 큰 수를 더하는 횟수를 제외한 나머지 횟수는 더하는 횟수 나누기 최대 큰 수 더하는 횟수의 나머지
        int max_1_cal = M / K;
        int max_2_cal = M % K;

        res = (max_1 * K * max_1_cal) + (max_2 * max_2_cal);
        System.out.println(res);

    }
}
