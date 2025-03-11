package ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination{
    private Dosis[] dosisArray = new Dosis[4];

    public DagligFast(LocalDate startDato, LocalDate slutDato, Laegemiddel laegemiddel) {
        super(startDato, slutDato, laegemiddel);
    }

    public void createDosis(double dosis1, double dosis2, double dosis3, double dosis4){
        dosisArray[0] = new Dosis(LocalTime.of(6,0), dosis1);
        dosisArray[1] = new Dosis(LocalTime.of(12,0), dosis2);
        dosisArray[2] = new Dosis(LocalTime.of(18,0), dosis3);
        dosisArray[3] = new Dosis(LocalTime.of(22,0), dosis4);
    }

    @Override
    public double samletDosis() {
        return doegnDosis() * super.antalDage();
    }

    @Override
    public double doegnDosis() {
        double doegnDosis = 0;
        for (Dosis dosis : dosisArray) {
            doegnDosis += dosis.getAntal();
        }
        return doegnDosis;
    }

    public Dosis[] getDoser() {
        return dosisArray;
    }

    @Override
    public String getType() {
        return "Daglig fast";
    }
}
