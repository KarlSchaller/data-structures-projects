import java.util.Scanner;

public class    RtTriangle extends NamedShape {
    // Data Fields

    private double base = 0;

    private double height = 0;

    // Constructors
    public RtTriangle() {
        super("Right Triangle");
    }

    public RtTriangle(double base, double height) {
        super("Right Triangle");
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) { this.height = height; }

    public void setBase(double base) { this.base = base; }

    public double getWidth() {
        return base;
    }

    public double computeArea() {
        return 0.5 * height * base;
    }

    public double computePerimeter() {
        double hyp = Math.sqrt((base * base) + (height * height));

        return hyp + base + height;
    }

    public void readShapeData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the base of the Right Triangle");
        base = in.nextDouble();
        System.out.println("Enter the height of the Right Triangle");
        height = in.nextDouble();
    }

    @Override
    public String toString() {
        return super.toString() + ": base is " + base
                + ", height is " + height;
    }
}
