package ordination;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DagligSkaev {
    private List<Dosis>doser = new ArrayList<>();
    //DagligSkæv har composition til Ordination
    private Ordination ordination;

    public Ordination getOrdination() {
        return ordination;
    }

    public void setOrdination(Ordination ordination) {
        this.ordination = ordination;
    }

    public void opretDosis(LocalTime tid, double antal) {
        doser.add(new Dosis(tid, antal));
    }
    public Dosis[] getDoser() {
        return new Dosis[0];
    }
}
