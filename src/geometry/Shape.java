package geometry;

public interface Shape {
    double getArea();
    double getPerimeter();
    double distance(Shape other);


    void move(double dx, double dy);
    void rotate(double angle);
    void zoom(double factor);
}
