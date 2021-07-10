package nl.hu.bep.domein;

public class Toebehoren {
    private String model;
    private int serienummer;
    private String omschrijving;

    public Toebehoren(String model, int serienummer, String omschrijving) {
        this.model = model;
        this.serienummer = serienummer;
        this.omschrijving = omschrijving;
    }
}
