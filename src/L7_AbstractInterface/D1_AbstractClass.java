package L7_AbstractInterface;

public class D1_AbstractClass {
    public static void main(String[] args) {
        // abstract class new ile nesne oluşturulmaz.
        // class içindeki bir metodun abstract olması o sınıfın abstract class olması için yeterlidir

        System.out.println("********** RightTriangle **********");

        GeometricShape triangle = new RightTriangle(3, 4);
        triangle.area();  // 6
        triangle.perimeter(); // 12

        System.out.println("************ Rectangle ************");

        GeometricShape rectangle = new Rectangle(5, 5);
        rectangle.area(); // 50
        rectangle.perimeter(); // 30

        System.out.println("************* Square **************");

        GeometricShape square = new Square(5);
        square.area(); // 25
        square.perimeter(); // 20

        System.out.println("***********************************");

        compareArea(triangle, rectangle);
        compareArea(square, triangle);
        compareArea(rectangle, square);

        /*     AnonymousInnerClass Usage Example
        normalde abstract olan class tan nesne oluşturamayız ama
        bu class tipini kullanarak {} ifadelerinden sonra abstact class
        içindeki abstract methodlarını yazmak şartıyla kullanabiliriz.

        GeometricShape g = new GeometricShape(){
            void area(){
                System.out.println("area");
            }
            void perimeter(){
                System.out.println("perimeter");
            }
        };
        g.area();
        g.perimeter();
         */
    }

    public static void compareArea(GeometricShape g1, GeometricShape g2) {
        if (g1.getArea() > g2.getArea()) {
            System.out.println("ilk alan ikinci alandan daha büyüktür.");
        } else if (g1.getArea() < g2.getArea()) {
            System.out.println("ilk alan ikinci alandan daha küçüktür.");
        } else {
            System.out.println("ilk alan ve ikinci alan eşittir.");
        }
    }
}

abstract class GeometricShape {


    private double first_edge;
    private double area;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getFirst_edge() {
        return first_edge;
    }

    public void setFirst_edge(double first_edge) {
        this.first_edge = first_edge;
    }

    abstract void area();

    abstract void perimeter();

}

class Rectangle extends GeometricShape {
    private double sec_edge;

    public Rectangle(double first_edge, double sec_edge) {
        setFirst_edge(first_edge);
        this.sec_edge = sec_edge;
    }

    public double getSec_edge() {
        return sec_edge;
    }

    public void setSec_edge(double sec_edge) {
        this.sec_edge = sec_edge;
    }

    @Override
    void area() {
        setArea(getFirst_edge() * getSec_edge());
        System.out.println("area is " + getArea());
    }

    @Override
    void perimeter() {
        System.out.println("perimeter is " + 2 * (getFirst_edge() + getSec_edge()));
    }

    void rec_ınfo() {
        System.out.println("Rectangle method");
    }
}

class RightTriangle extends GeometricShape {

    private double sec_edge;
    private double last_edge;

    public RightTriangle(double first_edge, double sec_edge) {
        setFirst_edge(first_edge);
        this.sec_edge = sec_edge;
        this.last_edge = Math.sqrt(Math.pow(this.sec_edge, 2) + Math.pow(getFirst_edge(), 2));
    }

    public double getSec_edge() {
        return sec_edge;
    }

    public void setSec_edge(double sec_edge) {
        this.sec_edge = sec_edge;
    }

    public double getLast_edge() {
        return last_edge;
    }

    public void setLast_edge(double last_edge) {
        this.last_edge = last_edge;
    }

    @Override
    void area() {
        setArea((getSec_edge() * getFirst_edge()) / 2);
        System.out.println("area is : " + getArea());
    }

    @Override
    void perimeter() {
        System.out.println("perimeter is : " + (getLast_edge() + getFirst_edge() + getSec_edge()));
    }

    void tri_ınfo() {
        System.out.println("RightTriangle method");
    }
}

class Square extends GeometricShape {
    public Square(double first_edge) {
        setFirst_edge(first_edge);
    }

    @Override
    void area() {
        setArea((getFirst_edge() * getFirst_edge()));
        System.out.println("area is : " + getArea());
    }

    @Override
    void perimeter() {
        System.out.println("perimeter is : " + (4 * getFirst_edge()));
    }

    void sqr_ınfo() {
        System.out.println("Square method");
    }
}