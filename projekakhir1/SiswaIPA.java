package projekakhir1;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

public class SiswaIPA extends JFrame {
    private JPanel mainPanel;
    private JButton addButton;
    private JTable tabel;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JTextField nama;
    private JTextField nim;
    private JTextField kelas;
    private JTextField math;
    private JTextField bindo;
    private JTextField bing;
    private JTextField fisika;
    private JTextField kimia;
    private JTextField biologi;
    private JButton backButton;
    private JButton searchButton;
    private DefaultTableModel model;

    public SiswaIPA() {
        JFrame frame = new JFrame("Ranking Siswa IPA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        model = new DefaultTableModel();
        Object[] column = {"Nama", "NIM", "Kelas", "Math", "Bindo", "Bing", "Fisika", "Kimia", "Biologi"};
        Object[] row = new Object[9];
        model.setColumnIdentifiers(column);
        tabel.setModel(model);
        tabel.setDefaultEditor(Object.class, null);

        TableColumnModel columns = tabel.getColumnModel();
        columns.getColumn(0).setMinWidth(200);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(3).setCellRenderer(centerRenderer);
        columns.getColumn(4).setCellRenderer(centerRenderer);
        columns.getColumn(5).setCellRenderer(centerRenderer);
        columns.getColumn(6).setCellRenderer(centerRenderer);
        columns.getColumn(7).setCellRenderer(centerRenderer);
        columns.getColumn(8).setCellRenderer(centerRenderer);

        display();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nama.getText().equals("") || nim.getText().equals("") || kelas.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Mohon isi nama, nim dan kelas");
                    return;
                }

                for(Siswa s : Data.siswa) {
                    if(s.getNim().equals(nim.getText())) {
                        JOptionPane.showMessageDialog(null, "Mohon isi dengan nim yang berbeda");
                        return;
                    }
                }

                if(isNilaiEmpty()) {
                    JOptionPane.showMessageDialog(null, "Mohon isi field nilai");
                    return;
                }

//                if(math.getText().equals(""))
//                    math.setText("0");
//                if(bindo.getText().equals(""))
//                    bindo.setText("0");
//                if(bing.getText().equals(""))
//                    bing.setText("0");
//                if(fisika.getText().equals(""))
//                    fisika.setText("0");
//                if(kimia.getText().equals(""))
//                    kimia.setText("0");
//                if(biologi.getText().equals(""))
//                    biologi.setText("0");

                if(cekNilai()) {
                    JOptionPane.showMessageDialog(null, "Mohon masukkan siswa dengan nilai minimal 80");
                    return;
                }

                if(isGreater()) {
                    JOptionPane.showMessageDialog(null, "Mohon masukkan nilai tidak melebihi 100");
                    return;
                }

//                row[0] = nama.getText();
//                row[1] = nim.getText();
//                row[2] = kelas.getText();
//                row[3] = math.getText();
//                row[4] = bindo.getText();
//                row[5] = bing.getText();
//                row[6] = fisika.getText();
//                row[7] = kimia.getText();
//                row[8] = biologi.getText();
//                model.addRow(row);
                tambah();
                JOptionPane.showMessageDialog(null, "Added Successfully");
                clear();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tabel.getSelectedRow();
                if(i < 0) {
                    JOptionPane.showMessageDialog(null, "Select a row");
                    display();
                }
                else {
                    model.removeRow(i);
                    removeRecord(nim.getText());
                    JOptionPane.showMessageDialog(null, "Deleted Successfully");
                    clear();
                }
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tabel.getSelectedRow();
                if(i < 0)
                    JOptionPane.showMessageDialog(null, "Select a row");
                else {
                    if(nama.getText().equals("") || nim.getText().equals("") || kelas.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Mohon isi nama, nim dan kelas");
                        return;
                    }

//                    if(math.getText().equals(""))
//                        math.setText("0");
//                    if(bindo.getText().equals(""))
//                        bindo.setText("0");
//                    if(bing.getText().equals(""))
//                        bing.setText("0");
//                    if(fisika.getText().equals(""))
//                        fisika.setText("0");
//                    if(kimia.getText().equals(""))
//                        kimia.setText("0");
//                    if(biologi.getText().equals(""))
//                        biologi.setText("0");

                    if(isNilaiEmpty()) {
                        JOptionPane.showMessageDialog(null, "Mohon isi field nilai");
                        return;
                    }

                    if(Data.siswa.contains(new IPA(nama.getText(), nim.getText(), "", 0, 0, 0,
                            0, 0, 0))) {

                        if(cekNilai()) {
                            JOptionPane.showMessageDialog(null, "Mohon masukkan siswa dengan nilai minimal 80");
                            return;
                        }

                        if(isGreater()) {
                            JOptionPane.showMessageDialog(null, "Mohon masukkan nilai tidak melebihi 100");
                            return;
                        }

//                        model.setValueAt(nama.getText(), i, 0);
//                        model.setValueAt(nim.getText(), i, 1);
//                        model.setValueAt(kelas.getText(), i, 2);
//                        model.setValueAt(math.getText(), i, 3);
//                        model.setValueAt(bindo.getText(), i, 4);
//                        model.setValueAt(bing.getText(), i, 5);
//                        model.setValueAt(fisika.getText(), i, 6);
//                        model.setValueAt(kimia.getText(), i, 7);
//                        model.setValueAt(biologi.getText(), i, 8);
                        JOptionPane.showMessageDialog(null, "Updated succesfully");
                        updateFile();
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update");
                    }
                }
                display();
            }
        });
        tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabel.getSelectedRow();
                // kalo kosong, error
                nama.setText(model.getValueAt(i, 0).toString());
                nim.setText(model.getValueAt(i, 1).toString());
                kelas.setText(model.getValueAt(i, 2).toString());
                math.setText(model.getValueAt(i, 3).toString());
                bindo.setText(model.getValueAt(i, 4).toString());
                bing.setText(model.getValueAt(i, 5).toString());
                fisika.setText(model.getValueAt(i, 6).toString());
                kimia.setText(model.getValueAt(i, 7).toString());
                biologi.setText(model.getValueAt(i, 8).toString());
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                deleteFile();
                frame.dispose();
                new Menu();
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cari();
            }
        });
    }

    private void cari() {
        if(Data.siswa.contains(new IPA("", nim.getText(), "", 0, 0, 0, 0, 0, 0))) {
            JOptionPane.showMessageDialog(null, "Data ditemukan");
            IPA s = (IPA) Data.siswa.get(Data.siswa.indexOf(new IPA("", nim.getText(), "", 0
                    , 0, 0, 0, 0, 0)));
            JOptionPane.showMessageDialog(null, s.getNama() + " " + s.getNim() + " " + s.getKelas() + " \n"
                    + s.getMath() + " " + s.getBindo() + " " + s.getBing() + " \n" + s.getFisika() + " " + s.getKimia()
                    + " " + s.getBiologi());
        } else
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
    }

    private void tambah() {
//        Data.siswa.add(new IPA(nama.getText(), nim.getText(), kelas.getText(), Double.parseDouble(math.getText()),
//                Double.parseDouble(bindo.getText()), Double.parseDouble(bing.getText()),
//                Double.parseDouble(fisika.getText()), Double.parseDouble(kimia.getText()),
//                Double.parseDouble(biologi.getText())));
//        Data.sort();

        Data.siswa.add(new IPA(nama.getText(), nim.getText(), kelas.getText(), Double.parseDouble(math.getText()),
                Double.parseDouble(bindo.getText()),
                Double.parseDouble(bing.getText()), Double.parseDouble(fisika.getText()),
                Double.parseDouble(kimia.getText()), Double.parseDouble(biologi.getText())));
        writeToFile(Data.siswa); // write to file sudah ada sortnya
        display();

//        File f = new File("Database.txt");
//        try {
//            PrintWriter pw = new PrintWriter(new FileOutputStream(f, true));
//            pw.append(nama.getText()).append(",").append(nim.getText()).append(",").append(kelas.getText()).append(",").append(math.getText()).append("\n");
//            pw.close();
//        } catch(Exception e) {
//            System.out.println(e.getMessage());
//        }
//        Data.tampil();
    }

    private void display() {
//        try {
//            // terminal output
////            BufferedReader br = new BufferedReader(new FileReader("Database.txt"));
////            String s = "";
////            while((s = br.readLine()) != null) {
////                String[] data = new String[4];
////                data = s.split(",");
////                for(int i = 0; i < 4; i++) {
////                    System.out.print(data[i] + " ");
////                    tabel.setValueAt(data[i], i, 0);
////                }
////                System.out.println();
////            }
//
//            // jTable output
//
//            BufferedReader br = new BufferedReader(new FileReader("Database.txt"));
//                Object[] tableLines = br.lines().toArray();
//                for(int i = 0; i < tableLines.length; i++) {
//                    String[] dataRow = tableLines[i].toString().split(",");
//                    IPA s = new IPA(dataRow[0], dataRow[1], dataRow[2], Double.parseDouble(dataRow[3]), 0, 0, 0, 0, 0);
//                    if(Data.siswa.contains(s))
//                        continue;
//                    else
//                        Data.siswa.add(s);
//                    Data.sort();
//                    model.addRow(dataRow);
//                }
//            Data.tampil();
//        } catch(Exception e) {
//            System.out.println(e.getMessage());
//        }

        // display ganti menggunakan arraylist

        deleteRows();
        readFile(); // sudah sama sort
        for(Siswa s : Data.siswa) {
            if(s instanceof  IPA) {
                String[] dataRow = {s.getNama(), s.getNim(), s.getKelas(), Double.toString(s.getMath()),
                        Double.toString(s.getBindo()), Double.toString(s.getBing()), Double.toString(((IPA) s).getFisika()),
                        Double.toString(((IPA) s).getKimia()), Double.toString(((IPA) s).getBiologi())};
                model.addRow(dataRow);
            }
        }
    }

    private void removeRecord(String removeTerm) {
        IPA s = new IPA(nama.getText(), nim.getText(), "", 0, 0, 0, 0, 0, 0);
        Data.siswa.remove(s);
        Data.tampil();

        writeToFile(Data.siswa);
    }

    private void writeToFile(ArrayList<Siswa> list) {
        Data.sort();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Database.txt"));
            for(Siswa s : list) {
                if(s instanceof IPA)
                    bw.append(s.getNama()).append(",").append(s.getNim()).append(",").append(s.getKelas()).append(",")                                                 .append(String.valueOf(s.getMath() + "," + s.getBindo() + "," + s.getBing() + "," +
                            ((IPA) s).getFisika() + "," + ((IPA) s).getKimia() + "," + ((IPA) s).getBiologi() + "\n"));
            }
            Data.tampil();
            bw.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
    }

    private void readFile() {
        try {
            // terminal output
//            BufferedReader br = new BufferedReader(new FileReader("Database.txt"));
//            String s = "";
//            while((s = br.readLine()) != null) {
//                String[] data = new String[4];
//                data = s.split(",");
//                for(int i = 0; i < 4; i++) {
//                    System.out.print(data[i] + " ");
//                    tabel.setValueAt(data[i], i, 0);
//                }
//                System.out.println();
//            }

            // jTable output
            BufferedReader br = new BufferedReader(new FileReader("Database.txt"));
            Object[] tableLines = br.lines().toArray();
            for(int i = 0; i < tableLines.length; i++) {
                String[] dataRow = tableLines[i].toString().split(",");
                IPA s = new IPA(dataRow[0], dataRow[1], dataRow[2], Double.parseDouble(dataRow[3]),
                        Double.parseDouble(dataRow[4]), Double.parseDouble(dataRow[5]),
                        Double.parseDouble(dataRow[6]), Double.parseDouble(dataRow[7]), Double.parseDouble(dataRow[8]));
                if(Data.siswa.contains(s))
                    continue;
                else
                    Data.siswa.add(s);
            }
            br.close();
            Data.tampil(); // sudah sama sort
        } catch(Exception e) {
            e.getStackTrace();
        }
    }

    private void updateFile() {
        IPA s = new IPA(nama.getText(), nim.getText(), "", 0, 0, 0, 0, 0, 0);
        if(Data.siswa.contains(s)) {
            System.out.println("Mitsuketa!!");

//            Data.siswa.get(Data.siswa.indexOf(s)).setNama(nama.getText());
//            Data.siswa.get(Data.siswa.indexOf(s)).setNim(nim.getText());
//            Data.siswa.get(Data.siswa.indexOf(s)).setKelas(kelas.getText());
//            Data.siswa.get(Data.siswa.indexOf(s)).setMath(Double.parseDouble(math.getText()));
//            Data.siswa.get(Data.siswa.indexOf(s)).setMath(Double.parseDouble(math.getText()));
//            Data.siswa.get(Data.siswa.indexOf(s)).setMath(Double.parseDouble(math.getText()));

            IPA s1 = (IPA) Data.siswa.get(Data.siswa.indexOf(s));
            s1.setNama(nama.getText());
            s1.setNim(nim.getText());
            s1.setKelas(kelas.getText());
            s1.setMath(Double.parseDouble(math.getText()));
            s1.setBindo(Double.parseDouble(bindo.getText()));
            s1.setBing(Double.parseDouble(bing.getText()));
            s1.setFisika(Double.parseDouble(fisika.getText()));
            s1.setKimia(Double.parseDouble(kimia.getText()));
            s1.setBiologi(Double.parseDouble(biologi.getText()));

            Data.siswa.remove(s1);
            Data.siswa.add(s1);

            writeToFile(Data.siswa); // sudah sama sort di awal method
        }

//        try {
//            BufferedReader br = new BufferedReader(new FileReader("Database.txt"));
//            String s = "";
//            while()
//        } catch(Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println(Arrays.toString(e.getStackTrace()));
//        }
    }

