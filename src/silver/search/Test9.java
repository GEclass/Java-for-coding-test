package silver.search;

import java.util.*;

public class Test9 {
    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        // offer() : 해당 큐 맨 뒤에 값 삽입, 값 추가 실패 시 false 반환 <-> add()
        q.offer(start);
        // 현재 노드를 방문 처리
        visited[start] = true;

        // 큐가 빌 때까지 반복
        while(!q.isEmpty()) {
            // 큐에서 하나의 원소를 뽑아 출력
            // poll() : 큐 맨 앞에 있는 값 반환 후 삭제, 큐가 비어있을 경우 null 반환 <-> remove()
            int x = q.poll();
            // 한 줄 출력을 해야 하므로 print()
            System.out.print(x + " ");
            // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for (int i = 0; i < graph.get(x).size(); i ++) {
                int y = graph.get(x).get(i);
                if(!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

    public static void main(String [] args) {
        for (int i = 0; i < 9; i ++) {
            graph.add(new ArrayList<Integer>());
        }

        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 이미 노드 1은 2와 연결되어 있는데, 왜 노드 2에서 한 번 더 1을 연결하는걸까?
        graph.get(2).add(1);
        graph.get(2).add(7);

        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        graph.get(4).add(3);
        graph.get(4).add(5);

        graph.get(5).add(3);
        graph.get(5).add(4);

        graph.get(6).add(7);

        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        graph.get(8).add(1);
        graph.get(8).add(7);

        bfs(1);
    }
}
