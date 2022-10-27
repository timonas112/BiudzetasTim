package lt.codeacademy.biudzetas.irasai;

import lt.codeacademy.biudzetas.kategorijos.IslaiduKategorija;

import java.time.LocalDate;

public class IslaiduIrasas extends Irasas {

    public static final String IRASO_TIPAS = "islaidu_irasas";

    private IslaiduKategorija kategorija;

    public IslaiduIrasas() {
        super();
    }

    public IslaiduIrasas(float suma, LocalDate data, String papildomaInfo, IslaiduKategorija kategorija) {
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

    public IslaiduKategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(IslaiduKategorija kategorija) {
        this.kategorija = kategorija;
    }
}
