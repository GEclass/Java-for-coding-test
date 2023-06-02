package silver.search;

public class Test6 {
    public static final int INF = 999999999;

    // 2차원 배열을 이용해 인접 행렬 표현
    public static int[][] graph = {
            {0, 7, 5},
            {7, 0, INF},
            {5, INF, 0}
    };

    public static void main(String [] args) {
        // 행
        for (int i = 0; i < 3; i ++) {
            // 열
            for (int j = 0; j < 3; j ++) {
                // 같은 행 내에서 열만 구분하여 출력하므로, print() / + " "
                System.out.print(graph[i][j] + " ");
            }

            // 다음 행 출력
            System.out.println();
        }
    }
}
