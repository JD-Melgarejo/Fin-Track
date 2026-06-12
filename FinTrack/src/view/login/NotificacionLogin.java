
package view.login;

import javax.swing.JWindow;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NotificacionLogin extends JWindow {
    
    private JLabel lblMensaje;
    private JPanel panelPrincipal;
    
public NotificacionLogin(String usuario){

    setSize(300, 80);
    setLocationRelativeTo(null);
    setAlwaysOnTop(true);
    setLayout(null);
    setBackground(new Color(10, 36, 77));
        
    lblMensaje = new JLabel("Bienvenido " + usuario);
    add(lblMensaje);

    lblMensaje.setBounds(20, 25, 260, 30);
    lblMensaje.setForeground(Color.WHITE);
    lblMensaje.setFont(new Font("SansSerif", Font.BOLD, 16));
    lblMensaje.setHorizontalAlignment(JLabel.CENTER);
    
    panelPrincipal = new JPanel();
    add(panelPrincipal);
    panelPrincipal.setLayout(null);
    panelPrincipal.setBackground(new Color(10, 36, 77));
    panelPrincipal.setBounds(0, 0, 300, 80);
    
    Timer timer = new Timer(3000, new ActionListener(){
        
        public void actionPerformed(ActionEvent e){
            dispose();
        }
    });
    
    timer.setRepeats(false);
    timer.start();
    
}
    
}
