public class TestSquare {
    public static void main(String[] args) {

        Square square = new Square();
        square.readShapeData();
        System.out.printf("The width of the " + square.getShapeName() + " is " + square.getWidth() + "\n");
        System.out.printf("The height of the " + square.getShapeName() + " is " + square.getHeight() + "\n");
        System.out.printf("The area of the " + square.getShapeName() + " is " + square.computeArea() + "\n");
        System.out.printf("The perimeter of the " + square.getShapeName() + " is " + square.computePerimeter() + "\n");


        System.out.println();
        // Casting example. Now a Shape reference variable refers to a Square object. To call methods defined in Square,
        // we need to use casts as shown:
        Shape s = new Square();
        System.out.printf("The name of this shape is \"" + ((NamedShape) s).getShapeName() + "\"\n");
        // System.out.println(s instanceof Square); // prints true
        s.readShapeData();
        System.out.printf("The width of the " + ((Square) s).getShapeName() + " is " + s.getWidth() + "\n");
        System.out.printf("The height of the " + ((Square) s).getShapeName() + " is " + s.getHeight() + "\n");
        System.out.printf("The area of the " + ((Square) s).getShapeName() + " is " + s.computeArea() + "\n");
        System.out.printf("The perimeter of the " + ((Square) s).getShapeName() + " is " + s.computePerimeter() + "\n");
    }
}
