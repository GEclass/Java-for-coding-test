package silver.dynamic;

public class Test1 {
    // 재귀 함수를 사용한 피보나치 함수
    public static int fibo(int x) {
        // (3) 3 (2, 1) 중, x = 2
        // (5) 3 (1) 중, x = 1

        // (9) 4 (2) 중, x = 2
        if (x == 1 || x == 2) {
            return 1;
        }

        // (1) { x = 4 -> 4 (3, 2) }
        // (2) { x = 4 -> 4 (3, 2) } + { x = 3 -> 3 (2, 1)}

        // (4) { x = 4 -> 4 (3, 2) } + { x = 3 -> 3 (1) }
        // (6) { x = 4 -> 4 (3, 2) } + { x = 3 }
        // (7) { x = 4 -> 4 (2) }

        // (8) { x = 4 -> 4 (2) }
        // (10) { x = 4 }
        return fibo(x - 1) + fibo( x - 2);
    }

    public static void main(String[] args) {
        // (11)
        System.out.println(fibo(4));
    }
}
