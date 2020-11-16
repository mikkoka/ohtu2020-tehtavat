
package ohtu;

public class Player implements Comparable<Player> {
    private String name, nationality, team;
    private int goals, assists;

    public String getName() {
        return nationality;
    }

    public String getTeam() {
        return nationality;
    }

    public int getGoals() {
        return goals;
    }

    public String getNationality() {
        return nationality;
    }

    public String getGoalsAndAssists() {
        return goals + " + " + "assists";
    }

    public int getPoints() {
        return goals + assists;
    }

    public String toString() {
        return String.format("%-20s %s\t%d\t+\t%d\t=\t%d", name, team, goals, assists, getPoints());
    }

    @Override
    public int compareTo(Player p) {
        int diff = this.getPoints() - p.getPoints();
        if (diff != 0)
            return diff;
        else return goals - p.getGoals();
    }
}
