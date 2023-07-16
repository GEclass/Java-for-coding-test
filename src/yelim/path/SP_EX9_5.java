package yelim.path;

import java.util.*;

class Node_City implements Comparable<Node_City> {

    private int index;
    private int distance;

    public Node_City(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node_City other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class SP_EX9_5 {
    // 다른 노드로 가는 최단 거리 초기화를 무한(10억)으로 한다.
    // 무한 = 10억
    public static final int INF = (int) 1e9;

    // n : 노드 개수, m : 간선 개수, start : 시작 노드
    // 노드의 개수는 최대 100,000개 이다.
    public static int n, m, start;

    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node_City>> graph = new ArrayList<ArrayList<Node_City>>();

    // 시작 노드에서 각 노드까지의 최단 경로를 저장하는 배열
    // 노드 최대 개수는 100000개이다.
    public static int[] d = new int[30001];

    public static void dijkstra(int start) {
        // 우선 순위 큐 : 우선 순위가 높은 데이터를 가장 먼저 삭제한다.
        // 거리(비용)가 짧은 것이 높은 우선순위(compareTo())를 가지는 큐
        PriorityQueue<Node_City> pq = new PriorityQueue<>();

        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입한다.
        // (거리:0, 노드:1) 형태로 우선 순위 큐에 들어간다.
        pq.offer(new Node_City(start, 0));

        // 각 노드 최단 경로 배열에도 초기화
        // 시작 노드에 대해서 초기화
        // 시작 노드에서 시작 노드까지 거리는 0이므로
        d[start] = 0;

        while(!pq.isEmpty()) { // 큐가 비어있지 않다면
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            // pq.poll : 우선순위가 가장 높은 노드(거리가 가장 짧은 노드)을 제거
            // (거리:0, 노드:1) 꺼내기
            // (거리:2, 노드:3) 꺼내기
            // (거리:4, 노드:2) 꺼내기
            Node_City node = pq.poll();

            int dist = node.getDistance(); // 현재 꺼낸 노드까지의 비용(거리), (0, 2, 4)
            int now = node.getIndex(); // 현재 노드, (1, 3, 2)

            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시한다.
            // 현재 꺼낸 노드보다 이미 거리가 짧으므로 무시한다.
            // INF < 0
            // d[3] < 2 -> 2 < 2
            // d[2] < 4 -> 4 < 4
            if (d[now] < dist) continue;

            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            // 현재 꺼낸 노드와 연결된 노드 수 만큼 반복한다.
            // graph.get(1).size() -> 노드 1과 연결된 간선 개수 만큼 반복
            // graph.get(2).size() -> 노드 2과 연결된 간선 개수 만큼 반복
            for (int i = 0; i < graph.get(now).size(); i++) {
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리 구하기
                // d[1] + graph.get(1).get(0).getDistance() -> 0 + 4 = 4 -> cost = 4
                // d[1] + graph.get(1).get(1).getDistance() -> 0 + 2 = 2
                int cost = d[now] + graph.get(now).get(i).getDistance();

                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                // 4 < d[graph.get(1).get(0).getIndex()] -> 4 < d[2] -> 4 < INF
                // 2 < d[graph.get(1).get(1).getIndex()] -> 2 < d[3] -> 2 < INF
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    // 각 노드 최단 경로 배열에 저장해주고 우선 순위 큐에도 저장
                    // d[2] = 4
                    // d[3] = 2
                    d[graph.get(now).get(i).getIndex()] = cost;
                    // 우선순위 큐에 (거리:4, 노드:2) 넣기
                    // 우선순위 큐에 (거리:2, 노드:3) 넣기
                    pq.offer(new Node_City(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 노드 개수 3개(도시 3개)
        m = sc.nextInt(); // 간선 개수 2개(통로 2개)
        start = sc.nextInt(); // 시작 노드(메세지를 보내는 도시 1번)

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node_City>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            // X번 노드에서 Y번 노드로 가는 비용이 Z라는 의미
            // 1번 도시에서 2번 도시로 가는 시간이 4
            // 1번 도시에서 3번 도시로 가는 시간이 2
            graph.get(x).add(new Node_City(y, z));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);

        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 도달할 수 있는 노드의 개수
        int count = 0;
        // 도달할 수 있는 노드 중에서, 가장 멀리 있는 노드와의 총 시간
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            // 도달할 수 있는 노드인 경우
            if (d[i] != INF) {
                count += 1;
                maxDistance = Math.max(maxDistance, d[i]);
            }
        }

        // 시작 노드는 제외해야 하므로 count - 1을 출력
        System.out.println((count - 1) + " " + maxDistance);
    }

}
