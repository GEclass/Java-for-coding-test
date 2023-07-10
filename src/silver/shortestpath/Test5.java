package silver.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node3 implements Comparable<Node3> {
    private int index;
    private int distance;

    public Node3(int index, int distance) {
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
    public int compareTo(Node3 other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class Test5 {
    // 무한을 의미하는 값으로 10억을 설정
    public static final int INF = (int) 1e9;

    // N : 노드의 개수, M : 간선의 개수, start : 시작 노드 번호
    public static int n, m, start;

    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node3>> graph = new ArrayList<ArrayList<Node3>>();

    // 최단 거리 테이블 만들기
    public static int[] d = new int[30001];

    public static void dijkstra(int start) {
        PriorityQueue<Node3> pq = new PriorityQueue<>();

        // 시작 노드로 가기 위한 최단 경로는 0으로 설정, 큐에 삽입
        // pq.offer(new Node3(1, 0))
        pq.offer(new Node3(start, 0));

        // d[1] = 0;
        d[start] = 0;

        // 큐가 비어있지 않다면
        while(!pq.isEmpty()) {
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            // poll() : 첫 번째 값을 반환하고 제거
            Node3 node3 = pq.poll();
            // 현재 노드까지의 비용
            // (1,0) -> (3,2) -> (2,4)
            // 마지막 dist : 4
            int dist = node3.getDistance();
            // 현재 노드
            // 마지막 노드 : 2
            int now = node3.getIndex();

            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            // 0 < 0
            if (d[now] < dist) {
                continue;
            }

            // 양방향을 허용하지 않음
            // size() -> 이전 다익스트라 알고리즘과 같이 i값에 대한(= 각 노드에 대한) size의 값이 일정함
            // size = 노드의 개수 + 1(배열 특성 상, 0번 노드도 포함)
            // i = 0, size() : 4 -> i = 1, size() : 4 -> i = 2, size() : 4

            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int i = 0; i < graph.get(now).size(); i ++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                // 4(노드 2) < 10000000(d[2])
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    // 저장할 때(= pq.offer())마다 compareTo를 일련의 이유로 내부적으로 호출해서 정렬을 수행
                    pq.offer(new Node3(graph.get(now).get(i).getIndex(), cost));
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
        for (int i = 0; i <= n; i ++) {
            graph.add(new ArrayList<Node3>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i ++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            // 이때, 메세지를 받는 동시의 총 개수를 구해야하므로
            // 메세지를 보낼 도시의 개수는 고려하지 않아도 됨
            // 즉, 3번 노드 -> 1번 노드의 간선은 없어도 됨

            // Z : X번 노드에서 Y번 노드로 가는 비용
            graph.get(x).add(new Node3(y,z));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);

        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 도달할 수 있는 노드의 개수
        int count = 0;
        // 도달할 수 있는 노드 중에서, 가장 멀리 있는 노드와의 최단 거리
        int maxDistance = 0;

        for (int i = 1; i <= n; i ++) {
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
