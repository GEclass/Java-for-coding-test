package yelim;

public class Greedy_EX3_1 {
    public static void main(String [] args){
        int n = 1260;
        int[] coin_type = {500, 100, 50, 10};

        int total_cnt = 0;
        int coin_cnt = 0;

        for (int k : coin_type) {
            coin_cnt = n / k;
            n -= (k * coin_cnt);
            total_cnt += coin_cnt;
        }

        System.out.println(total_cnt);
    }
}

