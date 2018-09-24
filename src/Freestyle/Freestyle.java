package Freestyle;

import java.util.LinkedList;

public class Freestyle {
    public static void main (String [] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("David");
        System.out.println(names);
        if(names.contains("Bob")) names.add("Charlie");
        names.forEach(E->{
            E.toUpperCase();
        });
        System.out.println(names);
    }


}
