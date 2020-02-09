public abstract class NamedShape implements Shape {

    private String shapeName = " ";

    public NamedShape(String name) {
        this.shapeName = name;
    }

    public NamedShape() {
        super();
    }

    @Override
    public String toString() {
        return "Shape is a " + shapeName;
    }
}
