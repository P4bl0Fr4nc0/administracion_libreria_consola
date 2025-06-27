package inserccion;

import conexion.ConexionBD;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.Scanner;

public class InsertarDatos {

    private ConexionBD conexion;
    Scanner entrada  = new Scanner(System.in);



    public InsertarDatos (){
        conexion = new ConexionBD();
    }


    public void insertarDatosAutor(){



        System.out.println("Inserte el codigo del Autor: ");
        String codigo = entrada.nextLine();
        System.out.println("Inserte el nombre del Autor: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese Apellido paterno: ");
        String apellidoP = entrada.nextLine();
        System.out.println("ingresa el apellido materno: ");
        String apellidoM = entrada.nextLine();
        System.out.println("Ingresa la fecha de nacimiento YYYY-MM-DD: ");
        String fechaN = entrada.nextLine();
        System.out.println("Ingresa el Pais de nacimiento del autor: ");
        String pais = entrada.nextLine();
        System.out.println("Ingresa la ciudad de nacimiento del autor: ");
        String ciudad = entrada.nextLine();
        System.out.println("Observaciones: ");
        String obsrvaciones = entrada.nextLine();



      //  System.out.println(consulta);

        try {
                String consulta = "INSERT INTO autor (CODIGO_AUTOR, NOMBRE, APELLIDO_P, APELLIDO_, FECHA_NACIMIENTO, PAIS, CIUDAD, OBSERVACIONES)" +
                "VALUES ("+"'"+codigo+"'"+","+"'"+nombre+"'"+","+"'"+apellidoP+"'"+","+"'"+apellidoM+"'"+","+"'"+fechaN+"'"+","+"'"+pais+"'"+","+"'"+ciudad+"'"+","+"'"+obsrvaciones+"'"+")";
          //  String consulta = "INSERT INTO autor (CODIGO_AUTOR, NOMBRE, APELLIDO_P, APELLIDO_, FECHA_NACIMIENTO, PAIS, CIUDAD, OBERVACIONES)" +
          //          "VALUES ("+codigo+nombre+apellidoP+apellidoM+fechaN+pais+ciudad+obsrvaciones+")";

            PreparedStatement statement = conexion.getConexion().prepareStatement(consulta);
            statement.executeUpdate();
            System.out.println("Los datos se han insertado correctamente");

        }
        catch (SQLException e) {

            System.out.println("Error al insertar datos, favor de verificar" + e.getMessage());


        }



    }

    public void insertarEditorial (){
        System.out.println("Ingrese el código de la editorial: ");
        String  codigo = entrada.nextLine();
        System.out.println("Ingrese el nombre de la editorial: ");
        String  nombre = entrada.nextLine();
        System.out.println("Ingrese el teléfono de la editorial (xx)xx-xx-xx-xx-xx: ");
        String  telefono = entrada.nextLine();
        System.out.println("Ingrese la persona de contacto de la editorial: ");
        String  contacto = entrada.nextLine();
        System.out.println("Ingrese la dirección de la editorial: ");
        String  direccion = entrada.nextLine();
        System.out.println("Ingrese el Pais de la editorial: ");
        String  pais = entrada.nextLine();
        System.out.println("Ingrese la ciudad de la editorial: ");
        String  ciudad = entrada.nextLine();

        try {
            String consulta = "INSERT INTO editorial (CODIGO_EDITORIAL, NOMBRE, TELEFONO, CONTACTO, DIRECCION, CIUDAD, PAIS)" +
                    "VALUES ("+"'"+codigo+"'"+","+"'"+nombre+"'"+","+"'"+telefono+"'"+","+"'"+contacto+"'"+","+"'"+direccion+"'"+","+"'"+pais+"'"+","+"'"+ciudad+"'"+")";

            PreparedStatement statement = conexion.getConexion().prepareStatement(consulta);
            statement.executeUpdate();
            System.out.println("Los datos se han insertado correctamente");

        }
        catch (SQLException e) {

            System.out.println("Error al insertar datos, favor de verificar" + e.getMessage());


        }



    }

