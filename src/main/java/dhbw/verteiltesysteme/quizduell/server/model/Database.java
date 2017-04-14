package dhbw.verteiltesysteme.quizduell.server.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum Database {
    ENTITY_MANAGER(Persistence.createEntityManagerFactory("emf"));

    private EntityManager entityManager;

    Database(EntityManagerFactory factory) {
        this.entityManager = factory.createEntityManager();
    }
}
