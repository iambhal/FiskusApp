package id.go.pajak.fiskusapp.models;

public class ModelKepatuhanWP {
    private String kdStatus;
    private DetailKepatuhanWP detailKepatuhanWP = new DetailKepatuhanWP();

    public ModelKepatuhanWP() {
    }

    public ModelKepatuhanWP(String kdStatus, DetailKepatuhanWP detailKepatuhanWP) {
        this.kdStatus = kdStatus;
        this.detailKepatuhanWP = detailKepatuhanWP;
    }

    public String getKdStatus() {
        return kdStatus;
    }

    public void setKdStatus(String kdStatus) {
        this.kdStatus = kdStatus;
    }

    public DetailKepatuhanWP getDetailKepatuhanWP() {
        return detailKepatuhanWP;
    }

    public void setDetailKepatuhanWP(DetailKepatuhanWP detailKepatuhanWP) {
        this.detailKepatuhanWP = detailKepatuhanWP;
    }
}
