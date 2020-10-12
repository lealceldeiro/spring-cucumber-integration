package com.example.hello;

import javax.persistence.PostPersist;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EntityEventListener {
    private final Logger logger = Logger.getAnonymousLogger();

    @PostPersist
    public void entitySaved(HelloEntity entity) {
        logger.log(Level.INFO, "Entity saved {0}", entity);
    }
}
