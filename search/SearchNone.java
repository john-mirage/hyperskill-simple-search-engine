package search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SearchNone extends Search {
    public SearchNone(String[] persons, Map<String, ArrayList<Integer>> personsMap) {
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
            System.out.printf("%d persons found:\n", this.persons.length - indexes.size());
            for (int i = 0; i < this.persons.length; i++) {
                if (!indexes.contains(i)) {
                    System.out.println(this.persons[i]);
                }
            }
        } else {
            System.out.printf("%d persons found:\n", this.persons.length);
            for (String person : this.persons) {
                System.out.println(person);
            }
        }
    }
}
