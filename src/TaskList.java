import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskList<T extends Task & Recurring> {
    private final Map<Integer, Task> calendar = new HashMap<>();

    public void addTask(Task task) throws NoRequiredData {
        if (calendar.containsKey(task.getId())) {
            throw new RuntimeException("Задача уже существует");
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
                a = RepeatTask.WEAKLY;
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
            if (value.getStartTime() != null && value.getStartTime().toLocalDate().equals(date)) ;
            System.out.println(value);
        }
    }
    public static LocalDate createDate(Scanner scanner) throws NoRequiredData {
//        System.out.println("Введите дату в формате гггг-мм-дд:");

        System.out.println("год:");
        int year;
        if (scanner.hasNextInt()) {
            year = scanner.nextInt();
        } else {
            throw new NoRequiredData("Некорректные данные");
        }
        System.out.println("месяц:");
        int month;
        if (scanner.hasNextInt()) {
            month = scanner.nextInt();
        } else {
            throw new NoRequiredData("Некорректные данные");
        }
        System.out.println("день:");
        int day;
        if (scanner.hasNextInt()) {
            day = scanner.nextInt();
        } else {
            throw new NoRequiredData("Некорректные данные");
        }
        return LocalDate.of(year, month, day);
    }
}
