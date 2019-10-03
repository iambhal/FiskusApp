package id.go.pajak.fiskusapp.models;

public class DetailUtang {
    public String KEY_kdStatusUtang = "kd_statusUtang";
    public String KEY_ketStatusUtang = "ketStatusUtang";

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

    @Override
    public String toString() {
        return "\nStatus Utang : "+ ketStatusUtang+"\n";
    }
}
