package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Введите кол-во строк: " );
            Scanner sc = new Scanner(System.in);

            int number = sc.nextInt();

            System.out.println("Введите ваши строки:");
            String[] strings = new String[number];
            String original = "";
            sc.nextLine();

            for (int i = 0; i < number; i++)
            {
                strings[i] = sc.nextLine();
                original += "\n" + strings[i];
            }

            System.out.println("Исходный текст: \n" + original);
            System.out.print("Введите путь к файлу исходного текста: ");
            String origPass = sc.nextLine();
            File source = new File(origPass);
            if(!source.exists())
            {
                source.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(origPass);
            PrintStream printStream = new PrintStream(fos);
            printStream.println(original);
            System.out.println("Файл записан");
            fos.close();

            System.out.print("Введите подстроку: ");
            String subStr = sc.nextLine();

            String replace = original.replace(subStr, "");
            System.out.print("Введите путь к файлу результата: ");
            String resPass = sc.nextLine();
            File result = new File(resPass);
            if(!result.exists())
            {
                result.createNewFile();
            }
            FileOutputStream fos1 = new FileOutputStream(result);
            PrintStream printStream1 = new PrintStream(fos1);
            printStream1.println(replace);
            System.out.println("Файл перезаписан");

            System.out.println("Итоговый текст : \n" + replace);
            fos1.close();
            sc.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Файл не найден: " + e);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

