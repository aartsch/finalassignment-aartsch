package nl.hu.bep.domein;

import java.util.ArrayList;

public class Aquarium {
//    private static Aquarium deAquarium;
    private String naam;
    private int lengte;
    private int breedte;
    private int hoogte;
    private String bodemsoort;
    private String watersoort;
    private static ArrayList<Ornament> ornamenten;
    private static ArrayList<Bewoner> bewoners;

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
    public void voegOrnamentToe(Ornament nweOrnament) {
        ornamenten.add(nweOrnament);

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
}
