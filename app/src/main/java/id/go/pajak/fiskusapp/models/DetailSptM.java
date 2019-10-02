package id.go.pajak.fiskusapp.models;

public class DetailSptM {
    private String kdStatusSptM;
    private String ketStatusSptM;

    public DetailSptM() {
    }

    public DetailSptM(String kdStatusSptM, String ketStatusSptM) {
        this.kdStatusSptM = kdStatusSptM;
        this.ketStatusSptM = ketStatusSptM;
    }

    public String getKdStatusSptM() {
        return kdStatusSptM;
    }

    public void setKdStatusSptM(String kdStatusSptM) {
        this.kdStatusSptM = kdStatusSptM;
    }

    public String getKetStatusSptM() {
        return ketStatusSptM;
    }

    public void setKetStatusSptM(String ketStatusSptM) {
        this.ketStatusSptM = ketStatusSptM;
    }
}
