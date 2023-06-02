package silver.search;

public class Test4 {
    public static void recursiveFunction(int i) {
        // 1) i가 100인지 체크 후, 아니므로 if문은 건너뜀
        // 3) i가 100이 되면, if문 내의 코드 실행
        if (i == 100) {
            System.out.println(i + "번째 재귀 함수에서 " + (i + 1) + "번째 재귀함수를 호출합니다.");
            // 4) 해당 메소드 종료, 이전 호출 스택으로 리턴
            return;
        }

        // 2) i는 100이 될 때까지 증가
        recursiveFunction(i + 1);
        // 5) 이전 호출 스택에서는 i의 값이 99이므로, "99번째 재귀 함수를 종료합니다."
        // 6) 처음의 recursiveFunction(1) 호출로 되돌아갈 때까지 반복, 이때 "1번째 재귀함수를 종료합니다."
        System.out.println(i + "번째 재귀 함수를 종료합니다.");

    }
    public static void main(String [] args) {
        recursiveFunction(1);
    }
}
