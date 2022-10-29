import java.time.LocalDate;
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
                            deleteTask (scanner, notebook);
                            break;
                        case 3:
                            getListOfTask (scanner,notebook);
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

    private static void inputTask(Scanner scanner, TaskList notebook) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.next();
        System.out.print("Выберите тип задачи: \n");
        System.out.println(
                """
                        P - личная,
                        W - рабочая,
                        """);
        WhatType whatType = WhatType.valueOf(scanner.next());
        LocalDate dateTask = LocalDate.parse(scanner.next());
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
        RepeatTask repeat = RepeatTask.valueOf(scanner.next());
    }


    private static void deleteTask (Scanner scanner, TaskList notebook) {
        System.out.println("Введине номер ID задачи: ");
        int id = scanner.nextInt();
        notebook.removeTask(id);
    }

    private static void getListOfTask (Scanner scanner,TaskList notebook) throws NoRequiredData {
        System.out.println("Получить задачи на день: ");
        notebook.printToDoListOfDay(createDate(scanner));
    }
    public static LocalDate createDate(Scanner scanner) throws NoRequiredData {
     System.out.println("год:");
      int year;
      if (scanner.hasNextInt()) {
      year = scanner.nextInt();
         }else{
        throw new NoRequiredData("Некорректные данные");
        }
       System.out.println("месяц:");
        int month;
         if (scanner.hasNextInt()) {
             month = scanner.nextInt();
             }else{
             throw new NoRequiredData("Некорректные данные");
             }
         System.out.println("день:");
         int day;
         if (scanner.hasNextInt()) {
             day = scanner.nextInt();
             }else{
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