package yelim.sort;

public class Sort_EX6_4 {
    // 제한된 테이터 크기 범위
    // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
    public static final int MAX_VALUE = 9;
    public static void main(String[] args) {
        // 계수 정렬 : 데이터의 크기 범위가 제한되어 정수 형태로 표현할 수 있을 때만 사용할 수 있다.

        // 모든 원소의 값이 0보다 크거나 같다고 가정
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
        // 모든 범위를 포함하는 배열 선언요
        int[] cnt = new int[MAX_VALUE + 1];

        // 각 데이터에 해당하는 인덱스의 값 증가
        for(int i = 0; i < arr.length; i++) {
            cnt[arr[i]] += 1;
        }

        // 배열에 기록된 정렬 정보 확인
        for(int i = 0; i <= MAX_VALUE; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                System.out.print(i + " ");
            }
        }

    }
}
