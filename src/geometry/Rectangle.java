package geometry;

import java.awt.*;

public class Rectangle implements Shape {
    private Point topLeft;
    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double distance(Shape other) {
        return topLeft.distance(other);
    }

    @Override
    public void move(double dx, double dy) {
        topLeft.move(dx, dy);
    }

    @Override
    public void rotate(double angle) {
        System.out.println("Xoay hình chữ nhật một góc " + angle + " độ.");
    }

    @Override
    public void zoom(double factor) {
        this.width *= factor;
        this.height *= factor;
    }

    @Override
    public String toString() {
        return "geometry.Rectangle [TopLeft=" + topLeft + ", Width=" + width + ", Height=" + height + "]";
    }
}
