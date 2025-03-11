package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination{
    ArrayList<Dosis> dosisArrayList = new ArrayList<>();

    public DagligSkaev(LocalDate startDato, LocalDate slutDato, Laegemiddel laegemiddel) {
        super(startDato, slutDato, laegemiddel);
    }

    @Override
    public double samletDosis() {
        return doegnDosis() * antalDage();
    }

    @Override
    public double doegnDosis() {
        double doegnDosis = 0;
        for (Dosis dosis : dosisArrayList) {
            doegnDosis+= dosis.getAntal();
        }
        return doegnDosis;
    }

    @Override
    public String getType() {
        return "Daglig Skæv";
    }

    public ArrayList<Dosis> getDoser() {
        return dosisArrayList;
    }

    public void opretDosis(LocalTime tid, double antal) {
        dosisArrayList.add(new Dosis(tid, antal));
    }
}
