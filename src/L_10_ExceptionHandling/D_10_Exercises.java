package L_10_ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class D_10_Exercises {
    public static void main(String[] args) {
        // istiklal marşındaki toplam karakter , kelime ve satır sayısını
        // ekranda gösteren uygulamayı yaz.
        // en çok tekrar eden kelime?

        int totalCharacter = 0;
        int totalWorld = 0;
        int totalColumn = 0;

        HashMap<String, Integer> frequentlyWord = new HashMap<>();


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("istiklalmarşı.txt"))) {
            String presentColumn = bufferedReader.readLine();

            while (presentColumn != null) {
                totalColumn++;

                String[] wordArray = presentColumn.toLowerCase().split(" ");
                totalWorld += wordArray.length;

                for (String word : wordArray) {

                    if (frequentlyWord.containsKey(word)) {
                        frequentlyWord.put(word, frequentlyWord.get(word) + 1);
                    } else {
                        frequentlyWord.put(word, 1);
                    }

                    totalCharacter += word.length();
                }

                presentColumn = bufferedReader.readLine();
            }
            System.out.println("number o columns : " + totalColumn);
            System.out.println("number o words : " + totalWorld);
            System.out.println("number o characters : " + totalCharacter);

            int repeatNumber = 0;
            String repeatText = null;
            for (Map.Entry<String, Integer> temp:frequentlyWord.entrySet()){
                if (temp.getValue() > repeatNumber && !temp.getKey().equals("")){
                    repeatText = temp.getKey();
                    repeatNumber = temp.getValue();
                }
            }

            System.out.println("most repeated word -> " + "{" + repeatText + "}" + " and repeat number -> "+ repeatNumber);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
