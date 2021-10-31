package projekakhir1;

public class IPA extends Siswa {
    private double fisika;
    private double kimia;
    private double biologi;

    IPA() {

    }

    public IPA(String nama, String nim, String kelas, double math, double bindo, double bing, double fisika, double kimia, double biologi) {
        super(nama, nim, kelas, math, bindo, bing);
        this.fisika = fisika;
        this.kimia = kimia;
        this.biologi = biologi;
        jumlah();
        rata2();
    }

    public IPA(String nama, Double nilai) {
        super(nama, nilai);
    }

    @Override
    public void jumlah() {
        setJumlahNilai(getMath() + getBindo() + getBing() + fisika + kimia + biologi);
    }

    @Override
    public void rata2() {
        setRataRata((getMath() + getBindo() + getBing() + fisika + kimia + biologi) / 6);
    }

    public double getFisika() {
        return fisika;
    }

    public void setFisika(double fisika) {
        this.fisika = fisika;
    }

    public double getKimia() {
        return kimia;
    }

    public void setKimia(double kimia) {
        this.kimia = kimia;
    }

    public double getBiologi() {
        return biologi;
    }

    public void setBiologi(double biologi) {
        this.biologi = biologi;
    }
}
