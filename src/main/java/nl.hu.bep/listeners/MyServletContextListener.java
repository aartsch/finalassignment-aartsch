package nl.hu.bep.listeners;


import nl.hu.bep.domein.Aquarium;
import nl.hu.bep.domein.AquariumManager;
import nl.hu.bep.domein.Eigenaar;
import security.MyUser;
import nl.hu.bep.security.SecurityManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.Duration;

import static java.lang.System.*;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            System.out.println("Applciatie start op!");
            SecurityManager.getInstance().registerUser(new MyUser("eigenaar", "eigenaar", "eigenaar"));
            SecurityManager.getInstance().registerUser(new MyUser("beheerder", "beheerder", "beheerder"));
            AquariumManager aq1 = new AquariumManager("aq2016");
            Eigenaar jan = new Eigenaar("Jan", "achternaam");
            aq1.voegEigenaarToe(jan);
            Aquarium aquarium1 = new Aquarium("deAqua", 100,200,100,"gras","water");
            jan.voegAquariumToe(aquarium1);

        } catch (Exception e) {
            out.println("Error loading world: " + e.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            out.println("Applicatie sluit af");
        } catch (Exception e) {
            out.println("Error saving world: " + e.getMessage());
        }
    }
}