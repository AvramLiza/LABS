package com.company;

public class Polynomial {
    private int size;
    private Fraction[] coefficients ;

    public Polynomial()
    {
        this.size = 1;
        this.coefficients=new Fraction[size];
    }
    public Polynomial(int size,Fraction[] c)
    {
        this.size = size;
        coefficients = new Fraction[size];
        for(int i=0;i<size;i++) {
            coefficients[i]=new Fraction();
            this.coefficients[i].setFraction(c[i].getX(), c[i].getY());
        }
    }

    public void setPolynomial(int size,Fraction[] c){
        //super();
        this.size = size;
        coefficients = new Fraction[size];
        for(int i=0;i<size;i++) {
            coefficients[i]=new Fraction();
            this.coefficients[i].setFraction(c[i].getX(), c[i].getY());
        }
    }
    public int getSize(){
        return this.size;
    }

    public Fraction[] getCoefficients(){
        return this.coefficients;
    }

    public Polynomial add(Polynomial addable)
    {
        int currentSize = 0;
        if(this.size < addable.getSize())
        {
            currentSize = addable.getSize();
        }
        else
        {
            currentSize = this.size;
        }

        Fraction[] newFractions = new Fraction[currentSize];

        int delta = Math.abs(this.size - addable.getSize());

        if(this.size > addable.getSize())
        {
            for (int i = 0; i < delta; i++)
            {
                newFractions[i] = this.coefficients[i];
            }
            for (int i = delta; i < currentSize; i++)
            {
                newFractions[i] = addable.getCoefficients()[i - delta].add(this.coefficients[i]);
            }
        }

        if(addable.getSize() > this.size)
        {
            for (int i = 0; i < delta; i++)
            {
                newFractions[i] = addable.getCoefficients()[i];
            }
            for (int i = delta; i < currentSize; i++)
            {
                newFractions[i] = this.coefficients[i - delta].add(addable.getCoefficients()[i]);
            }
        }

        if(addable.getSize() == this.size)
        {
            for (int i = 0; i < currentSize; i++)
            {
                newFractions[i] = this.coefficients[i].add(addable.getCoefficients()[i]);
            }
        }

        return new Polynomial(currentSize, newFractions);
    }

    public String toStringPoly() {
        String s = "";
        for (int i = size,j = 0;i >= 0; i--,j++)
        {
            if(i > 1) s += this.coefficients[j].toString() + "*x^" + (i - 1) + " + ";
            if(i == 1) s += this.coefficients[j].toString();
        }
        return s;
    }
}

