package nl.hu.bep.domein;

public class Bewoner {
    private String soortnaam;
    private String kleurnaam;
    private int aantal;
    private String groepsDier;
    private int type;

    public Bewoner(String soortnaam, String kleurnaam, int aantal, String groepsDier, int type) {
        this.soortnaam = soortnaam;
        this.kleurnaam = kleurnaam;
        this.aantal = aantal;
        this.groepsDier = groepsDier;
        this.type = type;
    }
}
