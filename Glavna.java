package tvz.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class Glavna {
    public static void main(String[] args) {
        Scanner unos = new Scanner(System.in);
        int brojSimptoma, i, brojBolesti;
        ArrayList<Simptom> simptomi = new ArrayList<>();
        ArrayList<Simptom> simptomiBolesti = new ArrayList<>();
        ArrayList<Bolest> bolesti = new ArrayList<>();
        ArrayList<Osoba> osobe = new ArrayList<>();
        ArrayList<Osoba> kontaktiraneOsobe = new ArrayList<>();

        Boolean zarazna = false;
        System.out.print("Molimo unesite broj mogucih simptoma: ");
        brojSimptoma = unos.nextInt();
        unos.nextLine();

        for (i = 0; i < brojSimptoma; i++) {

            System.out.println("Molimo unesite naziv simptoma: ");
            String nazivSimptoma = unos.nextLine();
            System.out.println("Molimo unesite vrijednost simptoma: ");
            String vrijednostSimptoma = unos.nextLine();
            simptomi.add(new Simptom(nazivSimptoma, vrijednostSimptoma));
        }

        System.out.print("Molimo unesite broj bolesti: ");
        brojBolesti = unos.nextInt();

        for (i = 0; i < brojBolesti; i++) {
            unos.nextLine();
            System.out.println("Molimo unesite naziv bolesti: ");
            String nazivBolesti = unos.nextLine();
            System.out.println("Molimo unesite koliko bolest ima simptoma: ");
            int brojSimptomaBolesti = unos.nextInt();

            for (int j = 0; j < brojSimptomaBolesti; j++) {
                System.out.println("Moguci odabira simptoma: ");
                for (int k = 0; k < brojSimptoma; k++) {
                    System.out.println((k + 1) + ") " + simptomi.get(k).getNaziv());
                }
                System.out.println("Unesite broj ispred simptoma kojeg zelite odabrati:");
                int brojZeljenogSimptoma = unos.nextInt();
                simptomiBolesti.add(simptomi.get(brojZeljenogSimptoma - 1));
            }

            System.out.println("Molimo napisite 1 ako je bolest zarazna ili 2 ako bolest nije zarazna: ");
            int provjeraZaraze = unos.nextInt();
            if (provjeraZaraze == 1)
                zarazna = true;
            else
                zarazna = false;

            bolesti.add(new Bolest(nazivBolesti, simptomiBolesti, zarazna));

        }

        System.out.println("Molimo vas napisite koliko je potrebno osoba unijeti: ");
        int brojOsoba = unos.nextInt();

        for (i = 0; i < brojOsoba; i++) {
            unos.nextLine();
            System.out.println("Molimo unesite ime osobe: ");
            String imeOsobe = unos.nextLine();
            System.out.println("Molimo unesite prezime osobe: ");
            String prezimeOsobe = unos.nextLine();

            if (imeOsobe == "Tea" && prezimeOsobe == "Grabusic") {
                break;
            }

            System.out.println("Moguci odabir bolesti: ");
            for (int k = 0; k < brojBolesti; k++) {
                System.out.println((k + 1) + ") " + bolesti.get(k).getNaziv());
            }
            System.out.println("Unesite broj ispred bolesti kojom je osoba zarazena:");
            int brojZeljeneBolesti = unos.nextInt();
            Bolest zarazenaBolescu = bolesti.get(brojZeljeneBolesti - 1);
            kontaktiraneOsobe.clear();
            osobe.add(new Osoba(imeOsobe, prezimeOsobe, zarazenaBolescu, kontaktiraneOsobe));
        }

        for (int j = 0; j < i; j++) {
            System.out.println("S koliko ljudi je bila " + (j + 1) + ". osoba u kontaktu: ");
            int brojKontakata = unos.nextInt();
            ArrayList<Osoba> kontakti = new ArrayList<>();

            for (int l = 0; l < brojKontakata; l++) {
                System.out.println("Moguci odabir kontaktiranih ljudi: ");
                for (int k = 0; k < i; k++) {
                    System.out.println((k + 1) + ") " + osobe.get(k).getIme());
                }

                System.out.println("Unesite broj ispred osobe s kojom je osoba bila u kontaktu:");
                int brojZeljenogKontakta = unos.nextInt();
                kontakti.add(osobe.get(brojZeljenogKontakta - 1));
            }
            osobe.get(j).setKontaktiraneOsobe(kontakti);
        }


        for (int j = 0; j < i; j++) {
            if (osobe.get(j).getZarazenaBolescu().getZarazna() == true) {
                for (int k = 0; k < osobe.get(j).getKontaktiraneOsobe().size(); k++) {
                    for (int l = 0; l < i; l++) {
                        if (osobe.get(l).equals(osobe.get(j).getKontaktiraneOsobe().get(k))) {
                            osobe.get(l).setZarazenaBolescu(osobe.get(j).getZarazenaBolescu());
                        }
                    }
                }
            }
        }

        for (int j = 0; j < i; j++) {
            System.out.println("Ime i prezime: " + osobe.get(j).getIme() + " " + osobe.get(j).getPrezime());
            System.out.println("Zarazena bolescu: " + osobe.get(j).getZarazenaBolescu().getNaziv());
            System.out.println("Simptomi te bolesti su:");
            ArrayList<Simptom> simptomiBolestiIspis = osobe.get(j).getZarazenaBolescu().getSimptomi();
            for (int k = 0; k < simptomiBolestiIspis.size(); k++) {
                System.out.println(simptomiBolestiIspis.get(k).getNaziv() + "; "
                        + simptomiBolestiIspis.get(k).getVrijednost());
            }
        }
    }
}
