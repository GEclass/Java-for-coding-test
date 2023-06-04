// 퀵 정렬

package silver.sort;

public class Test3 {
    // start = 첫 번째 데이터의 인덱스, end = 마지막 데이터의 인덱스
    // start = 0, end = 9
    public static void quickSort(int[] arr, int start, int end) {
        // 데이터가 한 개인 경우 종료
        if (start >= end)
            return;

        int pivot = start;
        int left = start + 1;
        int right = end;
        while (left <= right) {
            // 피벗보다 큰 데이터를 찾을 때까지 반복
            // while (1 <= 9 && arr[1] <= arr[0])
            // while (7 <= 8 && 7 <= 5)
            // while 문 종료
            while (left <= end && arr[left] <= arr[pivot])
                left ++;

            // 피벗보다 작은 데이터를 찾을 때까지 반복
            // while (9 > 0 && arr[9] >= arr[0])
            // while (8 > 5 && arr[8] >= 5)
            // while 문 반복
            while (right > start && arr[right] >= arr[pivot])
                right --;

            // 엇갈렸다면 작은 데이터와 피벗을 교체
            // 피벗을 기준으로 피벗보다 작은 원소들이 왼쪽에, 큰 원소들이 오른쪽에 위치
            if (left > right) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            }
            // left가 가리키는 원소(arr[left])와 right가 가리키는 원소(arr[right])를 스왑
            // 피벗을 기준으로 큰 값과 작은 값을 올바른 위치에 배치
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        // 분할 이후 왼쪽 파트와 오른쪽 파트에서 각각 정렬 수행
        quickSort(arr, start, right -1);
        quickSort(arr, right + 1, end);
    }

    public static void main(String[] args) {
        int n = 10;
        int[] arr = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort(arr, 0, n - 1);

        for (int i = 0; i < n; i ++) {
            System.out.print(arr[i] + " ");
        }
    }
}
