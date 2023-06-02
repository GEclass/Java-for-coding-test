package silver.search;

public class Test4 {
    public static void recursiveFunction(int i) {
        // 2) i가 100인지 체크 후, 아니므로 if문은 건너뜀
        // 5) i가 100이 되면, if문 내의 코드 실행
        if (i == 100) {
            return;
        }

        // 3) 출력
        // "1번째 재귀 함수에서 2번째 재귀 함수를 호출합니다."
        System.out.println(i + "번째 재귀 함수에서 " + (i + 1) + "번째 재귀 함수를 호출합니다.");

        // 4) i는 2가 되면서 다시 recursiveFunction()을 출력
        // 이때, 재귀함수는 스택 구조이므로 recursiveFunction(1) 메소드 위에 recursiveFunction(2) 메소드가 생김
        recursiveFunction(i + 1);

        // 6) i는 매개변수로써 넘겨지기 전 값인 99로서, 아래 출력문 출력
        // "99번째 재귀 함수를 종료합니다."

        // 7) recursiveFunction(99) 메소드가 리턴된 후에 그 아래에 있던 recursiveFunction(98) 메소드가 호출됨
        // 반복 ..
        System.out.println(i + "번째 재귀 함수를 종료합니다.");
    }
    public static void main(String [] args) {
        // 1) 1이라는 값을 가진 i를 매개변수로 입력하여 recursiveFunction() 메소드를 호출
        recursiveFunction(1);
    }
}
