package tvz.oop;

import java.util.ArrayList;

public class Bolest {

    private String naziv;
    private ArrayList<Simptom> simptomi;
    private Boolean zarazna;

    public Bolest(String naziv, ArrayList<Simptom> simptomi, Boolean zarazna) {
        this.naziv = naziv;
        this.simptomi = simptomi;
        this.zarazna = zarazna;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public ArrayList<Simptom> getSimptomi() {
        return simptomi;
    }

    public void setSimptomi(ArrayList<Simptom> simptomi) {
        this.simptomi = simptomi;
    }

    public Boolean getZarazna() {
        return zarazna;
    }

    public void setZarazna(Boolean zarazna) {
        this.zarazna = zarazna;
    }
}
