package search;

import java.util.ArrayList;
import java.util.Map;

public abstract class Search {
    protected final String[] persons;
    protected final Map<String, ArrayList<Integer>> personsMap;

    protected Search(String[] persons, Map<String, ArrayList<Integer>> personsMap) {
        this.persons = persons;
        this.personsMap = personsMap;
    }

    public void execute() {
        String searchQuery = this.getQuery();
        this.search(searchQuery);
    }

    private String getQuery() {
        return UserInterface.askForSearchQuery().toLowerCase();
    }

    protected abstract void search(String searchQuery);
}
