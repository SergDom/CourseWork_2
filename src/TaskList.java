import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TaskList <T extends Task & Recurring> {
    private final Map<Integer, T> calendar = new HashMap<>();

    public void addTask (T task){
        calendar.put(task.getId(), task);
    }

    public void removeTask (int id){
        calendar.get(id);  //////   ?????
    }

    public void printToDoListOfDay (LocalDate date) {
        for (T value : calendar.values()) {
            if (value.getEndOfTask() != null && value.getEndOfTask().toLocalDate().isLeapYear());
            System.out.println(value);
        }
    }

}
