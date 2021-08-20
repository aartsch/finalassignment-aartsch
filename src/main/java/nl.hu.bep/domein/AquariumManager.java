package nl.hu.bep.domein;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AquariumManager {
    private static AquariumManager deAquariumManager = new AquariumManager("Installatie1");
    public static AquariumManager getAquariumManager() {
        return deAquariumManager;
    }
    private String installatienaam;

    public static List<Eigenaar> getAlleEigenaren() {
        return alleEigenaren;
    }

    private  static List<Eigenaar> alleEigenaren = new ArrayList<>();
    private  static List<Toebehoren> alleToebehoren = new ArrayList<>();
    private  static List<Bewoner> alleBewoners = new ArrayList<>();

    public AquariumManager(String installatienaam) {
        this.installatienaam = installatienaam;

    }
    public void voegEigenaarToe(Eigenaar nweEigenaar) {
        for (int i = 0; i < alleEigenaren.size(); i++) {
            if (!nweEigenaar.equals(alleEigenaren.get(i))) {
                alleEigenaren.add(nweEigenaar);
            }
        }
    }

    public void voegToebehorenToe(Toebehoren nweToebehoren) {
        for (int i = 0; i < alleToebehoren.size(); i++) {
           if (!nweToebehoren.equals(alleToebehoren.get(i))) {
               alleToebehoren.add(nweToebehoren);
           }

        }

    }
    public void voegBewonerToe(Bewoner nweBewoner) {
        alleBewoners.add(nweBewoner);
    }

    public List<Eigenaar> getAllEigenaren() {
        return Collections.unmodifiableList(alleEigenaren);
    }

    public Eigenaar getEigenaarByName(String achternaam) {
        Eigenaar result = null;

        for (Eigenaar eigenaar : alleEigenaren) {
            if (eigenaar.getAchternaam() == achternaam) {
                result = eigenaar;
                break;
            }
        }
        return result;
    }


    public List<Toebehoren> getAllToebehoren() {
        return Collections.unmodifiableList(alleToebehoren);
    }

    public List<Bewoner> getAllBewoners() {
        return Collections.unmodifiableList(alleBewoners);
    }

    public AquariumManager(){
    }

    public static boolean removeEigenaar(String eigenaarName) {
        Eigenaar foundEigenaar = null;
        for (Eigenaar eigenaar : alleEigenaren) {
            if (eigenaar.getAchternaam().equals(eigenaarName)) {
                foundEigenaar = eigenaar;
                break;
            }
        }

        if (foundEigenaar != null) {
            alleEigenaren.remove(foundEigenaar);
            return true;
        } else return false;
    }
}

