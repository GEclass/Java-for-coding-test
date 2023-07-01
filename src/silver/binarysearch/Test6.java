package silver.binarysearch;

import java.util.HashSet;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // 집합(Set) 정보를 처리하기 위한 HashSet 라이브러리
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i ++) {
            int x = sc.nextInt();
            s.add(x);
        }

        int m = sc.nextInt();
        // ?
        int[] targets = new int[n];
        for (int i = 0; i < m; i ++) {
            targets[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i ++) {
            if (s.contains(targets[i])) {
                System.out.print("yes ");
            }
            else {
                System.out.print("no ");
            }
        }
    }
}
