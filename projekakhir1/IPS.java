package projekakhir1;

public class IPS extends Siswa {
    private double geografi;
    private double sosiologi;
    private double ekonomi;

    IPS() {

    }

    public IPS(String nama, String nim, String kelas, double math, double bindo, double bing, double geografi, double sosiologi, double ekonomi) {
        super(nama, nim, kelas, math, bindo, bing);
        this.geografi = geografi;
        this.sosiologi = sosiologi;
        this.ekonomi = ekonomi;
        jumlah();
        rata2();
    }

    public IPS(String nama, Double nilai) {
        super(nama, nilai);
    }

    @Override
    public void jumlah() {
        setJumlahNilai(getMath() + getBindo() + getBing() + geografi + sosiologi + ekonomi);
    }

    @Override
    public void rata2() {
        setRataRata((getMath() + getBindo() + getBing() + geografi + sosiologi + ekonomi) / 6);
    }

    public double getGeografi() {
        return geografi;
    }

    public void setGeografi(double geografi) {
        this.geografi = geografi;
    }

    public double getSosiologi() {
        return sosiologi;
    }

    public void setSosiologi(double sosiologi) {
        this.sosiologi = sosiologi;
    }

    public double getEkonomi() {
        return ekonomi;
    }

    public void setEkonomi(double ekonomi) {
        this.ekonomi = ekonomi;
    }
}
