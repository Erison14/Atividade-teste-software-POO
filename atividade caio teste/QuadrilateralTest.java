//questao 3
class Point {
    double x, y;
    Point(double x, double y) { this.x = x; this.y = y; }
}

class Quadrilateral {
    Point p1, p2, p3, p4;

    Quadrilateral(Point a, Point b, Point c, Point d) {
        p1 = a; p2 = b; p3 = c; p4 = d;
    }

    // Método para ser sobrescrito ou usado como base
    public String getCoordinatesAsString() {
        return String.format("(%.1f, %.1f), (%.1f, %.1f), (%.1f, %.1f), (%.1f, %.1f)", 
            p1.x, p1.y, p2.x, p2.y, p3.x, p3.y, p4.x, p4.y);
    }
}

// 1. Trapézio
class Trapezoid extends Quadrilateral {
    Trapezoid(Point a, Point b, Point c, Point d) { super(a, b, c, d); }

    public double getArea() {
        // Área = ((base1 + base2) * altura) / 2
        double base1 = Math.abs(p2.x - p1.x);
        double base2 = Math.abs(p3.x - p4.x);
        double height = Math.abs(p2.y - p3.y);
        return ((base1 + base2) * height) / 2.0;
    }
}

// 2. Paralelogramo (Um paralelogramo é um trapézio com bases iguais)
class Parallelogram extends Trapezoid {
    Parallelogram(Point a, Point b, Point c, Point d) { super(a, b, c, d); }
    
    @Override
    public double getArea() {
        // Área = base * altura
        double base = Math.abs(p2.x - p1.x);
        double height = Math.abs(p2.y - p3.y);
        return base * height;
    }
}

// 3. Retângulo
class Rectangle extends Parallelogram {
    Rectangle(Point a, Point b, Point c, Point d) { super(a, b, c, d); }
}

// 4. Quadrado
class Square extends Rectangle {
    Square(Point a, Point b, Point c, Point d) { super(a, b, c, d); }
}

public class QuadrilateralTest {
    public static void main(String[] args) {
        // Definindo pontos para teste (ajustados para cada forma)
        Trapezoid trap = new Trapezoid(new Point(0,0), new Point(10,0), new Point(8,5), new Point(2,5));
        Parallelogram para = new Parallelogram(new Point(5,5), new Point(11,5), new Point(12,10), new Point(6,10));
        Rectangle rect = new Rectangle(new Point(17,14), new Point(30,14), new Point(30,28), new Point(17,28));
        Square sqr = new Square(new Point(4,0), new Point(8,0), new Point(8,4), new Point(4,4));

        System.out.printf("Área do Trapézio: %.2f\n", trap.getArea());
        System.out.printf("Área do Paralelogramo: %.2f\n", para.getArea());
        System.out.printf("Área do Retângulo: %.2f\n", rect.getArea());
        System.out.printf("Área do Quadrado: %.2f\n", sqr.getArea());
    }
}