package L5_OOP;

public class D0_Main {
    public static void main(String[] args) {

        // D1_Rectangle Class
        D1_Rectangle rc = new D1_Rectangle();
        rc.en = 5;
        rc.boy = 10;
        int alan = rc.alanHesapla(23, 5);
        System.out.println("alan : " + alan);

        System.out.println();

        // D2_Students Class
        D2_Students sc = new D2_Students("burak", "aksoy", 808, (byte) 15, true);
        sc.showStudentInfo();

        System.out.println();

        // D2_Students Class 2
        D2_Students[] student_all = new D2_Students[500];
        D2_Students sc0 = new D2_Students();
        D2_Students sc1 = new D2_Students("burak");
        D2_Students sc2 = new D2_Students("burak", "aksoy");
        D2_Students sc3 = new D2_Students("burak", "aksoy", 808);
        D2_Students sc4 = new D2_Students("burak", "aksoy", 808, (byte) 15);
        D2_Students sc5 = new D2_Students("burak", "aksoy", 808, (byte) 15, true);

        sc0.showStudentInfo();
        System.out.println("------------------");
        sc1.showStudentInfo();
        System.out.println("------------------");
        sc2.showStudentInfo();
        System.out.println("------------------");
        sc3.showStudentInfo();
        System.out.println("------------------");
        sc4.showStudentInfo();
        System.out.println("------------------");
        sc5.showStudentInfo();
        System.out.println("------------------");

        student_all[0] = sc0;
        student_all[1] = sc1;
        student_all[2] = sc2;
        student_all[3] = sc3;
        student_all[4] = sc4;
        student_all[5] = sc5;

        student_all[5].showStudentInfo();
        System.out.println("------------------");
        /*
        for (int i = 0; i < student_all.length; i++) {
            System.out.println(student_all[i].name);
        }  */

        System.out.println();

        // D3_Encapsulation_Students Class
        D3_Encapsulation_Students es = new D3_Encapsulation_Students("ceren", "alkan", 714, (byte) 35, true);
        System.out.println(es.getName());
        es.setName("burak");
        System.out.println(es.getName());

        System.out.println();

        // D4_StaticVariables Class
        D4_StaticVariables acc1 = new D4_StaticVariables("Ali");
        D4_StaticVariables acc2 = new D4_StaticVariables("Veli");

        acc1.displayInfo();
        acc2.displayInfo();

        // Statik değişkene sınıf üzerinden erişim
        D4_StaticVariables.interestRate = 7.0;  // Değiştirildi

        System.out.println("\nGüncellenmiş Faiz Oranı:");
        acc1.displayInfo();
        acc2.displayInfo();

        System.out.println();

        // D5_StaticCarCount Class
        D5_StaticCarCount car1 = new D5_StaticCarCount("BMW");
        D5_StaticCarCount car2 = new D5_StaticCarCount("Mercedes");
        D5_StaticCarCount car3 = new D5_StaticCarCount("Tesla");

        car1.display();
        car2.display();
        car3.display();

        car1.setModel("Bugatti");
        car2.setModel("TOGG");
        car3.setModel("Tofaş");

        System.out.println("------------------");
        car1.display();
        car2.display();
        car3.display();


        D5_StaticCarCount.showTotalCars();

        System.out.println();

        // D6_ImmutableClass Class
        String[] companies = {"hp", "apple"};
        D6_ImmutableClass ıc = new D6_ImmutableClass(12, 16, companies);

        String[] tmp_comp = ıc.getCompanies();   // burda yapılan işlemleri değiştirebiliyoruz.
        tmp_comp[0] = "lenovo";    // ve public String[] getCompanies() bu metodun içinde kopyasını tuttuğumuz
        tmp_comp[1] = "asus";           // için orijinal değeri değiştiremiyoruz.

        computerShow(ıc);

    }

    public static void computerShow(D6_ImmutableClass object_name) {
        System.out.println("core number : " + object_name.getCore_number());
        System.out.println("ram size : " + object_name.getRam_size());

        for (int i = 0; i < object_name.getCompanies().length; i++) {
            System.out.println("company name  : " + object_name.getCompanies()[i]);
        }
    }
}
