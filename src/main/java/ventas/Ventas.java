package ventas;

import conexion.ConexionBD;

import java.sql.*;

public class Ventas {
    private final ConexionBD conexion;


    public Ventas(){
    conexion = new ConexionBD();
    }


    public  double obtenerPrecio(String nombre){


        double resultado = 0.0;
        String consulta = "SELECT * FROM libro WHERE TITULO =?";
        try{
            Connection con = conexion.getConexion();
            PreparedStatement sentencia = con.prepareStatement(consulta);
            sentencia.setString(1,nombre);
            ResultSet resultadoConsulta = sentencia.executeQuery();
            while (resultadoConsulta.next()){
                resultado = resultadoConsulta.getDouble("PRECIO_VENTA");

            }

            }
        catch(SQLException e){

            System.out.println("Error: verifica tus datos " + e);
            return 0;

        }

        finally {
            conexion.cerrarConexion();
        }

        return resultado;
    }

}




