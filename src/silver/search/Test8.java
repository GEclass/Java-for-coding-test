package silver.search;

import java.util.*;

public class Test8 {
    
    public static boolean[] visited = new boolean[9];
    // 인접 리스트의 예제와 달리, Integer 객체를 사용
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    
    public static void dfs(int x) {
        // 현재 노드를 방문 처리
        // visited[1,2,3,4,.., 8]
        visited[x] = true;
        // println() 사용 시, 다음 행으로 넘어가므로 print() 메소드 사용
        System.out.print(x + " ");

        // 그때 그때 연결된 노드의 수만큼 진행
        for (int i = 0; i < graph.get(x).size(); i ++) {
            // 현재 방문하는 노드
            // int y = graph.get(1).get(0) --> 노드 1과 연결된 노드 2, 3, 8 중 인덱스가 0인 노드 --> 노드 2
            int y = graph.get(x).get(i);
            // if (!visited[y]) dfs(y);
            // else {
            //      continue;
            // }
            if (!visited[y])
                // 재귀 함수의 호출이 종료될 때, y가 stack에서 제거됨으로써 pop() 연산과 유사하게 수행
                dfs(y);
        }
    }

    public static void main(String [] args) {
        // 그래프 초기화
        for(int i = 0; i < 9; i ++) {
            // 노드 생성
            graph.add(new ArrayList<Integer>());
        }

        // 노드 1에 연결된 간선들 생성
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 노드 2에 연결된 간선들 생성
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 노드 3에 연결된 간선들 생성
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4에 연결된 간선들 생성
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5에 연결된 간선들 생성
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 노드 6에 연결된 간선들 생성
        graph.get(6).add(7);

        // 노드 7에 연결된 간선들 생성
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        // 노드 8에 연결된 간선들 생성
        graph.get(8).add(1);
        graph.get(8).add(7);

        dfs(1);
    }
}
