package model;


public class Gasto {
    
    private int id;
    private String descripcion;
    private double monto;
    private String categoria;
    private String observacion;
    private int idUsuario;
    private String fecha;
    
    public Gasto(

          String descripcion,
          double monto,
          String categoria,
          String observacion,
          int idUsuario,
          int id
         ){

    this.descripcion = descripcion;
    this.monto = monto;
    this.categoria = categoria;
    this.observacion = observacion;
    this.idUsuario = idUsuario;
    this.id = id;
    }
    
    public Gasto(
    String descripcion,
    double monto,
    String categoria,
    String observacion,
    int idUsuario
){
    this.descripcion = descripcion;
    this.monto = monto;
    this.categoria = categoria;
    this.observacion = observacion;
    this.idUsuario = idUsuario;
}
    
    public int getId(){
    return id;}
    public void setId(int id){
    this.id = id;
    }
    
    public String getDescripcion(){
    return descripcion;
    }
    public void setDescripcion(String descripcion){
    this.descripcion = descripcion;
    }
    
    public double getMonto(){
    return monto;
    }
    public void setMonto(double monto){
    this.monto = monto;
    }
    
    public String getCategoria(){
    return categoria;
    }
    public void setCategoria(String categoria){
    this.categoria  = categoria;
    }
    
    public String getObservacion(){
    return observacion;
    }
    public void setObservacion(String observacion){
    this.observacion = observacion;}
    
    public int getidUsuario(){
    return idUsuario;
    }
    public void setidUsuario(int idUsuario){
    this.idUsuario = idUsuario;}
    
    public String getFecha(){
    return fecha;
    }
    public void setFecha(String fecha){
    this.fecha = fecha;
    }
    
    @Override
    public String toString(){
        return "Gasto{" +
                "descripcion='" + descripcion + '\'' +
                ", monto=" + monto +
                ", categoria='" + categoria + '\'' +
                ", observacion='" + observacion + '\'' +
                ", idusuario=" + idUsuario +
                '}';    
    }}

