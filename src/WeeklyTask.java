import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task implements Repeatable{
    public WeeklyTask(String taskName, String taskDescription, LocalDateTime startTime, WhatType whatType) throws NoRequiredData {
        super(taskName, taskDescription, startTime, whatType);
    }

    @Override
    public boolean nextTime(LocalDate localDate) {
        LocalDateTime variable = getStartTime();
        if (getStartTime().toLocalDate().isBefore(localDate) && !getStartTime().toLocalDate().isEqual(localDate)) {
            variable = getStartTime().plusWeeks(1);
        }
        return getStartTime().toLocalDate().isEqual(localDate);
    }

    @Override
    public String toString() {
        return super.toString() + " Еженедельная";
    }
}
