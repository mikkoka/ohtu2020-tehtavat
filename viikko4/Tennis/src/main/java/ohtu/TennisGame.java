package ohtu;

public class TennisGame {

    private int[] scores = new int[3];
    private String[] players = new String[3];
    private final String[] scoreNames = new String[] {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame(String player1Name, String player2Name) {
        players[1] = player1Name;
        players[2] = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            scores[1] += 1;
        else
            scores[2] += 1;
    }

    public String getScore() {
        if (scores[1] == scores[2]) return playersEven();
        if (scores[1] > scores[2])
            return playerLeads(1);
        else return playerLeads(2);
    }

    private String playersEven(){
        if (scores[1] <= 3) return scoreNames[scores[1]] + "-All";
          else return "Deuce";
    }

    private String playerLeads(int leader) {

        int challenger = leader == 1 ? 2 : 1;
        if (scores[leader] >= 4) return overForty(leader, challenger);
        else return underForty();
    }


    private String overForty(int leader, int challenger)   {

        switch (scores[leader]-scores[challenger]) {
            case 1: return "Advantage player" + leader;
            default: return "Win for player" + leader;
        }
    }

    private String underForty() {
        return scoreNames[scores[1]] + "-" + scoreNames[scores[2]];
    }
}