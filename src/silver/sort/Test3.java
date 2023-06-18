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
            // 피벗보다 큰 값을 왼쪽에서부터 찾았으나 오른쪽에 있는 경우 = 피벗보다 작은 값을 오른쪽에서부터 찾았으나 왼쪽에 있는 경우
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
        // if (start >= end)에 걸릴 때까지 재귀 함수 반복 수행
        // 왼쪽 파트 : (왼쪽 기준) 인덱스 0부터 피벗 값(5) 전(right - 1)까지
        quickSort(arr, start, right -1);
        // 이후, if (start >= end)에 걸릴 때까지 재귀 함수 반복 수행
        // 오른쪽 파트 : (오른쪽 기준) 피벗 값(5) 다음(right + 1)부터 인덱스 9까지
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
