package MVC.view;

import MVC.controller.PersonController;
import MVC.model.Person;


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
        result += "<body>\n";
        result += "<h1>Name: " + P.getName() + "</h1>\n";
        result += "<h1>cpr: " + P.getCpr() + "</h1>\n";
        result += "<h1>Age: " + PersonController.calcAge(P) + "</h1>\n";
        String type = P.getClass().toString().substring(16,P.getClass().toString().length());
        result += "<h1>Exam("+type+"): " + P.doExam() + "</h1>\n";
        result += "<h1>Type: " + type + "</h1>\n";
        result += "</body>";
        return result;
    }
}
