import java.time.LocalDateTime;

public class DailyTask extends Task implements Recurring {

    public DailyTask(String taskName, String taskDescription, LocalDateTime endOfTask, Boolean whatType) throws NoRequiredData {
        super(taskName, taskDescription, endOfTask, whatType);
    }

    @Override
    public LocalDateTime getEndOfTask() {
        LocalDateTime endOfTask = getEndOfTask();
        while (LocalDateTime.now().isAfter(endOfTask)) {
            endOfTask = endOfTask.plusDays(1);
        } return endOfTask;
    }

    @Override
    public String toString() {
        return super.toString() + "Время выполнения: " + getEndOfTask();
    }
}

