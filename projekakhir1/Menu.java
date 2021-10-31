package projekakhir1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Menu extends JFrame {
    private JButton IPAButton;
    private JButton IPSButton;
    private JButton exitButton;
    private JPanel mainPanel;


    public Menu() {
//        Menu mainUI = new Menu();
//        JPanel root = mainUI.getMainPanel();
        JFrame frame = new JFrame("Ranking Siswa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
//        frame.pack();
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        IPAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                setVisible(false);
                frame.dispose();
                new SiswaIPA();
            }
        });
        IPSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                setVisible(false);
                frame.dispose();
                new SiswaIPS();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                frame.dispose();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }

//    public JPanel getMainPanel() {
//        return mainPanel;
//    }
}
