import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        TaskList notebook = new TaskList();

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner, notebook);
                            break;
                        case 2:
                            deleteTask(scanner, notebook);
                            break;
                        case 3:
                            getListOfTask(scanner, notebook);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner, TaskList notebook) throws NoRequiredData {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.next();
        System.out.println("Если задача личная введите - 1 \nЕсли задача рабочая введите - 2\n");
        System.out.print("Тип задачи: ");
        int scanTypeOfTask = scanner.nextInt();
        WhatType typeOfTask;
        if (scanTypeOfTask == 1) {
            typeOfTask = WhatType.PERSONAL;
        } else if (scanTypeOfTask == 2) {
            typeOfTask = WhatType.WORK;
        } else throw new NoRequiredData("Неверно введен тип задачи");

        System.out.println("Введите дату в формате гггг-мм-дд:");
        LocalDate dateTask = LocalDate.parse(scanner.next());
        System.out.println("Введите время в формате чч:мм:");
        LocalTime timeTask = LocalTime.parse(scanner.next());
        System.out.println("Выберете повторяемость:");
        System.out.println(
                """
                        1 - не повторяется,
                        2 - через день,
                        3 - через неделю,
                        4 - через месяц,
                        5 - через год.
                        """);
        System.out.print("Повторяемость задачи: ");
        LocalDateTime startTime = LocalDateTime.of(dateTask, timeTask);
        int repeatTask = scanner.nextInt();
        switch (repeatTask) {
            case 1:
                notebook.addTask(new SingleTask(taskName, taskDescription, startTime, typeOfTask));
                break;
            case 2:
                notebook.addTask(new DailyTask(taskName, taskDescription, startTime, typeOfTask));
                break;
            case 3:
                notebook.addTask(new WeeklyTask(taskName, taskDescription, startTime, typeOfTask));
                break;
            case 4:
                notebook.addTask(new MonthlyTask(taskName, taskDescription, startTime, typeOfTask));
                break;
            case 5:
                notebook.addTask(new AnnualTask(taskName, taskDescription, startTime, typeOfTask));
                break;
        }
    }

    private static void deleteTask(Scanner scanner, TaskList notebook) {
        try {
            System.out.println("Введите номер ID задачи: ");
            int id = scanner.nextInt();
            notebook.removeTask(id);
        } catch (Exception e) {
            System.out.println("Неправильно введен ID");
            System.out.println(e.getMessage());
        }
    }

    private static void getListOfTask(Scanner scanner, TaskList notebook) {
        System.out.println("Получить задачи на день\nВведите дату в формате гггг-мм-дд: ");
        scanner.nextLine();
        LocalDate getTask = LocalDate.parse(scanner.next());
        List <Task> printTask = notebook.printToDoListOfDay(getTask);
        for (Task task: printTask) {
            System.out.println(task);
        }

    }

    private static void printMenu() {
        System.out.println(
                """
                        1. Добавить задачу
                        2. Удалить задачу
                        3. Получить задачу на указанный день
                        0. Выход
                        """
        );

    }
}