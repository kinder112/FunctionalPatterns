package visitor.gof;

interface Shape {
    void accept(ShapeVisitor visitor);
}

class Circle implements Shape {
    final int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

class Rectangle implements Shape {
    final int width;
    final int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

interface ShapeVisitor {

    void visit(Circle circle);

    void visit(Rectangle rectangle);
}

class AreaCalculatingVisitor implements ShapeVisitor {

    @Override
    public void visit(Circle circle) {
        System.out.printf("Area of circle with radius %d is %f\n", circle.radius, Math.pow(circle.radius, 2.0) * Math.PI);
    }

    @Override
    public void visit(Rectangle rectangle) {
        System.out.printf("Area of rectangle with width %d and height %d is %d\n", rectangle.width, rectangle.height, rectangle.width * rectangle.height);
    }
}

public class Visitor {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(2, 4);

        ShapeVisitor visitor = new AreaCalculatingVisitor();

        circle.accept(visitor);
        rectangle.accept(visitor);

    }
}