package yelim.dfs_bfs;

public class DFS_BFS_EX5_5 {
    public static int factorial_iteration(int i) {
        int result = 1;
        // 반복문을 이용한 펙토리얼 계산
        for(int j = i;j > 0;j--){
            result *= j;
        }
        return result;
    }

    public static int factorial_recursive(int i) {
        int result = 1;
        // 재귀 함수 종료 조건
        // 1이하일 경우, 종료
        if(i <= 1) {
            return 1;
        }

        // n! = n * (n-1)!
        return i * factorial_recursive(i -1);
    }
    public static void main(String[] args) {
        System.out.println("반복적으로 구현 : " + factorial_iteration(5));
        System.out.println("재귀적으로 구현 : " + factorial_recursive(5));
    }
}
