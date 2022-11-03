package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = getSessionFactory();

    private static SessionFactory getSessionFactory(){

        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            return configuration.buildSessionFactory(
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                .build());
        } catch (Throwable e){
            System.err.println("Creation failed " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory SessionFactory(){
        return sessionFactory;
    }
}