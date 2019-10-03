package id.go.pajak.fiskusapp.models;

public class DetailSptM {
    public String KEY_kdStatusSptM = "kd_statusSPTm";
    public String KEY_ketStatusSptM = "ketStatusSPTm";

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

    @Override
    public String toString() {
        return "\nKepatuhan Pelaporan SPT Masa : " + ketStatusSptM +"\n" ;
    }
}
