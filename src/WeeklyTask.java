import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task implements Repeatable{
    public WeeklyTask(String taskName, String taskDescription, LocalDateTime startTime, WhatType whatType) throws NoRequiredData {
        super(taskName, taskDescription, startTime, whatType);
    }

    @Override
    public boolean nextTime(LocalDateTime localDate) {
        LocalDateTime variable = getStartTime();
        while (variable.isBefore(localDate)) {
            if (variable.isEqual(localDate)) {
                return true;
            }
            variable = variable.plusWeeks(1);
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " Еженедельная";
    }
}
