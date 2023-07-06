package yelim.dynamic;

import java.util.*;

public class DP_EX8_6 {
    // 식량 창고 i까지의 최대 식량 합 위한 DP 테이블 - 메모이제이션
    public static int[] d = new int[100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 식량 창고 개수 정수 N을 입력받기 (3 <= N <= 100)
        int n = sc.nextInt();

        // 식량 창고에 저장된 식량 개수 (0 <= arr[i] <= 1000)
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 일찍선으로 구성된 식량 창고에서 창고 사이가 최소 한 칸이상 떨어진 창고들만 식량을 약탈한다고 했을 때, 얻을 수 있는 식량 최대값
        // 다이나믹 프로그래밍 - 보텀업
        // ai = max(ai-1, ai-2 + ki)

        // 식량 창고가 4개이고 각 창고에 1, 3, 1, 5개의 식량이 있다면,
        // a3(식량 창고 0~2까지 식량 합의 최대 값)과 a2(식량 창고 0~1까지 식량 합의 최대 값) + k4(식량 창고 3의 식량 개수 - 식량 창고 3은 식량 창고 0~1과 한 칸 떨어져 있는 창고 이므로 더해 준다.)
        // d 배열은 각 창고까지의 식량 최대 값 (d[2]이라면 0~2까지의 식량 창고에서 얻을 수 있는 식량 최대 수)
        // a4 = max(a3, a2 + k4)
        // > a3 = max(a2, a1 + k3) ((식량 창고 0~1까지 식량 합의 최대 값, 식량 창고 0의 식량 수 + 식량 창고 0과 떨어져 있는 식량 창고 2의 식량 수) 중 에서 최대 식량 수)
        // > a2 = max(a1) (식량 창고 0과 식량 창고 1의 식량 수 중 최대 값)
        d[0] = arr[0]; // d[0]은 a1(식량 창고 0의 식량 개수 == 식량 창고 0까지의 식량 합)
        d[1] = Math.max(arr[0], arr[1]); // d[1]은 a2(식량 창고 0~1까지의 각 식량 최대 수, 식량 창고 0과 식량 창고 1중 더 큰 식량 개수) -> 인접한 창고 중 하나만 식량 가져오기
        for (int i = 2; i < n; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + arr[i]);
        }

        // 계산된 결과 출력
        System.out.println(d[n - 1]);

    }
}
