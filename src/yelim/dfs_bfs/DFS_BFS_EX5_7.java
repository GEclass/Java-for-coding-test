package yelim.dfs_bfs;

import java.util.*;

class Node {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public void show() {
        System.out.print("(" + this.index + ", " + this.distance + ")");
    }
}

public class DFS_BFS_EX5_7 {
    // Node 객체만 저장하하는 ArrayList 2차원으로 선언
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static void main(String[] args) {
        // ArrayList 그래프 초기화
        for(int i=0;i < 3;i++) {
            graph.add(new ArrayList<Node>());
        }

        // 그래프의 0번째 요소에 노드 저장
        graph.get(0).add(new Node(1,7));
        graph.get(0).add(new Node(2,5));

        // 그래프의 1번째 요소에 노드 저장
        graph.get(1).add(new Node(0,7));

        // 그래프의 2번재 요소에 노드 저장
        graph.get(2).add(new Node(0,5));

        // 그래프 출력
        for(int i=0;i < 3;i++){
            for(int j=0;j < graph.get(i).size();j++) {
                graph.get(i).get(j).show();
            }
            System.out.println();
        }

    }
}
