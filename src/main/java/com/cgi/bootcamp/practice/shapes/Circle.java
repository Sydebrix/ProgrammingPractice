package com.cgi.bootcamp.practice.shapes;

public class Circle extends InfoShape {

    private double radius;

    public Circle(double r){
        radius = r;
    }

    @Override
    public double area() {
        return radius*radius*Math.PI;
    }

    @Override
    public double perimeter(){
        return 2*radius*Math.PI;
    }

    @Override
    public String info(){
        String s = "";
        s += super.info();
        s += "\n\t\t\"radius\": \"" + String.format("%.0f\"", radius);
        s += "\n\t}";
        s += "\n}";
        return s;
    }
}
