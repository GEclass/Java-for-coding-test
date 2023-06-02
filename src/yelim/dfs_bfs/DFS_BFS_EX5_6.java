package yelim.dfs_bfs;

public class DFS_BFS_EX5_6 {
    // 연결되지 않는 노드끼리 표현 -> 무한의 비용
    // 논리적으로 정답이 될 수 없는 큰 값
    public static final int INF = 999999999;

    // 2차원 배열로 인접 행 표현
    public static int [][] graph = {
            {0, 7, 5},
            {7, 0, INF},
            {5, INF, 0},
    };
    public static void main(String[] args) {
        // 그래프 출력
        for(int i=0;i < graph.length;i++) {
            for(int j=0;j < graph[i].length;j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

    }
}
