public class Rectangle extends NamedShape {

    double width;

    double height;

    public Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    public double computeArea() {
        return width * height;
    }

    public double computePerimeter() {
        return 2*width + 2*height;
    }

    public void readShapeData() {

    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return super.toString() + "  width is " + width + " height is " + height;
    }
}
