package ec.edu.espe.rest;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD
{
    private static final String URL = "jdbc:mysql://den1.mysql4.gear.host/ifttt";
    private static final String USUARIO = "ifttt";
    private static final String CONTRASEÑA = "Ik7IU_hKU3L~";
    private static ConexionBD instancia;
    private static Connection conexion;

    private ConexionBD()
    {
        conexion = iniciarConexion();
    }

    private Connection iniciarConexion()
    {
        Connection conexionAux = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conexionAux = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return conexionAux;
    }
    
    public static Connection getConexion()
    {
        if (instancia == null || conexion==null)
        {
            instancia = new ConexionBD();
        }
        return conexion;
    }
}
