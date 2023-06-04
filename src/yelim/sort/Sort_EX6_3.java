package yelim.sort;

public class Sort_EX6_3 {
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return; // 원소가 1개인 경우 종료

        // 피벗은 첫 번째 원소
        // 큰 수와 작은 수를 교환할 때, 교환하기 위한 기준
        int pivot = start; // 가쥰 원소 인덱스
        int left = start + 1;
        int right = end;

        while (left <= right) {
            // 피벗보다 작은 데이터를 찾을 때까지 반복
            // 마지막 인덱스 번호보다 작으면서 기준 원소보다 작은 원소 찾기
            // 찾으면 옆으로 가기
            while (left <= end && arr[left] <= arr[pivot]) left++;

            // 피벗보다 큰 데이터를 찾을 때까지 반복
            // 처음 인덱스 번호보다 크면서 기분 원소보다 큰 원소 찾기
            while (right > start && arr[right] >= arr[pivot]) right--;

            // 엇갈렸다면 작은 데이터와 피벗을 교체
            // 엇갈렸다는 개념을 아직 모르겠음
            if (left > right) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            }

            // 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }
    public static void main(String[] args) {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort(arr, 0, n - 1);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
