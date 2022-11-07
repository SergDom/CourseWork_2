import java.time.LocalDate;
import java.time.LocalDateTime;

public class SingleTask extends Task implements Repeatable{


    public SingleTask(String taskName, String taskDescription, LocalDateTime startTime, WhatType whatType) throws NoRequiredData {
        super(taskName, taskDescription, startTime, whatType);
    }

    @Override
    public boolean nextTime(LocalDate localDate) {
        LocalDate variable = getStartTime().toLocalDate();
            if (localDate.equals(variable)) {
             return true;
            }
        variable = localDate;

            return false;
    }

    @Override
    public String toString() {
        return super.toString() + " Однаразовая";
    }
}
