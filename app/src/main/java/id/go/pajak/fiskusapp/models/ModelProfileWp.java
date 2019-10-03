package id.go.pajak.fiskusapp.models;

public class ModelProfileWp {

    private String kdStatus;
    private DetailProfileWP detailProfileWP = new DetailProfileWP();

    public ModelProfileWp() {
    }

    public String getKdStatus() {
        return kdStatus;
    }

    public void setKdStatus(String kdStatus) {
        this.kdStatus = kdStatus;
    }

    public DetailProfileWP getDetailProfileWP() {
        return detailProfileWP;
    }

    public void setDetailProfileWP(DetailProfileWP detailProfileWP) {
        this.detailProfileWP = detailProfileWP;
    }

    @Override
    public String toString() {
        return "Data Wajib Pajak\n" +
                detailProfileWP.toString();
    }
}
