package nl.hu.bep.domein;

public class Bewoner {
    private String soortnaam;
    private String kleurnaam;
    private int aantal;
    private boolean groepsDier;
    private int type;



    public Bewoner(String soortnaam, String kleurnaam, int aantal, boolean groepsDier, int type) {
        this.soortnaam = soortnaam;
        this.kleurnaam = kleurnaam;
        this.aantal = aantal;
        this.groepsDier = groepsDier;
        this.type = type;
    }
    public int getAantal() {
        return aantal;
    }

}
