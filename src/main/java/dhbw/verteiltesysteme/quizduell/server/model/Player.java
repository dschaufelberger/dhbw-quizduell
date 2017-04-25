package dhbw.verteiltesysteme.quizduell.server.model;

import javax.persistence.*;
import java.util.Random;

@Entity
public class Player {
    private int id;
    private String name;

    public Player() {
    }

    public Player(String name) {
        setName(name);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String generateRandomName() {
        StringBuilder sb = new StringBuilder(6);
        Random random = new Random(System.nanoTime());

        for (int i = 0; i < sb.capacity(); i++) {
            char letter = (char)(97 + random.nextInt(26));
            sb.append(letter);
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
