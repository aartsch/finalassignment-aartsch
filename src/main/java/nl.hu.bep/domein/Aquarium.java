package nl.hu.bep.domein;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
//    private static Aquarium deAquarium;
    private String naam;
    private int lengte;
    private int breedte;
    private int hoogte;
    private String bodemsoort;
    private String watersoort;
    private List<Ornament> ornamenten = new ArrayList<>();
    private List<Bewoner>  bewoners = new ArrayList<>();

//    public static Aquarium getAquarium() {
//        return deAquarium;
//    }

    public Aquarium(String naam, int lengte, int breedte, int hoogte, String bodemsoort, String watersoort) {
        this.naam = naam;
        this.lengte = lengte;
        this.breedte = breedte;
        this.hoogte = hoogte;
        this.bodemsoort = bodemsoort;
        this.watersoort = watersoort;
    }



    public void voegBewonerToe(Bewoner nweBewoner) {
        bewoners.add(nweBewoner);

    }

    public List<Ornament> getOrnamenten() {
        return ornamenten;
    }

    public void voegOrnamentToe(Ornament nweOrnament) {
        for (int i = 0; i < ornamenten.size(); i++) {
            if (!nweOrnament.equals(ornamenten.get(i))) {
                ornamenten.add(nweOrnament);
            }
        }
    }



    public String getWatersoort() {
        return watersoort;
    }

    public String getBodemsoort() {
        return bodemsoort;
    }

    public int getHoogte() {
        return hoogte;
    }

    public int getBreedte() {
        return breedte;
    }

    public int getLengte() {
        return lengte;
    }

    public String getNaam() {
        return naam;
    }

    public boolean equals(Object andereObject) {
        boolean gelijkeObjecten = false; // blijft false tenzij:

        if (andereObject instanceof Aquarium) {
            Aquarium andereAquarium = (Aquarium) andereObject;

            if (this.naam.equals(andereAquarium.naam)) {
                gelijkeObjecten = true;
            }

        }
        return gelijkeObjecten;
    }
}

