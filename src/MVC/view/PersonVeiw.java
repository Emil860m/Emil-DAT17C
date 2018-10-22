package MVC.view;

import MVC.controller.PersonController;
import MVC.model.Person;
import MVC.model.Student;
import MVC.model.Teacher;

public class PersonVeiw {

    public static String toJSON(Person P){
//        String json = "{ \"name\": \"" + P.getName() + "\", \"cpr\": \"" + P.getCpr() + "\", \"age\": " + PersonController.calcAge(P) + " }";
        String result = "{";
        result += "\"name\": \"" + P.getName() + "\", ";
        result += "\"cpr\": \"" + P.getCpr()+ "\", ";
        result += "\"age\": " + PersonController.calcAge(P);
        result += "}";
        return result;
    }

    public static String toHTML(Person P){
        String result = "";
//        result += "<head></head>";
        result += "<body>";
        result += "<h1>Name: " + P.getName() + "</h1>";
        result += "<h1>cpr: " + P.getCpr() + "</h1>";
        result += "<h1>Age: " + PersonController.calcAge(P) + "</h1>";
        String type = P.getClass().toString().substring(16,P.getClass().toString().length());
        result += "<h1>Exam("+type+"): " + P.doExam() + "</h1>";
        result += "<h1>Type: " + type + "</h1>";
//        if(P instanceof Teacher){
//            result += "<h1>Exam(Teacher): " + P.doExam() + "</h1>";
//            result += "<h1>Type: Teacher </h1>";
//        }else if(P instanceof Student){
//            result += "<h1>Exam(Student): " + P.doExam() + "</h1>";
//            result += "<h1>Type: Student </h1>";
//        }

        result += "</body>";
        return result;
    }
}
