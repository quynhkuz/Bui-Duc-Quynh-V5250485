//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import geometry.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Shape> shapeList = new ArrayList<>();
        Random random = new Random();

        System.out.print("Nhập số lượng hình muốn tạo trong ứng dụng Paint: ");
        int sizeShape = sc.nextInt();

        for (int i = 0; i < sizeShape; i++) {
            // Chọn ngẫu nhiên loại hình: 0: Point, 1: Line, 2: Circle, 3: Rectangle, 4: Triangle
            int type = random.nextInt(5);

            System.out.println("\n========================================");
            System.out.println("KHỞI TẠO HÌNH THỨ " + (i + 1));

            // Mọi hình đều bắt đầu từ một điểm gốc (P1)
            System.out.println("1. Nhập tọa độ ĐIỂM GỐC (P1) của hình:");
            System.out.print("   - Tọa độ x1: ");
            double x = sc.nextDouble();
            System.out.print("   - Tọa độ y1: ");
            double y = sc.nextDouble();
            Point p1 = new Point(x, y);

            switch (type) {
                case 0: // Point
                    System.out.println("Loại hình : ĐIỂM (Point)");
                    shapeList.add(p1);
                    break;

                case 1: // Line
                    System.out.println("Loại hình : ĐOẠN THẲNG (Line)");
                    System.out.println("2. Nhập tọa độ ĐIỂM KẾT THÚC (P2):");
                    System.out.print("   - Tọa độ x2: "); double x2 = sc.nextDouble();
                    System.out.print("   - Tọa độ y2: "); double y2 = sc.nextDouble();
                    shapeList.add(new Line(p1, new Point(x2, y2)));
                    break;

                case 2: // Circle
                    System.out.println(" Loại hình : HÌNH TRÒN (Circle)");
                    System.out.print("2. Nhập giá trị BÁN KÍNH (Radius): ");
                    double radius = sc.nextDouble();
                    shapeList.add(new Circle(p1, radius));
                    break;

                case 3: // Rectangle
                    System.out.println("Loại hình : HÌNH CHỮ NHẬT (Rectangle)");
                    System.out.print("2. Nhập CHIỀU RỘNG (Width): ");
                    double w = sc.nextDouble();
                    System.out.print("3. Nhập CHIỀU CAO (Height): ");
                    double h = sc.nextDouble();
                    shapeList.add(new Rectangle(p1, w, h));
                    break;

                case 4: // Triangle
                    System.out.println(" Loại hình: HÌNH T AM GIÁC (Triangle)");
                    System.out.println("2. Nhập tọa độ ĐIỂM THỨ HAI (P2):");
                    System.out.print("   - Tọa độ x2: "); double tx2 = sc.nextDouble();
                    System.out.print("   - Tọa độ y2: "); double ty2 = sc.nextDouble();
                    System.out.println("3. Nhập tọa độ ĐIỂM THỨ BA (P3):");
                    System.out.print("   - Tọa độ x3: "); double tx3 = sc.nextDouble();
                    System.out.print("   - Tọa độ y3: "); double ty3 = sc.nextDouble();
                    shapeList.add(new Triangle(p1, new Point(tx2, ty2), new Point(tx3, ty3)));
                    break;
            }
        }

        System.out.println("\n****************************************");
        System.out.println("----- KẾT QUẢ TÍNH TOÁN CHI TIẾT -----");
        Point origin = new Point(0, 0);

        for (int i = 0; i < shapeList.size(); i++) {
            Shape s = shapeList.get(i);
            System.out.println("\nHÌNH " + (i + 1) + ": " + s.toString());
            System.out.printf("Diện tích: %.2f | Chu vi: %.2f\n", s.getArea(), s.getPerimeter());

            System.out.printf("Khoảng cách từ tâm đến O(0,0): %.2f\n", s.distance(origin));
            System.out.println("----------------------------------------");
        }

        double totalArea = 0;
        for (Shape s : shapeList) {
            totalArea += s.getArea();
        }
        System.out.printf("\nTỔNG DIỆN TÍCH CỦA %d HÌNH: %.2f\n", shapeList.size(), totalArea);

        sc.close();
    }


}
