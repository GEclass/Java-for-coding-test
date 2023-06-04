// 삽입 정렬 : 데이터를 하나씩 확인
// 오름차순으로 정렬할 것이므로 항상 왼쪽에 삽입

package silver.sort;

public class Test2 {
    public static void main(String [] args) {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        // 두 번째 데이터부터 비교
        for (int i = 1; i < n; i ++) {
            // 두 번째 데이터와 비교할 첫 번째 데이터
            for (int j = i; j > 0; j --) {
                // arr[1] < arr[0]
                // 5 < 7
                if(arr[j] < arr[j - 1]) {
                    // temp = arr[1]
                    // temp = 5
                    int temp = arr[j];

                    // arr[1] = arr[0]
                    // arr[1] = 7
                    arr[j] = arr[j - 1];

                    // arr[0] = 5
                    arr[j - 1] = temp;
                }

                // 현재 값보다 비교하는 값이 작다면 두 번째 for문 탈출
                // 즉, 첫 번째 for문으로 다시 돌아가서 i의 값이 증가한 채 다시 두 번째 for문 수행
                else break;
            }
        }

        for(int i = 0; i < n; i ++) {
            System.out.print(arr[i] + " ");
        }
    }
}
