import java.util.ArrayList;

public class Person {
    int challenges, wins;
    ArrayList<Person> uniquePlayers;
    String name;

    Person(String name) {
        challenges = 0;
        wins = 0;
        uniquePlayers = new ArrayList<>();
        this.name = name;
    }


}
