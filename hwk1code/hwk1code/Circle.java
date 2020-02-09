import java.util.Scanner;

public class Circle extends NamedShape {
    // The radius of the circle
    private double radius = 0;

    //Constructors
    // Constructs a default circle
    public Circle() {
        super("Circle");
    }

    // Constructs a circle of the given radius
    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    // Methods

    // Get the radius
    public double getRadius() {
        return radius;
    }

    // Set the radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Get the width of the circle
    public double getWidth() {
        return 2 * radius;
    }

    // Get the height of the circle
    public double getHeight() {
        return 2 * radius;
    }

    // Compute the area of the circle
    public double computeArea() {
        return Math.PI * radius * radius;
    }

    // Compute the perimeter of the circle
    public double computePerimeter() { return 2 * Math.PI * radius; }

    // Read the attributes of the circle
    public void readShapeData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the radius of the Circle");
        radius = in.nextDouble();
    }

    // Create a string representation of the circle
    public String toString() {
        return super.toString() + ": radius is " + radius;
    }
}
