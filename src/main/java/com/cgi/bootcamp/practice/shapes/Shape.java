package com.cgi.bootcamp.practice.shapes;

public interface Shape {

    // Alles wurde trivial berechnet; Einfach zu verstehen, zu pflegen
    // und an dieser Stelle auch nicht zeitkritisch.

    double perimeter();
    double area();
    String info();

    default String name(){
        String s = this.getClass().getName();
        if(s.contains("Square")) return "Square";
        if(s.contains("Rectangle")) return "Rectangle";
        if(s.contains("Circle")) return "Circle";
        return s;
    }
}
