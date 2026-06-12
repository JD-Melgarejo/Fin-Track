package view.gastos;

import main.MainFrame;
import service.GastoDAO;
import session.SesionUsuario;
import model.Gasto;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.List;

public class PanelGastos extends JPanel{
    
    private JButton btnIncluir;
    private JButton btnEditar;
    private JButton btnBorrar;
    private JButton btnOtrasOpciones;
    
    private JLabel lblTituloGastos;
    private JLabel lblBuscar;
    
    private JTextField txtBuscar;
    
    private JTable tablaGastos;
    private DefaultTableModel modeloTabla;
    private JScrollPane scrollTabla;
    
    private MainFrame mainFrame;
    
    public PanelGastos(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    setLayout(null);
    setBackground(Color.WHITE);
    setPreferredSize(new Dimension(950, 650));
    
    lblTituloGastos = new JLabel("Gestión de Gastos");
    add(lblTituloGastos);
    lblTituloGastos.setBounds(30, 20, 300, 40);
    lblTituloGastos.setFont(new Font("SansSerif", Font.BOLD, 14));
    
    btnIncluir = new JButton("Incluir");
    add(btnIncluir);
    btnIncluir.setBounds(20, 80, 120, 50);
    btnIncluir.addActionListener(new ActionListener(){
    
    public void actionPerformed(ActionEvent e){
    mainFrame.mostrarPanel(
    new PanelNuevoGasto(mainFrame)
    );
    }
    });
    
    btnEditar = new JButton("Editar");
    add(btnEditar);
    btnEditar.setBounds(150, 80, 120, 50);
    
    btnBorrar = new JButton("Borrar");
    add(btnBorrar);
    btnBorrar.setBounds(280, 80, 120, 50);
    
    btnOtrasOpciones = new JButton("Otras Opciones");
    add(btnOtrasOpciones);
    btnOtrasOpciones.setBounds(418, 80, 160, 50);   
    
    txtBuscar = new JTextField("Buscar");
    add(txtBuscar);
    txtBuscar.setBounds(750, 90, 130, 30);
    
    ImageIcon iconoLupa = new ImageIcon(
            getClass().getResource("/img/iconobuscar.png"));
    Image imagen = iconoLupa.getImage();
    Image imagenEscalada = imagen.getScaledInstance(
    24,
    24,
    Image.SCALE_SMOOTH
    );
    
    iconoLupa = new ImageIcon(imagenEscalada);
    
    lblBuscar = new JLabel(iconoLupa);
    add(lblBuscar);
    lblBuscar.setBounds(880, 90, 30, 30);
    
    
    
    String[] columnas = {
    
        "ID",
        "Fecha",
        "Categoria",
        "Descripcion",
        "Monto"
     };
    
    modeloTabla = new DefaultTableModel(
    columnas,
    0
);

    tablaGastos = new JTable(modeloTabla);
    scrollTabla = new JScrollPane(tablaGastos);
    add(scrollTabla);
    scrollTabla.setBounds(20, 150, 900, 450);
    cargarGastos();
    }
    private void cargarGastos(){
    GastoDAO gastoDAO = new GastoDAO();

List<Gasto> lista =
    gastoDAO.listar(
        SesionUsuario.getIdUsuario()
    );

modeloTabla.setRowCount(0);

for(Gasto gasto : lista){

    modeloTabla.addRow(
        new Object[]{
            gasto.getId(),
            gasto.getFecha(),
            gasto.getCategoria(),
            gasto.getDescripcion(),
            gasto.getMonto()
        }
    );
}
    }
    
}
