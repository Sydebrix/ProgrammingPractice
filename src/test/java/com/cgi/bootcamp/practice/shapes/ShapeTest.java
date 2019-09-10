package com.cgi.bootcamp.practice.shapes;

public class ShapeTest {

    final static double TRESHOLD = 0.00001; // Ausgleichen von FP-Rundungsfehlern


    /**
     * @param actual Errechneter Wert
     * @param expected Erwarteter (korrekter) Wert
     * @param text Textanfang, da sich dieser je nach Figur ändert
     */
    private static boolean checkEqual(double actual, double expected, String text){
        if (Math.abs(actual-expected) < TRESHOLD) {
            return true;
        } else {
            System.out.printf("\n" + text + " should be %.2f but was %.2f", expected, actual);
            return false;
        }
    }

    // Einzelnes '&' damit alle Checks ausgewertet werden
    public static boolean testSquare(double length, double expectedArea, double expectedPerimeter){
        Square square = new Square(length);
        return  checkEqual(square.area(), expectedArea, "square("+length+").area") &
                checkEqual(square.perimeter(), expectedPerimeter, "square("+length+").perimeter");
    }

    public static boolean testRectangle(double length, double height, double expectedArea, double expectedPerimeter){
        Rectangle rectangle = new Rectangle(length, height);
        return  checkEqual(rectangle.area(), expectedArea, "rectangle("+length+").area") &
                checkEqual(rectangle.perimeter(), expectedPerimeter, "rectangle("+length+").perimeter");
    }

    public static boolean testCircle(double radius, double expectedArea, double expectedPerimeter){
        Circle circle = new Circle(radius);
        return  checkEqual(circle.area(), expectedArea, "circle("+radius+").area") &
                checkEqual(circle.perimeter(), expectedPerimeter, "circle("+radius+").perimeter");
    }

    public static void main(String[] args){
        if( testSquare(12, 144, 48) &
            testRectangle(10, 12, 120, 44) &
            testCircle(1, Math.PI, 2*Math.PI)){
            System.out.println("Tests SUCCEEDED");
        } else {
            System.err.println("Tests FAILED!");
        }
    }
}
