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

        // 4방향의 따른 x, y 변화
        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, 1, 0, -1};
        int nx = 0;
        int ny = 0;

        map[x][y] = 1; // 현재 시작 좌표 방문 처리

        // 방문 칸 수
        int count = 1;

        // 동서남북 이동할 수 있는지
        // turn_time 변수는 가본 방향을 누적한 것
        // 4라면 모든 방향을 이동할 수 없다.
        int turn_time = 0;

        while(true){
            // 방향을 왼쪽으로 돌리기
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

                // 새로운 곳으로 나아갔으므로 초기화
                turn_time = 0;

                continue;
            }else { // 좌표 값이 바다거나 가본 곳이라면
                // 방향 하나를 탐색했으므로 1 증가
                turn_time += 1;
            }

            // 더이상 갈 곳이 없는 경우
            // 4방향 모두 갈 수 없는 것
	        // 모든 4방향을 탐색한 상태로 되돌아가거나 이동을 끝내기
            if(turn_time == 4) {
                // 되돌아가기
                nx = x - dx[d];
                ny = y - dy[d];

                // 되돌아갔는데 땅일 때
                if(map[nx][ny] == 0){
                    x = nx;
                    y = ny;
                }else { // 되돌아갔는데 바다이고 되돌아갈 수 없을 때
                    // 이동을 끝내기
                    break;
                }

                // 탐색 방향 가능 변수 초기화
                turn_time = 0;
            }
        }

        System.out.println(count);
    }
}
