import java.time.LocalDate;
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

    public RepeatTask repeatTask(int repeatTask) {
        RepeatTask a = null;
        switch (repeatTask) {
            case 1:
                a = RepeatTask.SINGLE;
                break;
            case 2:
                a = RepeatTask.DAILY;
                break;
            case 3:
                a = RepeatTask.WEEKLY;
                break;
            case 4:
                a = RepeatTask.MONTHLY;
                break;
            case 5:
                a = RepeatTask.ANNUAL;
                break;
        }
        return a;
    }


    public void printToDoListOfDay(LocalDate date) {
        for (Task value : calendar.values()) {
            if (value.getStartTime() != null && value.getStartTime().toLocalDate().equals(date)) {
                System.out.println(value);
            }
        }
    }
}

