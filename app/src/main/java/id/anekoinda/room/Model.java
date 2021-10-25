package id.anekoinda.room;

public class Model {
    String nik, nama, telepon, jenis_kelamin, kondisi_kesehatan, persentase_kondisi, keterangan, is_valid;

    public String getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(String is_valid) {
        this.is_valid = is_valid;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Model(String nik, String nama, String telepon, String jenis_kelamin, String kondisi_kesehatan, String persentase_kondisi, String keterangan, String is_valid){
        this.nik = nik;
        this.nama = nama;
        this.telepon = telepon;
        this.jenis_kelamin = jenis_kelamin;
        this.kondisi_kesehatan = kondisi_kesehatan;
        this.persentase_kondisi = persentase_kondisi;
        this.keterangan = keterangan;
        this.is_valid = is_valid;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getKondisi_kesehatan() {
        return kondisi_kesehatan;
    }

    public void setKondisi_kesehatan(String kondisi_kesehatan) {
        this.kondisi_kesehatan = kondisi_kesehatan;
    }

    public String getPersentase_kondisi() {
        return persentase_kondisi;
    }

    public void setPersentase_kondisi(String persentase_kondisi) {
        this.persentase_kondisi = persentase_kondisi;
    }
}
