public class TestShapes {
    public static void main(String[] args) {
        System.out.println();

        Shape c = new Circle(2);
        Shape r = new Rectangle(4, 7);
        Shape rt = new RtTriangle(3,4);
        Shape s = new Square(5.0);
        Shape[] shapes = new Shape[4];
        shapes[0] = c; shapes[1] = r; shapes[2] = rt; shapes[3] = s;

        // Your code here. Note that the output should match exactly the output shown in the instructions.
        for (Shape shape: shapes)
            System.out.println("The name of the current shape is " + ((NamedShape)shape).getShapeName() + " " +
                    "and it has the following attributes:\n" +
                    "height: " + shape.getHeight() + "; " +
                    "width: " + shape.getWidth() + "; " +
                    "area: " + shape.computeArea() + "; " +
                    "perimeter: " + shape.computePerimeter() + ".\n");
    }
}
