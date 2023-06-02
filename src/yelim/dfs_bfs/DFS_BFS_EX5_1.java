package yelim.dfs_bfs;

import java.util.Stack;

public class DFS_BFS_EX5_1 {
    public static void main(String [] args) {
        // 스택 선언
        Stack<Integer> stack = new Stack<>();

        // 값 추가 및 삭제
        stack.push(34);
        stack.push(92);
        stack.push(21);
        stack.push(82);
        stack.pop();
        stack.push(69);
        stack.push(13);
        stack.pop();

        // 최하단 요소부터 출력 1
        // [34, 92, 21, 69]
        System.out.println(stack);

        // 최하단 요소부터 출력 2
        // 69
        // 21
        // 92
        // 34
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
