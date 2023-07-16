package yelim.graph;

import java.util.*;
public class Graph_EX10_1 {
    // V : 노드 개수, E : 간선 개수(Union 연산)
    // 노드 최대 개수는 100000개이다.
    public static int v, e;
    public static int[] parent = new int[100001]; // 부모 테이블 초기화하기

    // 특정 원소가 속한 집합을 찾기
    // 부모 테이블에서 각 노드의 부모 노드 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        // 부모 노드가 자기 자신이라면 그냥 반환하기
        if (x == parent[x]) return x;
        return findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
        // 입력(1 4) -> 1 < 4 -> parent[4] = 1 -> 4번 노드의 부모 노드는 1번 노드이다.
        // 입력(2 3) -> 2 < 3 -> parent[3] = 3 -> 3번 노드의 부모 노드는 2번 노드이다.
        // 입력(2 4) -> 4번 노드의 부모 노드는 1번 노드 -> 2 > 1 -> parent[2] = 1 -> 2번 노드이 부모 노드는 1번 노드이다.
        // 입력(5 6) -> 5 < 6 -> parent[5] = 6 -> 5번 노드의 부모 노드는 6번 노드이다.
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // V : 노드 개수, E : 간선 개수(Union 연산)
        v = sc.nextInt();
        e = sc.nextInt();

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        // 노드의 개수 만큼 돌면서 부모를 자기 자신으로 초기화 -> 아직 연결되어 있는 노드 X
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // Union 연산을 각각 수행
        // 간선의 개수 만큼 돌면서 각 노드가 연결된 정보를 받아 각 노드들을 정보에 따라 Union 연산
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
        }

        // 각 원소가 속한 집합 출력하기
        // 각 노드의 부모 노드 출력하기
        System.out.print("각 원소가 속한 집합: ");
        for (int i = 1; i <= v; i++) {
            System.out.print(findParent(i) + " ");
        }
        System.out.println();

        // 부모 테이블 내용 출력하기
        System.out.print("부모 테이블: ");
        for (int i = 1; i <= v; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }
}
