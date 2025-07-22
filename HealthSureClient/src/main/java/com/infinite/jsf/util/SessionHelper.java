package com.infinite.jsf.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;

public class SessionHelper {
    private static final Logger logger = Logger.getLogger(SessionHelper.class);
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration config = new Configuration().configure(); // Loads hibernate.cfg.xml
            sessionFactory = config.buildSessionFactory();
            logger.info("Hibernate SessionFactory initialized.");
        } catch (Throwable ex) {
            logger.error("SessionFactory creation failed: ", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
