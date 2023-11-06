package io.github.ruanosena;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Interativo extends JFrame {
    private final JPanel tela;
    private int px;
    private int py;
    private boolean jogando = true;

    private final boolean[] controleTecla = new boolean[4];
    public void inicia() {
        int FPS = 1000 / 20;
        long prxAtualizacao = 0;
        while (jogando) {
            if (System.currentTimeMillis() >= prxAtualizacao) {
                atualizaJogo();
                tela.repaint();
                prxAtualizacao = System.currentTimeMillis() + FPS;
            }
        }
    }

    public Interativo() {
        super.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                setaTecla(e.getKeyCode(), true);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                setaTecla(e.getKeyCode(), false);
            }
        });

        tela = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, tela.getWidth(), tela.getHeight());

                int x = tela.getWidth() / 2 - 20 + px;
                int y = tela.getHeight() / 2 -20 + py;

                g.setColor(Color.BLUE);
                g.fillRect(x, y, 40, 40);
                g.drawString("Agora eu estou em %d x %d".formatted(x, y), 5, 10);
            }
        };



//        adiciona a tela à moldura
        getContentPane().add(tela);
//        comportamento do dispose
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        tamanho da tela com bordas
        setSize(640, 480);
//        pinta a tela
        setVisible(true);
    }

    private void atualizaJogo() {
        if (controleTecla[0]) {
            py--;
        } else if (controleTecla[1]) {
            py++;
        }
        if (controleTecla[2]) {
            px--;
        } else if (controleTecla[3]) {
            px++;
        }
    }

    private void setaTecla(int tecla, boolean pressionada) {
        switch (tecla) {
            case KeyEvent.VK_ESCAPE:
                jogando = false;
                dispose();
                break;
            case KeyEvent.VK_UP:
                controleTecla[0] = pressionada;
                break;
            case KeyEvent.VK_DOWN:
                controleTecla[1] = pressionada;
                break;
            case KeyEvent.VK_LEFT:
                controleTecla[2] = pressionada;
                break;
            case KeyEvent.VK_RIGHT:
                controleTecla[3] = pressionada;
                break;
        }
    }
}
