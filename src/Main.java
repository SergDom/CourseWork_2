import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoRequiredData {
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
//        WhatType typeOfTask;
        System.out.println("Если задача личная введите - 1 \nЕсли задача рабочая введите - 2\n");
        System.out.print("Тип задачи: ");
        int scanTypeOfTask = scanner.nextInt();
        WhatType typeOfTask;
        if (scanTypeOfTask == 1) {
            typeOfTask = WhatType.PERSONAL;
        } else if (scanTypeOfTask == 2) {
            typeOfTask = WhatType.WORK;
        } else throw new NoRequiredData("Неверно введен тип задачи");
//        System.out.print("Выберите тип задачи: \n");
//        System.out.println(
//                """
//                        P - личная,
//                        W - рабочая,
//                        """);

        System.out.println("Введите дату в формате гггг-мм-дд:");
        LocalDate dateTask = LocalDate.parse(scanner.next());
        System.out.println("Введите время в формате чч:мм:");
        LocalTime timeTask = LocalTime.parse(scanner.next());
        System.out.println("Выберете повторяемость:");
        System.out.println(
                """
                        S - не повторяется,
                        D - через день,
                        W - через неделю,
                        M - через месяц,
                        A - через год.
                        """);
        RepeatTask repeatTask = RepeatTask.valueOf(scanner.next());
        LocalDateTime startTime = LocalDateTime.of(dateTask, timeTask);
        notebook.addTask(new Task(taskName, taskDescription, repeatTask, startTime, typeOfTask));
    }


    private static void deleteTask(Scanner scanner, TaskList notebook) {
        System.out.println("Введине номер ID задачи: ");
        int id = scanner.nextInt();
        notebook.removeTask(id);
    }

    private static void getListOfTask(Scanner scanner, TaskList notebook) throws NoRequiredData {
        System.out.println("Получить задачи на день: ");
        notebook.printToDoListOfDay(createDate(scanner));
    }

    public static LocalDate createDate(Scanner scanner) throws NoRequiredData {
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