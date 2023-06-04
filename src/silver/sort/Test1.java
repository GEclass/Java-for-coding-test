package silver.sort;

public class Test1 {
    public static void main(String[] args) {
        // int[] array = new int[] {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        // 총 데이터의 개수
        int n = 10;

        // 첫 번째 데이터
        for (int i = 0; i < n; i ++) {
            int min_index = i;
            // 두 번째 데이터
            for (int j = i + 1; j < n; j++) {
                // 가장 작은 값을 가진 데이터의 인덱스 구하기
                // arr[0] > arr[1]
                // 7 > 5
                if (arr[min_index] > arr[j]) {
                    // min_index = 1;
                    min_index = j;
                }
            }

            // 스와프 : 특정한 리스트가 주어졌을 때, 두 변수의 위치를 변경하는 작업

            // 기존 arr 배열의 데이터 값을 저장할 temp 변수
            // temp = arr[0];
            // temp = 7;
            int temp = arr[i];

            // 찾은 작은 데이터 값의 위치 변경
            // arr[0] = arr[3]
            // arr[0] = 0;
            arr[i] = arr[min_index];

            // 기존 arr 배열의 데이터 값의 위치 변경
            // arr[3] = 7;
            arr[min_index] = temp;
        }

        // 재배치 완료한 arr 배열의 값을 순서대로 출력
        for(int i = 0; i < n; i ++) {
            System.out.print(arr[i] + " ");
        }
    }
}
