package yelim.dfs_bfs;

public class DFS_BFS_EX5_4 {
    public static void recursiveFunction1(int i) {
        // 재귀 함수의 종료 조건
        if(i == 100) {
            return;
        }

        // 재귀 함수의 수행은 스택 자료 구조를 사용한다.
        // 1번째 재귀 함수에서 2번째 재귀 함수를 호출합니다.
        // 2번째 재귀 함수에서 3번째 재귀 함수를 호출합니다.
        // 3번째 재귀 함수에서 4번째 재귀 함수를 호출합니다.
        // 4번째 재귀 함수에서 5번째 재귀 함수를 호출합니다.
        // ...
        // 4번째 함수를 종료합니다.
        // 3번째 함수를 종료합니다.
        // 2번째 함수를 종료합니다.
        // 1번째 함수를 종료합니다.
        System.out.println(i + "번째 재귀 함수에서 " + (i+1) + "번째 재귀 함수를 호출합니다.");
        recursiveFunction1(i+1);
        System.out.println(i + "번째 함수를 종료합니다.");
    }
    public static void main(String[] args) {
        recursiveFunction1(1);
    }
}
