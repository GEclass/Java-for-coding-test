// ※ 자바는 파이썬과 달리 데이터 타입을 항상 명시해줘야 한다.

package silver.greedy;

import java.util.*;

public class Test3 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;

        for(int i = 0; i < n; i ++) {
            // 해당 행을 기준으로, "가장 작은 수" 찾기
            int min_value = 10000;
            for(int j = 0; j < m; j ++) {
                // 해당 행을 기준으로, 열 하나씩 입력받기
                int x = sc.nextInt();
                // 자바에서 가장 작은 값을 찾는 함수
                min_value = Math.min(min_value, x);
            }
            result = Math.max(result, min_value);
        }
        System.out.println(result);
    }
}
