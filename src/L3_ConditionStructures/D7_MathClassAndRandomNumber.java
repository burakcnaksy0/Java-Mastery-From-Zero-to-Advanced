package L3_ConditionStructures;

public class D7_MathClassAndRandomNumber {
    public static void main(String[] args) {
        // math class

        System.out.println("pi değeri : " + Math.PI);
        System.out.println("e değeri : " + Math.E);

        System.out.println("-5 'in mutlak değeri : " + Math.abs(-5));
        System.out.println("4.6 yuvarlanmış değeri : " + Math.ceil(4.6)); // yukarı yuvarlar
        System.out.println("2 nin küpü : " + Math.pow(2, 3));
        System.out.println("16 nın karekökü: " + Math.sqrt(16));

        // random ifadesi
        while(true) {
            int randomNumber = (int) (Math.random() * 10 + 1);   // 0-1 arasında ondalıklı değer döndürür. *10  -> 0-10 (10 dahil değil)
            System.out.println("random number is " + randomNumber);
            if (randomNumber == 5){
                break;
            }
        }

        // eğer üretilecek rastgele sayının 0 da olmasını istersen:
        // Math.random * (üstsınır + 1)

        // eğer üretilecek rastgele sayını 0 olmasını istemezsen :
        // (Math.random * üstsınır) + 1
    }
}
