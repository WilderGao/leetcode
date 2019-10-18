package 笔试题;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author WilderGao
 * time 2019-10-16 20:12
 * motto : everything is no in vain
 * description
 */
public class HuaweiNewThree {
    private static final int NUM = 10;

    public static void main(String[] args) {
        List<Student> students = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < NUM; i++) {
            String information = scanner.nextLine();
            String[] splitInform = information.split(" ");
            if (splitInform[0].length() > 10 || Integer.parseInt(splitInform[1]) < 60 ||
                    Integer.parseInt(splitInform[2]) < 60 || Integer.parseInt(splitInform[2]) < 60) {
                continue;
            }
            students.add(toStudent(information));
        }

        students.sort(((o1, o2) -> {
            char[] chars1 = o1.name.toCharArray();
            char[] chars2 = o2.name.toCharArray();
            int i = 0;
            while (i < chars1.length && i < chars2.length) {
                if (chars1[i] > chars2[i]) {
                    return 1;
                } else if (chars1[i] < chars2[i]) {
                    return -1;
                } else {
                    i++;
                }
            }
            if (i == chars1.length) return 1;
            if (i == chars2.length) return -1;
            return 0;
        }));

        students.sort((o1, o2) -> {
            if (o1.english > o2.english) {
                return -1;
            } else if (o1.english < o2.english) {
                return 1;
            } else {
                return 0;
            }
        });

        students.sort((o1, o2) -> {
            if (o1.math > o2.math) {
                return -1;
            } else if (o1.math < o2.math) {
                return 1;
            } else {
                return 0;
            }
        });

        students.sort((o1, o2) -> {
            if (o1.chinese > o2.chinese) {
                return -1;
            } else if (o1.chinese < o2.chinese) {
                return 1;
            } else {
                return 0;
            }
        });

        students.sort((o1, o2) -> {
            if (o1.count > o2.count) {
                return -1;
            } else if (o1.count < o2.count) {
                return 1;
            } else {
                return 0;
            }
        });

        System.out.println("[First round name list]");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
        System.out.println("[Final name list]");
        int counter = 0;
        for (int i = 0; i < students.size() && counter < 3; i++) {
            Student student = students.get(i);
            if (student.chinese < 60 || student.math < 60 || student.english < 60) continue;
            if (i - 1 > 0) {
                Student beforeStudent = students.get(i - 1);
                if (beforeStudent.chinese == student.chinese
                        && beforeStudent.math == student.math && beforeStudent.english == student.english) {
                    System.out.println(student);
                    continue;
                }
            }
            System.out.println(student);
            counter++;
        }
    }


    private static Student toStudent(String information) {
        String[] splitInform = information.split(" ");
        return new Student(splitInform[0], Integer.parseInt(splitInform[1]),
                Integer.parseInt(splitInform[2]), Integer.parseInt(splitInform[3]));
    }
}

class Student {
    String name;
    int chinese;
    int math;
    int english;
    int count;

    Student(String name, int chinese, int math, int english) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.count = chinese + math + english;
    }

    @Override
    public String toString() {
        return name + " " + chinese + " " + math + " " + english;
    }
}
