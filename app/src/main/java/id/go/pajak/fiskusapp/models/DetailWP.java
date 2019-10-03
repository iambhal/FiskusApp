package id.go.pajak.fiskusapp.models;

public class DetailWP {
    public String KEY_kdStatusWP = "kd_statusWP";
    public String KEY_statusWP = "statusWP";
    public String KEY_npwp15 = "npwp15";
    public String KEY_namaWP = "namaWP";
    public String KEY_tglDaftar = "tglDaftar";

    private String kdStatusWP;
    private String statusWP;
    private String npwp15;
    private String namaWP;
    private String tglDaftar;

    public DetailWP() {
    }

    public DetailWP(String kdStatusWP, String statusWP, String npwp15, String namaWP, String tglDaftar) {
        this.kdStatusWP = kdStatusWP;
        this.statusWP = statusWP;
        this.npwp15 = npwp15;
        this.namaWP = namaWP;
        this.tglDaftar = tglDaftar;
    }

    public String getKdStatusWP() {
        return kdStatusWP;
    }

    public void setKdStatusWP(String kdStatusWP) {
        this.kdStatusWP = kdStatusWP;
    }

    public String getStatusWP() {
        return statusWP;
    }

    public void setStatusWP(String statusWP) {
        this.statusWP = statusWP;
    }

    public String getNpwp15() {
        return npwp15;
    }

    public void setNpwp15(String npwp15) {
        this.npwp15 = npwp15;
    }

    public String getNamaWP() {
        return namaWP;
    }

    public void setNamaWP(String namaWP) {
        this.namaWP = namaWP;
    }

    public String getTglDaftar() {
        return tglDaftar;
    }

    public void setTglDaftar(String tglDaftar) {
        this.tglDaftar = tglDaftar;
    }

    @Override
    public String toString() {
        return "\nNPWP   : " + npwp15 + "\n" +
                "Nama   : " + namaWP + "\n" +
                "Terdaftar : " + tglDaftar +"\n" ;
    }
}
