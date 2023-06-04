package yelim.sort;

import java.util.*;
public class Sort_EX6_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정렬할 수의 개수 받기
        int n = sc.nextInt();

        // 수를 배열에 저장
        // int [] arr = new int[n];
        // public static void sort(int[] a) {
        //    DualPivotQuicksort.sort(a, 0, 0, a.length);
        // }
        // 위 메소드가 Arrays 클래스에 있기 때문에
        // int[]를 매개변수로 받기 때문에 오름차순으로 정렬할 수 있다.
        Integer [] arr = new Integer[n];
        for(int i=0;i < n;i++) {
            arr[i] = sc.nextInt();
        }

        // 거꾸로 정렬하기
        // int형 배열을 거꾸로 정렬할 경우, 에러
        // Arrays.<T>sort(T[], java.util.Comparator<? super T>)에서 T가 int형을 호환하지 않는다.
        // 어떤 객체든 호환하는 Generic Class(여기서는 Collections 클래스) 입장에서 int형은 객체가 아닌 원시 타입이여서 호환하지 않으므로
        // Collections.reverseOrder() 사용하기 위해서는 Integer형으로 선언된 배열을 사용해야 한다.
        Arrays.sort(arr, Collections.reverseOrder());

        // 정렬한 내용 출력
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
