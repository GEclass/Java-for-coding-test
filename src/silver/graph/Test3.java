package silver.graph;

import java.util.*;

public class Test3 {
    // V : 노드의 개수
    // E : 간선의 개수
    public static int v, e;
    // 부모 테이블 초기화
    public static int[] parent = new int[100001];

    // 특정 원소가 속한 집합 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) return x;
        // parent[2] -> 2 -> findParent(parent[2]) -> findParent(1)
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        // 1 -> 1
        a = findParent(a);
        // 2 -> 1
        b = findParent(b);
        if (a < b) parent[b] = a;
        // 2 < 1
        // parent[2] = 1;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 3
        v = sc.nextInt();
        // 3
        e = sc.nextInt();

        // 부모 테이블 상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i ++) {
            parent[i] = i;
        }

        // 사이클 발생 여부
        boolean cycle = false;

        for (int i = 0; i < e; i ++) {
            // (1, 2)
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 사이클이 발생한 경우 종료
            // (2, 3) -> 1 == 1
            if (findParent(a) == findParent(b)) {
                cycle = true;
                break;
            }
            // 사이클이 발생하지 않았다면 합집합(union) 연산 수행
            // findParent(1) -> 1 == findParent(2) -> 2
            else {
                // (1, 2) -> 1
                // (1, 3) -> 1
                unionParent(a, b);
            }
        }

        if (cycle) {
            System.out.println("사이클이 발생했습니다.");
        } else {
            System.out.println("사이클이 발생하지 않았습니다.");
        }
    }
}
