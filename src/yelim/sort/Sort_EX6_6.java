package yelim.sort;

import java.util.*;

// 객체 정렬을 위한 인터페이스 Comparable
class Fruit implements Comparable<Fruit> {

    private String name;
    private int score;

    // 생성하면서 저장
    public Fruit(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    // 정렬 기준 : 점수가 낮은 순서
    // Comparable 인터페이스 : 객체를 정렬하는 데 사용되는 메소드인 compareTo() 메소드를 정의
    // -> compareTo() 오버라이딩하여 정렬 방식 정의
    @Override
    public int compareTo(Fruit other) {
        if (this.score < other.score) {
            return -1;
        }
        return 1;
    }
}

public class Sort_EX6_6 {
    public static void main(String[] args) {
        // 데이터 저장할 리스트 선언
        List<Fruit> fruits = new ArrayList<>();

        // 데이터 저장
        fruits.add(new Fruit("바나나", 2));
        fruits.add(new Fruit("사과", 5));
        fruits.add(new Fruit("당근", 3));

        // 리스트 데이터 정렬
        Collections.sort(fruits);

        // 정렬된 데이터 출력
        for (int i = 0; i < fruits.size(); i++) {
            System.out.print("(" + fruits.get(i).getName() + "," + fruits.get(i).getScore() + ") ");
        }

    }
}
