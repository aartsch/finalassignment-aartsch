package nl.hu.bep.domein;

public class Toebehoren {
    private String model;
    private int serienummer;
    private String omschrijving;

    public int getSerienummer() {
        return serienummer;
    }

    public Toebehoren(String model, int serienummer, String omschrijving) {
        this.model = model;
        this.serienummer = serienummer;
        this.omschrijving = omschrijving;
    }

    public boolean equals(Object andereObject) {
        boolean gelijkeObjecten = false; // blijft false tenzij:

        if (andereObject instanceof Toebehoren) {
            Toebehoren andereToebehoren = (Toebehoren) andereObject;

            if (this.serienummer == andereToebehoren.serienummer) {
                gelijkeObjecten = true;
            }

        }
        return gelijkeObjecten;
    }
}

