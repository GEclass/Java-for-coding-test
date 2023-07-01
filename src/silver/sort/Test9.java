package silver.sort;

import java.util.*;

public class Test9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        // 한 줄에 여러 int 값을 입력으로 받기 위해
        // 배열 a와 배열 b를 분리
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i ++) {
            a[i] = sc.nextInt();
        }

        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i ++) {
            b[i] = sc.nextInt();
        }

        // 오름차순 및 내림차순 정렬을 수행하지 않는다면
        // 동일한 인덱스 값을 가졌을 때, 작은지 큰지 비교를 할 수 없을 것
        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        for (int i = 0; i < k; i ++) {
            if (a[i] < b[i]) {
                // (주의) a[i] 값을 저장할 임시 변수
                // 임시 변수가 없다면, 복사하여 a[i]에 저장한 b[i]을 다시 b[i]에 저장할 것
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            } else { // (주의) 바로 break;가 있다면 if문이 속한 반복문이 한 번 실행되면 무조건 종료됨
                break;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i ++) {
            sum += a[i];
            System.out.println(" a[i]의 합 : " + sum);
        }
    }
}
