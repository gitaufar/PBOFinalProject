/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author ammar
 */
import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import pbo.*;

public class Gui {

    private JButton go, back;
    private JLabel page = new JLabel("1");
    private JLabel page2 = new JLabel("2");
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JLabel background = new JLabel();
    int count;

    public Gui() {
        go = new JButton("Go");
        back = new JButton("Back");
        go.setBounds(0, 0, 100, 40);
        back.setBounds(0, 0, 100, 40);
        ImageIcon image = new ImageIcon(this.getClass().getResource("test.png"));
        background.setIcon(image);
        background.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        page.setBounds(250, 250, 100, 50);
        page2.setBounds(250, 250, 100, 50);
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        go.addActionListener((e) -> {
            panel2.setVisible(true);
            panel.setVisible(false);
        });

        back.addActionListener((e) -> {
            panel.setVisible(true);
            panel2.setVisible(false);
        });

        panel.add(background);
        panel.add(go);
        panel.add(page);
        panel.setVisible(true);
        panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        panel.setLayout(null);

        panel2.add(back);
        panel2.add(page2);
        panel2.setVisible(false);
        panel2.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        panel2.setLayout(null);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.CENTER);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException, CustomException {
        new Gui();
    }

}
