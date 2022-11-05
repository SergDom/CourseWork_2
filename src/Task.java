import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Task {

    private static int counter = 1;
    private final Integer id = counter++;
    private String taskName;
    private String taskDescription;
    private final RepeatTask repeatTask;
    private WhatType whatType;
    private final LocalDateTime startTime;

    public Task(String taskName, String taskDescription, RepeatTask repeatTask, LocalDateTime startTime, WhatType whatType) throws NoRequiredData {
        setTaskName(taskName);
        setTaskDescription(taskDescription);
        this.repeatTask = repeatTask;
        this.startTime = startTime;
        this.whatType = whatType;
    }


    public Integer getId() {

        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) throws NoRequiredData {
        if (taskName == null || taskName.isBlank()) {
            throw new NoRequiredData("Введите название задачи !!!!");
        } else {
            this.taskName = taskName;
        }
    }

    public String getTaskDescription() {

        return taskDescription;
    }

    public WhatType getWhatType() {
        return whatType;
    }

    public void setWhatType(WhatType whatType) {

        this.whatType = whatType;
    }

    public void setTaskDescription(String taskDescription) throws NoRequiredData {

        if (taskDescription == null || taskDescription.isBlank()) {
            throw new NoRequiredData("Заполните описание задачи !!!!");
        } else {
            this.taskDescription = taskDescription;
        }

    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(taskName, task.taskName) && Objects.equals(taskDescription, task.taskDescription) && repeatTask == task.repeatTask && whatType == task.whatType && Objects.equals(startTime, task.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskName, taskDescription, repeatTask, whatType, startTime);
    }

    @Override
    public String toString() {
        return "Номер задачи № " + id + " Имя задачи: " + taskName + " Описание задачи: "
                + taskDescription + " Тип задачи: " + getWhatType().name + " Дата: " + startTime + " "
                + repeatTask.getName();
    }

}
