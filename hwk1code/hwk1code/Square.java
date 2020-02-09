import java.util.Scanner;

public class Square extends Rectangle {
    private double side = 0;

    public Square() { super("Square"); }

    public Square(double side) {
        super("Square");
        super.setWidth(side);
        super.setHeight(side);
        this.side = side;
    }

    public void setWidth(double width) { setSide(width); }

    public void setHeight(double height) { setSide(height); }

    public void setSide(double side)
    {
        this.side = side;
        super.setWidth(side);
        super.setHeight(side);
    }

    public double getSide() { return side; }

    public void readShapeData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the side of the Square");
        setSide(in.nextDouble());
    }

    public String toString() {
        return super.toString() + ": side is " + side;
    }
}
