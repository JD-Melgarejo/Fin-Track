package view.login;
import database.ConexionBD;
import main.MainFrame;
import session.SesionUsuario;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.Timer;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;

import javax.swing.JOptionPane;

public class LoginFrame extends JFrame{
    
    private JPanel panelPrincipal;
    private JPanel panelIzquierdo;
    private JPanel panelDerecho;
    private PanelLogin panelLogin;

    
    
    private JLabel lblTitulo;
    private JLabel lblSubtitulo;
    private JLabel lblUsuario;
    private JLabel lblContraseña;
    private JLabel lblLogo;
    
    private JTextField tfeUsuario;
    private JPasswordField tfeContraseña;

    private JButton btnIniciarSesion;
    private JButton btnMostrarOcultar;

    
    public LoginFrame() {
    
        setTitle("FinTrack");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);


        panelPrincipal = new JPanel();
        add(panelPrincipal);
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setLayout(new BorderLayout());
        Color colorPersonalizado = new Color(10, 36, 77);

        panelIzquierdo = new JPanel();
        panelPrincipal.add(panelIzquierdo, BorderLayout.WEST);
        panelIzquierdo.setBackground(colorPersonalizado);
        panelIzquierdo.setPreferredSize(new Dimension(400, 0));
        
        lblLogo = new JLabel();
        panelIzquierdo.add(lblLogo);
        panelIzquierdo.setLayout(null);
        panelIzquierdo = new JPanel();
        lblLogo.setBounds(0, -25, 395, 500);
        ImageIcon logo = new ImageIcon(getClass().getResource("/img/logo_oficial_FINETRACK.png"));
        Image imagenEscalada = logo.getImage().getScaledInstance(
        395,
        500,
        Image.SCALE_SMOOTH
        );
        
        lblLogo.setIcon(new ImageIcon(imagenEscalada));
        
        panelDerecho = new JPanel();
        panelPrincipal.add(panelDerecho, BorderLayout.CENTER);
        panelDerecho.setBackground(Color.WHITE);
        panelDerecho.setLayout(null);
        
        panelLogin = new PanelLogin();
        panelDerecho.add(panelLogin);
        panelLogin.setLayout(null);
        panelLogin.setBounds(70, 70, 400, 320);
        lblTitulo = new  JLabel("Acceso Seguro al Sistema");
        panelLogin.add(lblTitulo, BorderLayout.CENTER);
        lblTitulo.setBounds(40, 50, 400, 30);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        Color colorlbl = new Color(60, 60, 60);
        lblTitulo.setForeground(colorlbl);

        lblSubtitulo = new JLabel("Inicia sesión para continuar");
        panelLogin.add(lblSubtitulo, BorderLayout.CENTER);
        lblSubtitulo.setBounds(70, 100, 400, 30);
        lblSubtitulo.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lblSubtitulo.setForeground(colorlbl);

        lblUsuario = new JLabel("Usuario:");
        panelLogin.add(lblUsuario, BorderLayout.CENTER);
        lblUsuario.setBounds(40, 160, 400, 40);
        lblUsuario.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblUsuario.setForeground(colorlbl);

        lblContraseña = new JLabel("Contraseña:");
        panelLogin.add(lblContraseña, BorderLayout.CENTER);
        lblContraseña.setBounds(40, 210, 400, 40);
        lblContraseña.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblContraseña.setForeground(colorlbl);

        tfeUsuario = new JTextField("Ingrese su Usuario");
        panelLogin.add(tfeUsuario, BorderLayout.CENTER);
        tfeUsuario.setBounds(130, 165, 160, 30);
        tfeUsuario.setBorder(new MatteBorder(0, 0, 1, 0, colorlbl));
        tfeUsuario.addFocusListener(
            new FocusListener(){

                public void focusGained(FocusEvent e){
                    if (tfeUsuario.getText().equals("Ingrese su Usuario"))
                        tfeUsuario.setText("");
                    tfeUsuario.setBorder(new MatteBorder(0, 0, 2, 0, new Color(10, 36, 77)));
                }

           public void focusLost(FocusEvent e){
                     if (tfeUsuario.getText().equals(""))
                        tfeUsuario.setText("Ingrese su Usuario");
                     tfeUsuario.setBorder(new MatteBorder(0, 0, 1, 0, new Color(210, 210, 210)));
                }

    });

