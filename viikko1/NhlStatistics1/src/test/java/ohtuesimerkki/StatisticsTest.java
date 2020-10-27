package ohtuesimerkki;

import junit.framework.TestCase;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StatisticsTest extends TestCase {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp(){
        stats = new Statistics(readerStub);
    }

    public void testSearchFinds() {
        Player p = stats.search("Kurri");
        assertEquals(p.getName(), "Kurri");
    }

    public void testSearchDoesntFake() {
        Player p = stats.search("ville");
        assertNull(p);
    }

    public void testTeam() {
        List<Player> team = stats.team("EDM");
        assertEquals(team.get(0).getName(), "Semenko");

    }
    public void testTopScorers() {
        List<Player> best = stats.topScorers(1);
        assertEquals(best.get(0).getName(), "Gretzky");
    }
}