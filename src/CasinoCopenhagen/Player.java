package CasinoCopenhagen;

public class Player extends User {
    private int cash;

    public Player(String name, String cpr, int cash) {
        super(name, cpr);
        this.cash = cash;
    }
}
