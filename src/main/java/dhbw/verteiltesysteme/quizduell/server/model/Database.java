package dhbw.verteiltesysteme.quizduell.server.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum Database {
    INSTANCE(Persistence.createEntityManagerFactory("emf"));

    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    Database(EntityManagerFactory factory) {
        this.entityManager = factory.createEntityManager();
    }
}
