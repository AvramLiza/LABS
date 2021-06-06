package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        try
        {
            boolean bool = true;

            System.out.print("Введите колличество студентов: ");
            int n = scanner.nextInt();

            Student[] Spis = new Student[n];

            for (int i = 0; i < n; i++)
            {
                Spis[i] = new Student();
                Spis[i].setStudent();
            }

            while (bool)
            {
                System.out.print("\nВведите 1, если желаете вывести список студентов факультета"
                        + "\nВведите 2, если желаете вывести список студентов факультета и курса"
                        + "\nВведите 3, если желаете вывести список студентов, родившихся после заданного года"
                        + "\nВведите 4, если желаете вывести список учебной группы"
                        + "\nЧтобы выйти, введите что-нибудь другое! "
                        + "\nВводите здесь: ");
                scanner.nextLine();

                String variant = scanner.nextLine();

                switch (variant)
                {
                    case "1":
                        System.out.print("Введите название факультета: ");
                        String faculty1 = scanner.next();

                        System.out.printf("%15s%15s%15s%15s%15s%15s%15s%15s%15s%15s%15s", "Фамилия", "Имя"
                                , "Отчество", "День", "Месяц", "Год", "Адрес", "Телефон", "Факультет", "Курс", "Группа");

                        for (int i = 0; i < n; i++)
                        {
                            if (faculty1.equals(Spis[i].getFaculty()))
                            {
                                Spis[i].Show();
                            }
                        }
                        break;
                    case "2":
                        System.out.print("Введите название факультета: ");
                        String faculty2 = scanner.next();

                        System.out.print("Введите номер курса: ");
                        int kurs2 = scanner.nextInt();

                        System.out.printf("%15s%15s%15s%15s%15s%15s%15s%15s%15s%15s%15s", "Фамилия", "Имя"
                                , "Отчество", "День", "Месяц", "Год", "Адрес", "Телефон", "Факультет", "Курс", "Группа");
                        for (int i = 0; i < n; i++)
                        {
                            if (faculty2.equals(Spis[i].getFaculty()) && kurs2 == Spis[i].getCourse())
                            {
                                Spis[i].Show();
                            }
                        }
                        break;
                    case "3":
                        System.out.print("Введите год: ");
                        int year = scanner.nextInt();

                        System.out.printf("%15s%15s%15s%15s%15s%15s%15s%15s%15s%15s%15s", "Фамилия", "Имя"
                                , "Отчество", "День", "Месяц", "Год", "Адрес", "Телефон", "Факультет", "Курс", "Группа");

                        for (int i = 0; i < n; i++)
                        {
                            if (Spis[i].getYear() > year)
                            {
                                Spis[i].Show();
                            }
                        }
                        break;
                    case "4":
                        System.out.print("Введите название факультета: ");
                        String faculty4 = scanner.next();

                        System.out.print("Введите номер курса: ");
                        int kurs4 = scanner.nextInt();

                        System.out.print("Введите номер группы: ");
                        int group4 = scanner.nextInt();

                        System.out.printf("%15s%15s%15s%15s%15s%15s%15s%15s%15s%15s%15s", "Фамилия", "Имя"
                                , "Отчество", "День", "Месяц", "Год", "Адрес", "Телефон", "Факультет", "Курс", "Группа");
                        for (int i = 0; i < n; i++)
                        {
                            if (faculty4.equals(Spis[i].getFaculty()) &&
                                    kurs4 == Spis[i].getCourse() && group4 == Spis[i].getGroup())
                            {
                                Spis[i].Show();
                            }
                        }
                        break;
                    default:
                        System.out.println("\nВы ввели что-то другое!");
                        bool = false;
                        break;
                }
            }
            scanner.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            scanner.close();
        }
        catch (Error ex2)
        {
            System.out.println("Ошибка!");
            scanner.close();
        }
    }
}
