package lt.codeacademy.biudzetas.saugykla;

import lt.codeacademy.biudzetas.irasai.Irasas;
import lt.codeacademy.biudzetas.irasai.IslaiduIrasas;
import lt.codeacademy.biudzetas.irasai.PajamuIrasas;
import lt.codeacademy.biudzetas.kategorijos.IslaiduKategorija;
import lt.codeacademy.biudzetas.kategorijos.PajamuKategorija;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Failas {

    public static void issaugotiDuomenis(ArrayList<Irasas> irasuSarasas) {
        PrintWriter out = null;
        try {
            FileWriter failuWriteris = new FileWriter("src/failas.csv", false);
            BufferedWriter bufferWriteris = new BufferedWriter(failuWriteris);
            out = new PrintWriter(bufferWriteris);
            for (Irasas irasas : irasuSarasas) {
                out.println(irasas.iFaila());
            }
        } catch (IOException e) {
            System.out.println("Nepavyko irasyti i faila.");
        } finally {
            out.close();
        }

    }

    

    private static Irasas irasasIsFailoDuomenu(String csv) {
        String[] duomenys = csv.split(",");
        Irasas irasas = null;
        if (PajamuIrasas.IRASO_TIPAS.equals(duomenys[0])) {
            PajamuIrasas pi = new PajamuIrasas();
            pi.setId(Long.parseLong(duomenys[1]));
            pi.setSuma(Float.parseFloat(duomenys[2]));
            pi.setData(LocalDate.parse(duomenys[3]));
            pi.setPapildomaInfo(duomenys[4]);
            pi.setKategorija(PajamuKategorija.kategorijaPagalNumeri(Integer.parseInt(duomenys[5])));
            irasas = pi;
        } else if (IslaiduIrasas.IRASO_TIPAS.equals(duomenys[0])) {
            IslaiduIrasas ii = new IslaiduIrasas();
            ii.setId(Long.parseLong(duomenys[1]));
            ii.setSuma(Float.parseFloat(duomenys[2]));
            ii.setData(LocalDate.parse(duomenys[3]));
            ii.setPapildomaInfo(duomenys[4]);
            ii.setKategorija(IslaiduKategorija.kategorijaPagalNumeri(Integer.parseInt(duomenys[5])));
            irasas = ii;
        }
        return irasas;
    }
    public static ArrayList<Irasas> gautiDuomenis() {
        ArrayList<Irasas> irasai = new ArrayList<>();
        BufferedReader readeris = null;
        try {
            File failas = new File("src/failas.csv");
            FileInputStream fileInput = new FileInputStream(failas);
            readeris = new BufferedReader(new InputStreamReader(fileInput));
            String line;
            while ((line = readeris.readLine()) != null) {
                irasai.add(irasasIsFailoDuomenu(line));
            }
        } catch (IOException e) {
            System.out.println("Nepavyko nuskaityt duomenu!");
        } finally {
            try {
                readeris.close();
            } catch (IOException e) {
                System.out.println("Nepavyko nuskaityti Readerio!");
            }
        }
        return irasai;
    }

}
