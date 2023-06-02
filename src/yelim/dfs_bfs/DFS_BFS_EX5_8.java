package yelim.dfs_bfs;

import java.util.ArrayList;

public class DFS_BFS_EX5_8 {
    // 노드 방문 처리할 스택
    public static boolean [] visited = new boolean[9];
    // 그래프 선언
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    // DFS 함수 정의
    // 현재 노드를 매개 변수로 설정
    public static void dfs(int x) {
        // 현재 노드 방문 처리
        visited[x] = true;
        System.out.print(x + " ");

        // 햔재 노드와 연결되 노드를 재귀적으로 방문
        for(int i=0;i < graph.get(x).size();i++){
            // 현재 노드와 연결된 노드를 가져와 방문하지 않았을 시, 깊이 우선 탐색
            int y = graph.get(x).get(i);
            if(!visited[y]) dfs(y);
        }

    }
    public static void main(String[] args) {
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

        dfs(1);
    }
}
