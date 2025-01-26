package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SearchAll extends Search {
    public SearchAll(String[] persons, Map<String, ArrayList<Integer>> personsMap) {
        super(persons, personsMap);
    }

    @Override
    public void search(String searchQuery) {
        String[] searchTerms = searchQuery.split(" ");
        boolean allTermsFound = Arrays.stream(searchTerms)
                .allMatch(this.personsMap::containsKey);
        if (allTermsFound) {
            List<ArrayList<Integer>> indexes = Arrays.stream(searchTerms)
                    .map(this.personsMap::get)
                    .toList();
            List<Integer> intersection = new ArrayList<>(indexes.getFirst());
            for (List<Integer> list : indexes.subList(1, indexes.size())) {
                intersection.retainAll(list);
            }
            if (!intersection.isEmpty()) {
                System.out.printf("%d persons found:\n", intersection.size());
                for (Integer i : intersection) {
                    System.out.println(this.persons[i]);
                }
            } else {
                System.out.println("No matching people found.");
            }
        } else {
            System.out.println("No matching people found.");
        }
    }
}
