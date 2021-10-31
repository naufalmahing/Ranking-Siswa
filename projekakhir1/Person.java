package projekakhir1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Person implements Comparable<Person> {

    private String nama;
    private int absen;

    public static ArrayList<Person> persons = new ArrayList<>();

    public Person(String nama, int absen) {
        this.nama = nama;
        this.absen = absen;
    }

    @Override
    public int compareTo(Person o) {
        Integer absen = this.absen;
        Integer absenO = o.absen;
        return absen.compareTo(absenO);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getAbsen() {
        return absen;
    }

    public void setAbsen(int absen) {
        this.absen = absen;
    }

    public static void main(String[] args) {
        persons.add(new Person("Naufal", 23));
        persons.add(new Person("Mahing", 1));
        persons.add(new Person("Ahmad", 12));
        Collections.sort(persons);
        persons.stream().map(s -> s.nama).forEach(System.out::print);
    }
}
