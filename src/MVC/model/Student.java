package MVC.model;

public class Student extends Person {

    public Student(String name, String cpr) {
        super(name, cpr);
        System.out.println("A student has been created");
    }

    @Override
    public void doExam() {
        System.out.println("I will read for the exam");
    }
}
