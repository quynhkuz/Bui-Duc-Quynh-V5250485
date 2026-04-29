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
        System.out.print("Nhập số lượng hình: ");
        int sizeShape = sc.nextInt();

        List<Shape> shapeList = new ArrayList<>();
        Random random = new Random();

        // 1. Khởi tạo ngẫu nhiên 5 loại hình
        for (int i = 0; i < sizeShape; i++) {
            int type = random.nextInt(5);
            double x = random.nextDouble() * 100;
            double y = random.nextDouble() * 100;
            Point p1 = new Point(x, y);

            switch (type) {
                case 0: shapeList.add(p1); break;
                case 1:
                    shapeList.add(new Line(p1, new Point(random.nextDouble()*100, random.nextDouble()*100)));
                    break;
                case 2:
                    shapeList.add(new Circle(p1, 10 + random.nextDouble()*40));
                    break;
                case 3:
                    shapeList.add(new Rectangle(p1, 10 + random.nextDouble()*50, 10 + random.nextDouble()*50));
                    break;
                case 4:
                    shapeList.add(new Triangle(p1, new Point(random.nextDouble()*100, random.nextDouble()*100),
                            new Point(random.nextDouble()*100, random.nextDouble()*100)));
                    break;
            }
        }

        // 2. Hiển thị danh sách kèm diện tích, chu vi và khoảng cách
        System.out.println("\n----- CHI TIẾT TÍNH TOÁN CÁC HÌNH -----");
        Point origin = new Point(0, 0); // Điểm gốc để tính khoảng cách tham chiếu

        for (int i = 0; i < shapeList.size(); i++) {
            Shape s = shapeList.get(i);
            System.out.println("Hình thứ " + (i + 1) + ": " + s.toString());

            // Gọi các phương thức tính toán từ interface Shape
            System.out.printf("  + Diện tích: %.2f\n", s.getArea());
            System.out.printf("  + Chu vi: %.2f\n", s.getPerimeter());

            // Tính khoảng cách từ tâm hình đó đến điểm gốc (0,0)
            System.out.printf("  + Khoảng cách đến gốc tọa độ (0,0): %.2f\n", s.distance(origin));
            System.out.println("---------------------------------------");
        }

        // 3. Thống kê tổng hợp
        double totalArea = 0;
        for (Shape s : shapeList) totalArea += s.getArea();
        System.out.printf("\n=> TỔNG DIỆN TÍCH TẤT CẢ CÁC HÌNH: %.2f\n", totalArea);

        sc.close();
    }

}
