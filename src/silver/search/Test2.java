package silver.search;

import java.util.*;

public class Test2 {
    public static void main(String [] args) {
        // 자바에서 큐는 인터페이스가 있고 별도의 클래스가 없다.
        // 따라서 큐 인터페이스를 구현한 클래스들을 사용해야 한다.
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(5);
        queue.offer(2);
        queue.offer(3);
        queue.offer(7);
        // 큐 맨 앞에 있는 값 반환 후 삭제
        queue.poll();
        queue.offer(1);
        queue.offer(4);
        queue.poll();

        // 먼저 들어온 순서대로 출력
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
