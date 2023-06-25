package silver.binarysearch;

import java.util.Scanner;

public class Test5 {
    // 계수 정렬
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // 가게의 부품 번호 배열
        int[] arr = new int[1000001];
        for (int i = 0; i < n; i ++) {
            // 가게의 부품 번호
            // 첫 번째 부품의 번호, x = 3
            int x = sc.nextInt();
            // arr[3] = 1
            // [0, 0, 0, 1, ..
            // 즉, 1부터 세는 n번째가 아니라 0부터 세는 인덱스라고 생각할 것
            // 해당 부품 번호가 가게의 부품 번호 배열에 있다면
            // 0 -> 1
            arr[x] = 1;
        }

        int m = sc.nextInt();
        // ?
        int[] targets = new int[m];
        for (int i = 0; i < m; i ++) {
            targets[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i ++) {
            if (arr[targets[i]] == 1) {
                System.out.print("yes ");
            }
            else {
                System.out.println("no ");
            }
        }
    }
}
