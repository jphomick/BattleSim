import java.util.ArrayList;
import java.util.Random;

public class Main {

    static ArrayList<Person> people;
    static final String[] games = {"Monopoly", "Sorry", "Clue", "Dominant Species", "Wingspan",
            "Scythe", "Risk", "Ticket to Ride", "Azul", "Reef", "Yu-Gi-Oh", "Mario Kart", "Super Smash Bros."};

    public static void main(String[] args) {
        people = new ArrayList<>();
        people.add(new Person("Ben"));
        people.add(new Person("Jane"));
        people.add(new Person("Alfonzo"));
        people.add(new Person("Haley"));
        people.add(new Person("George"));
        people.add(new Person("Sarah"));

        Random r = new Random();
        int listSize = people.size();

        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            Person match1 = people.get(r.nextInt(listSize));
            int idx = r.nextInt(listSize);
            Person match2 = people.get(idx);
            while (match1.uniquePlayers.contains(match2)) {
                idx++;
                if (idx >= listSize) {
                    idx = 0;
                }
                match2 = people.get(idx);
            }
            if (!match1.name.equals(match2.name)) {
                match1.uniquePlayers.add(match2);
                match2.uniquePlayers.add(match1);
                System.out.println(match1.name + " has challenged " + match2.name + " this weekend!");
                match1.challenges++;
                match2.challenges++;
                for (int j = 0; j < r.nextInt(5) + 1; j++) {
                    int who = r.nextInt(2);
                    if (who == 0) {
                        System.out.println(match1.name + " beat " + match2.name + " in "
                                + games[r.nextInt(games.length)] + "!");
                        match1.wins++;
                    } else {
                        System.out.println(match2.name + " beat " + match1.name + " in "
                                + games[r.nextInt(games.length)] + "!");
                        match2.wins++;
                    }
                }
            } else {
                System.out.println(match1.name + " decided to take the weekend off");
            }
        }

        System.out.println();
        for (Person guy : people) {
            System.out.println(guy.name + "\nChallenges:\t"
                    + guy.challenges + "\nVictories:\t" + guy.wins);
        }
    }
}
