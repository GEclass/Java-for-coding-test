package yelim.greedy;

public class Greedy_EX3_4 {
    public static void main(String[] args) {
        int N = 25;
        int K = 3;
        int cnt = 0;

        while (true) {
            if(N == 1) {
                break;
            }else {
                if(N % K == 0){
                    N = N / K;
                    cnt += 1;
                }else {
                    N = N - 1;
                    cnt += 1;
                }
            }
        }

        System.out.println(cnt);
    }
}
