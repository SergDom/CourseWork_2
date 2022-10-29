import java.time.LocalDateTime;

public class AnnualTask extends Task implements Recurring {

    public AnnualTask(String taskName, String taskDescription, LocalDateTime endOfTask, Boolean whatType) throws NoRequiredData {
        super(taskName, taskDescription, endOfTask, whatType);
    }

    @Override
    public LocalDateTime getEndOfTask() {
        LocalDateTime endOfTask = getEndOfTask();
        while (LocalDateTime.now().isAfter(endOfTask)) {
            endOfTask = endOfTask.plusYears(1);
        } return endOfTask;
    }

    @Override
    public String toString() {
        return super.toString() + "Время выполнения: " + getEndOfTask();
    }
}

