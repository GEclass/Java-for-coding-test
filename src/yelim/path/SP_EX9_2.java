package yelim.path;

import java.util.*;

// 우선순위 큐에 저장할 객체는 필수적으로 Comparable 인터페이를 구현해야한다.
class Node_queue implements Comparable<Node_queue> {

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

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node_queue other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}
public class SP_EX9_2 {
    // 다른 노드로 가는 최단 거리 초기화를 무한(10억)으로 한다.
    // 무한 = 10억
    public static final int INF = (int) 1e9;

    // n : 노드 개수, m : 간선 개수, start : 시작 노드
    // 노드의 개수는 최대 100,000개 이다.
    public static int n, m, start;

    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    // 시작 노드에서 각 노드까지의 최단 경로를 저장하는 배열
    // 노드 최대 개수는 100000개이다.
    public static int[] d = new int[11];

    public static void dijkstra(int start) {
        // 우선 순위 큐 : 우선 순위가 높은 데이터를 가장 먼저 삭제한다.
        // 거리(비용)가 짧은 것이 높은 우선순위(compareTo())를 가지는 큐
        PriorityQueue<Node_queue> pq = new PriorityQueue<>();

        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
        // (거리:0, 노드:1) 형태로 우선 순위 큐에 들어간다.
        pq.offer(new Node_queue(start, 0));

        // 각 노드 최단 경로 배열에도 초기화
        // 시작 노드에 대해서 초기화
        // 시작 노드에서 시작 노드까지 거리는 0이므로
        d[start] = 0;

        while(!pq.isEmpty()) { // 큐가 비어있지 않다면
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            // pq.poll : 우선순위가 가장 높은 노드(거리가 가장 짧은 노드)을 제거
            Node_queue node = pq.poll();

            int dist = node.getDistance(); // 현재 꺼낸 노드까지의 비용
            int now = node.getIndex(); // 현재 노드

            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시한다.
            // 현재 꺼낸 노드보다 이미 거리가 짧으므로 무시한다.
            if (d[now] < dist) continue;

            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            // 현재 꺼낸 노드와 연결된 노드 수 만큼 반복
            for (int i = 0; i < graph.get(now).size(); i++) {
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리 구하기
                int cost = d[now] + graph.get(now).get(i).getDistance();
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    // 각 노드 최단 경로 배열에 저장해주고 우선 순위 큐에도 저장
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node_queue(graph.get(now).get(i).getIndex(), cost));
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
            graph.add(new ArrayList<Node>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
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
