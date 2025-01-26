package search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SearchAny extends Search {
    public SearchAny(String[] persons, Map<String, ArrayList<Integer>> personsMap) {
        super(persons, personsMap);
    }

    @Override
    public void search(String searchQuery) {
        String[] searchTerms = searchQuery.split(" ");
        Set<Integer> indexes = new HashSet<>();
        for (String searchTerm : searchTerms) {
            if (this.personsMap.containsKey(searchTerm)) {
                indexes.addAll(this.personsMap.get(searchTerm));
            }
        }
        if (!indexes.isEmpty()) {
            System.out.printf("%d persons found:\n", indexes.size());
            for (Integer index : indexes) {
                System.out.println(this.persons[index]);
            }
        } else {
            System.out.println("No matching people found.");
        }
    }
}
