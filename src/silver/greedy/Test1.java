package silver.greedy;

public class Test1 {

    public static void main(String [] args) {
        int n = 1260;
        int count = 0;

        int [] coinTypes = {500, 100, 50, 10};

        // coinTypes를 순회하기 위한 변수 i
        for(int i = 0; i < 4; i ++) {
            count = count + n / coinTypes[i];
            // 자바에도 나머지 연산자(%)가 존재
            n = n % coinTypes[i];
        }
        System.out.println(count);
    }
}
