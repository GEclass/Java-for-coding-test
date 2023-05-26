package silver.implement;

import java.util.*;

public class Test2 {

    // 매 시각 안에 '3'이 포함되어 있는지 확인하기 위한 check() 메소드
    public static boolean check(int h, int m, int s) {
        // ※ '3'이 포함되어 있는지 확인하기 위한 연산
        // 몫 연산자(/) 10 : 두 자리수 일 때 '3'이 있는지 확인
        // 나머지 연산자(%) 10 : 한 자리 수 일 때 '3'이 있는지 확인
        if(h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < 60; j ++) {
                for(int k = 0; k < 60; k ++) {
                    // if 문이 참일 경우, count ++
                    if(check(i, j, k)) {
                        count ++;
                    }
                }
            }
        }
    }
}
