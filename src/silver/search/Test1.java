// ※ 자바는 Stack 자료구조를 곧바로 sort() 메소드를 통해 정렬시킬 수 없다.

package silver.search;

import java.util.*;

public class Test1 {
    public static void main(String [] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.pop();
        stack.push(1);
        stack.push(4);
        stack.pop();

        // 스택의 최하단 원소부터 출력
        System.out.println(stack);

        // 스택의 최상단 원소부터 출력
        while(!stack.empty()) {
            // peek() : 가장 마지막에 저장된 요소 반환
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
