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
        for (int i = 0; i < aquariua.size(); i++) {
            if (!nweAquarium.equals(aquariua.get(i))) {
                aquariua.add(nweAquarium);;
            }

        }
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

    public boolean equals(Object andereObject) {
        boolean gelijkeObjecten = false; // blijft false tenzij:

        if (andereObject instanceof Eigenaar) {
            Eigenaar andereEigenaar = (Eigenaar) andereObject;

            if (this.voornaam.equals(andereEigenaar.voornaam) &&
                    this.achternaam.equals(andereEigenaar.achternaam)) {


                gelijkeObjecten = true;
            }
        }

        return gelijkeObjecten;
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
