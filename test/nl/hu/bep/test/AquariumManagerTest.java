package nl.hu.bep.test;

import nl.hu.bep.domein.AquariumManager;
import nl.hu.bep.domein.Bewoner;
import nl.hu.bep.domein.Eigenaar;
import nl.hu.bep.domein.Toebehoren;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AquariumManagerTest {

    @Test
    public void bewonerToevoegenVerhoogtAantal(){
       AquariumManager aq1 = new AquariumManager("1");
       Bewoner b1 = new Bewoner("goudvis", "rood", 5, true, 2);
       Bewoner b2 = new Bewoner (" goudvis", "rood", 1, true, 2);
       aq1.voegBewonerToe(b1);
       aq1.voegBewonerToe(b2);
       assertEquals(6, aq1.getAllBewoners());
    }
    @Test
    public void checkUniqueToebehoren(){
        AquariumManager aq1 = new AquariumManager("1");
        Toebehoren toebehoren1 = new Toebehoren("model", 12, "toebehoren");
        Toebehoren toebehoren2 = new Toebehoren("model", 12, "toebehoren");
        aq1.voegToebehorenToe(toebehoren1);
        aq1.voegToebehorenToe(toebehoren2);

        assertEquals(toebehoren1, aq1.getAllToebehoren());
    }
    @Test
    public void checkUniqueAquariumManagerInstallatie(){
        AquariumManager aq1 = new AquariumManager("1");
        AquariumManager aq2 = new AquariumManager("2");


        assertEquals(AquariumManager.getAquariumManager(), aq1);
    }

    @Test
    public void checkUniqueEigenaar(){
        AquariumManager aq1 = new AquariumManager("1");
        Eigenaar eigenaar1 = new Eigenaar("Jan", "Schouten");
        Eigenaar eigenaar2 = new Eigenaar("Jan", "Schouten");
        aq1.voegEigenaarToe(eigenaar1);
        aq1.voegEigenaarToe(eigenaar2);
        assertEquals(AquariumManager.getAlleEigenaren(), eigenaar1);

    }
}

