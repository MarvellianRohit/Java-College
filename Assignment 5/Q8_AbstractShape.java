/*
 * Q8: Create an abstract class Shape with an abstract method calculateArea(). Derive two
 * concrete classes, Circle (with radius) and Rectangle (with length and breadth). Implement the
 * calculateArea() method in both subclasses and display the area of each shape.
 */

abstract class Shape {
    abstract void calculateArea();
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void calculateArea() {
        double area = 3.14159 * radius * radius;
        System.out.printf("Area of Circle: %.2f%n", area);
    }
}

class Rectangle extends Shape {
    double length, breadth;

    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    void calculateArea() {
        double area = length * breadth;
        System.out.println("Area of Rectangle: " + area);
    }
}

public class Q8_AbstractShape {
    public static void main(String[] args) {
        Shape c = new Circle(5.0);
        Shape r = new Rectangle(10.0, 4.0);

        c.calculateArea();
        r.calculateArea();
    }
}

/*
Output:
Area of Circle: 78.54
Area of Rectangle: 40.0
*/

