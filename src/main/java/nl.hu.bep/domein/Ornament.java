package nl.hu.bep.domein;

public class Ornament {
    private String naam;
    private String omschrijving;
    private String kleur;
    private boolean kanOpLuchtPomp;

    public Ornament(String naam, String omschrijving, String kleur, boolean kanOpLuchtPomp) {
        this.naam = naam;
        this.omschrijving = omschrijving;
        this.kleur = kleur;
        this.kanOpLuchtPomp = kanOpLuchtPomp;
    }

    public boolean equals(Object andereObject) {
        boolean gelijkeObjecten = false; // blijft false tenzij:

        if (andereObject instanceof Ornament) {
            Ornament andereOrnament = (Ornament) andereObject;

            if (this.naam.equals(andereOrnament.naam)) {
                gelijkeObjecten = true;
            }

        }
        return gelijkeObjecten;
    }


}

