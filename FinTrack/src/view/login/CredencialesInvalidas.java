package view.login;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CredencialesInvalidas extends JDialog{
    
    private JPanel panelPrincipal;
    
    private JLabel lblTitulo;
    private JLabel lblMensaje;
    
    private JButton btnAceptar;
    
    public CredencialesInvalidas(){
    setTitle("Inicio de Sesión");
    setSize(400, 200);
    setLocationRelativeTo(null);
    setModal(true);
    setResizable(false);
    Color colorPersonalizado = new Color(10, 36, 77);
    
    panelPrincipal = new JPanel();
    add(panelPrincipal);
    panelPrincipal.setLayout(null);
    panelPrincipal.setBackground(Color.WHITE);
    
    lblTitulo = new JLabel("Inicio de sesión");
    panelPrincipal.add(lblTitulo);
    lblTitulo.setBounds(110, 20, 200, 30);
    lblTitulo.setFont(new Font("SnasSerif", Font.BOLD, 18));
    lblTitulo.setForeground(new Color(10, 36, 77));
    
    lblMensaje = new JLabel("Usuario o contraseña incorrectos");
    panelPrincipal.add(lblMensaje);
    lblMensaje.setBounds(70, 70, 260, 30);
    lblMensaje.setFont(new Font("SansSerif", Font.PLAIN, 14));
    lblMensaje.setForeground(new Color(80, 80, 80));
    
    btnAceptar = new JButton("Aceptar");
    panelPrincipal.add(btnAceptar);
    btnAceptar.setBounds(140, 120, 120, 35);
    btnAceptar.setBackground(colorPersonalizado);
    btnAceptar.setForeground(Color.WHITE);
    btnAceptar.setFocusPainted(false);
    btnAceptar.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
    dispose();
    }
    });
    
    }
    
}
