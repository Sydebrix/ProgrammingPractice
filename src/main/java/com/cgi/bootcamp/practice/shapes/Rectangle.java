package com.cgi.bootcamp.practice.shapes;

public class Rectangle extends InfoShape {

    private double side1, side2;

    Rectangle(double a, double b){
        side1=a;
        side2=b;
    }

    @Override
    public double area() {
        return side1*side2;
    }

    @Override
    public double perimeter(){
        return side1*2+side2*2;
    }

    @Override
    public String info(){
        String s = "";
        s += super.info();
        s += "\n\t\t\"length\": \"" + String.format("%.0f\"", side1) + ",";
        s += "\n\t\t\"height\": \"" + String.format("%.0f\"", side2);
        s += "\n\t}";
        s += "\n}";
        return s;
    }
}
