// ※ 자바는 파이썬과 달리 데이터 타입을 항상 명시해줘야 한다.
// 1. 자바에서 데이터를 입력받는 방법은?

import java.util.*;

public class Test3 {

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;

        for (int i = 0; i < n; i ++) {
            int min_value = 10001;
            for (int j = 0; j < m; j ++) {
                int x = sc.nextInt();
                min_value = Math.min(min_value, x);
            }
            result = Math.max(result, min_value);
        }
        System.out.println(result);
    }
}
