package yelim.dfs_bfs;

import java.util.Queue;
import java.util.LinkedList;

public class DFS_BFS_EX5_2 {
    public static void main(String [] args) {
        // 큐 선언
        Queue<Integer> queue = new LinkedList<>();

        // 값 추가 및 제거
        queue.offer(11);
        queue.offer(22);
        queue.offer(33);
        queue.offer(44);
        queue.poll();
        queue.offer(55);
        queue.offer(66);
        queue.poll();

        // 먼저 들어온 요소부터 출력 1
        // [33, 44, 55, 66]
        System.out.println(queue);

        // 먼저 들어온 요소부터 출력 2
        // 33
        // 44
        // 55
        // 66택
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
