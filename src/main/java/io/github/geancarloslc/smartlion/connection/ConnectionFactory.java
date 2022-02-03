package io.github.geancarloslc.smartlion.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");

    public EntityManager getConnection(){

        return entityManagerFactory.createEntityManager();
    }

}
