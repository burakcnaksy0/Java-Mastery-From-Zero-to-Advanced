package L0_PatikaQuestions;

import java.util.*;

public class D6_FixtureGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Takımları giriniz (Her bir takımı yeni satıra girin, bitirmek için boş satır bırakın):");

        List<String> teams = new ArrayList<>();
        while (true) {
            String team = scanner.nextLine().trim();
            if (team.isEmpty()) break;
            teams.add(team);
        }

        if (teams.size() % 2 != 0) {
            teams.add("Bay"); // Eğer takım sayısı tekse "Bay" ekle
        }

        generateFixture(teams);
    }

    public static void generateFixture(List<String> teams) {
        int totalRounds = (teams.size() - 1) * 2; // Çift devreli lig için
        int matchesPerRound = teams.size() / 2;
        List<String> fixtures = new ArrayList<>();

        List<String> teamList = new ArrayList<>(teams);
        Collections.shuffle(teamList); // Takımları rastgele sırala

        List<String> firstHalf = new ArrayList<>(teamList.subList(0, matchesPerRound));
        List<String> secondHalf = new ArrayList<>(teamList.subList(matchesPerRound, teams.size()));

        for (int round = 0; round < totalRounds / 2; round++) {
            StringBuilder roundMatches = new StringBuilder("Round " + (round + 1) + "\n");
            for (int i = 0; i < matchesPerRound; i++) {
                roundMatches.append(firstHalf.get(i)).append(" vs ").append(secondHalf.get(i)).append("\n");
            }
            fixtures.add(roundMatches.toString());

            // Döndürme algoritması ile takımları değiştir
            secondHalf.add(0, firstHalf.remove(firstHalf.size() - 1));
            firstHalf.add(1, secondHalf.remove(secondHalf.size() - 1));
        }

        // Rövanş maçları ekle
        int currentRound = fixtures.size();
        for (int i = 0; i < currentRound; i++) {
            String[] matches = fixtures.get(i).split("\n");
            StringBuilder reverseRound = new StringBuilder("Round " + (i + currentRound + 1) + "\n");
            for (int j = 1; j < matches.length; j++) {
                String[] teamsMatch = matches[j].split(" vs ");
                reverseRound.append(teamsMatch[1]).append(" vs ").append(teamsMatch[0]).append("\n");
            }
            fixtures.add(reverseRound.toString());
        }

        // Fikstürü yazdır
        for (String round : fixtures) {
            System.out.println(round);
        }
    }
}
