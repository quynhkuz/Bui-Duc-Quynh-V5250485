package geometry;

public class Triangle implements Shape {
    private Point p1, p2, p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public double getArea() {
        double a = p1.distance(p2);
        double b = p2.distance(p3);
        double c = p3.distance(p1);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    @Override
    public double distance(Shape other) {
        return p1.distance(other);
    }

    @Override
    public void move(double dx, double dy) {
        p1.move(dx, dy);
        p2.move(dx, dy);
        p3.move(dx, dy);
    }

    @Override
    public void rotate(double angle) {
        p1.rotate(angle);
        p2.rotate(angle);
        p3.rotate(angle);
    }

    @Override
    public void zoom(double factor) {
        p1.zoom(factor);
        p2.zoom(factor);
        p3.zoom(factor);
    }

    @Override
    public String toString() {
        return "Triangle [P1=" + p1 + ", P2=" + p2 + ", P3=" + p3 + "]";
    }
}