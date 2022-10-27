package lt.codeacademy.biudzetas.irasai;

import lt.codeacademy.biudzetas.kategorijos.PajamuKategorija;

import java.time.LocalDate;

public class PajamuIrasas extends Irasas {

    public static final String IRASO_TIPAS = "pajamu_irasas";

    private PajamuKategorija kategorija;

    public PajamuIrasas() {
        super();
    }

    public PajamuIrasas(float suma, LocalDate data, String papildomaInfo, PajamuKategorija kategorija) {
        super(suma, data, papildomaInfo);
        this.kategorija = kategorija;
    }

    @Override
    public String toString() {
        return String.format(IRASO_TIPAS + ", kategorija=%s, %s", kategorija, super.toString());
    }

    @Override
    public String iFaila() {
        return String.format("%s,%s,%s", IRASO_TIPAS, super.iFaila(), kategorija.getNumeris());
    }

    public PajamuKategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(PajamuKategorija kategorija) {
        this.kategorija = kategorija;
    }
}
