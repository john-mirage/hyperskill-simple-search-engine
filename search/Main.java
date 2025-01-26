package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File(args[1]);
        try (Scanner scanner = new Scanner(file)) {
            ArrayList<String> words = new ArrayList<>();
            while (scanner.hasNext()) {
                words.add(scanner.nextLine());
            }
            String[] persons = words.toArray(new String[0]);
            Map<String, ArrayList<Integer>> personsMap = generatePersonsMap(persons);
            while (true) {
                String action = UserInterface.askForAction();
                if (!action.equals("0")) {
                    ActionExecutor actionExecutor = switch (action) {
                        case "1" -> new ActionExecutor(new FindPersonExecutingMethod(persons, personsMap));
                        case "2" -> new ActionExecutor(new PrintAllPeopleExecutingMethod(persons));
                        default -> throw new IllegalArgumentException("Invalid action");
                    };
                    actionExecutor.execute();
                } else {
                    System.out.println("Bye!");
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }
    }

    public static Map<String, ArrayList<Integer>> generatePersonsMap(String[] persons) {
        Map<String, ArrayList<Integer>> personsMap = new HashMap<>();
        for (int i = 0; i < persons.length; i++) {
            String[] parts = persons[i].split(" ");
            for (String part : parts) {
                String lowerCasePart = part.toLowerCase();
                if (!personsMap.containsKey(lowerCasePart)) {
                    personsMap.put(lowerCasePart, new ArrayList<>());
                }
                personsMap.get(lowerCasePart).add(i);
            }
        }
        return personsMap;
    }
}
