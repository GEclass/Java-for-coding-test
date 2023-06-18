package silver.sort;

import java.util.*;

class Fruit implements Comparable<Fruit> {
    private String name;
    private int score;

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

    // Q. 디버깅 시, other.score이 왜 2, 5, 5, 2 순으로 할당되는지 모르겠습니다.
    @Override
    public int compareTo(Fruit other) {
        System.out.println("this.score : " + this.score + ", other.score : " + other.score);
        if (this.score < other.score) {
            return -1;
        }
        else if (this.score > other.score) {
            return 1;
        }
        // 두 객체의 score이 같을 경우
        return 0;
    }
}

public class Test6 {
    public static void main(String[] args) {
        // Fruit라는 클래스 타입을 가진 List 선언
        List<Fruit> fruits = new ArrayList<>();

        fruits.add(new Fruit("바나나", 2));
        fruits.add(new Fruit("사과", 5));
        fruits.add(new Fruit("당근", 3));

        Collections.sort(fruits);

        for (int i = 0; i < fruits.size(); i ++) {
            System.out.println("(" + fruits.get(i).getName() + "," + fruits.get(i).getScore() + ")");
        }
    }
}