package id.go.pajak.fiskusapp.models;


public class UserModel {
    private Integer id;
    private String nip9;
    private String pwd;
    private String nip19;
    private String nama;
    private String unitkerja;
    private String jabatan;

    public UserModel() {
    }

    public UserModel(String nip9, String pwd, String nip19, String nama, String unitkerja, String jabatan) {
        this.nip9 = nip9;
        this.pwd = pwd;
        this.nip19 = nip19;
        this.nama = nama;
        this.unitkerja = unitkerja;
        this.jabatan = jabatan;
    }

    public UserModel(Integer id, String nip9, String pwd, String nip19, String nama, String unitkerja, String jabatan) {
        this.id = id;
        this.nip9 = nip9;
        this.pwd = pwd;
        this.nip19 = nip19;
        this.nama = nama;
        this.unitkerja = unitkerja;
        this.jabatan = jabatan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNip9() {
        return nip9;
    }

    public void setNip9(String nip9) {
        this.nip9 = nip9;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNip19() {
        return nip19;
    }

    public void setNip19(String nip19) {
        this.nip19 = nip19;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUnitkerja() {
        return unitkerja;
    }

    public void setUnitkerja(String unitkerja) {
        this.unitkerja = unitkerja;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }


}
