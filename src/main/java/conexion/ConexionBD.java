package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private Connection conexion;


    public ConexionBD() {


                String  url = "Database";
        String usuario = "usuario";
        String password = "password";


        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            //System.out.println("Conexión exitosa");


        }
        catch (SQLException e ){

            System.out.println("Error al conectarse a la base de datos " + e.getMessage());

        }

    }

    public Connection getConexion() {
        return conexion;
    }

    public void  cerrarConexion(){

        try {
            if (conexion != null) {
                conexion.close();


            }

        }
        catch (SQLException e) {
            System.out.println("Error: no se puedo cerrar la conexion a la base de datos" + e.getMessage());

        }
    }
}
