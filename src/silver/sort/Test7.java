// 수열 〓 배열

package silver.sort;

import java.util.*;

public class Test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 3
        int n = sc.nextInt();

        /**
         * 15
         * 27
         * 12
         */
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = sc.nextInt();
        }

        // StringBuilder의 .reverse() 사용 시, 아래와 같이 출력되므로 x
        /**
         * 725121
         */

        // 자바의 기본 정렬 라이브러리를 사용한 내림차순 정렬 수행
        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < n; i ++) {
            System.out.print(arr[i] + " ");
        }
    }
}
