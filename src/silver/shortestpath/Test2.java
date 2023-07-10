package silver.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node2 implements Comparable<Node2> {
	private int index;
	private int distance;

	public Node2(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return this.index;
	}

	public int getDistance() {
		return this.distance;
	}

	// ★ 거리(비용)가 짧은 (노드, 거리)이 높은 우선순위를 가지도록 역할을 수행
	// compareTo() : 정렬을 수행
	@Override
	public int compareTo(Node2 other) {
		// (3,5) < (2,2) -> 1
		// (4,1) < (2,2) -> -1
		if (this.distance < other.distance) {
			// "자리를 바꿔라"
			// 전 : (4,1), (3,5), (2,2)
			// 후 : (4,1), (2,2), (3,5)
			// 내부 동작에 대해서는 추후.. 이해 예정
			return -1;
		}

		return 1;
	}
}
public class Test2 {
	public static final int INF = (int) 1e9;

	// n : 노드의 개수, m : 간선의 개수, start : 시작 노드 번호
	public static int n, m, start;

	public static ArrayList<ArrayList<Node2>> graph = new ArrayList<ArrayList<Node2>>();

	public static int[] d = new int[100001];

	public static void dijkstra(int start) {
		// 우선순위 큐 : 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
		PriorityQueue<Node2> pq = new PriorityQueue<>();

		// 시작 노드로 가기 위한 최단 경로는 0
		// 큐에 삽입
		pq.offer(new Node2(start, 0));
		d[start] = 0;

		// 큐가 비어있지 않다면 (= 큐가 비어있다면, 최단 경로를 구한 것)
		while(!pq.isEmpty()) {
			// 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
			// poll() : 첫 번째 값을 반환하고 제거
			// 비어있다면 null
			Node2 node2 = pq.poll();
			// 현재 노드까지의 비용
			int dist = node2.getDistance();
			// 현재 노드
			int now = node2.getIndex();

			// 현재 노드가 이미 처리된 적이 있는 노드라면 무시
			if (d[now] < dist) {
				continue;
			}
			// 현재 노드와 연결된 다른 인접한 노드들을 확인
			for (int i = 0; i < graph.get(now).size(); i ++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				// 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
				if (cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					// offfer() : 값을 성공적으로 삽입한 경우, true 반환
					// 큐가 다 찬 경우, false 반환
					// 하지만 일반적으로 PriorityQueue의 경우, 동적으로 크기가 변하므로
					// 실질적인 차이는 x
					pq.offer(new Node2(graph.get(now).get(i).getIndex(), cost));
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
			graph.add(new ArrayList<>());
		}

		// 모든 간선 정보를 입력받기
		for (int i = 0; i < m; i ++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			// c : a번 노드에서 b번 노드로 가는 비용
			graph.get(a).add(new Node2(b, c));
		}

		// 최단 거리 테이블을 모두 무한으로 초기화
		Arrays.fill(d, INF);

		// 다익스트라 알고리즘을 수행
		dijkstra(start);

		// 모든 노드로 가기 위한 최단 거리를 출력
		for (int i = 1; i <= n; i ++) {
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
