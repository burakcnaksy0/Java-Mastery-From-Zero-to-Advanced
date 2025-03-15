package L8_GenericClasses;

public class D2_GenericMethods {
    public static void main(String[] args) {
        Integer[] numbers = {10, 20, 30, 40, 50};
        String[] names = {"Ahmet", "Mehmet", "Zeynep", "Elif"};
        Character[] letters = {'A', 'B', 'C', 'D', 'E'};

        printArray(numbers);

        System.out.println();

        printArray(names);

        System.out.println();

        printArray(letters);
    }

    public static <DataType> void printArray(DataType[] array) {
        for (DataType i : array) {
            System.out.print(i + " , ");
        }
    }
}
