package geometry;

public class Circle implements Shape {
    private final Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double distance(Shape other) {
        return center.distance(other);
    }

    @Override
    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    @Override
    public void rotate(double angle) {
        System.out.println("Xoay hình tròn quanh tâm " + center + " góc " + angle + " độ.");
    }

    @Override
    public void zoom(double factor) {
        this.radius *= factor;
    }

    @Override
    public String toString() {
        return "Circle [Center=" + center + ", Radius=" + radius + "]";
    }
}