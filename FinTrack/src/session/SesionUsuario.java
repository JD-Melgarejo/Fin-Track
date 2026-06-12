package session;


public class SesionUsuario {
    
    private static int idUsuario;
    
    public static void setIdUsuario(int idUsuario){
        SesionUsuario.idUsuario = idUsuario;
    }
    public static int getIdUsuario(){
        return idUsuario;
    }
            
}
