package statistics;
import statistics.matcher.*;

import java.util.ArrayList;

public class QueryBuilder {

    private ArrayList<Matcher> matchers;

    public QueryBuilder () {
        this.matchers = new ArrayList<>();
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        matchers.add(new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasFewerThan (int value, String category) {
        matchers.add(new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher...matchs) {
        matchers.add(new Or(matchs));
        return this;

    }

    public Matcher build() {
        if (matchers.isEmpty()) return new All();
        Matcher[] arr = new Matcher[matchers.size()];
        arr = matchers.toArray(arr);
        matchers = new ArrayList<>();
        return new And(arr);
    }
}
