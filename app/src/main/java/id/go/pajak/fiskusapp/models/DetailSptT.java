package id.go.pajak.fiskusapp.models;

public class DetailSptT {
    private String kdStatusSptT;
    private String ketStatusSptT;
    private String dataBpsSpt1;
    private String thnSpt1;
    private String tglTerimaSpt1;
    private String dataBpsSpt2;
    private String thnSpt2;
    private String tglTerimaSpt2;

    public DetailSptT() {

    }

    public DetailSptT(String kdStatusSptT, String ketStatusSptT, String dataBpsSpt1, String thnSpt1, String tglTerimaSpt1, String dataBpsSpt2, String thnSpt2, String tglTerimaSpt2) {
        this.kdStatusSptT = kdStatusSptT;
        this.ketStatusSptT = ketStatusSptT;
        this.dataBpsSpt1 = dataBpsSpt1;
        this.thnSpt1 = thnSpt1;
        this.tglTerimaSpt1 = tglTerimaSpt1;
        this.dataBpsSpt2 = dataBpsSpt2;
        this.thnSpt2 = thnSpt2;
        this.tglTerimaSpt2 = tglTerimaSpt2;
    }

    public String getKdStatusSptT() {
        return kdStatusSptT;
    }

    public void setKdStatusSptT(String kdStatusSptT) {
        this.kdStatusSptT = kdStatusSptT;
    }

    public String getKetStatusSptT() {
        return ketStatusSptT;
    }

    public void setKetStatusSptT(String ketStatusSptT) {
        this.ketStatusSptT = ketStatusSptT;
    }

    public String getDataBpsSpt1() {
        return dataBpsSpt1;
    }

    public void setDataBpsSpt1(String dataBpsSpt1) {
        this.dataBpsSpt1 = dataBpsSpt1;
    }

    public String getThnSpt1() {
        return thnSpt1;
    }

    public void setThnSpt1(String thnSpt1) {
        this.thnSpt1 = thnSpt1;
    }

    public String getTglTerimaSpt1() {
        return tglTerimaSpt1;
    }

    public void setTglTerimaSpt1(String tglTerimaSpt1) {
        this.tglTerimaSpt1 = tglTerimaSpt1;
    }

    public String getDataBpsSpt2() {
        return dataBpsSpt2;
    }

    public void setDataBpsSpt2(String dataBpsSpt2) {
        this.dataBpsSpt2 = dataBpsSpt2;
    }

    public String getThnSpt2() {
        return thnSpt2;
    }

    public void setThnSpt2(String thnSpt2) {
        this.thnSpt2 = thnSpt2;
    }

    public String getTglTerimaSpt2() {
        return tglTerimaSpt2;
    }

    public void setTglTerimaSpt2(String tglTerimaSpt2) {
        this.tglTerimaSpt2 = tglTerimaSpt2;
    }
}
