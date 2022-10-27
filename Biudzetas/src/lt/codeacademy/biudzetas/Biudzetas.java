package lt.codeacademy.biudzetas;

import lt.codeacademy.biudzetas.irasai.Irasas;
import lt.codeacademy.biudzetas.irasai.IslaiduIrasas;
import lt.codeacademy.biudzetas.irasai.PajamuIrasas;

import java.util.ArrayList;

public class Biudzetas {

    private ArrayList<Irasas> irasuSarasas = new ArrayList<>();

    public void pridetiIrasa(Irasas irasas) {
        irasuSarasas.add(irasas);
    }

    public Irasas gautiIrasaPagalId(long id) {
        for (Irasas irasas : irasuSarasas) {
            if (irasas.getId() == id) {
                return irasas;
            }
        }

        return null;
    }

    public ArrayList<Irasas> gautiVisusPajamuIrasus() {
        ArrayList<Irasas> pajamuIrasuSarasas = new ArrayList<>();
        for (Irasas irasas : irasuSarasas) {
            if (irasas instanceof PajamuIrasas) {
                pajamuIrasuSarasas.add(irasas);
            }
        }
        return pajamuIrasuSarasas;
    }

    public ArrayList<Irasas> gautiVisusIslaiduIrasus() {
        ArrayList<Irasas> islaiduIrasuSarasas = new ArrayList<>();
        for (Irasas irasas : irasuSarasas) {
            if (irasas instanceof IslaiduIrasas) {
                islaiduIrasuSarasas.add(irasas);
            }
        }
        return islaiduIrasuSarasas;
    }

    public ArrayList<Irasas> gautiVisusIrasus() {
        return irasuSarasas;
    }

    public float balansas() {
        float balansas = 0;
        for(Irasas irasas : irasuSarasas) {
            if (irasas instanceof PajamuIrasas) {
                balansas += irasas.getSuma();
            } else if (irasas instanceof IslaiduIrasas) {
                balansas -= irasas.getSuma();
            }
        }
        return balansas;
    }

    public boolean pasalintiIrasa(long id) {
        Irasas tusciasIrasas = new Irasas();
        tusciasIrasas.setId(id);
        return irasuSarasas.remove(tusciasIrasas);
    }

    public boolean atnaujintiIrasa(Irasas irasas) {
        pasalintiIrasa(irasas.getId());
        return irasuSarasas.add(irasas);
    }

}