        btnMostrarOcultar = new JButton("Ver");
        panelLogin.add(btnMostrarOcultar);
        btnMostrarOcultar.setBounds(290, 220, 60, 20);
        btnMostrarOcultar.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnMostrarOcultar.setForeground(colorPersonalizado);
        btnMostrarOcultar.setBackground(colorPersonalizado);
        btnMostrarOcultar.setFocusPainted(false);
        btnMostrarOcultar.setBorderPainted(false);
        btnMostrarOcultar.setContentAreaFilled(false);
        btnMostrarOcultar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnMostrarOcultar.addActionListener(

            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                if (tfeContraseña.getEchoChar() != 0){
                    tfeContraseña.setEchoChar((char)0);
                } else {
                    tfeContraseña.setEchoChar('*');
                }
                }
            }

        );
        
        btnMostrarOcultar.addMouseListener(
            new MouseAdapter(){

                public void mouseEntered(MouseEvent e){
                    btnMostrarOcultar.setBorder(new LineBorder(new Color(180, 180, 180), 2));
                    btnMostrarOcultar.setBackground(new Color(220,220,220));
                    btnMostrarOcultar.setContentAreaFilled(true);
                }

                public void mouseExited(MouseEvent e){
                    btnMostrarOcultar.setBorder(new LineBorder(colorPersonalizado, 1));
                    btnMostrarOcultar.setContentAreaFilled(false);
                }

            }
        );

        tfeContraseña = new JPasswordField("Ingrese su Contraseña");
        panelLogin.add(tfeContraseña);
        tfeContraseña.setBounds(130, 215, 160, 30);
        tfeContraseña.setBorder(new MatteBorder(0, 0, 1, 0, colorlbl));
        tfeContraseña.addFocusListener(
            new FocusListener(){
                
                public void focusGained(FocusEvent e){
                    if (String.valueOf(tfeContraseña.getPassword()).equals("Ingrese su Contraseña"))
                        tfeContraseña.setText("");
                    tfeContraseña.setBorder(new MatteBorder(0, 0, 2, 0, new Color(10, 36, 77)));
                }
                public void focusLost(FocusEvent e){
                    if (String.valueOf(tfeContraseña.getPassword()).equals(""))
                        tfeContraseña.setText("Ingrese su Contraseña");
                    tfeContraseña.setBorder(new MatteBorder(0, 0, 1, 0, new Color(210, 210, 210)));
                }
            });

        btnIniciarSesion = new JButton("Iniciar Sesión");
        panelLogin.add(btnIniciarSesion, BorderLayout.CENTER);
        btnIniciarSesion.setBounds(110, 270, 150, 30);
        btnIniciarSesion.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnIniciarSesion.setForeground(Color.WHITE);
        btnIniciarSesion.setBackground(colorPersonalizado);
        btnIniciarSesion.setFocusPainted(false);
        btnIniciarSesion.setBorderPainted(true);
        btnIniciarSesion.setContentAreaFilled(true);
        btnIniciarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnIniciarSesion.addMouseListener(
            new MouseAdapter(){

                public void mouseEntered(MouseEvent e){
                    btnIniciarSesion.setBorder(new LineBorder(new Color(248, 248, 248), 2));
                }

                public void mouseExited(MouseEvent e){
                    btnIniciarSesion.setBorder(new LineBorder(colorPersonalizado, 1));
                }
                 });
                
  
        btnIniciarSesion.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
                
            String usuario = tfeUsuario.getText();
            String contraseña = String.valueOf(tfeContraseña.getPassword());      
            
            ConexionBD conexionBD = new ConexionBD();
            Connection conexion = conexionBD.conectar();
            
            String sql = "SELECT * FROM USR WHERE USR_NOMBRE = ? AND USR_PSW = ?";
            
            try{
            PreparedStatement ps = conexion.prepareStatement(sql);  
            
             ps.setString(1, usuario);
             ps.setString(2, contraseña);
            
            ResultSet rs = ps.executeQuery();
            
            
          
                                          
           boolean existe = rs.next();

        if (existe){

            int idUsuario = rs.getInt("USR_ID");
            
            SesionUsuario.setIdUsuario(idUsuario);

            String sqlLogin = "INSERT INTO USR_LOGIN(ID_USR_LOGIN) VALUES (?)";

            PreparedStatement psLogin = conexion.prepareStatement(sqlLogin);

            psLogin.setInt(1, idUsuario);


         psLogin.executeUpdate();
         
         NotificacionLogin notificacion = new NotificacionLogin(usuario);
         notificacion.setVisible(true);
         
         Timer timer = new Timer(3000, new ActionListener() {

    public void actionPerformed(ActionEvent e) {

         MainFrame mainFrame = new MainFrame();
         mainFrame.setVisible(true);
         dispose();

    }

});

timer.setRepeats(false);
timer.start();
         

        } else {

             CredencialesInvalidas credencialesInvalidas =
                     new CredencialesInvalidas();
             
             credencialesInvalidas.setVisible(true);

        }
            
            } catch (SQLException ex){
                ex.printStackTrace();
            }
            
        }
        });
        
           }   
        
    }
