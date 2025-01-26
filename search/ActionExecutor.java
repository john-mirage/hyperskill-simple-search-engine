package search;

public class ActionExecutor {
    private final ExecutingMethod executingMethod;

    public ActionExecutor(ExecutingMethod executingMethod) {
        this.executingMethod = executingMethod;
    }

    public void execute() {
        this.executingMethod.execute();
    }
}
