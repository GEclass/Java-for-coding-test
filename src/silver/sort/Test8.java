package silver.sort;

import java.util.*;

class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    // (핵심) this (index : 1), other (index : 0)으로 할당
    // 이후 다음 인덱스로 this, other이 진행됨
    // 즉, 입력된 순서를 기반으로 정렬을 수행
    @Override
    public int compareTo(Student other) {
        // 오름차순 정렬 기준, this.score보다 other.score가 크다면
        if (this.score < other.score) {
            // "자리를 바꿔라."
            return -1;
        }

        // this.score가 other.score보다 크다면
        // "자리를 바꾸지 말아라."
        return 1;
    }
}

class Test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 한 줄에 String과 int를 저장하기 위해서 list 선언
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            // Student 객체에 추가
            students.add(new Student(name, score));
        }

        // (핵심) compareTo를 거침으로써 정렬이 수행
        Collections.sort(students);

        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i).getName() + " ");
        }
    }
}
