package silver.greedy;

import java.util.*;

public class Test4 {

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        // 자바에도 동일하게 while()문이 존재
        // 또한 if가 아니라 while인 이유를 생각해보면 좋을 것
        while(n >= k) {
            while (n % k != 0) {
                n = n - 1;
                result = result + 1;
            }
            n = n / k;
            result = result + 1;
        }
        while (n > 1) {
            n = n - 1;
            result = result + 1;
        }
        System.out.println(result);
    }
}
