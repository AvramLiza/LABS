package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main
{

    public static void main(String[] args)
    {
        try
        {
            List<String> numbers = getRandomStringListOfNum(10,100);
            System.out.print("\nИсходные числа:\n" + numbers);
            Scanner sc = new Scanner(System.in);

            System.out.print("\nВведите путь к директории с файлами: ");
            String dirPass = sc.nextLine();

            if(!new File(dirPass).mkdirs())
            {
                Files.createDirectory(Path.of(dirPass));
            }

            System.out.print("\nВведите путь к исходному файлу: ");
            String origPass = sc.nextLine();
            File source = new File(origPass);

            if(!source.exists())
            {
                source.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(origPass);
            PrintStream printStream = new PrintStream(fos);
            printStream.println(numbers);
            System.out.println("Файл записан");
            fos.close();

            System.out.print("Введите путь к файлу результата: ");
            String resPass = sc.nextLine();
            File result = new File(resPass);
            if(!result.exists())
            {
                result.createNewFile();
            }
            FileOutputStream fos1 = new FileOutputStream(result);
            PrintStream printStream1 = new PrintStream(fos1);
            printStream1.println(getSortedNum(numbers));
            System.out.println("Файл перезаписан");

            System.out.println("Итог: \n" + getSortedNum(numbers));
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

    public static List<String> getRandomStringListOfNum(int amountOfNumbers, int boundOfRandomizing)
    {
        Random random = new Random();
        List<String> randomNum = new ArrayList<>(amountOfNumbers);
        for (int i = 0; i < amountOfNumbers; i++)
        {
            randomNum.add(String.valueOf(random.nextInt(boundOfRandomizing)));
        }
        return randomNum;
    }

    public static List<String> getSortedNum(List<String> randomNum)
    {
        randomNum.sort(Comparator.comparing(Integer::valueOf));
        return randomNum;
    }
}