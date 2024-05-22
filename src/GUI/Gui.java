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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import pbo.*;

public class Gui {

    private JFrame frame;
    public static Player a = new Player();
    public static Map m = new HomeBase();
    public int k = 0;

    //Layar awal mulai
    public ImageIcon firstImage = new ImageIcon(this.getClass().getResource("Homebase.png"));
    public JLabel firstBackground = new JLabel();
    public JPanel firstPanel = new JPanel(null);
    public JButton newGame;
    public JButton loadGame;
    //Layar awal akhir

    //newGame mulai
    public JPanel newPanel = new JPanel(null);
    public ImageIcon pokemon1 = new ImageIcon(this.getClass().getResource("charmander.png"));
    public ImageIcon pokemon2 = new ImageIcon(this.getClass().getResource("squirtle.png"));
    public ImageIcon pokemon3 = new ImageIcon(this.getClass().getResource("bulbasaur.png"));
    public JLabel pokemon1Panel = new JLabel();
    public JLabel pokemon2Panel = new JLabel();
    public JLabel pokemon3Panel = new JLabel();
    //newGame akhir

    //home base awal
    public JPanel homeBasePanel = new JPanel(null);
    public ImageIcon homeImage = new ImageIcon();
    public JLabel homeBG = new JLabel();
    public JButton evolusi = new JButton("Evolusi");
    public JButton heal = new JButton("Heal");
    public JButton levelUp = new JButton("Level up");
    //home base akhir

    public void select(Gui gui, Player player) {
        int plus = 0;
        
        for (int i = 0; i < player.ownedPokemon.size(); i++) {
            System.out.println((player.ownedPokemon.get(i).getNama() + ".png").toLowerCase());
            ImageIcon temp = new ImageIcon(this.getClass().getResource((player.ownedPokemon.get(i).getNama() + ".png").toLowerCase()));
            Image temp2 = temp.getImage();
            ImageIcon scaled = new ImageIcon(temp2.getScaledInstance(70, 70, Image.SCALE_SMOOTH));
            JLabel container = new JLabel();
            container.setIcon(scaled);
            container.setBounds(plus, 200, 70, 70);
            container.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new HomeBase().healPokemon(player.ownedPokemon.get(k));
                    k++;
                }
            });
            gui.homeBasePanel.add(container);
            plus += 20;
            gui.homeBasePanel.revalidate();
            gui.homeBasePanel.repaint();
        }
    }

    public void newGame() {
        firstPanel.setVisible(false);
        newPanel.setVisible(true);
    }

    public void battleArena(Player player) {

    }

    private JButton createImageButton(ImageIcon icon, String text, int fontSize, int width, int height) {
        JButton button = new JButton(text);
        button.setFont(new Font("Forte", Font.PLAIN, fontSize));
        Image image = icon.getImage();
        ImageIcon scaled = new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
        button.setIcon(scaled);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        return button;
    }

    private void selectPokemon() {

    }

    public Gui() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setLayout(null);

        //layar awal mulai
        Image image = firstImage.getImage();
        ImageIcon scaled = new ImageIcon(image.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH));
        firstBackground.setIcon(scaled);
        firstBackground.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        newGame = createImageButton(new ImageIcon(this.getClass().getResource("button.png")), "N E W  G A M E", 15, 200, 100);
        loadGame = createImageButton(scaled, "L O A D  G A M E", 15, 200, 100);
        newGame.setBounds(550, 200, 200, 100);
        loadGame.setBounds(550, 400, 200, 100);
        newGame.addActionListener((e) -> {
            newGame();
        });
        loadGame.addActionListener((e) -> {
            try {
                Game.loadFile(this, a);
            } catch (InterruptedException x) {
                x.getMessage();
            }
        });
        firstPanel.add(newGame);
        firstPanel.add(loadGame);
        firstPanel.add(firstBackground);
        firstPanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        firstPanel.setVisible(true);
        //layar awal akhir

        //new game awal
        Image p1 = pokemon1.getImage();
        Image p2 = pokemon2.getImage();
        Image p3 = pokemon3.getImage();
        ImageIcon scaledp1 = new ImageIcon(p1.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        ImageIcon scaledp2 = new ImageIcon(p2.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        ImageIcon scaledp3 = new ImageIcon(p3.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        pokemon1Panel.setIcon(scaledp1);
        pokemon1Panel.setBounds(200, 200, 100, 100);
        pokemon1Panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                a.add(ListPokemon.list.get(0));
                a.setMap(new HomeBase());
                newPanel.setVisible(false);
                homeBasePanel.setVisible(true);
            }
        });
        pokemon2Panel.setIcon(scaledp2);
        pokemon2Panel.setBounds(400, 200, 100, 100);
        pokemon2Panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                a.add(ListPokemon.list.get(1));
                a.setMap(new HomeBase());
                newPanel.setVisible(false);
                homeBasePanel.setVisible(true);
            }
        });
        pokemon3Panel.setIcon(scaledp3);
        pokemon3Panel.setBounds(600, 200, 100, 100);
        pokemon3Panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                a.add(ListPokemon.list.get(4));
                a.setMap(new HomeBase());
                newPanel.setVisible(false);
                homeBasePanel.setVisible(true);
            }
        });
        newPanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        JLabel choose = new JLabel("Pilih pokemon awalan anda");
        choose.setFont(new Font("Forte", Font.PLAIN, 24));
        choose.setBounds(270, 300, 500, 100);
        newPanel.add(choose);
        newPanel.add(pokemon1Panel);
        newPanel.add(pokemon2Panel);
        newPanel.add(pokemon3Panel);
        newPanel.setVisible(false);
        //new game akhir

        //home base awal
        homeBG.setIcon(homeImage);
        heal.setBounds(0, 0, 200, 100);
        heal.addActionListener((e) -> {
            select(this, a);
        });
        homeBasePanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        homeBasePanel.add(heal);
        homeBasePanel.add(evolusi);
        homeBasePanel.add(levelUp);
        homeBasePanel.setVisible(false);
        //home base akhir

        //dungeon awal
        
        //dungeon akhir
        
        //menambah seluruh panel ke frame
        frame.add(firstPanel, BorderLayout.CENTER);
        frame.add(newPanel, BorderLayout.CENTER);
        frame.add(homeBasePanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException, CustomException {
        Gui g = new Gui();
        a.add(ListPokemon.list.get(1));
    }

}
