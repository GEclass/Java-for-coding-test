package silver.graph;

import java.util.*;

class Edge implements Comparable<Edge> {
    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getNodeA() {
        return this.nodeA;
    }

    public int getNodeB() {
        return this.nodeB;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Edge other) {
        if (this.distance < other.distance) {
            return -1;
        }
        // 자리를 바꿔라?
        return 1;
    }
}

public class Test4 {
    // V : 노드의 개수
    // E : 간선의 개수
    public static int v, e;
    // 부모 테이블 초기화
    public static int[] parent = new int[100001];
    // ArrayList : 모든 간선을 담을 리스트
    public static ArrayList<Edge> edges = new ArrayList<>();
    public static int result = 0;

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) return x;
        // parent[4] -> 3 = findParent(4);
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        // 3 -> 3
        // 4 -> 3
        a = findParent(a);
        // 4 -> 3
        // 7 -> 7
        b = findParent(b);
        // 3 < 4 -> parent[4] = 3;
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 7
        v = sc.nextInt();
        // 6
        e = sc.nextInt();

        // 부모 테이블 상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i ++) {
            // parent[1] = 1
            // parent[2] = 2
            // ..
            parent[i] = i;
        }

        // 모든 간선에 대한 정보를 입력 받기
        for (int i = 0; i < e; i ++) {
            // 1
            // 1
            int a = sc.nextInt();
            // 2
            // 5
            int b = sc.nextInt();
            // 29
            // 75
            int cost = sc.nextInt();
            // edges.add(new Edge(29, 1, 2));
            // edges.add(new Edge(75, 1, 5));
            edges.add(new Edge(cost, a, b));
        }

        // 간선을 비용순으로 정렬
        // compareTo()를 통해 정렬 -> return 1 : 정렬, 즉 자리를 바꿔라.
        Collections.sort(edges);

        // 간선을 하나씩 확인하며
        for (int i = 0; i < edges.size(); i ++) {
            // cost = edges.get(0).getDistance(); -> 7
            // cost = edges.get(1).getDistance(); -> 13
            int cost = edges.get(i).getDistance();
            // a = edges.get(0).getNodeA(); -> 3
            // a = edges.get(1).getNodeA(); -> 4
            int a = edges.get(i).getNodeA();
            // b = edges.get(0).getNodeB(); -> 4
            // b = edges.get(1).getNodeB(); -> 7
            int b = edges.get(i).getNodeB();
            // 사이클이 발생하지 않는 경우에만 집합에 포함
            // findParent(3) -> 3 != findParent(4) -> 4
            // findParent(4) -> 3 != findParent(7) -> 7
            if (findParent(a) != findParent(b)) {
                // unionParent(3, 4) -> 3
                // unionParent(4, 7) -> 3
                unionParent(a, b);
                // result += 7;
                result += cost;
            }
        }

        System.out.println(result);
    }
}
