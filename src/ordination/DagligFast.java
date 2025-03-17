package ordination;

import java.time.LocalDate;

public class DagligFast extends Ordination {
    private Dosis[] doser;
    private double morgenAntal;
    private double middagAntal;
    private double aftenAntal;
    private double natAntal;

    public DagligFast(LocalDate startDato, LocalDate slutDato, Laegemiddel laegemiddel, double morgenAntal, double middagAntal, double aftenAntal, double natAntal){
        super(startDato,slutDato,laegemiddel);
        this.morgenAntal = morgenAntal;
        this.middagAntal = middagAntal;
        this.aftenAntal = aftenAntal;
        this.natAntal = natAntal;

    }


    public Dosis[] getDoser() {
        return doser;
    }

    @Override
    public double samletDosis() {
        double totalDosis = 0;
        for (Dosis dosis : doser) {
            totalDosis += dosis.getAntal();
        }
        return totalDosis * antalDage();
    }

    @Override
    public double doegnDosis() {
        double totalDosis = 0;
        for (Dosis dosis : doser) {
            totalDosis += dosis.getAntal();
        }
        return totalDosis;
    }

    @Override
    public String getType() {
        return "DagligFast";
    }
}
