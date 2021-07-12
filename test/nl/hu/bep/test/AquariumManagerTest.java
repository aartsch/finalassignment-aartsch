package nl.hu.bep.test;

import nl.hu.bep.domein.AquariumManager;
import nl.hu.bep.domein.Bewoner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AquariumManagerTest {

    @Test
    void BewonerToevoegenVerhoogtAantal(){
       AquariumManager aq1 = new AquariumManager("1");
       Bewoner b1 = new Bewoner("goudvis", "rood", 5, true, 2);
       Bewoner b2 = new Bewoner (" goudvis", "rood", 1, true, 2);
       aq1.voegBewonerToe(b1);
       aq1.voegBewonerToe(b2);
       assertEquals(6, aq1.getAllBewoners());
    }
}