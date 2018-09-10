public class HelloWorld {

    public static void main(String [] args){

        MyArrayList<String> list = new MyArrayList<>();
        System.out.println(list.size());
        list.add("Hej");
        list.add("med");
        list.add("dig!");
        System.out.println(list);
        System.out.println(list.remove(2));
        /*System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.size());*/

        /*
        Teacher T = new Teacher("Hans Andersen", "010160 7891","CS Professor");
        Teacher T1 = new Teacher("Sara Hansen", "121256 7892","Professor");
        Student S = new Student("Anders Christensen", "121255 4321", 10);
        Student S1 = new Student("Peter Jensen", "121255 4321", 11);
        Student S2 = new Student("Carl Carlsen", "121255 4321", 12);
        Person[] p = new Person[5];
        p[0] = T;
        p[1] = T1;
        p[2] = S;
        p[3] = S1;
        p[4] = S2;
        S.grades.add(10);
        S.grades.add(7);
        S.grades.add(4);
        S.grades.add(12);
        S.grades.add(12);
        S.grades.add(12);
        System.out.println("Average grade: " + S.getGradeAverage());
        for (Person m: p){
            System.out.println(m.toString());
        }
        System.out.println("Age: " + p[0].Age());
        System.out.println("Is these two the same student: " + Student.equals((Student)p[2],(Student)p[3]));
        System.out.println("Students: " + Student.getStudentCount());
        System.out.println("Teachers: " + Teacher.getTeacherCount());
        */
    }
}