//    private void deleteFile() {
//        try {
//            File f = new File("Database.txt");
//            PrintWriter pw = new PrintWriter(new FileOutputStream(f, f.delete()));
//            pw.append("");
//            pw.close();
//            JOptionPane.showMessageDialog(null, "Deleted file successfully");
//        } catch(Exception e) {
//            System.out.println(e.getMessage());
//            JOptionPane.showMessageDialog(null, "Delete file failed");
//        }
//    }

    private void deleteRows() {
        for(int i = tabel.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private void clear() {
        nama.setText("");
        nim.setText("");
        kelas.setText("");
        math.setText("");
        bindo.setText("");
        bing.setText("");
        fisika.setText("");
        kimia.setText("");
        biologi.setText("");
    }

    private boolean cekNilai() {
        return Double.parseDouble(math.getText()) < 80 || Double.parseDouble(bindo.getText()) < 80
                || Double.parseDouble(bing.getText()) < 80 || Double.parseDouble(fisika.getText()) < 80
                || Double.parseDouble(kimia.getText()) < 80 || Double.parseDouble(biologi.getText()) < 80;
    }

    private boolean isGreater() {
        return Double.parseDouble(math.getText()) > 100 || Double.parseDouble(bindo.getText()) > 100
                || Double.parseDouble(bing.getText()) > 100 || Double.parseDouble(fisika.getText()) > 100
                || Double.parseDouble(kimia.getText()) > 100 || Double.parseDouble(biologi.getText()) > 100;
    }

    private boolean isNilaiEmpty() {
        return math.getText().equals("") || bindo.getText().equals("") || bing.getText().equals("") || fisika.getText()
                .equals("") || kimia.getText().equals("") || biologi.getText().equals("");
    }

//    public JPanel getMainPanel() {
//        return mainPanel;
//    }
}
