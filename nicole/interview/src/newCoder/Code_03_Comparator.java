package newCoder;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author NicoleChen
 * @date 2018/5/3 20:52
 */
public class Code_03_Comparator {
    public static void main(String[] args) {
        Student s1 = new Student("A",1,23);
        Student s2 = new Student("B",2,27);
        Student s3 = new Student("C",3,21);
        Student[] students = new Student[]{s1,s2,s3};
        printStudent(students);
        Arrays.sort(students,new IdAscendComparator());
        printStudent(students);
        Arrays.sort(students,new IdDesendComparator());
        printStudent(students);

        PriorityQueue<Student> heaap = new PriorityQueue<>(new IdAscendComparator());
        heaap.add(s1);
        heaap.add(s2);
        heaap.add(s3);
        while (!heaap.isEmpty()){
            Student stu = heaap.poll();
            System.out.println("Name :" + stu.name + " Id :" + stu.name + " Age :" + stu.age);
        }

    }
    public static void printStudent(Student[] students){
        for(Student s : students){
            System.out.println("Name :" + s.name + " Id :" + s.name + " Age :" + s.age);
        }
        System.out.println("================================");
    }
    static class Student{
        private int id;
        private int age;
        private String name;

        public Student(String name, int id, int age ) {
            this.id = id;
            this.age = age;
            this.name = name;
        }
    }

    static class IdAscendComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id-o2.id;
        }
    }
    static class IdDesendComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id-o1.id;
        }
    }


}


