package id.go.pajak.fiskusapp.models;

public class DetailPenyidikan {
    public String KEY_kdStatusSidik = "kd_statusSidik";
    public String KEY_ketStatusSidik = "ketStatusSidik";

    private String kdStatusSidik;
    private String ketStatusSidik;

    public DetailPenyidikan() {
    }

    public DetailPenyidikan(String kdStatusSidik, String ketStatusSidik) {
        this.kdStatusSidik = kdStatusSidik;
        this.ketStatusSidik = ketStatusSidik;
    }

    public String getKdStatusSidik() {
        return kdStatusSidik;
    }

    public void setKdStatusSidik(String kdStatusSidik) {
        this.kdStatusSidik = kdStatusSidik;
    }

    public String getKetStatusSidik() {
        return ketStatusSidik;
    }

    public void setKetStatusSidik(String ketStatusSidik) {
        this.ketStatusSidik = ketStatusSidik;
    }

    @Override
    public String toString() {
        return "\nDetail Penyidikan" +
                "\nKeterangan :" + ketStatusSidik+"\n" ;
    }
}

