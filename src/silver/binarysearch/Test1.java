package silver.binarysearch;

import java.util.Scanner;

public class Test1 {
    // 순차 탐색
    public static int sequentialSerach (int n, String target, String[] arr) {
        // 각 원소를 하나씩 확인
        for (int i = 0; i < n; i ++) {
            // 문자열 배열의 문자와 찾고자 하는 문자가 같다면
            // 해당 문자의 인덱스 저장
            if (arr[i].equals(target)) {
                return i + 1;
            }
        }

        // 문자열 배열에 찾고자 하는 문자가 없다면
        return - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("생성할 원소 개수를 입력한 다음 한 칸 띄고 찾을 문자열을 입력하세요.");
        // 원소의 개수
        // 5
        int n = sc.nextInt();
        // 찾고자 하는 문자열
        // "Dongbin"
        String target = sc.next();

        System.out.println("앞서 적은 원소 개수만큼 문자열을 입력하세요. 구분은 띄어쓰기 한 칸으로 합니다.");
        String[] arr = new String[n];
        for (int i = 0; i < n; i ++) {
            // 원소의 개수에 맞는 문자열 모두 입력
            // "Hanul" "Jonggu" "Dongbin" "Taeil" "Sangwook"
            arr[i] = sc.next();
        }

        // 순차 탐색 수행 결과 출력
        System.out.println(sequentialSerach(n, target, arr));
    }
}
