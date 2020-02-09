import java.util.Scanner;

public class Rectangle extends NamedShape {
    // Data Fields - the width and the height of the rectangle
    private double width = 0;
    private double height = 0;

    // Constructors
    public Rectangle() {
        super("Rectangle");
    }

    public Rectangle(String name) {super(name);}

    // Constructs a rectangle of the specified size.
    public Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
        //if (width == height) setShapeName("Square");
    }

    // Methods
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double computeArea() {
        return height * width;
    }

    public double computePerimeter() {
        return 2 * (height + width);
    }

    public void readShapeData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the width of the Rectangle");
        width = in.nextDouble();
        System.out.println("Enter the height of the Rectangle");
        height = in.nextDouble();
    }

    public String toString() {
        return super.toString() + ": width is " + width
                + ", height is " + height;
    }
}
