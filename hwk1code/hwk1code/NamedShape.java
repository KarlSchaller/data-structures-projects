public abstract class NamedShape implements Shape {

    // the name of the shape
    private String shapeName;

    // Constructor - initializes the name of the shape
    public NamedShape() {shapeName = "None";}

    public NamedShape(String shapeName) {
        this.shapeName = shapeName;
    }

    // Get the kind of shape this is
    public String getShapeName() {
        return shapeName;
    }

    // Set the name for this shape
    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public String toString() {
        return "Shape is a " + shapeName;
    }
}