package nl.hu.bep.domein;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Eigenaar {
    private String voornaam;
    private String achternaam;
    private static ArrayList<Aquarium> aquariua;
    private static ArrayList<Toebehoren> toebehoren;


    public Eigenaar(String voornaam, String achternaam){
        this.voornaam = voornaam;
        this.achternaam=achternaam;
    }

    public void voegToebehorenToe(Toebehoren nweToebehoren) {
       toebehoren.add(nweToebehoren);
    }

    public void voegAquariumToe(Aquarium nweAquarium) {
        aquariua.add(nweAquarium);
    }

    public static boolean removeAquarium(String aquariumName) {
        Aquarium foundAquarium = null;
        for (Aquarium aquarium : aquariua) {
            if (aquarium.getNaam().equals(aquariumName)) {
                foundAquarium = aquarium;
                break;
            }
        }

        if (foundAquarium != null) {
            aquariua.remove(foundAquarium);
            return true;
        } else return false;
    }

    public List<Aquarium> getAquarium() {
        return Collections.unmodifiableList(aquariua);
    }

    public String getVoornaam() {
        return achternaam;
    }
    public String getAchternaam() {
        return achternaam;
    }
}
