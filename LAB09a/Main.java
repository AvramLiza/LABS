package com.company;

import java.util.*;
public class Main {

    public static void main(String[] args)
    {
        System.out.println("Введите текст");
        Scanner sc = new Scanner(System.in);

        String[] text = (sc.nextLine()).split(" ");

        System.out.println("Введите номер");
        int number = 0;

        try
        {
            number = sc.nextInt();
        }
        catch (InputMismatchException fg)
        {
            System.out.print("Значение не является числом");
            return;
        }

        System.out.println("Введите символ");
        char symbol = sc.next().charAt(0);

        String result[] = new String[text.length];

        for(int i = 0; i < text.length; i++)
        {
            if (text[i].length() >= number)
            {
                result[i] = text[i].substring(0, number - 1) + symbol + text[i].substring(number);
            }
            else
            {
                result[i] = text[i];
            }
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
}


