package yelim.search;

import java.util.*;

public class Search_EX7_5 {
    // 계수 정렬로 부품 찾기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 가게의 부품 개수
        // 가게 부품 목록
        int n = sc.nextInt();
        int[] arr = new int[1000001];
        for (int i = 0; i < n; i++) {
            // 가게 부품 목록에 부품이 있다는 것을 표시하기 위해 배열의 값에 1을 넣어준다.
            int x = sc.nextInt();
            arr[x] = 1;
        }

        // 손님이 확인 요청한 부품 개수
        // 손님이 확인 요청한 부품 목록
        int m = sc.nextInt();
        int[] targets = new int[n];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        // 손님이 확인 요청한 부품 번호를 하나씩 확인
        for (int i = 0; i < m; i++) {
            // 계수를 통해 있는지 확인
            // 가게 부품 목록 배열에 확인 요청한 부품(인덱스)에 1이 있는지 확인
            if (arr[targets[i]] == 1) {
                System.out.print("yes ");
            }
            else {
                System.out.print("no ");
            }
        }
    }
}
