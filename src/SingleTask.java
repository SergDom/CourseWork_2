import java.time.LocalDateTime;

//public class SingleTask extends Task implements Recurring {
//
//    public SingleTask(String taskName, String taskDescription, LocalDateTime endOfTask, Boolean whatType) throws NoRequiredData {
//        super(taskName, taskDescription, endOfTask, whatType);
//    }
//
//    @Override
//    public LocalDateTime getEndOfTask() {
//        if (LocalDateTime.now().isBefore(getEndOfTask())) {
//            return getEndOfTask();
//        } else return null;
//    }
//
//    @Override
//    public String toString() {
//        return super.toString() + "Время выполнения: " + getEndOfTask();
//    }
//}
//
