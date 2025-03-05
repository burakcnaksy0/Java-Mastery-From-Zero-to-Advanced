package L6_OOP_Structures;

import java.sql.SQLOutput;

public class D4_InheritanceStc {
    public static void main(String[] args) {

        System.out.println("shape infos : \n");

        Shape sp = new Shape(10, 6);
        System.out.println(sp);

        System.out.println("rectangle infos : \n");

        Rectangle rc = new Rectangle(10, 5);
        rc.areaCalculate();
        rc.perimeterCalculate();
        rc.show_ınfos();
        System.out.println(rc);

        System.out.println("square infos : \n");

        Square sq = new Square(5);
        sq.areaCalculate();
        sq.perimeterCalculate();
        sq.show_ınfos();
    }
}

class Shape {
    private int weight;
    private int height;

    Shape() {
    }

    Shape(int weight) {
        //this.weight = weight;
        setWeight(weight);
    }

    Shape(int weight, int height) {
        /*this.height = height;
        this.weight = weight;*/
        setWeight(weight);
        setHeight(height);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void areaCalculate() {
        System.out.println("area is : " + (getHeight() * getWeight()));
    }

    public void perimeterCalculate() {
        System.out.println("perimeter is : " + (getHeight() + getWeight()) * 2);
    }

    @Override
    public String toString() {
        return ("weight  :" + getWeight() + " height : " + getHeight());
    }

}

class Rectangle extends Shape {

    Rectangle() {
    }

    Rectangle(int weight) {
        setWeight(weight);
    }

    Rectangle(int weight, int height) {
        //setWeight(weight);
        //setHeight(height);
        super(weight, height);
    }

    public void show_ınfos() {
        System.out.println("weight  :" + getWeight() + " height : " + getHeight());
    }
}

class Square extends Rectangle {

    Square() {
    }

    Square(int weight) {
        //setWeight(weight);
        super(weight);
    }

    @Override
    public void areaCalculate() {
        System.out.println("alan : " + (getWeight() * getWeight()));
    }

    @Override
    public void show_ınfos() {
        System.out.println("weight  :" + getWeight() + " height : " + getWeight());
    }
}
