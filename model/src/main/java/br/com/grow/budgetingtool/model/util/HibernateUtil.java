package br.com.grow.budgetingtool.model.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory buildSessionFactory(Configuration config) {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return config.buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory(Configuration config) {
        return buildSessionFactory(config);
    }
    
}
