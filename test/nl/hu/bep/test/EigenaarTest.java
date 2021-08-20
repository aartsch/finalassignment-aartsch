package nl.hu.bep.test;

import nl.hu.bep.domein.Aquarium;
import nl.hu.bep.domein.AquariumManager;
import nl.hu.bep.domein.Eigenaar;
import nl.hu.bep.domein.Toebehoren;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EigenaarTest {
    @Test
    public void checkUniqueAquarium(){
        AquariumManager aq1 = new AquariumManager("1");
        Eigenaar eigenaar1 = new Eigenaar("Jan", "Schouten");
        Aquarium aqu1 = new Aquarium("a", 2, 3, 4, "bodem", "water");
        Aquarium aqu2 = new Aquarium("a", 2, 3, 4, "bodem", "water");
        eigenaar1.voegAquariumToe(aqu1);
        eigenaar1.voegAquariumToe(aqu2);
        assertEquals(aqu1, eigenaar1.getAquarium());
    }

}