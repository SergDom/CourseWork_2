import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class TaskList {
    private final Map<Integer, Task> calendar = new HashMap<>();

    public void addTask(Task task) throws NoRequiredData {
        if (calendar.containsKey(task.getId())) {
            throw new NoRequiredData ("Задача уже существует");
        } else {
            calendar.put(task.getId(), task);
        }
    }

    public void removeTask(int id) {
        calendar.remove(id);
    }


    public List <Task> printToDoListOfDay(LocalDateTime date) {
        List <Task> allTaskList = new ArrayList<>();
        for (Map.Entry<Integer, Task> value : calendar.entrySet()) {
            Task task = value.getValue();
            if (task.nextTime(date)) {
               allTaskList.add(task);
            }
        }
        return allTaskList;
    }
}

