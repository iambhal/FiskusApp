package id.go.pajak.fiskusapp.models;

public class DetailKepatuhanWP {
    private String kdStatusWP;
    private String statusSKF;
    private DetailWP detailWP = new DetailWP();
    private DetailSptT detailSptT = new DetailSptT();
    private DetailSptM detailSptM = new DetailSptM();
    private DetailUtang detailUtang = new DetailUtang();
    private DetailPenyidikan detailPenyidikan = new DetailPenyidikan();

    public DetailKepatuhanWP() {
    }

    public DetailKepatuhanWP(String kdStatusWP, String statusSKF, DetailWP detailWP, DetailSptT detailSptT, DetailSptM detailSptM, DetailUtang detailUtang, DetailPenyidikan detailPenyidikan) {
        this.kdStatusWP = kdStatusWP;
        this.statusSKF = statusSKF;
        this.detailWP = detailWP;
        this.detailSptT = detailSptT;
        this.detailSptM = detailSptM;
        this.detailUtang = detailUtang;
        this.detailPenyidikan = detailPenyidikan;
    }

    public String getKdStatusWP() {
        return kdStatusWP;
    }

    public void setKdStatusWP(String kdStatusWP) {
        this.kdStatusWP = kdStatusWP;
    }

    public String getStatusSKF() {
        return statusSKF;
    }

    public void setStatusSKF(String statusSKF) {
        this.statusSKF = statusSKF;
    }

    public DetailWP getDetailWP() {
        return detailWP;
    }

    public void setDetailWP(DetailWP detailWP) {
        this.detailWP = detailWP;
    }

    public DetailSptT getDetailSptT() {
        return detailSptT;
    }

    public void setDetailSptT(DetailSptT detailSptT) {
        this.detailSptT = detailSptT;
    }

    public DetailSptM getDetailSptM() {
        return detailSptM;
    }

    public void setDetailSptM(DetailSptM detailSptM) {
        this.detailSptM = detailSptM;
    }

    public DetailUtang getDetailUtang() {
        return detailUtang;
    }

    public void setDetailUtang(DetailUtang detailUtang) {
        this.detailUtang = detailUtang;
    }

    public DetailPenyidikan getDetailPenyidikan() {
        return detailPenyidikan;
    }

    public void setDetailPenyidikan(DetailPenyidikan detailPenyidikan) {
        this.detailPenyidikan = detailPenyidikan;
    }
}
