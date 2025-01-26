package search;

public class PrintAllPeopleExecutingMethod implements ExecutingMethod {
    private final String[] persons;

    public PrintAllPeopleExecutingMethod(String[] persons) {
        this.persons = persons;
    }

    @Override
    public void execute() {
        System.out.println("=== List of people ===");
        for (String person : this.persons) {
            System.out.println(person);
        }
    }
}
