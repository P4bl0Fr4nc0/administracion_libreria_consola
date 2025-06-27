package consultas;

import conexion.ConexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultas {

    private ConexionBD conexion;




    public Consultas() {

        conexion = new ConexionBD();


    }


    public void consultaAutor(){

    try {

        Connection con = conexion.getConexion();


        Statement sentencia = con.createStatement();

        ResultSet resultado = sentencia.executeQuery("SELECT * FROM autor");


        System.out.println("COD======NOMBRE======APELLIDO=====FECHA DE NACIMIENTO======PAIS======CIUDAD==========================================================");
        while (resultado.next()) {
            System.out.println("=================================================================================================================================================");
            System.out.println(resultado.getString("CODIGO_AUTOR") + "   |  " + resultado.getString("NOMBRE") + "   |   " + resultado.getString("APELLIDO_P")
                    + " " + resultado.getString("APELLIDO_") + "  |       " + resultado.getDate("FECHA_NACIMIENTO") + "      |    " + resultado.getString("PAIS")
                    + "  |   " + resultado.getString("CIUDAD") + "  |    " + resultado.getString("OBSERVACIONES"));
            System.out.println("=================================================================================================================================================");

        }


    }
    catch(SQLException e) {
            System.out.println("Error de conexion a la base de datos:" + e.getMessage());
        }

    }

    public void consultarEditorial(){
        try {

            Connection con = conexion.getConexion();


            Statement sentencia = con.createStatement();

            ResultSet resultado = sentencia.executeQuery("SELECT * FROM editorial");


            System.out.println("CODIGO======NOMBRE======TELEFONO=====CONTACTO======DIRECCION======CIUDAD======PAIS===================================================");
            while (resultado.next()) {
                System.out.println("=================================================================================================================================================");
                System.out.println(resultado.getString("CODIGO_EDITORIAL") + "   |  " + resultado.getString("NOMBRE") + "   |   " + resultado.getString("TELEFONO")
                        + " " + resultado.getString("CONTACTO") + "  |       " + resultado.getString("DIRECCION") + "      |    " + resultado.getString("PAIS")
                        + "  |   " + resultado.getString("CIUDAD"));
                System.out.println("=================================================================================================================================================");

            }


        }
        catch(SQLException e) {
            System.out.println("Error de conexion a la base de datos:" + e.getMessage());
        }
    }

    public void consultarClientes(){
        try {

            Connection con = conexion.getConexion();


            Statement sentencia = con.createStatement();

            ResultSet resultado = sentencia.executeQuery("SELECT * FROM clientes");


            System.out.println("ID ClIENTE======NOMBRE======EMAIL======TELEFONO======DIRECCION================");
            while (resultado.next()) {
                System.out.println("=================================================================================================================================================");
                System.out.println(resultado.getString("ID_CLIENTE") + "   |  " + resultado.getString("NOMBRE_CLIENTE") + "   |   " + resultado.getString("EMAIL")
                        + " " + resultado.getString("TELEFONO") + "  |       " + resultado.getString("DIRECCION"));
                System.out.println("=================================================================================================================================================");

            }


        }
        catch(SQLException e) {
            System.out.println("Error de conexion a la base de datos:" + e.getMessage());
        }


    }

    public void consultarLibro(){

        try {

            Connection con = conexion.getConexion();


            Statement sentencia = con.createStatement();

            ResultSet resultado = sentencia.executeQuery("SELECT * FROM libro");


            System.out.println("ISBN======TITULO======COD_AUT======COD_EDT======EDICION======LUGAR_EDC======NUM_EDC=======PRECIO======TIPO CUBIERTA=======PAGINAS======ESTANTE======EJEMPLARES======OBS======COD_BARRAS");
            while (resultado.next()) {
                System.out.println("=================================================================================================================================================");
                System.out.println(resultado.getString("ISBN") + "   |  " + resultado.getString("TITULO") + "   |   " + resultado.getString("CODIGO_AUTOR")
                        + " " + resultado.getString("CODIGO_EDITORIAL") + "  |       " + resultado.getString("EDICION") + "      |    " + resultado.getString("LUGAR_EDICION")
                        + "  |   " + resultado.getString("NUMERO_EDICION") + "  |    " + resultado.getDouble("PRECIO_VENTA")+ "      |    " + resultado.getString("TIPO_CUBIERTA")
                        + "      |    " + resultado.getString("PAGINAS")+ "      |    " + resultado.getString("ESTANTERIA")+ "      |    " + resultado.getInt("NUMERO_EJEMPLARES")
                        + "      |    " + resultado.getString("OBSERVACIONES")+ "      |    " + resultado.getString("CODIGO_BARRAS"));
                System.out.println("=================================================================================================================================================");

            }


        }
        catch(SQLException e) {
            System.out.println("Error de conexion a la base de datos:" + e.getMessage());
        }
    }

    public void consultarVentasPeriodo(String fechaInicial, String fechaFinal){

        try {

            Connection con = conexion.getConexion();


            Statement sentencia = con.createStatement();

            ResultSet resultado = sentencia.executeQuery("SELECT SUM(total) AS TOTAL_VENTAS_DEL_PERIODO FROM ventas WHERE venta_fecha BETWEEN" + "'" +fechaInicial + "'" + "AND" + "'" + fechaFinal+"'");


            System.out.println("===============VENTAS EN EL PERIODO COMPRENDIDO DEL " + fechaInicial + " AL " + fechaFinal + "================");
            while (resultado.next()) {
                System.out.println("=================================================================================================================================================");
                System.out.println(resultado.getDouble("TOTAL_VENTAS_DEL_PERIODO"));
                System.out.println("=================================================================================================================================================");

            }


        }
        catch(SQLException e) {
            System.out.println("Error de conexion a la base de datos:" + e.getMessage());
        }

    }

    public void consultarVentas(){

        try {

            Connection con = conexion.getConexion();


            Statement sentencia = con.createStatement();

            ResultSet resultado = sentencia.executeQuery("SELECT * FROM ventas");


            System.out.println("ID VENTA======TOTAL======PAGO======CAMBIO======FORMA DE PAGO======FECHA DE VENTA================");
            while (resultado.next()) {
                System.out.println("=================================================================================================================================================");
                System.out.println(resultado.getInt("id_venta") + "   |  " + resultado.getString("total") + "   |   " + resultado.getString("cantidad_pagada")
                        + "      |      " + resultado.getString("cambio") + "  |       " + resultado.getString("tipo_pago")+ "  |       " + resultado.getDate("fecha_venta"));
                System.out.println("=================================================================================================================================================");

            }


        }
        catch(SQLException e) {
            System.out.println("Error de conexion a la base de datos:" + e.getMessage());
        }

    }



    }






