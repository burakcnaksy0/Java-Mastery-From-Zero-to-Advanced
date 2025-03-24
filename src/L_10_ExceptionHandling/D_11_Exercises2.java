package L_10_ExceptionHandling;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class D_11_Exercises2 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        // burada sırasız şekilde olan maaş.txt dosyasını alıp , okuyoruz ve içindekileri düzenliyoruz
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("maas.txt"))) {
            String column = bufferedReader.readLine();
            while (column != null) {

                String[] columnArray = column.split(" ");

                String name = columnArray[0];
                int salary = Integer.parseInt(columnArray[1]);

                Employee employee = new Employee(name, salary);
                employees.add(employee);

                column = bufferedReader.readLine();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(employees);
        System.out.println(employees.size());

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                /*
                // maaşa göre sıralama
                if (o1.salary > o2.salary) {
                    return 1;
                } else if (o1.salary < o2.salary) {
                    return -1;
                } else {
                    return 0;
                }*/

                // alfabetik sıralama
                if (o1.name.compareTo(o2.name) > 0) {
                    return 1;
                } else if (o1.name.compareTo(o2.name) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // burdada okuma işleminde sıralayıp arrayliste atıp , sonra arraylisti kullanarak yeni bir
        // txt dosyası açıp onun içine yazıp kaydediyoruz.
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("sort_salary.txt"))) {

            for (Employee temp : employees) {
                bufferedWriter.write(temp.name + " " + temp.salary);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {
    String name;
    int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}