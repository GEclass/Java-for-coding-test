package silver.graph;

import java.util.*;

public class Test2 {
    // V : 노드의 개수
    // E : 간선의 개수
    public static int v, e;
    // 부모 테이블 초기화
    public static int[] parent = new int[100001];

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) return x;
        // parent[4] = findParent(parent[4]) -> 1
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        // 1 -> 1
        // 2 -> 2
        // 2 -> 2
        // 5 -> 5
        a = findParent(a);
        // 4 -> 4
        // 3 -> 3
        // 4 -> 1
        // 6 -> 6
        b = findParent(b);
        // 1 < 4 -> parent[4] = 1;
        // 2 < 3 -> parent[3] = 2;
        // 2 < 1 -> parent[2] = 1;
        // 5 < 6 -> parent[6] = 5;
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 6
        v = sc.nextInt();
        // 4
        e = sc.nextInt();

        // 부모 테이블 상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i ++) {
            // parent[1] = 1
            // parent[2] = 2
            // parent[3] = 3
            // parent[4] = 4
            // parent[5] = 5
            // parent[6] = 6
            parent[i] = i;
        }

        // Union 연산을 각각 수행
        for (int i = 0; i < e; i ++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // (1, 4)
            // (2, 3)
            // (2, 4)
            // (5, 6)
            unionParent(a, b);
        }

        // 각 원소가 속한 집합 출력하기
        System.out.print("각 원소가 속한 집합 : ");
        for (int i = 1; i <= v; i ++) {
            System.out.print(findParent(i) + " ");
        }
        System.out.println();

        // 부모 테이블 내용 출력하기
        System.out.print("부모 테이블 : ");
        for (int i = 1; i <= v; i ++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }
}
