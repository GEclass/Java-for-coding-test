package silver.shortestpath;

import java.util.Arrays;
import java.util.Scanner;

// 플로이드 워셜 알고리즘
public class Test3 {
	public static final int INF = (int) 1e9; // 무한 = 10억 = 1 * 10^9

	// n : 노드의 개수
	// m : 간선의 개수
	public static int n, m;

	// 노드의 개수는 최대 500개라고 가정
	// 2차원 배열(그래프 표현)을 만들기
	public static int[][] graph = new int[501][501];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// ※ nextInt() : 공백(space) 또는 개행(enter)으로 입력
		n = sc.nextInt();
		m = sc.nextInt();

		// 최단 거리 테이블을 모두 무한으로 초기화
		for (int i = 0; i < 501; i ++) {
			Arrays.fill(graph[i], INF);
		}

		// 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
		// a = 1, b = 1 -> graph[1][1] = 0
		// a = 2, b = 2 -> graph[2][2] = 0 ..
		for (int a = 1; a <= n; a ++) {
			for (int b = 1; b <= n; b ++) {
				if (a == b) graph[a][b] = 0;
			}
		}

		// 각 간선에 대한 정보를 입력 받아서
		// 그 값으로 초기화
		for (int i = 0; i < m; i ++) {
			// A → B로 가는 비용은 C라고 설정
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			// (책) 노드 1부터 시작
			// (코드) 노드 1부터 시작
			// 여기서도 관례상, 노드 번호는 1부터 입력할 것

			// graph[1][2] = 4
			graph[a][b] = c;
		}

		// 점화식에 따라 플로이드 워셜 알고리즘을 수행
		// k 노드를 거치는 경우를 계산하므로
		// k가 첫 번째 for문의 변수로 위치
		for (int k = 1; k <= n; k ++) {
			for (int a = 1; a <= n; a ++) {
				for (int b = 1; b <= n; b ++) {
					// graph[1][2] = Math.min(graph[1][2], graph[1][1] + graph[1][2]) = (4, 0 + 4) = 4

					// graph[a]는 행 단위로 구별, 즉 출발 노드를 의미
					// graph[1] = 1번 노드에서 n번 노드로 가는 최단 경로를 저장한 최단 거리 테이블
					// graph[2] = 2번 노드에서 n번 노드로 가는 최단 경로를 저장한 최단 거리 테이블
					// graph[3] = 3번 노드에서 n번 노드로 가는 최단 경로를 저장한 최단 거리 테이블
					// graph[4] = 4번 노드에서 n번 노드로 가는 최단 경로를 저장한 최단 거리 테이블
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}

		// 수행된 결과를 출력
		for (int a = 1; a <= n; a ++) {
			for (int b = 1; b <= n; b ++) {
				if (graph[a][b] == INF) {
					System.out.print("INFINITY");
				}
				// 도달할 수 있는 경우 거리를 출력
				else {
					System.out.print(graph[a][b] + " ");
				}
			}

			System.out.println();
		}
	}
}
