package ordination;

import java.time.LocalDate;

public class DagligFast extends Ordination {
    private Dosis[] doser;

    public DagligFast(LocalDate startDato, LocalDate slutdato, Lægemiddel laegemiddel, Dosis[] doser) {
        super(startDato, slutdato, laegemiddel);
        this.doser = doser;
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
