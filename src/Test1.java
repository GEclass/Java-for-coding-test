// 1. for문의 i는 무슨 역할을 하는가?
// 2. coin 변수를 따로 선언한 까닭은?
// 3. 아래의 코드가 옳지 않은 이유는?
// n = n - count * cointype[coin];
// n = n % (count * cointype[coin]);
// 4. 자바에도 % 연산자가 존재한다.

public class Test1 {

    public static void main(String [] args) {
        int n = 1260;
        int count = 0;

        int [] cointype = {500, 100, 50, 10};

        for(int i = 0; i < 4; i ++) {
            int coin = cointype[i];
            count = count + n / coin;
            n = n % coin;
        }
        System.out.println(count);
    }
}
