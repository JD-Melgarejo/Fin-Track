
package main;
import view.login.LoginFrame;
import view.login.ConfirmarCerrarSesion;
import view.gastos.PanelGastos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class MainFrame extends JFrame {
    
           private JPanel panelMenuSuperior;
           private JPanel panelMenuInferior;
           private JPanel panelPrincipal;
           private JPanel panelMenu;
           private JPanel panelContenido;
           
           private JButton btnIngresos;
           private JButton btnGastos;
           private JButton btnCuentas;
           private JButton btnMetas;
           private JButton btnReportes;
           private JButton btnConfiguracion;
           private JButton btnCerrarSesion;
               
           //GASTO
           private JButton btnRegistrarGasto;
           private JButton btnTiposGastos;
           private JButton btnCategoriasGasto;
           private boolean menuGastosExpandido = false;
           
    
           private void configurarBotonMenu(JButton boton){
           boton.setBackground(new Color(10, 36, 77));
           boton.setForeground(Color.WHITE);
           boton.setFocusPainted(false);
           boton.setBorderPainted(false);
           
        configurarBotonMenu(btnIngresos);
        configurarBotonMenu(btnGastos);
        configurarBotonMenu(btnCuentas);
        configurarBotonMenu(btnMetas);
        configurarBotonMenu(btnReportes);
        configurarBotonMenu(btnConfiguracion);
           

           }
    
    public MainFrame(){
    
        
    setTitle("FinTrack");
    setSize(1200, 700);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    
    panelPrincipal = new JPanel();
    add(panelPrincipal);
    
    panelPrincipal.setLayout(new BorderLayout());
    panelMenu = new JPanel();
    panelPrincipal.add(panelMenu, BorderLayout.WEST);
    panelMenu.setPreferredSize(new Dimension(220, 0));
    panelMenu.setLayout(new BorderLayout());
    panelMenu.setBackground(new Color(10, 36, 77));
    
    panelMenuSuperior = new JPanel();
    panelMenu.add(panelMenuSuperior, BorderLayout.CENTER);
    panelMenuSuperior.setBackground(new Color(10, 36, 77));
    panelMenuSuperior.setLayout(new javax.swing.BoxLayout(
        panelMenuSuperior,
        javax.swing.BoxLayout.Y_AXIS
));
    
    panelMenuInferior = new JPanel();
    panelMenu.add(panelMenuInferior, BorderLayout.SOUTH);
    panelMenuInferior.setBackground(new Color(10, 36, 77));
    
    
    btnIngresos = new JButton("Ingresos");
    panelMenuSuperior.add(btnIngresos);
    btnIngresos.setMaximumSize(new Dimension(220, 40));
    btnIngresos.setHorizontalAlignment(JButton.LEFT);
    btnIngresos.setBackground(new Color(10, 36, 77));
    btnIngresos.setForeground(Color.WHITE);
    btnIngresos.setFocusPainted(false);
    btnIngresos.setBorderPainted(false);
    
    //GASTOS
    
    btnGastos = new JButton("Gastos");
    panelMenuSuperior.add(btnGastos);
    btnGastos.setHorizontalAlignment(JButton.LEFT);
    btnGastos.setMaximumSize(new Dimension(220, 40));
    btnGastos.setBackground(new Color(10, 36, 77));
    btnGastos.setForeground(Color.WHITE);
    btnGastos.setFocusPainted(false);
    btnGastos.setBorderPainted(false);
    
    btnRegistrarGasto = new JButton("   Gestión de Gastos");
    panelMenuSuperior.add(btnRegistrarGasto);
    btnGastos.setMaximumSize(new Dimension(200, 40));
    btnRegistrarGasto.setHorizontalAlignment(JButton.LEFT);
    btnRegistrarGasto.setBackground(new Color(10, 30, 77));
    btnRegistrarGasto.setForeground(Color.WHITE);
    btnRegistrarGasto.setFocusPainted(false);
    btnRegistrarGasto.setBorderPainted(false);
    btnRegistrarGasto.setVisible(false);
    
    btnRegistrarGasto.addActionListener(new ActionListener(){
    
        public void actionPerformed(ActionEvent e){
            
            panelContenido.removeAll();
            panelContenido.add(new PanelGastos(MainFrame.this));
            panelContenido.revalidate();
            panelContenido.repaint();
        }
        
    });
    

    
    btnTiposGastos = new JButton("  Tipos de Gastos");
    panelMenuSuperior.add(btnTiposGastos);
    btnTiposGastos.setMaximumSize(new Dimension(200, 40));
    btnTiposGastos.setHorizontalAlignment(JButton.LEFT);
    btnTiposGastos.setBackground(new Color(10, 36, 77));
    btnTiposGastos.setForeground(Color.WHITE);
    btnTiposGastos.setFocusPainted(false);
    btnTiposGastos.setBorderPainted(false);
    btnTiposGastos.setVisible(false);
    
    btnCategoriasGasto = new JButton("  Categorias Gastos");
    panelMenuSuperior.add(btnCategoriasGasto);
    btnCategoriasGasto.setMaximumSize(new Dimension(200, 40));
    btnCategoriasGasto.setHorizontalAlignment(JButton.LEFT);
    btnCategoriasGasto.setBackground(new Color(10, 36, 77));
    btnCategoriasGasto.setForeground(Color.WHITE);
    btnCategoriasGasto.setFocusPainted(false);
    btnCategoriasGasto.setBorderPainted(false);
    btnCategoriasGasto.setVisible(false);
    
    btnGastos.addActionListener(new ActionListener(){
    
        public void actionPerformed(ActionEvent e){
            menuGastosExpandido = !menuGastosExpandido;
            btnRegistrarGasto.setVisible(menuGastosExpandido);
            btnTiposGastos.setVisible(menuGastosExpandido);
            btnCategoriasGasto.setVisible(menuGastosExpandido);
            

        }
    });
    
    
    btnCuentas = new JButton("Cuentas");
    panelMenuSuperior.add(btnCuentas);
    btnCuentas.setMaximumSize(new Dimension(200, 40));
    btnCuentas.setHorizontalAlignment(JButton.LEFT);
    btnCuentas.setBackground(new Color(10, 36, 77));
    btnCuentas.setForeground(Color.WHITE);
    btnCuentas.setFocusPainted(false);
    btnCuentas.setBorderPainted(false);
    
    btnMetas = new JButton("Metas");
    panelMenuSuperior.add(btnMetas);
    btnMetas.setMaximumSize(new Dimension(200, 40));
    btnMetas.setHorizontalAlignment(JButton.LEFT);
    btnMetas.setBackground(new Color(10, 36, 77));
    btnMetas.setForeground(Color.WHITE);
    btnMetas.setFocusPainted(false);
    btnMetas.setBorderPainted(false);
    
    btnReportes = new JButton("Reportes");
    panelMenuSuperior.add(btnReportes);
    btnReportes.setMaximumSize(new Dimension(200, 40));
    btnReportes.setHorizontalAlignment(JButton.LEFT);
    btnReportes.setBackground(new Color(10, 36, 77));
    btnReportes.setForeground(Color.WHITE);
    btnReportes.setFocusPainted(false);
    btnReportes.setBorderPainted(false);
    
    btnConfiguracion = new JButton("Configuracion");
    panelMenuSuperior.add(btnConfiguracion);
    btnConfiguracion.setMaximumSize(new Dimension(200, 40));
    btnConfiguracion.setHorizontalAlignment(JButton.LEFT);
    btnConfiguracion.setBackground(new Color(10, 36, 77));
    btnConfiguracion.setForeground(Color.WHITE);
    btnConfiguracion.setFocusPainted(false);
    btnConfiguracion.setBorderPainted(false);
    
    btnCerrarSesion = new JButton("Cerrar Sesion");
    panelMenuInferior.add(btnCerrarSesion);
    btnCerrarSesion.setBounds(10, 600, 200, 40);
    btnCerrarSesion.setBackground(new Color(10, 36, 77));
    btnCerrarSesion.setForeground(Color.WHITE);
    btnCerrarSesion.setFocusPainted(false);
    btnCerrarSesion.setBorderPainted(false);
    
    btnCerrarSesion.addActionListener(new ActionListener(){
            
        public void actionPerformed(ActionEvent e){
            LoginFrame loginFrame = new LoginFrame();
            
            ConfirmarCerrarSesion confirmar = new ConfirmarCerrarSesion(MainFrame.this);
            confirmar.setVisible(true);
        }
    });
   
    panelContenido = new JPanel();
    panelPrincipal.add(panelContenido, BorderLayout.CENTER);
    }
    
    public void mostrarPanel(JPanel panel){
    
        System.out.println("Monstrar" + panel.getClass().getName());
    panelContenido.removeAll();
    panelContenido.add(panel);
    panelContenido.revalidate();
    panelContenido.repaint();
    }
    
}
