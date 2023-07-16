package yelim.graph;

import java.util.*;

// 신장 트리 : 하나의 그래프가 있을 때, 모든 노드를 포함하면 사이클이 존재하지 않는 부분 그래프
// 크루스칼 알고리즘 : 가장 적은 비용으로 모든 노드를 연결하는 알고리(그리디 알고리즘)
//              -> 가장 거리가 짧은 간선부터 차례대로 집합에 추가한다.

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

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정한다.
    // 전체 간선 데이터를 리스트에 담은 뒤 정렬한다.
    // Collections.sort(edges); -> 이 코드에서 비용에 따라 정렬할 때, 쓰이는 메소드
    @Override
    public int compareTo(Edge other) {
        if (this.distance < other.distance) {
            return -1; // 그대로 두기
        }
        return 1; // 정렬하기
    }
}

public class Graph_EX10_4 {
    // V : 노드 개수, E : 간선 개수(Union 연산)
    // 노드 최대 개수는 100000개이다.
    public static int v, e;
    public static int[] parent = new int[100001]; // 부모 테이블 초기화하기

    // 그래프의 모든 간선을 담을 리스트
    public static ArrayList<Edge> edges = new ArrayList<>();
    // 최종 비용을 담을 변수
    public static int result = 0;

    // 특정 원소가 속한 집합을 찾기
    // 부모 테이블에서 각 노드의 부모 노드 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        // 부모 노드가 자기 자신이라면 그냥 반환하기
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 모든 간선에 대한 정보를 입력 받기
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(cost, a, b));
            // a번 노드와 b번 노드가 비용 cost로 연결되어 있다.
        }

        // 간선을 비용순으로 정렬
        Collections.sort(edges);

        // 간선을 하나씩 확인하며
        // 간선의 개수만큼 반복하면서
        // 비용이 가장 적은 간선부터
        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();
            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
            }
        }
        // (3 4) 7 -> findParent(3) != findParent(4) -> 3 != 4 -> unionParent(3, 4) -> 3 < 4 -> parent[4] = 3 -> result = 7
        // (4 7) 13 -> findParent(4) != findParent(7) -> 3 != 7 -> unionParent(4, 7) -> 3 < 7 -> parent[7] = 3 -> result = 20
        // (4 6) 23 -> findParent(4) != findParent(6) -> 3 != 6 -> unionParent(4, 6) -> 3 < 6 -> parent[6] = 3 -> result = 43
        // (6 7) 25 -> findParent(6) == findParent(7) -> 3 == 3 -> 사이클이 생기므로 최종 비용에 더해지지 않는다.
        // (1 2) 29 -> findParent(1) != findParent(2) -> 1 != 2 -> unionParent(1, 2) -> 1 < 2 -> parent[2] = 1 -> result = 72
        // (2 6) 34 -> findParent(2) != findParent(6) -> 1 != 3 -> unionParent(2, 6) -> 1 < 3 -> parent[3] = 1 -> result = 106
        // (2 3) 35 -> findParent(2) == findParent(3) -> 1 == 1 -> 사이클이 생기므로 최종 비용에 더해지지 않는다.
        // (5 6) 53 -> findParent(5) != findParent(6) -> 5 != 1(경로 압축 -> parent[6] = findParent(3) = 1) -> unionParent(5, 6) -> 5 > 3 -> parent[5] = 1 -> result = 159
        // (1 5) 75 -> findParent(1) == findParent(5) -> 1 == 1 -> 사이클이 생기므로 최종 비용에 더해지지 않는다.

        System.out.println(result);
    }
}
