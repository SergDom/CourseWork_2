import java.time.LocalDateTime;
import java.util.Objects;

public class Task {

    private static int counter = 0;
    private final Integer iD = counter++;
    private String taskName;
    private String taskDescription;
    private LocalDateTime endOfTask;
    private Boolean whatType;

    public Task(String taskName, String taskDescription, LocalDateTime endOfTask) {
        setTaskName(taskName);
        setTaskDescription(taskDescription);
        this.endOfTask = endOfTask;
    }


    public Integer getiD() {
        return iD;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        if (taskName == null || taskName.isBlank()) {
            throw new IllegalArgumentException();
        } else {
            this.taskName = taskName;
        }
    }

    public String getTaskDescription() {
        return taskDescription;
    }


    public void setTaskDescription(String taskDescription) {

        if (taskDescription == null || taskDescription.isBlank()) {
            throw new IllegalArgumentException();
        } else {
            this.taskDescription = taskDescription;
        }

    }

    public LocalDateTime getEndOfTask() {
        return endOfTask;
    }

    public void setEndOfTask(LocalDateTime endOfTask) {
        this.endOfTask = endOfTask;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(iD, task.iD) && Objects.equals(taskName, task.taskName) && Objects.equals(taskDescription, task.taskDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iD, taskName, taskDescription);
    }

    @Override
    public String toString() {
        String type = "личная";
        if (!whatType) type =  "рабочая";

        return "Task{" +
                "Номер задачи " + iD + taskName + " " + taskDescription + "\nТип задачи: " + type;
    }
}
