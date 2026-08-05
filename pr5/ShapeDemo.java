package pr5;
abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }
}

class Triangle extends Shape {
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }
}

public class ShapeDemo {
    public static void main(String[] args) {

        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(8, 3),
            new Circle(2)
        };

        double totalArea = 0;
        double largestArea = 0;

        System.out.println("Areas of Shapes:");

        for (Shape s : shapes) {
            double area = s.area(); // polymorphism

            System.out.printf("Area = %.2f%n", area);

            totalArea += area;

            if (area > largestArea) {
                largestArea = area;
            }

            System.out.printf("Running Total = %.2f%n%n", totalArea);
        }

        System.out.printf("Total Area = %.2f%n", totalArea);
        System.out.printf("Largest Area = %.2f%n", largestArea);
    }
}