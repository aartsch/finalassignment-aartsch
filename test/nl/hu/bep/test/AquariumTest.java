package nl.hu.bep.test;

import nl.hu.bep.domein.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AquariumTest {
    @Test
    public void checkUniqueOrnament(){
        Eigenaar eigenaar1 = new Eigenaar("Jan", "Schouten");
        Ornament ornament = new Ornament("model", "aaa", "toebehoren", true);
        Ornament ornament1 = new Ornament("model", "aaa", "toebehoren1", true);
        Aquarium aqu1 = new Aquarium("a", 2, 3, 4, "bodem", "water");
        aqu1.voegOrnamentToe(ornament);
        aqu1.voegOrnamentToe(ornament1);
        assertEquals(aqu1.getOrnamenten(), ornament);
    }

}