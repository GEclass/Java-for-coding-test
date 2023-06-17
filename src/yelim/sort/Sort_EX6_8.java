package yelim.sort;

import java.util.*;

class Student implements Comparable<Student> {

    private String name;
    private int score;

    // 학생의 이름과 점수 저장
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // 학생 이름 가져오기
    public String getName() {
        return this.name;
    }

    // 학생 점수 가져오기
    public int getScore() {
        return this.score;
    }

    // 정렬 라이브러리를 사용하기 위한 인터페이스 Comparable 구현
    // 정렬 기준은 점수가 낮은 순서로 compareTo 함수 오버라이딩
    @Override
    public int compareTo(Student other) {
        if (this.score < other.score) {
            return -1;
        }
        return 1;
    }
}

public class Sort_EX6_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            students.add(new Student(name, score));
        }

        // 인터페이스 Comparable 구현하여 오버라이딩한 대로 정렬된다.
        Collections.sort(students);

        // 정렬된 리스트의 이름 출력
        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i).getName() + " ");
        }
    }
}
