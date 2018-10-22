package MVC.model;

public class Teacher extends Person {

    public Teacher(String name, String cpr) {
        super(name, cpr);
    }

    @Override
    public void doExam() {
        System.out.println("I will ask the questions");
    }
}
