package com.cgi.bootcamp.practice.shapes;

public class Square extends InfoShape {

    private double side;

    Square(double a){
        side=a;
    }

    @Override
    public double area() {
        return side*side;
    }

    @Override
    public double perimeter(){
        return side*4;
    }

    @Override
    public String info(){
        String s = "";
        s += super.info();
        s += "\n\t\t\"length\": \"" + String.format("%.0f\"", side);
        s += "\n\t}";
        s += "\n}";
        return s;
    }
}
