package ordination;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;

public class PN {

    private LocalDate startDato;
    private LocalDate slutDato;
    private LocalDate sidsteDosis;
    private double antalEnheder;
    private Laegemiddel laegemiddel;
    private int antalGangeGivet = 0;

    public PN(LocalDate startDato, LocalDate slutDato, double antalEnheder, Laegemiddel laegemiddel) {
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.antalEnheder = antalEnheder;
        this.laegemiddel = laegemiddel;
    }

    /**
     * Registrerer at der er givet en dosis paa dagen givetDato
     * Returnerer true hvis givetDato er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givetDato ignoreres
     *
     * @param givetDato
     * @return
     */
    public boolean givDosis(LocalDate givetDato) {
        // Checker om dosis bliver givet i en valid periode. Hvis dosis bliver givet udenfor perioden, retuneres false
        if (givetDato.isAfter(startDato.minusDays(1)) && givetDato.isBefore(slutDato.plusDays(1))) {
            sidsteDosis = givetDato;
            antalGangeGivet++;
            return true;
        }
        return false;
    }

    public double doegnDosis() {
        // Finder antal dage mellem startdatoen og slutdatoen
        long dageImellemDosis = ChronoUnit.DAYS.between(startDato, slutDato);
        // Udregner døgndosis baseret på antallet af enhededr og antallet af dage mellem doseringer
        return (antalEnheder * antalGangeGivet) / dageImellemDosis;
    }


    public double samletDosis() {
        // Finder antal dage mellem startdatoen og slutdatoen
        long dageImellemDosis = ChronoUnit.DAYS.between(startDato, slutDato);
        return antalEnheder * dageImellemDosis;
    }
    /**
     * Returnerer antal gange ordinationen er anvendt
     *
     * @return
     */
    public int getAntalGangeGivet() {
        return antalGangeGivet;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

    public Laegemiddel getLaegemiddel() {
        return laegemiddel;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }
}
