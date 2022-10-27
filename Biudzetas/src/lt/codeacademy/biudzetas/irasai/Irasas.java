package lt.codeacademy.biudzetas.irasai;

import java.time.LocalDate;

public class Irasas {

    private static long counter = 0;

    private long id;
    private float suma;
    private LocalDate data;
    private String papildomaInfo;

    public Irasas() {
        this.id = counter++;
    }

    public Irasas(float suma, LocalDate data, String papildomaInfo) {
        this();
        this.suma = suma;
        this.data = data;
        this.papildomaInfo = papildomaInfo;
    }

    @Override
    public String toString() {
        return String.format("id=%d, suma=%.2fEur, data=%s, papildoma_info=%s", id, suma, data, papildomaInfo);
    }

    public String iFaila() {
        return String.format("%d,%s,%s,%s", id, suma, data, papildomaInfo);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Irasas && id == ((Irasas)o).getId()) {
            return true;
        } else {
            return false;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getSuma() {
        return suma;
    }

    public void setSuma(float suma) {
        this.suma = suma;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getPapildomaInfo() {
        return papildomaInfo;
    }

    public void setPapildomaInfo(String papildomaInfo) {
        this.papildomaInfo = papildomaInfo;
    }
}
