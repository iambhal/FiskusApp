package id.go.pajak.fiskusapp.models;

public class DetailProfileWP {
    public String KEY_RESULT = "RESULT";
    public String KEY_NPWP = "NPWP";
    public String KEY_STATUS = "STATUS";
    public String KEY_NAMA = "NAMA";
    public String KEY_ALAMAT = "ALAMAT";
    public String KEY_KELURAHAN = "KELURAHAN";
    public String KEY_KECAMATAN = "KECAMATAN";
    public String KEY_KABKOT = "KABKOT";
    public String KEY_PROVINSI = "PROVINSI";
    public String KEY_KODE_KLU = "KODE_KLU";
    public String KEY_KLU = "KLU";
    public String KEY_NAMA_KPP = "NAMA_KPP";
    public String KEY_NAMA_KANWIL = "NAMA_KANWIL";
    public String KEY_TELP = "TELP";
    public String KEY_FAX = "FAX";
    public String KEY_EMAIL = "EMAIL";
    public String KEY_TTL = "TTL";
    public String KEY_TGL_DAFTAR = "TGL_DAFTAR";
    public String KEY_STATUS_PKP = "STATUS_PKP";
    public String KEY_TGL_PENGUKUHAN_PKP = "TGL_PENGUKUHAN_PKP";
    public String KEY_JENIS_WP = "JENIS_WP";
    public String KEY_BADAN_HUKUM = "BADAN_HUKUM";

    private String RESULT;
    private String NPWP;
    private String STATUS;
    private String NAMA;
    private String ALAMAT;
    private String KELURAHAN;
    private String KECAMATAN;
    private String KABKOT;
    private String PROVINSI;
    private String KODE_KLU;
    private String KLU;
    private String NAMA_KPP;
    private String NAMA_KANWIL;
    private String TELP;
    private String FAX;
    private String EMAIL;
    private String TTL;
    private String TGL_DAFTAR;
    private String STATUS_PKP;
    private String TGL_PENGUKUHAN_PKP;
    private String JENIS_WP;
    private String BADAN_HUKUM;

    public DetailProfileWP() {
    }

    public String getRESULT() {
        return RESULT;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }

    public String getNPWP() {
        return NPWP;
    }

    public void setNPWP(String NPWP) {
        this.NPWP = NPWP;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getNAMA() {
        return NAMA;
    }

    public void setNAMA(String NAMA) {
        this.NAMA = NAMA;
    }

    public String getALAMAT() {
        return ALAMAT;
    }

    public void setALAMAT(String ALAMAT) {
        this.ALAMAT = ALAMAT;
    }

    public String getKELURAHAN() {
        return KELURAHAN;
    }

    public void setKELURAHAN(String KELURAHAN) {
        this.KELURAHAN = KELURAHAN;
    }

    public String getKECAMATAN() {
        return KECAMATAN;
    }

    public void setKECAMATAN(String KECAMATAN) {
        this.KECAMATAN = KECAMATAN;
    }

    public String getKABKOT() {
        return KABKOT;
    }

    public void setKABKOT(String KABKOT) {
        this.KABKOT = KABKOT;
    }

    public String getPROVINSI() {
        return PROVINSI;
    }

    public void setPROVINSI(String PROVINSI) {
        this.PROVINSI = PROVINSI;
    }

    public String getKODE_KLU() {
        return KODE_KLU;
    }

    public void setKODE_KLU(String KODE_KLU) {
        this.KODE_KLU = KODE_KLU;
    }

    public String getKLU() {
        return KLU;
    }

    public void setKLU(String KLU) {
        this.KLU = KLU;
    }

    public String getNAMA_KPP() {
        return NAMA_KPP;
    }

    public void setNAMA_KPP(String NAMA_KPP) {
        this.NAMA_KPP = NAMA_KPP;
    }

    public String getNAMA_KANWIL() {
        return NAMA_KANWIL;
    }

    public void setNAMA_KANWIL(String NAMA_KANWIL) {
        this.NAMA_KANWIL = NAMA_KANWIL;
    }

    public String getTELP() {
        return TELP;
    }

    public void setTELP(String TELP) {
        this.TELP = TELP;
    }

    public String getFAX() {
        return FAX;
    }

    public void setFAX(String FAX) {
        this.FAX = FAX;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getTTL() {
        return TTL;
    }

    public void setTTL(String TTL) {
        this.TTL = TTL;
    }

    public String getTGL_DAFTAR() {
        return TGL_DAFTAR;
    }

    public void setTGL_DAFTAR(String TGL_DAFTAR) {
        this.TGL_DAFTAR = TGL_DAFTAR;
    }

    public String getSTATUS_PKP() {
        return STATUS_PKP;
    }

    public void setSTATUS_PKP(String STATUS_PKP) {
        this.STATUS_PKP = STATUS_PKP;
    }

    public String getTGL_PENGUKUHAN_PKP() {
        return TGL_PENGUKUHAN_PKP;
    }

    public void setTGL_PENGUKUHAN_PKP(String TGL_PENGUKUHAN_PKP) {
        this.TGL_PENGUKUHAN_PKP = TGL_PENGUKUHAN_PKP;
    }

    public String getJENIS_WP() {
        return JENIS_WP;
    }

    public void setJENIS_WP(String JENIS_WP) {
        this.JENIS_WP = JENIS_WP;
    }

    public String getBADAN_HUKUM() {
        return BADAN_HUKUM;
    }

    public void setBADAN_HUKUM(String BADAN_HUKUM) {
        this.BADAN_HUKUM = BADAN_HUKUM;
    }

    @Override
    public String toString() {
        return  "\nNama : " + NAMA +
                "\nAlamat : " + ALAMAT +
                "\nKelurahan : " + KELURAHAN +
                "\nKecamatan : " + KECAMATAN +
                "\nKabupaten/Kota : " + KABKOT +
                "\nProvinsi : " + PROVINSI +
                "\nPekerjaan / Usaha : " + KLU +
                "\nEmail : " + EMAIL +
                "\nTempat Tanggal Lahir : " + TTL +
                "\nTelepon : " + TELP +
                "\nFaksimili : " + FAX +
                "\nKPP Terdaftar : " + NAMA_KPP +
                "\nTanggal Terdaftar : " + TGL_DAFTAR +
                "\nStatus PKP : " + STATUS_PKP +
                "\nTanggal Pengukuhan PKP : " + TGL_PENGUKUHAN_PKP +
                "\nJenis WP : " + JENIS_WP +
                "\nBadan Hukum: " + BADAN_HUKUM ;

    }
}
