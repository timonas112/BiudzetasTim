package lt.codeacademy.biudzetas;

import lt.codeacademy.biudzetas.irasai.Irasas;
import lt.codeacademy.biudzetas.irasai.IslaiduIrasas;
import lt.codeacademy.biudzetas.irasai.PajamuIrasas;
import lt.codeacademy.biudzetas.kategorijos.IslaiduKategorija;
import lt.codeacademy.biudzetas.kategorijos.PajamuKategorija;
import lt.codeacademy.biudzetas.saugykla.Failas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Biudzetas biudzetas = new Biudzetas();

        Scanner sc = new Scanner(System.in);

        boolean testiPrograma = true;

        while (testiPrograma) {
            int pasirinkimas = pagrindinisMeniu(sc);
            switch (pasirinkimas) {
                case 1:
                    int irasoPasirinkimas = irasoPasirinkimas(sc);
                    switch (irasoPasirinkimas) {
                        case 1: biudzetas.pridetiIrasa(naujasPajamuIrasas(sc));
                                break;
                        case 2: biudzetas.pridetiIrasa(naujasIslaiduIrasas(sc));
                                break;
                    }
                    break;
                case 2:
                    int irasuPasirinkimas = irasuPasirinkimas(sc);
                    switch (irasuPasirinkimas) {
                        case 1: spausdintiIrasus(biudzetas.gautiVisusPajamuIrasus());
                                break;
                        case 2: spausdintiIrasus(biudzetas.gautiVisusIslaiduIrasus());
                                break;
                        case 3: spausdintiIrasus(biudzetas.gautiVisusIrasus());
                                break;
                    }
                    break;
                case 3:
                    trintiIrasa(sc, biudzetas);
                    break;
                case 4:
                    redaguotiIrasa(sc, biudzetas);
                    break;
                case 5:
                    rodytiBalansa(biudzetas);
                    break;
                case 6:
                    biudzetas.gautiVisusIrasus().addAll(Failas.gautiDuomenis());
                    break;
                case 7:
                    Failas.issaugotiDuomenis(biudzetas.gautiVisusIrasus());
                    break;
                case 8:
                    testiPrograma = false;
                    break;
            }
        }

        sc.close();
    }

    private static int pagrindinisMeniu(Scanner scanner) {
        System.out.println("[1] - Sukurti nauja irasa\n" +
                            "[2] - Gauti irasa \n" +
                            "[3] - Trinti irasa\n" +
                            "[4] - Redaguoti irasa\n" +
                            "[5] - Balansas\n" +
                            "[6] - Gauti is failo\n" +
                            "[7] - Saugoti i faila\n" +
                            "[8] - Uzdaryti programa");
        return skaiciausPasirinkimas(scanner, 1, 2, 3, 4, 5, 6, 7, 8);
    }

    private static int irasoPasirinkimas(Scanner scanner) {
        System.out.println("[1] - pajamu irasas\n" +
                            "[2] - islaidu irasas");
        return skaiciausPasirinkimas(scanner, 1, 2);
    }


    private static Irasas naujasPajamuIrasas(Scanner scanner) {
        PajamuIrasas pajamuIrasas = new PajamuIrasas();

        System.out.print("Suma: ");
        pajamuIrasas.setSuma(ivestiSuma(scanner));

        System.out.println("Kategorija: ");
        for(PajamuKategorija pk : PajamuKategorija.values()) {
            System.out.println(pk);
        }
        pajamuIrasas.setKategorija(pajamuKategorijosPasirinkimas(scanner));

        System.out.println("papildoma informacija:");
        pajamuIrasas.setPapildomaInfo(tekstoIvedimas(scanner));

        pajamuIrasas.setData(LocalDate.now());

        return pajamuIrasas;
    }

    private static int irasuPasirinkimas(Scanner scanner) {
        System.out.println("[1] - pajamu irasai\n" +
                "[2] - islaidu irasai\n" +
                "[3] - visi irasai");
        return skaiciausPasirinkimas(scanner, 1, 2, 3);
    }

    private static float ivestiSuma(Scanner scanner) {
        float suma = 0;
        boolean neivesta = true;
        while (neivesta) {
            String ivestiDuomenys = scanner.next();
            try {
                suma = Float.parseFloat(ivestiDuomenys);
                neivesta = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Klaida! Ivestas ne skaicius");
            }
        }
        return suma;
    }

    private static PajamuKategorija pajamuKategorijosPasirinkimas(Scanner scanner) {
        PajamuKategorija kategorija = null;
        boolean neivesta = true;
        while (neivesta) {
            String ivestiDuomenys = scanner.next();
            try {
                int skaicius = Integer.parseInt(ivestiDuomenys);
                kategorija = PajamuKategorija.kategorijaPagalNumeri(skaicius);
                if (kategorija != null) {
                    neivesta = false;
                } else {
                    System.out.println("Kategorija nerasta");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Klaida! Ivestas ne skaicius");
            }
        }
        return kategorija;
    }

    private static IslaiduKategorija islaiduKategorijosPasirinkimas(Scanner scanner) {
        IslaiduKategorija kategorija = null;
        boolean neivesta = true;
        while (neivesta) {
            String ivestiDuomenys = scanner.next();
            try {
                int skaicius = Integer.parseInt(ivestiDuomenys);
                kategorija = IslaiduKategorija.kategorijaPagalNumeri(skaicius);
                if (kategorija != null) {
                    neivesta = false;
                } else {
                    System.out.println("Kategorija nerasta");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Klaida! Ivestas ne skaicius");
            }
        }
        return kategorija;
    }
    private static Irasas naujasIslaiduIrasas(Scanner scanner) {
        IslaiduIrasas islaiduIrasas = new IslaiduIrasas();

        System.out.print("Suma: ");
        islaiduIrasas.setSuma(ivestiSuma(scanner));

        System.out.println("Kategorija: ");
        for(IslaiduKategorija ik : IslaiduKategorija.values()) {
            System.out.println(ik);
        }
        islaiduIrasas.setKategorija(islaiduKategorijosPasirinkimas(scanner));

        System.out.println("papildoma informacija:");
        islaiduIrasas.setPapildomaInfo(tekstoIvedimas(scanner));

        islaiduIrasas.setData(LocalDate.now());

        return islaiduIrasas;
    }

    private static String tekstoIvedimas(Scanner scanner) {
        String tekstas = scanner.next();
        return tekstas;
    }

    private static int skaiciausPasirinkimas(Scanner scanner, int... leistinosReiksmes) {
        int pasirinkimas = 0;
        boolean neivesta = true;
        while (neivesta) {
            String ivestiDuomenys = scanner.next();
            try {
                pasirinkimas = Integer.parseInt(ivestiDuomenys);
                if (leistinosReiksmes.length == 0 || arSkaiciusYraSarase(leistinosReiksmes, pasirinkimas)) {
                    neivesta = false;
                } else {
                    System.out.println("Nezinoma komanda");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Klaida! Ivestas ne skaicius");
            }
        }
        return pasirinkimas;
    }

    private static boolean arSkaiciusYraSarase(final int[] skaiciuSarasas, final int skaicius) {
        boolean result = false;
        for (int i : skaiciuSarasas) {
            if (i == skaicius) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static void spausdintiIrasus(ArrayList<Irasas> irasai) {
        System.out.println("-_-____________________-_-");
        for (Irasas irasas : irasai) {
            System.out.println(irasas);
        }
        System.out.println("-_-____________________-_-");
    }

    private static void trintiIrasa(Scanner scanner, Biudzetas biudzetas) {
        System.out.println("Iveskite Id");
        long pasirinktasId = skaiciausPasirinkimas(scanner);
        biudzetas.pasalintiIrasa(pasirinktasId);
    }

    private static void redaguotiIrasa(Scanner scanner, Biudzetas biudzetas) {
        System.out.println("Iveskite Id");
        long pasirinktasId = skaiciausPasirinkimas(scanner);
        Irasas irasas = biudzetas.gautiIrasaPagalId(pasirinktasId);

        if (irasas != null) {

            System.out.print("Suma: " + irasas.getSuma() + ". Redaguoti: T - taip, N - ne");
            String atsakymas = scanner.next();
            if (atsakymas.toUpperCase().equals("T"))
                irasas.setSuma(ivestiSuma(scanner));

            if (irasas instanceof PajamuIrasas) {
                System.out.println("Kategorija: " + ((PajamuIrasas) irasas).getKategorija().getPaaiskinimas() + ". Redaguoti: ( T ) - taip, ( N ) - ne");
                atsakymas = scanner.next();
                if (atsakymas.toUpperCase().equals("T")) {
                    for (PajamuKategorija ik : PajamuKategorija.values()) {
                        System.out.println(ik);
                    }
                    ((PajamuIrasas) irasas).setKategorija(pajamuKategorijosPasirinkimas(scanner));
                }
            } else if (irasas instanceof IslaiduIrasas) {
                System.out.println("Kategorija: " + ((IslaiduIrasas) irasas).getKategorija().getPaaiskinimas() + ". Redaguoti: ( T ) - taip, ( N ) - ne");
                atsakymas = scanner.next();
                if (atsakymas.toUpperCase().equals("T")) {
                    for (IslaiduKategorija ik : IslaiduKategorija.values()) {
                        System.out.println(ik);
                    }
                    ((IslaiduIrasas) irasas).setKategorija(islaiduKategorijosPasirinkimas(scanner));
                }
            }

            System.out.println("papildoma informacija: " + irasas.getSuma() + ". Regaguoti: ( T ) - taip, ( N ) - ne");
            atsakymas = scanner.next();
            if (atsakymas.toUpperCase().equals("T"))
                irasas.setPapildomaInfo(tekstoIvedimas(scanner));

            biudzetas.atnaujintiIrasa(irasas);
        } else {
            System.out.println("Irasas nerastas");
        }

    }

    private static void rodytiBalansa(Biudzetas biudzetas) {
        float balansas = biudzetas.balansas();
        System.out.println(String.format("Balansas: %.2fEur", balansas));
    }

}
