package nl.hu.bep.listeners;


import nl.hu.bep.domein.Aquarium;
import nl.hu.bep.domein.AquariumManager;
import nl.hu.bep.domein.Eigenaar;
import nl.hu.bep.domein.Toebehoren;
import nl.hu.bep.domein.Ornament;
import nl.hu.bep.domein.Bewoner;
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
            Bewoner vis = new Bewoner("goudvis", "rood", 5, true, 2);
            Toebehoren boom = new Toebehoren("Aquarium21", 25, "boom in aquarium");
            Ornament ornament1 = new Ornament("ornament1", "ornament voor aquarium", "rood", true);
            aq1.voegEigenaarToe(jan);
            aq1.voegToebehorenToe(boom);
            aq1.voegBewonerToe(vis);
            Aquarium aquarium1 = new Aquarium("deAqua", 100,200,100,"gras","water");
            aquarium1.voegOrnamentToe(ornament1);
            aquarium1.voegBewonerToe(vis);
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