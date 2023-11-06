package io.github.ruanosena;

import javax.swing.*;
import java.awt.*;

public class Janela extends JFrame {
    
    private JPanel tela;
    public Janela() {
        tela = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
//                a pintura ocorre aqui
            }
        };
        super.getContentPane().add(tela);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);
    }
}
