package java.dhbw.verteiltesysteme.quizduell.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;

/**
 * Created by Dodo on 30.03.2017.
 */
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
    }

    public static String generateRandomName() {
        StringBuilder sb = new StringBuilder(6);
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < sb.capacity(); i++) {
            char letter = (char)(61 + random.nextInt(26));
            sb.append(letter);
        }

        return sb.toString();
    }
}
