package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Ordination {
    private LocalDate startDato;
    private LocalDate slutDato;

    private Laegemiddel laegemiddel;

    public Ordination(LocalDate startDato, LocalDate slutDato) {
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public Ordination(LocalDate startDato, LocalDate slutDato, Laegemiddel laegemiddel) {
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.laegemiddel = laegemiddel;
    }

    public void setLaegemiddel(Laegemiddel laegemiddel) {
        this.laegemiddel = laegemiddel;
    }

    // TODO Link til Laegemiddel
    // TODO constructor

    public LocalDate getStartDato() {
        return startDato;
    }	

    public LocalDate getSlutDato() {
        return slutDato;
    }

    /**
     * Antal hele dage mellem startdato og slutdato. Begge dage inklusive.
     * @return antal dage ordinationen gælder for
     */
    public int antalDage() {
        return (int) ChronoUnit.DAYS.between(startDato, slutDato) + 1;
    }

    @Override
    public String toString() {
        return startDato.toString();
    }

    /**
     * Returnerer den totale dosis der er givet i den periode ordinationen er gyldig
     * @return
     */
    public abstract double samletDosis();

    /**
     * Returnerer den gennemsnitlige dosis givet pr dag i den periode ordinationen er gyldig
     * @return
     */
    public abstract double doegnDosis();

    /**
     * Returnerer ordinationstypen som en String
     * @return
     */
    public abstract String getType();
}
