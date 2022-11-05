import java.time.LocalDate;
import java.time.LocalDateTime;

public class SingleTask extends Task implements Repeatable{


    public SingleTask(String taskName, String taskDescription, RepeatTask repeatTask, LocalDateTime startTime, WhatType whatType) throws NoRequiredData {
        super(taskName, taskDescription, repeatTask, startTime, whatType);
    }

    @Override
    public boolean nextTime(LocalDate localDate) {
        return getStartTime().toLocalDate().isEqual(localDate);
    }
}
