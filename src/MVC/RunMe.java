package MVC;

import MVC.model.Person;
import MVC.model.Student;
import MVC.model.Teacher;
import MVC.view.PersonVeiw;

public class RunMe {
    public static void main(String [] args){
        Person s = new Student("Alice", "1005893232");
        Person t = new Teacher("bob", "2312934545");

        System.out.println(PersonVeiw.toJSON(s));
        System.out.println(PersonVeiw.toJSON(t));
    }
}
