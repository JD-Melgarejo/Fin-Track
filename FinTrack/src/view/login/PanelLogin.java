package view.login;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class PanelLogin extends JPanel{

    public PanelLogin(){

        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color bordeColor = new Color(200, 200, 200);
        Color transColor = new Color(0, 0,0 ,50);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(transColor);
        g2.fillRoundRect(8, 8, getWidth() - 10, getHeight() - 10, 30, 30);

        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, 0, getWidth() -10, getHeight() -10, 30, 30);

        g2.setColor(bordeColor);
        g2.drawRoundRect(0, 0, getWidth() - 10, getHeight() - 10, 30, 30);
    }

}