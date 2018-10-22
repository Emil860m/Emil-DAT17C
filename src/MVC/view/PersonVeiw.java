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
}
