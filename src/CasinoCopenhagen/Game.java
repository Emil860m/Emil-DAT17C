package CasinoCopenhagen;
import java.util.ArrayList;

public class Game {
    private Tournament tournament;
    private String typeOfGame;
    private ArrayList<Player> playerList;
    private String[] winnerList;

    public Game(Tournament tournament, String typeOfGame) {
        this.tournament = tournament;
        this.typeOfGame = typeOfGame;
    }

    public void addPlayers(Player player){
        playerList.add(player);
    }
}
