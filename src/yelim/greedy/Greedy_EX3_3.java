package yelim.greedy;

import java.util.*;

public class Greedy_EX3_3 {
    public static void main(String[] args) {

        int[][] arr = {
                { 3, 1, 2 },
                { 4, 1, 4 },
                { 2, 2, 2 }
        };

        // 각 행에서 가장 작은 수 저장할 배열
        int[] min_arr = new int[arr.length];
        int min = 10001;
        int tot_max = 0;

        // 이중 for문으로 각 행에서 가장 작은 수를 배열에 저장
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
                min_arr[i] = min;
            }
            min = 10001;
        }

        // 각 행에서 가장 작은 수를 저장한 배열의 요소 최대 수 구하기
        for (int j = 0; j < min_arr.length; j++) {
            if (min_arr[j] > tot_max) {
                tot_max = min_arr[j];
            }
        }
        System.out.println(tot_max);

    }
}
