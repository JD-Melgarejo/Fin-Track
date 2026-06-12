
package view.gastos;

import main.MainFrame;
import service.GastoDAO;
import model.Gasto;
import session.SesionUsuario;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelNuevoGasto extends JPanel{
    
    private JLabel lblTitulo;
    
    private JLabel lblDescripcion;
    private JLabel lblMonto;
    private JLabel lblCategoria;
    private JLabel lblObservacion;
    
    private JTextField txtDescripcion;
    private JTextField txtMonto;
    private JTextField txtCategoria;
    private JTextField txtObservacion;
    
    private JButton btnAgregar;
    private JButton btnGuardarTodo;
    private JButton btnCancelar;
    
    private JTable tablaGastos;
    private JScrollPane scrollTabla;
    
    private DefaultTableModel modeloTabla;
    
    private MainFrame mainFrame;
    
    
    public PanelNuevoGasto(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        setLayout(null);
        setBackground(java.awt.Color.WHITE);
         setPreferredSize(
        new java.awt.Dimension(950,650));
        
        JLabel lblTitulo = new JLabel("Nuevo Gasto");
        add(lblTitulo);
        lblTitulo.setBounds(30, 20, 200, 30);
        
        lblTitulo = new JLabel("Nuevo Gasto");
        add(lblTitulo);
        lblTitulo.setBounds(30, 20, 200, 30);
        
        lblDescripcion = new JLabel("Descripcion:");
        add(lblDescripcion);
        lblDescripcion.setBounds(30, 70, 100, 25);
        
        txtDescripcion = new JTextField();
        add(txtDescripcion);
        txtDescripcion.setBounds(140, 70, 250, 25);
        
        
        lblMonto = new JLabel("Monto:");
        add(lblMonto);
        lblMonto.setBounds(30,110,100,25);
        
        txtMonto = new JTextField();
        add(txtMonto);
        txtMonto.setBounds(140,110,250,25);
        
        
        lblCategoria = new JLabel("Categoría:");
        add(lblCategoria);
        lblCategoria.setBounds(30,150,100,25);

        txtCategoria = new JTextField();
        add(txtCategoria);
        txtCategoria.setBounds(140,150,250,25);
        
        
        lblObservacion = new JLabel("Observación:");
        add(lblObservacion);
        lblObservacion.setBounds(30,190,100,25);

        txtObservacion = new JTextField();
        add(txtObservacion);
        txtObservacion.setBounds(140,190,250,25);
        
        
        btnAgregar = new JButton("Agregar");
        add(btnAgregar);
        btnAgregar.setBounds(420, 150, 120, 40);
        btnAgregar.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent e){
                
            if(txtDescripcion.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(PanelNuevoGasto.this, "Debe ingresar una descripción.");
            txtDescripcion.requestFocus();
            return;}
            if(txtCategoria.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(PanelNuevoGasto.this, "Debe ingresar una categoria.");
            txtCategoria.requestFocus();
            return;}
             if(txtMonto.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(PanelNuevoGasto.this, "Debe ingresar un monto.");
            txtMonto.requestFocus();
            return;}
             try{
             Double.parseDouble(
             txtMonto.getText());
             }catch(NumberFormatException ex){
             JOptionPane.showMessageDialog(PanelNuevoGasto.this, "El monto debe ser numérico.");
             txtMonto.requestFocus();
             return;
             };
             
              if(txtObservacion.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(PanelNuevoGasto.this, "Debe ingresar una descripción.");
            txtObservacion.requestFocus();
            return;}
            
            modeloTabla.addRow(
            new Object[]{
                txtDescripcion.getText(),
                txtCategoria.getText(),
                txtMonto.getText(),
                txtObservacion.getText()
            }
            );
            txtDescripcion.setText("");
            txtMonto.setText("");
            txtCategoria.setText("");
            txtObservacion.setText("");
            txtDescripcion.requestFocus();
                
            }
            
        });
        String[] columnas ={
         "Descripción",
         "Categoria",
         "Monto",
         "Observacion"
        };
        modeloTabla = new DefaultTableModel(columnas,0);
        tablaGastos = new JTable(modeloTabla);
        scrollTabla = new JScrollPane(tablaGastos);
        add(scrollTabla);
        scrollTabla.setBounds(30, 260, 850, 250);
        
        btnGuardarTodo = new JButton("Guardar Todo");
        add(btnGuardarTodo);
        btnGuardarTodo.setBounds(600, 540, 130, 40);
        GastoDAO gastoDAO = new GastoDAO();
        btnGuardarTodo.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            boolean todoCorrecto = true;
        for(int i = 0;
                i < modeloTabla.getRowCount();
                i++){
        String descripcion = modeloTabla.getValueAt(i,0).toString(); 
        String categoria = modeloTabla.getValueAt(i,1).toString();
        double monto = Double.parseDouble(modeloTabla.getValueAt(i,2).toString());
        String observacion = modeloTabla.getValueAt(i,3).toString();
        
        int idUsuario = SesionUsuario.getIdUsuario();
        Gasto gasto = new Gasto(
            descripcion,
            monto,
            categoria,
            observacion,
            idUsuario   
        );
        boolean resultado = gastoDAO.insertar(gasto);
        if(!resultado){
        todoCorrecto = false;
        break;
        }
        }
        if(todoCorrecto){
        JOptionPane.showMessageDialog(
        PanelNuevoGasto.this,
                "Gastos Guardados Correctamente.");
        mainFrame.mostrarPanel(new PanelGastos(mainFrame));
        }else{
        JOptionPane.showMessageDialog(PanelNuevoGasto.this,
                "Ocurrió un error al guardar los gastos.");}
        }
        });
      
        btnCancelar = new JButton("Cancelar");
        add(btnCancelar);
        btnCancelar.setBounds(750, 540, 130, 40);
        btnCancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            mainFrame.mostrarPanel(
            new PanelGastos(mainFrame)
            );
            }
        });
    }
    
}
