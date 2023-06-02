package silver.search;

public class Test5 {
    // 반복문으로 구현한 팩토리얼
    public static int factorialIterative(int n) {
        int result = 1;

        for (int i = 1; i <= n; i ++) {
            result = result * i;
        }

        return result;
    }

    // 재귀적으로 구현한 팩토리얼
    public static int factorialRecursive(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorialRecursive(n - 1);
    }

    public static void main(String [] args) {
        System.out.println("반복적으로 구현:" + factorialIterative(5));
        System.out.println("재귀적으로 구현" + factorialRecursive(5));
    }
}
