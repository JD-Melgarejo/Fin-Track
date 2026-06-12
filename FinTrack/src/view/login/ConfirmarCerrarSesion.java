package view.login;

import main.MainFrame;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmarCerrarSesion extends JDialog{
    
    private JPanel panelPrincipal;
    
    private JLabel lblTitulo;
    private JLabel lblMensaje;
    
    private JButton btnCancelar;
    private JButton btnCerrarSesion;
    
    private MainFrame mainFrame;
    
    public ConfirmarCerrarSesion(){
        
        
    setTitle("Cerrar Sesión");
    setSize(400, 200);
    setLocationRelativeTo(null);
    setModal(true);
    setResizable(false);
    Color colorPersonalizado = new Color(10, 36, 77);
    
    
    panelPrincipal = new JPanel();
    add(panelPrincipal);
    panelPrincipal.setLayout(null);
    panelPrincipal.setBackground(Color.WHITE);
    
    lblTitulo = new JLabel("Cerrar Sesion");
    panelPrincipal.add(lblTitulo);
    lblTitulo.setBounds(110, 20, 200, 30);
    lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
    lblTitulo.setForeground(new Color(10, 36, 77));
    
    lblMensaje = new JLabel("¿Desea finalizar la sesión actual?");
    panelPrincipal.add(lblMensaje);
    lblMensaje.setBounds(60, 70, 300, 30);
    lblMensaje.setFont(new Font("SansSerif", Font.PLAIN, 14));
    lblMensaje.setForeground(new Color(80, 80, 80));
    
    btnCerrarSesion = new JButton("Si");
    panelPrincipal.add(btnCerrarSesion);
    btnCerrarSesion.setBounds(220, 120, 120, 35);
    btnCerrarSesion.setBackground(colorPersonalizado);
    btnCerrarSesion.setForeground(Color.WHITE);
    btnCerrarSesion.setFocusPainted(false);
    btnCerrarSesion.addActionListener(new ActionListener(){
         
        public void actionPerformed(ActionEvent e){
        LoginFrame loginFrame = new LoginFrame();
         loginFrame.setVisible(true);
        mainFrame.dispose();
        dispose();
        }
    });
    
    btnCancelar = new JButton("No");
    panelPrincipal.add(btnCancelar);
    btnCancelar.setBounds(60, 120, 120, 35);
    btnCancelar.setBackground(colorPersonalizado);
    btnCancelar.setForeground(Color.WHITE);
    btnCancelar.setFocusPainted(false);
    btnCancelar.addActionListener(new ActionListener(){
        
        public void actionPerformed(ActionEvent e){
        dispose();
        }
    
    });
    
    
}
    
    public ConfirmarCerrarSesion(MainFrame mainframe){
        this();
        this.mainFrame = mainframe;
}
        
    
}
