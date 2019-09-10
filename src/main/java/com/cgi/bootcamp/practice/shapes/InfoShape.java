package com.cgi.bootcamp.practice.shapes;

public abstract class InfoShape implements Shape {

    // Nicht vollständig, da in den Unterklassen erweitert
    public String info(){
        String s = "";
        s += "\n{";
        s += "\n\t\"type\": \"" + name() + "\",";
        s += "\n\t\"perimeter\": " + String.format("%.2f", perimeter()).replace(',', '.') + ",";
        s += "\n\t\"area\": " + String.format("%.2f", area()).replace(',', '.') + ",";
        s += "\n\t\"parameters\": {";
        return s;
    }
}
