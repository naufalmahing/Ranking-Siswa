package projekakhir1;

import java.util.Comparator;

public abstract class Siswa {
    private String nama;
    private String nim;
    private String kelas;
    private double math;
    private double bindo;
    private double bing;
    private double jumlahNilai;
    private double rataRata;
    public Double nilai;

    Siswa() {

    }

    public Siswa(String nama, Double nilai) {
        this.nama = nama;
        this.nilai = nilai;
    }

    public Siswa(String nama, String nim, String kelas, double math, double bindo, double bing) {
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
        this.math = math;
        this.bindo = bindo;
        this.bing = bing;
    }

    public abstract void jumlah();
    public abstract void rata2();

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Siswa))
            return false;
        Siswa s = (Siswa) obj;
        if(this.getNim().equals(s.getNim()))
            return true;
        return false;
    }

    public double getJumlahNilai() {
        return jumlahNilai;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getBindo() {
        return bindo;
    }

    public void setBindo(double bindo) {
        this.bindo = bindo;
    }

    public double getBing() {
        return bing;
    }

    public void setBing(double bing) {
        this.bing = bing;
    }

    public void setJumlahNilai(double jumlahNilai) {
        this.jumlahNilai = jumlahNilai;
    }

    public double getRataRata() {
        return rataRata;
    }

    public void setRataRata(double rataRata) {
        this.rataRata = rataRata;
    }
}
