package geometry;

public class Point implements Shape {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    @Override
    public double getArea() { return 0; }

    @Override
    public double getPerimeter() { return 0; }

    @Override
    public double distance(Shape other) {
        if (other instanceof Point) {
            Point p = (Point) other;
            return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
        }
        return -1;
    }

    @Override
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public void rotate(double angle) {
        double rad = Math.toRadians(angle);
        double oldX = x;
        this.x = x * Math.cos(rad) - y * Math.sin(rad);
        this.y = oldX * Math.sin(rad) + y * Math.cos(rad);
    }

    @Override
    public void zoom(double factor) {
        this.x *= factor;
        this.y *= factor;
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}
