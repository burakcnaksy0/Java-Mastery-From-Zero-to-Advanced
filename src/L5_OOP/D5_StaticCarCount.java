package L5_OOP;

public class D5_StaticCarCount {
    public static int carCount = 0;  // Statik değişken
    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    D5_StaticCarCount(String model) {
        this.model = model;
        carCount++;  // Yeni araba oluşturulduğunda sayaç artar
    }

    void display() {
        System.out.println("Araba Modeli: " + model);
    }

    static void showTotalCars() {
        System.out.println("Toplam araba sayısı: " + carCount);
    }
}
