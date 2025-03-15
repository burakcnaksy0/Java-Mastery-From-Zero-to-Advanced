package L7_AbstractInterface;

public class D8_CalculaterInnerClass {
    public static void main(String[] args) {
        Calculater cl = new Calculater();

        String divide = cl.divide(6, 2);
        System.out.println(divide);

        int add_res = cl.add(123, 54);
        System.out.println(add_res);

        int sub_res = cl.sub(324, 12);
        System.out.println(sub_res);
    }
}

class Calculater {

    public int add(int i, int i1) {
        class Add {
            public int add(int i, int j) {
                return i + j;
            }
        }
        Add add = new Add();

        return add.add(i, i1);
    }

    public int sub(int i, int i1) {
        class Sub {
            public int sub(int i, int j) {
                return i - j;
            }
        }
        Sub sub = new Sub();

        return sub.sub(i, i1);
    }

    public int multiply(int i, int i1) {

        class Multiply {
            public int multiply(int i, int j) {
                return i * j;
            }
        }
        Multiply multiply = new Multiply();
        return multiply.multiply(i, i1);
    }

    public String divide(int i, int i1) {
        class Divide {
            public String divide(int i, int j) {
                if (j == 0) {
                    return "Payda 0 olamaz!";
                }
                return String.valueOf(i / j);
            }
        }
        Divide divide = new Divide();
        return divide.divide(i, i1);
    }
}