package com.cgi.bootcamp.practice.shapes;

public final class Shapes {

    //Verhindert Instanzen
    private Shapes(){};

    public static Square square(double a){
        return new Square(a);
    }

    public static Rectangle rectangle(double a, double b){
        return new Rectangle(a, b);
    }

    public static Circle circle(double r){
        return new Circle(r);
    }

}
