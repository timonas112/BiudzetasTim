package lt.codeacademy.biudzetas.kategorijos;

public enum IslaiduKategorija {

    TRANSPORTAS(1, "transportas"),
    MAISTAS(2, "maistas"),
    MOKESCIAI(3, "mokesciai");

    private int numeris;
    private String paaiskinimas;

    IslaiduKategorija(int i, String x) {
        numeris = i;
        paaiskinimas = x;
    }

    public static IslaiduKategorija kategorijaPagalNumeri(int i){
        for(IslaiduKategorija ik : values()){
            if( ik.getNumeris() == i){
                return ik;
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