    public void insertarClientes(){

        System.out.println("Ingrese el nombre del cliente: ");
        String  nombre = entrada.nextLine();
        System.out.println("Ingrese el e-mail del cliente  correo@dominio.com: ");
        String  email = entrada.nextLine();
        System.out.println("Ingrese el teléfono del cliente (xx)xx-xx-xx-xx-xx: ");
        String  telefono = entrada.nextLine();
        System.out.println("Ingrese la dirección del cliente: ");
        String  direccion = entrada.nextLine();

        try {
            String consulta = "INSERT INTO clientes ( NOMBRE_CLIENTE, EMAIL, TELEFONO, DIRECCION)" +
                    "VALUES ("+"'"+nombre+"'"+","+"'"+email+"'"+","+"'"+telefono+"'"+","+"'"+direccion+"'"+")";

            PreparedStatement statement = conexion.getConexion().prepareStatement(consulta);
            statement.executeUpdate();
            System.out.println("Los datos se han insertado correctamente");

        }
        catch (SQLException e) {

            System.out.println("Error al insertar datos, favor de verificar" + e.getMessage());


        }


    }

    public void instertarLibro(){

            Scanner entrada2 = new Scanner(System.in);
        try {
            System.out.println("Ingrese el ISBN del libro: ");
            String isbn = entrada.nextLine();
            System.out.println("Ingrese el titulo del libro: ");
            String titulo = entrada.nextLine();
            System.out.println("Ingrese el código del autor (verificar en tabla de autores, si no existe autor, es necesario agregarlo): ");
            String codigo = entrada.nextLine();
            System.out.println("Ingrese el código del editorial (verificar en la tabla editoriales, si no existe editorial, es necesiario agregarlo): ");
            String editorial = entrada.nextLine();
            System.out.println("Ingrese la edición del libro: ");
            String edicion = entrada.nextLine();
            System.out.println("Ingrese el el lugar de edicion:  ");
            String lugaredicion = entrada.nextLine();
            System.out.println("Ingrese el numero de edicion");
            String numedicion = entrada.nextLine();
            System.out.println("Ingrese el precio del libro: ");
            Float precio = entrada2.nextFloat();
            System.out.println("Ingrese el tipo de cubierta");
            String cubierta = entrada.nextLine();
            System.out.println("Ingrese el numero de paginas");
            String numpaginas = entrada.nextLine();
            System.out.println("Ingrese la estanteria donde esta almacenado");
            String estanteria = entrada.nextLine();
            System.out.println("Ingrese el numero de ejemplares");
            String ejemplares = entrada.nextLine();
            System.out.println("Observaciones");
            String observaciones = entrada.nextLine();
            System.out.println("Capture el codigo de barras");
            String codigobarras = entrada.nextLine();





            try {
               String consulta = "INSERT INTO libro ( ISBN, TITULO, CODIGO_AUTOR, CODIGO_EDITORIAL, EDICION, LUGAR_EDICION," +
                    "NUMERO_EDICION,PRECIO_VENTA, TIPO_CUBIERTA, PAGINAS, ESTANTERIA, NUMERO_EJEMPLARES, OBSERVACIONES, CODIGO_BARRAS)" +
                    "VALUES (" + "'" + isbn + "'" + "," + "'" + titulo + "'" + "," + "'" + codigo + "'" + "," + "'" + editorial + "'" +","+ "'" + edicion + "'" +","+ "'" + lugaredicion + "'"
                    +","+ "'" + numedicion + "'" +","+ "'" + precio + "'"+"," + "'" + cubierta + "'"+","+"'" + numpaginas + "'"+"," +"'" + estanteria + "'"+","+"'" + ejemplares + "'"+
                    ","+"'" + observaciones + "'"+","+"'" + codigobarras + "'"+")";

                PreparedStatement statement = conexion.getConexion().prepareStatement(consulta);
                statement.executeUpdate();
                System.out.println("Los datos se han insertado correctamente");

            } catch (SQLException e) {

                System.out.println("Error al insertar datos, favor de verificar" + e.getMessage());


            }
        }

        catch (NumberFormatException e){
            System.out.println("Error: debes ingresar un valor numerico en precio" + e);
        }







    }

    public void instertarVenta(String total,String totalPagado, String cambio, String tipoPago ) {

        try {

            Timestamp ventaFecha = new Timestamp(System.currentTimeMillis());
            String ventaFechamod = ventaFecha.toString().split("\\ ")[0];


            String consulta = "INSERT INTO ventas ( total, cantidad_pagada, cambio, tipo_pago,  venta_fecha)" +
                    "VALUES (" + "'" + total + "'" + "," + "'" + totalPagado + "'" + "," + "'" + cambio + "'" + "," + "'" + tipoPago + "'" +","+
                     "'" + ventaFechamod + "'"+")";

            PreparedStatement statement = conexion.getConexion().prepareStatement(consulta);
            statement.executeUpdate();
            System.out.println("Los datos se han insertado correctamente");

        } catch (SQLException e) {

            System.out.println("Error al insertar datos, favor de verificar" + e.getMessage());


        }

    }




}
