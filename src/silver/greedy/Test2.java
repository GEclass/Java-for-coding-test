package silver.greedy;

import java.util.*;

public class Test2 {
    public static void main(String [] args) {
        // 자바에서 데이터를 입력받는 방법, 반드시 java.util 패키지를 import 할 것
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        // 자바에서 배열을 생성하는 방법
        int [] arr = new int[n];
        for(int i = 0; i < n; i ++) {
            // 입력한 값을 하나씩 배열에 저장
            arr[i] = sc.nextInt();
        }

        // 자바에서 배열을 오름차순으로 정렬하는 방법
        Arrays.sort(arr);

        // 인덱스이므로 n - 1
        int first = arr[n - 1];
        int second = arr[n - 2];

        // 가장 큰 수가 더해지는 횟수 공식
        int count = (m / (k + 1)) * k;
        // m이 k+1로 나누어 떨어지지 않을 때, 가장 큰 수가 더해지는 횟수
        count = count + m % (k + 1);

        int result = 0;
        result = (count * first) + (m - count) * second;

        System.out.println(result);
    }
}
