package geometry;

public class Line implements Shape {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return start.distance(end);
    }

    @Override
    public double distance(Shape other) {
        return start.distance(other);
    }

    @Override
    public void move(double dx, double dy) {
        start.move(dx, dy);
        end.move(dx, dy);
    }

    @Override
    public void rotate(double angle) {
        start.rotate(angle);
        end.rotate(angle);
    }

    @Override
    public void zoom(double factor) {
        start.zoom(factor);
        end.zoom(factor);
    }

    @Override
    public String toString() {
        return "Line [Start=" + start + ", End=" + end + "]";
    }
}
