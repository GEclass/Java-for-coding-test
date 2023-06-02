package silver.search;

// '늘 필요한 라이브러리만 임포트하도록 노력하자.'
import java.util.ArrayList;

class Node {
    // 코드를 작성할 때, '항상 public으로 작성할 이유가 있을까?'라는 생각을 가져보자.
    // 노드의 인덱스 = 노드
    private int index;
    // 간선
    private int distance;

    public Node(int index, int distance) {
        // 지역 변수 = 매개 변수
        this.index = index;
        this.distance = distance;
    }

    public void show() {
        System.out.println("(" + this.index + "," + this.distance + ")");
    }
}
public class Test7 {
    // 2차원 리스트, 행렬
    // Node 객체들을 요소로 갖는 ArrayList를 다시 요소로 갖는 ArrayList를 선언하고, 이를 graph라는 이름으로 초기화
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    public static void main(String [] args) {
        // 그래프 초기화
        // 그래프를 구성하는 각 노드의 리스트를 생성
        // "행"만 초기화한 후, 이후 "열"은 후에 노드에 연결된 노드 정보를 추가할 때 만들어짐
        for (int i = 0; i < 3; i ++) {
            graph.add(new ArrayList<Node>());
        }

        // 노드 0에 연결된 노드 정보 저장 (노드, 거리)
        graph.get(0).add(new Node(1,7));
        graph.get(0).add(new Node(2,5));

        // 노드 1에 연결된 노드 정보 저장 (노드, 거리)
        graph.get(1).add(new Node(0, 7));

        // 노드 2에 연결된 노드 정보 저장 (노드, 거리)
        graph.get(2).add(new Node(0, 5));

        // 그래프 출력
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                graph.get(i).get(j).show();
            }

            System.out.println();
        }
    }

}
