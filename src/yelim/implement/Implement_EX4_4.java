package yelim.implement;

public class Implement_EX4_4 {
    public static void main(String[] args) {
        // 맵 크기
        int N = 4;
        int M = 4;

        // 캐릭터 위치와 방향
        int x = 1;
        int y = 1;
        int d = 0;

        // 맵 구성
        int [][] map = {
                {1,1,1,1},
                {1,0,0,1},
                {1,1,0,1},
                {1,1,1,1},
        };

        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, 1, 0, -1};
        int nx = 0;
        int ny = 0;

        // 방문 칸 수
        int count = 1;
        // 동서남북 이동할 수 있는지
        // 4라면 모든 방향을 이동할 수 없다.
        int turn_time = 0;

        while(true){
            d -= 1;
            if(d == -1) {
                d = 3;
            }
            // 좌표를 이동했는 때
            nx = x + dx[d];
            ny = y + dy[d];
            // 좌표 값이 육지라면 좌표를 이동
            if(map[nx][ny] == 0) {
                x = nx;
                y = ny;
                count += 1;
                // 가본 곳으로 표기
                map[nx][ny] = 1;
                continue;
                // 좌표 값이 바다거나 가본 곳이라면
            }else {
                turn_time += 1;
            }
            // 더이상 갈 곳이 없는 경우
            if(turn_time == 4) {

            }
        }

//        System.out.println(count);
    }
}
