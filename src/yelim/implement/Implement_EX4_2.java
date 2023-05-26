package yelim.implement;

import java.util.*;

public class Implement_EX4_2 {
    public static void main(String[] args) {
        int N = 5;

        int count = 0;

        for (int i = 0; i <= N; i++){
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    // 숫자를 string으로 바꾸어 3이 포함되는지 확인한다.
                    if (Integer.toString(i).concat(Integer.toString(j)).concat(Integer.toString(k)).contains("3")) {
                        count += 1;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
