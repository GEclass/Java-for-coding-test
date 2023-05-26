package yelim.implement;

public class Implement_EX4_3 {
    public static void main(String[] args) {
        int row = 1;
        int column = 0;
        String col_name = "a";

        String [] col_names = {"a", "b", "c", "d", "e", "f", "g", "h"};

        // 입력된 컬럼의 이름이 영어이므로 인덱스 숫자로 바꾸어주기
        for(int j = 0; j < col_names.length; j++){
            if(col_name == col_names[j]){
                column = j;
            }
        }

        // 나이트의 이동 경로 -> 아직 왜 이렇게 이동하는지 이해하지 못했음
        int [][] steps = {
                {-2, -1},
                {-1, -2},
                {1, -2},
                {2, -1},
                {2, 1},
                {1, 2},
                {-1, 2},
                {-2, 1},
        };

        int next_row = 0;
        int next_column = 0;
        int result = 0;

        // 나이트의 이동 수행
        for(int i = 0; i < steps.length; i++) {
            next_row = row + steps[i][0];
            next_column = column + steps[i][1];

            // 나이트의 이동이 체스판 범위 안일 경우 결과에 횟수 더하기
            if ((next_row >= 1) && (next_row <= 8) && (next_column >= 1) && (next_column <= 8)) {
                result += 1;
            }
            // next_row = 0;
            // next_column = 0;
        }

        System.out.println(result);

    }
}
