package projekakhir1;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Data {
    public static ArrayList<Siswa> siswa = new ArrayList<>();
    public static ArrayList<Siswa> siswa1 = new ArrayList<>();

    public static void sort() {
        Collections.sort(siswa, new Comparator<Siswa>() {
            @Override
            public int compare(Siswa o1, Siswa o2) {
                o1.jumlah();o2.jumlah();
                Double jumlahNilai1 = o1.getJumlahNilai();
                Double jumlahNilai2 = o2.getJumlahNilai();
                return jumlahNilai2.compareTo(jumlahNilai1);
            }
        });
    }

    public static void sort1() {
        Collections.sort(siswa1, new Comparator<Siswa>() {
            @Override
            public int compare(Siswa o1, Siswa o2) {
                o1.jumlah();o2.jumlah();
                Double jumlahNilai1 = o1.getJumlahNilai();
                Double jumlahNilai2 = o2.getJumlahNilai();
                return jumlahNilai2.compareTo(jumlahNilai1);
            }
        });
    }

    public static void tampil() {
        Data.sort();
        for(Siswa s : siswa) {
            s.rata2();
            System.out.println(s.getNama() + " " + s.getNim() + " " + s.getKelas() + " " + s.getJumlahNilai() + " " + s.getRataRata());
        }
    }

    public static void tampil1() {
        Data.sort1();
        for(Siswa s : siswa1) {
            s.rata2();
            System.out.println(s.getNama() + " " + s.getNim() + " " + s.getKelas() + " " + s.getJumlahNilai() + " " + s.getRataRata());
        }
    }

    public static void main(String[] args) {
        siswa.add(new IPA("Naufal", "205", "TIF-D", 70, 80, 90, 85, 0, 0));
        siswa.add(new IPA("Yusuf", "205", "TIF-D", 70, 80, 90, 0, 0, 100));
        siswa.add(new IPA("Riza", "205", "TIF-D", 70, 80, 90, 0, 90, 0));

        Collections.sort(siswa, new Comparator<Siswa>() {
            @Override
            public int compare(Siswa o1, Siswa o2) {
                o1.jumlah();o2.jumlah();
                Double jumlahNilai1 = o1.getJumlahNilai();
                Double jumlahNilai2 = o2.getJumlahNilai();
                return jumlahNilai2.compareTo(jumlahNilai1);
            }
        });

        for(Siswa s : siswa) {
            System.out.println(s.getNama());
        }

        Person.persons.add(new Person("Naufal", 23));
        Person.persons.add(new Person("Mahing", 1));
        Person.persons.add(new Person("Ahmad", 12));

        Collections.sort(Person.persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                Integer absen = o1.getAbsen();
                Integer absenO = o2.getAbsen();
                return absen.compareTo(absenO);
            }
        });

    }
}
