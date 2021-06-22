package tvz.oop;

import java.util.ArrayList;


public class Osoba {

    private String ime;
    private String prezime;
    private Bolest zarazenaBolescu;
    private ArrayList<Osoba> kontaktiraneOsobe;

    public Osoba(String ime, String prezime, Bolest zarazenaBolescu, ArrayList<Osoba> kontaktiraneOsobe) {
        this.ime = ime;
        this.prezime = prezime;
        this.zarazenaBolescu = zarazenaBolescu;
        this.kontaktiraneOsobe = kontaktiraneOsobe;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Bolest getZarazenaBolescu() {
        return zarazenaBolescu;
    }

    public void setZarazenaBolescu(Bolest zarazenaBolescu) {
        this.zarazenaBolescu = zarazenaBolescu;
    }

    public ArrayList<Osoba> getKontaktiraneOsobe() {
        return kontaktiraneOsobe;
    }

    public void setKontaktiraneOsobe(ArrayList<Osoba> kontaktiraneOsobe) {
        this.kontaktiraneOsobe = kontaktiraneOsobe;
    }
}
