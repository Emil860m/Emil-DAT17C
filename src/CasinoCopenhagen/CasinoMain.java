package CasinoCopenhagen;


import java.util.Scanner;

public class CasinoMain {
    public static void main(String[]args){
        Dealer dealer1 = new Dealer("Carl", "123456 7891", 1, "1234");

        Dealer.login("Carl", "1234");

        System.out.println("Dealer menu");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        switch (input){
            case "1": //new Dealer
                new Dealer("Alice", "123456 1234", 2, "1234");
                break;
            case "2": //new player
                new Player("Hans", "121290 4321", 200);
                break;
            default:
                break;
        }

    }
}
