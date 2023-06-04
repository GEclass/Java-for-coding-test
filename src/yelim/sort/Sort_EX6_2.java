package yelim.sort;

public class Sort_EX6_2 {
    public static void main(String[] args) {
        int[] arr = {74, 25, 19, 90, 33, 15, 66, 32, 84, 83};

        // 0번째 원소는 이미 정렬되었다고 생각하고 1번째 원소부터 시작
        for (int i = 1; i < arr.length; i++) {
            // 인덱스 i부터 1까지 감소하며 반복
            for (int j = i; j > 0; j--) {
                // 한 칸씩 왼쪽으로 이동하며 정렬
                // 자기보다 큰 원소를 만나면 자리 바꾸기
                if (arr[j] < arr[j - 1]) {
                    // 스와프
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
                // 자기보다 작은 데이터를 만나면 그 위치에서 멈춤
                else break;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
