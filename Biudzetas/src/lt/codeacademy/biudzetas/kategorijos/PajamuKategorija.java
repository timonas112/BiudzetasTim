package lt.codeacademy.biudzetas.kategorijos;

public enum PajamuKategorija {

    ATLYGINIMAS(1, "atlyginimas"),
    STIPENDIJA(2, "stipendija");

    private int numeris;
    private String paaiskinimas;

    PajamuKategorija(int i, String x) {
        numeris = i;
        paaiskinimas = x;
    }

    public static PajamuKategorija kategorijaPagalNumeri(int i){
        for(PajamuKategorija pk : values()){
            if( pk.getNumeris() == i){
                return pk;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("[%d] - %s", numeris, paaiskinimas);
    }

    public int getNumeris() {
        return numeris;
    }

    public String getPaaiskinimas() {
        return paaiskinimas;
    }

}
