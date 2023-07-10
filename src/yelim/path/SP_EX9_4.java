package yelim.path;

import java.util.*;

public class SP_EX9_4 {
    // 노드가 연결되지 않는 것은 무한으로 표시하기
    public static final int INF = (int) 1e9;

    // 노드 개수 n, 간선 개수 m, 거쳐갈 노드 x, 최종 목적지 노드 k
    public static int n, m, x, k;

    // 최단 거리 저장할 그래프 배열
    public static int[][] graph = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 최단 거리 배열을 모두 무한으로 초기화
        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b) graph[a][b] = 0;
            }
        }

        // 각 간선(m개)에 대한 정보를 입력 받기
        for (int i = 0; i < m; i++) {
            // A와 B가 서로에게 가는 비용(시간)을 1로 초기화
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 각 회사는 양방향으로 갈 수 있는 도로가 있다.
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        // 거쳐갈 노드 x와 최종 목적지 노드 k
        x = sc.nextInt();
        k = sc.nextInt();

        // x 노드를 거쳐서 k 노드로 가는 최단 거리 구하기
        // 1번 노드에서 k 노드까지 최단거리 + k 노드에서 x 노드까지 최단 거리
        // Dab = min(Dab, Dak + Dkb)

        // n = 5, m = 7, x = 4, k = 5
        // 노드는 5개이고 간선은 7개이다. 거쳐가야하는 노드는 4번 노드이고 최종 목적지 노드는 5번이다.
        // 노드 연결 -> (1, 2) (1, 3) (1, 4) (2, 4) (3, 4) (3, 5) (4, 5)
        // D11 = Math.min(graph[1][1], graph[1][1] + graph[1][1]) = 0
        // D12 = Math.min(graph[1][2], graph[1][1] + graph[1][2]) = Math.min(1, 0 + 1) = 1
        // D13 = Math.min(graph[1][3], graph[1][1] + graph[1][3]) = Math.min(1, 0 + 1) = 1
        // ...
        // D21 = Math.min(graph[2][1], graph[2][1] + graph[1][1]) = Math.min(1, 1 + 0) = 1
        // D22 = Math.min(graph[2][2], graph[2][1] + graph[1][2]) = Math.min(0, 1 + 1) = 0
        // D23 = Math.min(graph[2][3], graph[2][1] + graph[1][3]) = Math.min(1, 1 + 1) = 1
        // D24 = Math.min(graph[2][4], graph[2][1] + graph[1][4]) = Math.min(1, 1 + 1) = 1
        // D25 = Math.min(graph[2][5], graph[2][1] + graph[1][5]) = Math.min(무한, 무한 + 1) = 무한
        // ...
        // D31 = Math.min(graph[3][1], graph[3][1] + graph[1][3]) = Math.min(1, 1 + 1) = 1
        // D32 = Math.min(graph[3][2], graph[3][1] + graph[1][2]) = Math.min(무한, 1 + 1) = 2
        // ...
        // 하지만 최종적으로 1번 노드에서 5번 노드까지 최단 거리 + 5번 노드에서 4번 노드까지 최단 거리 구하기
        // graph[1][5] + graph[5][4]
        // > k = 1일 때, graph[1][5] = Math.min(graph[1][5], graph[1][1] + graph[1][5]) = Math.min(무한, 0 + 무한) = 무한
        // > k = 2일 때, graph[1][5] = Math.min(graph[1][5], graph[1][2] + graph[2][5]) = Math.min(무한, 1 + 무한) = 무한
        // > k = 3일 때, graph[1][5] = Math.min(graph[1][5], graph[1][3] + graph[3][5]) = Math.min(무한, 1 + 1) = 2
        // > k = 4일 때, graph[1][5] = Math.min(graph[1][5], graph[1][4] + graph[4][5]) = Math.min(2, 1 + 1) = 2
        // > k = 5일 때, graph[1][5] = Math.min(graph[1][5], graph[1][5] + graph[5][5]) = Math.min(2, 무한 + 0) = 2
        // >> graph[1][5] = 2
        // > k = 1일 때, graph[5][4] = Math.min(graph[5][4], graph[5][1] + graph[1][4]) = Math.min(1, 무한 + 1) = 1
        // > k = 2일 때, graph[5][4] = Math.min(graph[5][4], graph[5][2] + graph[2][4]) = Math.min(1, 무한 + 1) = 1
        // > k = 3일 때, graph[5][4] = Math.min(graph[5][4], graph[5][3] + graph[3][4]) = Math.min(1, 1 + 1) = 1
        // > k = 4일 때, graph[5][4] = Math.min(graph[5][4], graph[5][4] + graph[4][4]) = Math.min(1, 1 + 0) = 1
        // > k = 5일 때, graph[5][4] = Math.min(graph[5][4], graph[5][4] + graph[5][4]) = Math.min(1, 1 + 1) = 1
        // >> graph[5][4] = 1
        // 최종적으로 2 + 1 = 3이 나온다.

        // 점화식에 따라 플로이드 워셜 알고리즘을 수행
        // 모든 지정에서 다른 모든 지점까지 최단 거리를 구하기 때문에 3번 반복한다.
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 1번 노드에서 5번 노드까지 최단 거리 + 5번 노드에서 4번 노드까지 최단 거리
        // 무조건 출발 노드는 1번이다.
        int distance = graph[1][k] + graph[k][x];

        // 도달할 수 없는 경우, -1을 출력
        if (distance >= INF) {
            System.out.println(-1);
        }
        // 도달할 수 있다면, 최단 거리를 출력
        else {
            System.out.println(distance);
        }
    }
}
