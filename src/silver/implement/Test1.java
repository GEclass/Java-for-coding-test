package silver.implement;

import java.util.*;

public class Test1 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // ※ next(), nextInt() 사용 시 반드시 nextLine()을 통해 버퍼를 비워줘야 함
        sc.nextLine();
        // 이전 문제들과 달리 공백으로 구분되지 않음
        String[] plans = sc.nextLine().split(" ");
        int x = 1, y = 1;

        // L: ←, R: →, U: ↑, D: ↓
        int [] dx = {0, 0, -1, 1};
        int [] dy = {-1, 1, 0, 0};
        // 입력된 문자열
        char [] moveTypes = {'L', 'R', 'U', 'D'};

        // 여행가 A의 계획서를 하나씩 읽어오기
        for(int i = 0; i < plans.length; i ++) {
            // String 중 한 글자만 선택해서 char 타입으로 변환, 즉 R R R D D D → R, ..
            char plan = plans[i].charAt(0);
            // 계획서와 입력된 문자열 비교
            // Q. 책 기준, 왜 nx와 ny = -1로 초기화?
            int nx = 0, ny = 0;
            for(int j = 0; j < 4; j ++) {
                // 계획서와 0번째 moveTypes가 같지 않다면 다음 moveTypes 비교
                if(plan == moveTypes[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }

            if (nx < 1 || ny < 1 || nx > n || ny > n) {
                // 하나라도 참일 경우 첫 번째 for문으로 리턴
                continue;
            }

            x = nx;
            y = ny;
        }

        // " " 사용 시, 띄어쓰기 효과
        System.out.println(x + " " + y);
    }
}
