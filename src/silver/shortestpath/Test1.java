package silver.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// default class
// 그래프의 노드
class Node {

	// 노드의 번호
	private int index;
	// 노드의 간선
	private int distance;

	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return this.index;
	}

	public int getDistance() {
		return this.distance;
	}
}

// Main class
// 다익스트라 알고리즘 실행
// ★ 전체 흐름 ★
public class Test1 {
	// 1 * 10 ^ 9
	// 다른 모든 노드로 가는 최단 거리를 무한으로 설정
	public static final int INF = (int) 1e9;

	// n : 노드의 개수, m : 간선의 개수, start : 시작 노드 번호
	// (저자) 노드의 개수는 최대 100,000개라고 지정
	public static int n, m, start;

	// 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
	public static ArrayList<ArrayList<Node3>> graph = new ArrayList<ArrayList<Node3>>();

	// 방문한 적이 있는지 체크하는 목적의 배열
	public static boolean[] visited = new boolean[100001];

	// 최단 거리 테이블
	public static int[] d = new int[100001];

	// 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
	public static int getSmallestNode() {
		// min value : 최단 거리 테이블의 거리 초깃값
		int min_value = INF;
		// 가장 최단 거리가 짧은 노드(인덱스)
		// 출발 노드의 인덱스 = 초기화
		int index = 0;
		for (int i = 1; i <= n; i++) {
			// 확인하고자 하는 최단 거리 테이블의 노드(d[i])가 무한(min_value)보다 최단 거리가 짧고
			// 방문한 적이 없다면
			if (d[i] < min_value && !visited[i]) {
				// i : 노드 번호, d[i] : 해당 노드의 거리
				min_value = d[i];
				// 인덱스 = 해당 노드의 번호
				index = i;
			}
		}

		return index;
	}

	public static void dijkstra(int start) {
		// 시작 노드 초기화
		// (책) start = 1
		// (코드) start = 1
		// 인덱스 : 0 ~ 9 -> 10개
		// 인덱스 : 1 ~ 10 -> 10개
		// 인덱스 : 0 ~ 99,999 -> 10만개
		// 인덱스 : 1 ~ 100,000 -> 10만개

		// 관례상, 0은 잘 안 쓰일 것 같다.
		// 즉, 시작 노드는 대부분 1로 주어질 것 같음

		// d[1] = 0;
		// i = 1(노드 번호), d[i] = 0(해당 노드의 거리)
		d[start] = 0;
		// 시작 노드 방문 처리
		visited[start] = true;
		for (int j = 0; j  < graph.get(start).size(); j ++) {
			// 최단 거리 테이블의 노드 번호 = 노드 번호에 따른 거리

			// size : 간선의 수
			// j : start, 1하고 연결된 노드의 인덱스, start(1번 노드)와 직접적으로 연결된 노드들까지만 반복

			// ex. start = 1일 때,
			// d[2] = 2 (j = 0)
			// d[3] = 5 (j = 1)
			// d[4] = 1 (j = 2)
			// graph.get(start).get(j).getIndex() = i
			d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
		}

		// 시작 노드를 제외한 전체 n - 1개의 노드에 대해 알고리즘 반복
		for (int i = 0; i < n - 1; i ++) {
			// 현재 최단 거리가 가장 짧은 노드를 꺼내서
			int now = getSmallestNode();
			// 방문 처리
			visited[now] = true;
			// 현재 노드와 연결된 다른 노드를 확인
			for (int j = 0; j < graph.get(now).size(); j ++) {
				// 현재 노드에서 다른 노드로 이동하는 거리, 즉 비용
				int cost = d[now] + graph.get(now).get(j).getDistance();
				// 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
				// graph.get(start).get(j).getIndex() = i
				if (cost < d[graph.get(now).get(j).getIndex()]) {
					// 거리를 최단 거리 테이블에 저장
					d[graph.get(now).get(j).getIndex()] = cost;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// n : 노드의 개수
		n = sc.nextInt();
		// m : 간선의 개수
		m = sc.nextInt();
		// start : 시작 노드 번호
		start = sc.nextInt();

		// 그래프 초기화
		// = 그래프의 토대를 그리는 과정
		for (int i = 0; i < m; i ++) {
			graph.add(new ArrayList<Node3>());
		}

		// 모든 간선 정보를 입력받기
		// = 각 간선에 대한 거리, 즉 비용을 입력
		for (int i = 0; i < m; i ++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			// c : a번 노드에서 b번 노드로 가는 비용
			// graph.get(1).add(new Node(2,2))
			// 1번 노드에서 2번 노드로 가는 비용 2
			// 즉, 1번 노드와 2번 노드의 거리 2
			graph.get(a).add(new Node3(b, c));
		}

		// 최단 거리 테이블을 모두 무한으로 초기화
		Arrays.fill(d, INF);

		// 다익스트라 알고리즘을 수행
		dijkstra(start);

		// 모든 노드로 가기 위한 최단 거리를 출력
		for (int i = 1; i <= n; i ++) {
			// 갈 수 없는 경우, 무한(INFINITY)이라고 출력
			if (d[i] == INF) {
				System.out.println("INFINITY");
			}
			// 도달할 수 있는 경우, 거리를 출력
			else {
				System.out.println(d[i]);
			}
		}
	}
}
