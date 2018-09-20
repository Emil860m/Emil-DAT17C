package CasinoCopenhagen;

import java.util.ArrayList;

public class Dealer extends User {
    protected int employeeNr;
    private String password;
    private static ArrayList<Dealer> dealerList;

    public Dealer(String name, String cpr, int employeeNr, String password) {
        super(name, cpr);
        this.employeeNr = employeeNr;
        this.password = password;
    }

    public static Dealer login(String userName, String password){
        for (int i = 0; i <dealerList.size() ; i++) {
            if(userName.equals(dealerList.get(i).name) && password.equals(dealerList.get(i).password)){
                return dealerList.get(i);
            }
        }
        return null;
    }

}
