package id.go.pajak.fiskusapp.models;

public class DetailUtang {
    private String kdStatusUtang;
    private String ketStatusUtang;

    public DetailUtang() {
    }

    public DetailUtang(String kdStatusUtang, String ketStatusUtang) {
        this.kdStatusUtang = kdStatusUtang;
        this.ketStatusUtang = ketStatusUtang;
    }

    public String getKdStatusUtang() {
        return kdStatusUtang;
    }

    public void setKdStatusUtang(String kdStatusUtang) {
        this.kdStatusUtang = kdStatusUtang;
    }

    public String getKetStatusUtang() {
        return ketStatusUtang;
    }

    public void setKetStatusUtang(String ketStatusUtang) {
        this.ketStatusUtang = ketStatusUtang;
    }
}
