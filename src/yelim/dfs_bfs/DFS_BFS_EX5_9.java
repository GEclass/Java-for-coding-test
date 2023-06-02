package yelim.dfs_bfs;

import java.util.*;
public class DFS_BFS_EX5_9 {
    // 노드 방문 처리 유무
    public static boolean [] visited = new boolean[9];

    // 그래프 선언
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    // bfs 함수 정의
    public static void bfs(int start){
        // 방문한 노드 저장
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        // 현재 노드 방문 처리
        visited[start] = true;

        // 큐가 빌 때까지 반복
        while(!q.isEmpty()) {
            // 큐에 방문한 노드 차례로 뽑아 출력
            int x = q.poll();
            System.out.print(x + " ");

            // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for(int i=0;i < graph.get(x).size();i++){
                // 입접한 요소 가져오기
                int y = graph.get(x).get(i);
                // 인접한 요소가 방문하지 않았을 경우,
                if(!visited[y]) {
                    // 큐에 넣기
                    q.offer(y);
                    // 인접 노드 방문 처리
                    visited[y] = true;
                }
            }
        }
    }
    public static void main(String [] args) {
        // 그래프 초기화
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 노드 1에 연결된 노드 정보 저장
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 노드 2에 연결된 노드 정보 저장
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 노드 3에 연결된 노드 정보 저장
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 노드 6에 연결된 노드 정보 저장
        graph.get(6).add(7);

        // 노드 7에 연결된 노드 정보 저장
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        // 노드 8에 연결된 노드 정보 저장
        graph.get(8).add(1);
        graph.get(8).add(7);

        bfs(1);

    }
}
