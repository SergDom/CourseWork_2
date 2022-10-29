import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TaskList<T extends Task & Recurring> {
    private final Map<Integer, T> calendar = new HashMap<>();

    public void addTask(T task) throws NoRequiredData {
        if (calendar.containsKey(task.getId())) {
            throw new RuntimeException("Задача уже существует");
        } else {
            calendar.put(task.getId(), task);
        }
    }

    public void removeTask(int id) {

        calendar.remove(id);
    }

    public void printToDoListOfDay(LocalDate date) {
        for (T value : calendar.values()) {
            if (value.getEndOfTask() != null && value.getEndOfTask().toLocalDate().equals(date)) ;
            System.out.println(value);
        }
    }

}
