import java.time.LocalDateTime;
import java.util.Objects;

public class Task {

    private static int counter = 0;
    private final Integer id = counter++;
    private String taskName;
    private String taskDescription;
    private LocalDateTime endOfTask;
    private Boolean whatType;

    public Task(String taskName, String taskDescription, LocalDateTime endOfTask, Boolean whatType) throws NoRequiredData {
        setTaskName(taskName);
        setTaskDescription(taskDescription);
        this.endOfTask = endOfTask;
        this.whatType = whatType;
    }


    public Integer getId() {

        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) throws NoRequiredData{
        if (taskName == null || taskName.isBlank()) {
            throw new NoRequiredData("Введите название задачи !!!!");
        } else {
            this.taskName = taskName;
        }
    }

    public String getTaskDescription() {

        return taskDescription;
    }

    public Boolean getWhatType() {
        return whatType;
    }

    public void setWhatType(Boolean whatType) {
        this.whatType = whatType;
    }

    public void setTaskDescription(String taskDescription) throws NoRequiredData {

        if (taskDescription == null || taskDescription.isBlank()) {
            throw new NoRequiredData("Заполните описание задачи !!!!");
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
        return Objects.equals(id, task.id) && Objects.equals(taskName, task.taskName) && Objects.equals(taskDescription, task.taskDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskName, taskDescription);
    }

    @Override
    public String toString() {
        String type = "личная";
        if (!whatType) type = "рабочая";
        return "Номер задачи № " + id + taskName + " " + taskDescription + "\nТип задачи: " + type;
    }
}
