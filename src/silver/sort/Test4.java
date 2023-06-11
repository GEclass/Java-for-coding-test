package silver.sort;

public class Test4 {
    // arr 배열에서 가장 큰 값
    // = arr 배열의 인덱스가 0 ~ 9
    public static final int MAX_VALUE = 9;

    public static void main(String[] args) {
        // 데이터의 총 개수
        int n = 15;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};

        // arr 배열에서 등장하는 모든 데이터의 등장 횟수를 카운트할 배열
        // 선언 시, 값은 0으로 초기화
        // 인덱스가 0 ~ 9까지 = 배열의 크기는 10
        int[] cnt = new int[MAX_VALUE + 1];

        // cnt 배열에 arr 배열의 값이 위치하는 인덱스에 해당 값이 등장한 횟수 카운트

        // arr[0] = 7의 경우,
        // cnt[arr[0]] = cnt[arr[0]] + 1
        // cnt[7] = cnt[7] + 1
        // cnt[7] = 0 + 1

        // 정리 : 현재까지 arr[0]의 값인 7이 한 번 등장
        // 이 7은 cnt[] 배열의 7번째 인덱스에 카운트가 된다.
        // 7 = 7번째 인덱스인 이유 -> arr[] 값이 0, cnt[] 0번째 인덱스, arr[] 1, cnt[] 1번째 인덱스, ..
        for (int i = 0; i < n; i ++) {
            cnt[arr[i]] += 1;
        }

        // cnt 배열을 순회하며 각 인덱스를 해당 인덱스의 값만큼 반복하여 출력
        for (int i = 0; i <= MAX_VALUE; i ++) {
            // j = 0, j < cnt[0] --> j < 2
            // j가 0일 때, arr 배열의 첫 번째 0 출력
            // j가 1일 때, arr 배열의 두 번째 0 출력
            for (int j = 0; j < cnt[i]; j ++) {
                // System.out.println("j의 값 : " + j);
                // 모든 데이터, 즉 15개의 데이터 값이 정렬된 상태를 출력
                System.out.println(i + " ");
            }
        }
    }
}
