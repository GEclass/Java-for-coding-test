package yelim.implement;

public class Implement_EX4_1 {
    public static void main(String[] args) {
        int x = 1;
        int y = 1;

        // for문에서 아무 이동이 없으면 시작 좌표와 같아야 하므로 1로 초기화
        int nx = 1;
        int ny = 1;
        String [] move_type = {"L", "R", "U", "D"};

        int N = 5;
        String [] route = {"R", "R", "R", "U", "D", "D"};

        // 이동 계획 하나씩 확인
        for(int i = 0; i < route.length; i++){
            switch (route[i]) {
                case "R" :
                    ny = y + 1;
                    break;
                case "L" :
                    ny = y - 1;
                    break;
                case "U" :
                    nx = x - 1;
                    break;
                case "D" :
                    nx = x + 1;
                default:
                    break;
            }
            // 범위를 벗어나면 무시하기
            if((nx < 1) || (nx > N) || (ny < 1) || (ny > N)){
                continue;
            }
            // 확인한 이동 계획 수행
            x = nx;
            y = ny;
        }
        System.out.println(x + ", " + y);
    }
}
