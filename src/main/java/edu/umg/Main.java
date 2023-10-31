package edu.umg;

import edu.umg.gui.UserInterfaceMain;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Inicio de Sesión");
        frame.setIconImage(new ImageIcon("src/main/resources/img.jpg").getImage());
        frame.setTitle("Inicio de Sesión");
        frame.setContentPane(new UserInterfaceMain().getjMainPanel());
        frame.pack();
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public class HibernateUtil {
        private static final SessionFactory sessionFactory;

        static {
            try {
                // Carga la configuración desde hibernate.cfg.xml
                sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Error al inicializar la SessionFactory: " + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }
    }
}
