import java.time.LocalDate;
import java.time.LocalDateTime;

public class SingleTask extends Task implements Repeatable{


    public SingleTask(String taskName, String taskDescription, LocalDateTime startTime, WhatType whatType) throws NoRequiredData {
        super(taskName, taskDescription, startTime, whatType);
    }

    @Override
    public boolean nextTime(LocalDate localDate) {
        return getStartTime().toLocalDate().isEqual(localDate);
    }

    @Override
    public String toString() {
        return super.toString() + " Однаразовая";
    }
}
