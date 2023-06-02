package silver.search;

import java.util.*;

public class Test10 {

    // static 메소드인 main과 dfs에서 접근할 수 있게 하기 위해 static 변수로 선언
    public static int n, m;
    // 조건에 의하면 n, m 은 1000보다 작거나 같음
    public static int[][] graph = new int[1000][1000];

    // true/false로 result를 증가시키기 위해 boolean 값을 리턴
    public static boolean dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m)
            return false;

        // 현재 노드를 아직 방문하지 않았다면
        if (graph[x][y] == 0) {
            graph[x][y] = 1;
            dfs(x - 1, y); // 상
            dfs(x + 1, y); // 하
            dfs(x, y - 1); // 좌
            dfs(x, y + 1); // 우

            return true;
        }

        return false;
    }

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        /*
        2 2
        1 0
        1 1
         */
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        // 얼음 틀 만들기
        for (int i = 0; i < n; i++) {
            // 한 줄에 여러 값을 공백으로 구분하여 받는 방법
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                // 그래프의 특정 위치에 문자를 정수형 타입으로 변환하여 값을 저장하는 방법
                // graph[i][j] = str.charAt(j) - '0';
                graph[i][j] = Integer.parseInt(str.split(" ")[j]);

            }
        }

        System.out.println(Arrays.deepToString(graph));
        // 음료수 채우기
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}
