package silver.shortestpath;

import java.util.Arrays;
import java.util.Scanner;

// 최소 시간을 계산하는 플로이드 워셜 알고리즘
public class Test4 {
    // 무한을 의미하는 값으로 10억으로 설정
    public static final int INF = (int) 1e9;

    // N : 노드의 개수, M : 간선의 개수, X : 거쳐 갈 노드, K : 최종 목적지 노드
    public static int n, m, x, k;

    public static int[][] graph = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i < 101; i ++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int a = 1; a <= n; a ++) {
            for (int b = 1; b <= n; b ++) {
                if (a == b) {
                    graph[a][b] = 0;
                }
            }
        }

        // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        for (int i = 0; i < m; i ++) {
            // 회사끼리 이동할 수 있는 수단은 도로
            // 이때, 양방향으로 이동할 수 있으며
            // 특정 회사와 다른 회사가 도로로 연결되어 있고
            // 1만큼의 시간이 걸림

            // 따라서 A와 B가 서로에게 가는 비용은 1이라고 설정
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[a][b] = 1;
        }

        x = sc.nextInt();
        k = sc.nextInt();

        // 점화식에 따라 플로이드 워셜 알고리즘을 수행
        for (int k = 1; k <= n; k ++) {
            for (int a = 1; a <= n; a ++) {
                for (int b = 1; b <= n; b ++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 수행된 결과를 출력
        // 최소 시간을 구하므로
        // distance = time
        // a번 노드 = 1이므로 graph[1] ~
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
