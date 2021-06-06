package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int x,y,size;
        Fraction fractions[];

        System.out.println("Введите количество полиномов:");
        int polyNum = in.nextInt();

        Polynomial polynomials[] = new Polynomial[polyNum];
        for (int i = 0; i < polyNum; i++)
        {
            polynomials[i] = new Polynomial();
        }

        for (int i = 0; i < polyNum; i++)
        {
            System.out.println("Введите размер #" + (i + 1) + " полинома: ");

            size = in.nextInt();
            fractions = new Fraction[size];

            System.out.println("Введите рациональные коэфициенты #" + i + " полинома");
            for(int j = 0; j < size; j++)
            {
                fractions[j] = new Fraction();

                System.out.print((j + 1) + ")\n");

                System.out.print("Введите числитель:");
                x = in.nextInt();

                System.out.print("Введите знаменатель:");
                y = in.nextInt();

                fractions[j].setFraction(x, y);
            }

            polynomials[i].setPolynomial(size,fractions);
        }


        for (int i = 0; i < polyNum; i++)
        {
            System.out.println("Полином #" + (i + 1) + polynomials[i].toStringPoly());
        }
        Polynomial result = polynomials[0].add(polynomials[1]);

        for (int i = 2; i < polyNum; i++)
        {
            result = result.add(polynomials[i]);
        }

        System.out.println("Результат: ");
        System.out.println(result.toStringPoly());

    }
}


