package main;
import view.login.LoginFrame;
import database.ConexionBD;


public class Main {
    
    public static void main(String[] args){
    
    LoginFrame loginframe = new LoginFrame();
    loginframe.setVisible(true);    
    ConexionBD conexionBD = new ConexionBD();
    conexionBD.conectar();
    }
    
}