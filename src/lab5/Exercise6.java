package lab5;
public class Exercise6 {

    static class Rectangle {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double calculateArea() {
            return width * height;
        }

        public double calculatePerimeter() {
            return 2 * (width + height);
        }
    }

    static class Circle {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public double calculateSurface() {
            return Math.PI * radius * radius;
        }

        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Testing Rectangle ---");
        Rectangle rect = new Rectangle(5.0, 10.0);
        System.out.println("Width: " + rect.getWidth());
        System.out.println("Height: " + rect.getHeight());
        System.out.printf("Area: %.2f\n", rect.calculateArea());
        System.out.printf("Perimeter: %.2f\n", rect.calculatePerimeter());

        System.out.println("\n--- Testing Circle ---");
        Circle myCircle = new Circle(3.5);
        System.out.println("Radius: " + myCircle.getRadius());
        System.out.printf("Surface (Area): %.2f\n", myCircle.calculateSurface());
        System.out.printf("Perimeter (Circumference): %.2f\n", myCircle.calculatePerimeter());
    }
}
