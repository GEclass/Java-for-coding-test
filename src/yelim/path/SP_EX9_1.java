package yelim.path;

import java.util.*;

class Node_queue {

    private int index;
    private int distance;

    public Node_queue(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }
}

public class SP_EX9_1 {
    // 다른 노드로 가는 최단 거리 초기화를 무한(10억)으로 한다.
    public static final int INF = (int) 1e9;

    // n : 노드 개수, m : 간선 개수, start : 시작 노드
    public static int n, m, start;

    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node_queue>> graph = new ArrayList<ArrayList<Node_queue>>();

    // 노드를 방문한 적이 있는지 확인할 수 있는 배열
    // 노드 최대 개수는 100000개이다.
    public static boolean[] visited = new boolean[100001];

    // 시작 노드에서 각 노드까지의 최단 경로를 저장하는 배열
    // 노드 최대 개수는 100000개이다.
    public static int[] d = new int[100001];

    // 방문하지 않은 노드에서 가장 최단거리가 짧은 노드의 번호를 반환한다.
    public static int getSmallestNode() {
        int min_value = INF;
        int index = 0; // 가장 최단 거리가 짧은 노드(인덱스)

        //
        for (int i = 1; i <= n; i++) {
            // 노드(i)의 최단거리(d[i])가 더 짧고 노드(i)를 방문하지 않다면
            if (d[i] < min_value && !visited[i]) {
                // 최단거리(d[i])로 저장해주고 최단 거리를 저장한 노드(i)를 반환한다.
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }

    // 시작 노드에서 다익스트라 알고리즘 적용하기
    public static void dijkstra(int start) {
        // 시작 노드에 대해서 초기화
        // 시작 노드에서 시작 노드까지 거리는 0이므로
        d[start] = 0;
        // 시작 노드 방문 처리
        visited[start] = true;

        // 시작 노드에서의 노드 정보를 d 배열에 저장하기
        // 시작 노드에서 각 노드까지의 최단 경로를 저장하는 배열에 시작 노드에서 갈 수 있는 모든 노드의 비용을 저장한다.
        for (int j = 0; j < graph.get(start).size(); j++) {
            // get().get()인 이유는 graph의 구조가 ArrayList<ArrayList<Node>>로 되어 있기 때문이다.
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }

        // 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
        for (int i = 0; i < n - 1; i++) {
            // 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
            int now = getSmallestNode();
            visited[now] = true;
            // 현재 노드와 연결된 다른 노드를 확인
            for (int j = 0; j < graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();
                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node_queue>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node_queue(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);

        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (d[i] == INF) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(d[i]);
            }
        }
    }
}
