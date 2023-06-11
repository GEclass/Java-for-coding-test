package silver.sort;

import java.util.*;

class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.age;
    }

    @Override
    public int compareTo(Student other) {
        System.out.println("other " + other.getName());
        if (this.age < other.age) {
            return -1;
        }

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
            int age = sc.nextInt();
            // Student 객체에 추가
            students.add(new Student(name, age));
        }

        Collections.sort(students);

        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i).getName() + " ");
        }
    }
}
