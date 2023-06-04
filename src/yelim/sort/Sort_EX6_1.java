package yelim.sort;

public class Sort_EX6_1 {
    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        // 각 원소 인덱스에 대해
        for (int i = 0; i < arr.length; i++) {
            int min_index = i; // 가장 작은 원소의 인덱스
            // 전체 중에서 가장 작은 데이터 저장
            // 이미 정렬된 원소를 제외하고 가장 작은 데이터 찾기
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min_index] > arr[j]) {
                    min_index = j;
                }
            }

            // 스와프
            // 가장 작은 데이터 가장 앞에 있는 데이터와 맞바꾸기
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
