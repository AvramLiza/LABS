package com.company;

public class Fraction {
    int x;
    int y;

    Fraction(){
        x = 0;
        y = 1;
    }

    public int getX(){ return x; }

    public int getY(){ return y; }

    private void setX(int a){ x = a; }

    private void setY(int a){ y = a; }

    public void setFraction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Fraction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + getX() + "/" + getY() + ")";
    }

    public Fraction add(Fraction addable) {
        return new Fraction(x * addable.y + y * addable.x, y * addable.y);
    }
}

