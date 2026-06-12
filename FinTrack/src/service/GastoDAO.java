package service;

import model.Gasto;
import database.ConexionBD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

public class GastoDAO {
    
    private Connection conexion;
    
    public GastoDAO(){
    ConexionBD conexionBD = new ConexionBD();
    conexion = conexionBD.conectar();
    }
    public boolean insertar(Gasto gasto){
    String sql =
            "INSERT INTO GASTO " +
            "(GAS_DESCRIPCION, GAS_MONTO, GAS_CATEGORIA, GAS_OBSERVACION, USR_ID) " +
            "VALUES (?, ?, ?, ?, ?)";
     try{

        PreparedStatement ps =
                conexion.prepareStatement(sql);

        ps.setString(1, gasto.getDescripcion());

        ps.setDouble(2, gasto.getMonto());

        ps.setString(3, gasto.getCategoria());

        ps.setString(4, gasto.getObservacion());

        ps.setInt(5, gasto.getidUsuario());

        ps.executeUpdate();

        return true;

    }catch(SQLException e){

        System.out.println(
            "Error al insertar gasto: "
            + e.getMessage()
        );

        return false;
    }
     
     
    }
    public List<Gasto> listar(int idUsuario){
         List<Gasto> lista = new ArrayList<>();
         
         String sql =
        "SELECT GAS_ID, GAS_FECHA, GAS_CATEGORIA, " +
        "GAS_DESCRIPCION, GAS_MONTO " +
        "FROM GASTO " +
        "WHERE USR_ID = ? " +
        "ORDER BY GAS_FECHA DESC";
        
         try{

    PreparedStatement ps =
        conexion.prepareStatement(sql);

    ps.setInt(1, idUsuario);

    ResultSet rs = ps.executeQuery();

    while(rs.next()){       

   
        
        String descripcion =
            rs.getString("GAS_DESCRIPCION");

        double monto =
            rs.getDouble("GAS_MONTO");

        String categoria =
            rs.getString("GAS_CATEGORIA");

        Gasto gasto = new Gasto(
            descripcion,
            monto,
            categoria,
            "",
            idUsuario,
            rs.getInt("GAS_ID")
        );
        gasto.setFecha(
        rs.getString("GAS_FECHA")
        );

        lista.add(gasto);

    }

}catch(SQLException e){

    System.out.println(
        "Error al listar gastos: "
        + e.getMessage()
    );
}
          return lista;
}
}

