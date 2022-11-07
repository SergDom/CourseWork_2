import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task implements Repeatable {
    public DailyTask(String taskName, String taskDescription, LocalDateTime startTime, WhatType whatType) throws NoRequiredData {
        super(taskName, taskDescription, startTime, whatType);
    }

    @Override
    public boolean nextTime(LocalDate localDate) {
        LocalDate variable = getStartTime().toLocalDate();
        while (!variable.isAfter(localDate)) {
            if (variable.equals(localDate)) {
                return true;
            }
            variable = variable.plusDays(1);
        }
       return false;
    }

    @Override
    public String toString() {
        return super.toString() + " Ежедневная";
    }
}


