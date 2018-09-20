package CasinoCopenhagen;

public class Tournament {
    private String name;
    private int prize;
    private double buyIn;

    public Tournament(String name, int prize) {
        this.name = name;
        this.prize = prize;
        buyIn = prize * 0.1;
    }
}
