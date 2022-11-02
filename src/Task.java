import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Task implements Repeatable {

    private static int counter = 1;
    private final Integer id = counter++;
    private String taskName;
    private String taskDescription;
    private final RepeatTask repeatTask;
    private WhatType whatType;
    private LocalDateTime startTime;

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
    public boolean nextTime(LocalDate localDate) {
        switch (repeatTask) {
            case SINGLE:
                return startTime.toLocalDate().isEqual(localDate);

            case DAILY:
                return startTime.toLocalDate().isBefore(localDate);

            case WEEKLY:
                while (startTime.toLocalDate().isBefore(localDate) && !startTime.toLocalDate().isEqual(localDate)) {
                    startTime = startTime.plusWeeks(1);
                }
                return startTime.toLocalDate().isEqual(localDate);
            case MONTHLY:
                while (startTime.toLocalDate().isBefore(localDate) && !startTime.toLocalDate().isEqual(localDate)) {
                    startTime = startTime.plusMonths(1);
                }
                return startTime.toLocalDate().isEqual(localDate);
            case ANNUAL:
                while (startTime.toLocalDate().isBefore(localDate) && !startTime.toLocalDate().isEqual(localDate)) {
                    startTime = startTime.plusYears(1);
                }
                return startTime.toLocalDate().isEqual(localDate);
        }
        return false;
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
