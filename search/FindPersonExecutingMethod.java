package search;

import java.util.ArrayList;
import java.util.Map;

public class FindPersonExecutingMethod implements ExecutingMethod {
    private final String[] persons;
    private final Map<String, ArrayList<Integer>> personsMap;

    public FindPersonExecutingMethod(String[] persons, Map<String, ArrayList<Integer>> personsMap) {
        this.persons = persons;
        this.personsMap = personsMap;
    }

    @Override
    public void execute() {
        String searchingStrategy = UserInterface.askForSearchingStrategy();
        Search search = switch (searchingStrategy) {
            case "ALL" -> new SearchAll(this.persons, this.personsMap);
            case "ANY" -> new SearchAny(this.persons, this.personsMap);
            case "NONE" -> new SearchNone(this.persons, this.personsMap);
            default -> throw new IllegalArgumentException("Invalid searching strategy: " + searchingStrategy);
        };
        search.execute();
    }
}
