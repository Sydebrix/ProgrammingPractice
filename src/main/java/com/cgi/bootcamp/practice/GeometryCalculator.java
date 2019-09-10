package com.cgi.bootcamp.practice;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.cgi.bootcamp.practice.shapes.*;

import static com.cgi.bootcamp.practice.shapes.Shapes.circle;
import static com.cgi.bootcamp.practice.shapes.Shapes.rectangle;
import static com.cgi.bootcamp.practice.shapes.Shapes.square;

// Der Pfad der shapes.txt sollte vorher angepasst werden
public class GeometryCalculator {

    private final static String FILE_PATH = "X:\\Studium offline\\ProgrammingPractice\\src\\main\\resources\\shapes.txt";

    public static void main(String[] args) {
        System.out.println("\nWelcome to Pegeca, your personal geometry calculator.");
        handleConsoleInOut();
        System.out.println("Thank you for using Pegeca, your personal geometry calculator.");
    }

    private static void handleConsoleInOut() {

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while(true){
                System.out.println("\n\t'''");
                System.out.println("\tPlease choose: (ENTER to exit)");
                System.out.println("\ts: Square");
                System.out.println("\tr: Rectangle");
                System.out.println("\tc: Circle");
                System.out.println("\tp: Parse file");
                System.out.println("\t'''");

                String shape = br.readLine().toLowerCase();
                switch (shape){
                    case "s":
                        System.out.println("Please enter the side-length of your square and proceed with ENTER:");
                        String sideLength = br.readLine().replace(',', '.');
                        if(isValidNumber(sideLength)){
                            Square sq = square(Double.parseDouble(sideLength));
                            System.out.println(sq.info());
                            break;
                        }
                        break;
                    case "r":
                        System.out.println("Please enter the length of your rectangle and proceed with ENTER:");
                        String length = br.readLine().replace(',', '.');
                        if(isValidNumber(length)){
                            System.out.println("Please enter the height of your rectangle and proceed with ENTER:");
                            String height = br.readLine().replace(',', '.');
                            if(isValidNumber(height)){
                                Rectangle rectangle = rectangle(Double.parseDouble(length), Double.parseDouble(height));
                                System.out.println(rectangle.info());
                            }
                        }
                        break;
                    case "c":
                        System.out.println("Please enter the radius of your circle and proceed with ENTER:");
                        String radius = br.readLine().replace(',', '.');
                        if(isValidNumber(radius)){
                            Circle circle = circle(Double.parseDouble(radius));
                            System.out.println(circle.info());
                            break;
                        }
                        break;
                    case"p":
                        parseFile();
                        break;
                    case "":
                        return;
                    default:
                        System.out.println("Please make sure you type in one of the available letters to proceed.");
                        break;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static boolean isValidNumber(String input){
        try {
            double number = Double.parseDouble(input);
            if(number<=0){
                System.out.println("Please enter a valid number bigger than zero.");
                return false;
            }
        } catch (Exception e){
            System.out.println("Please enter a valid number bigger than zero.");
            return false;
        }
        return true;
    }

    public static void parseFile(){
        try {
            File file = new File(FILE_PATH);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String shape;
            ArrayList<InfoShape> shapesArray = new ArrayList<InfoShape>();

            while((shape = br.readLine()) != null){
                String[] split = shape.split(",");
                if(split[0].equals("s")){
                    shapesArray.add(square(Double.parseDouble(split[1])));
                } else if (split[0].equals("c")) {
                    shapesArray.add(circle(Double.parseDouble(split[1])));
                } else {
                    shapesArray.add(rectangle(Double.parseDouble(split[1]), Double.parseDouble(split[2])));
                }
            }

            System.out.println("***   Elements sorted by area   ***");
            Comparator<InfoShape> compareArea = Comparator.comparingDouble(Shape::area);
            Collections.sort(shapesArray, compareArea);
            shapesArray.forEach((n) -> System.out.println(n.info()));

            System.out.println("\n\n***   Elements sorted by perimeter   ***");
            Comparator<InfoShape> comparePerimeter = Comparator.comparingDouble(Shape::perimeter);
            Collections.sort(shapesArray, comparePerimeter);
            shapesArray.forEach((n) -> System.out.println(n.info()));

        } catch (Exception e) {
            System.out.println("Please check your file for Syntax errors and make sure the path is correct.");
            e.printStackTrace();
        }
    }
}
