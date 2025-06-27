package principal;
import conexion.ConexionBD;
import consultas.Consultas;
import inserccion.InsertarDatos;
import ventas.Ventas;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InsertarDatos insertarDatos = new InsertarDatos();
        Consultas consultas = new Consultas();
        System.out.println("""
                    ********************************************************************************************************
                    ********************************************************************************************************
                                   ***BIENVENIDOS AL SISTEMA DE ADMINISTRACION DE VENTAS DE LIBROS***
                    ********************************************************************************************************
                    ********************************************************************************************************
                    """);


        int bucle = 0;

        while (bucle != 12) {



            int menu;

            Scanner eleccion = new Scanner(System.in);

            System.out.println(" ");
            System.out.println(" Seleccione la opcion deseada:   ");
            System.out.println("""
                    
                    1.  Capturar Autor.
                    2.  Capturar Editorial.
                    3.  Capturar Cliente.
                    4.  Capturar Libro.
                    5.  Consultar Autor.
                    6.  Consultar Editorial.
                    7.  Consultar Cliente.
                    8.  Consultar Libro.
                    9.  ===>Registrar venta.<===
                    10. Consultar registro de ventas.
                    11. Consultar ventas en un periodo.
                    12. Salir
                    """

            );

             menu = eleccion.nextInt();
            switch (menu){

                case 1:

                    insertarDatos.insertarDatosAutor();

                    break;
                case 2:

                    insertarDatos.insertarEditorial();

                    break;
                case 3:

                    insertarDatos.insertarClientes();

                    break;
                case 4:

                    insertarDatos.instertarLibro();

                    break;
                case 5:

                    consultas.consultaAutor();

                    break;
                case 6:

                    consultas.consultarEditorial();

                    break;
                case 7:

                    consultas.consultarClientes();
                    break;
                case 8:

                    consultas.consultarLibro();


                    break;
                case 9:

                    //---
                    boolean opcion = true;
                    ArrayList <Double> precios = new ArrayList<>();

                    do {
                        Ventas ventas = new Ventas();
                        Scanner entrada = new Scanner(System.in);

                        Scanner opcionusuario = new Scanner(System.in);
                        System.out.println("Ingrese el nombre del libro");
                        String nombre = entrada.nextLine();

                        Double ObtenerPrecio = ventas.obtenerPrecio(nombre);
                        System.out.println(ObtenerPrecio);
                        precios.add(ObtenerPrecio);

                        System.out.println("Desea comprar otro libro S/N?");
                        String opc = opcionusuario.nextLine();
                        System.out.println(opc);
                        if (Objects.equals(opc, "S") || Objects.equals(opc, "s")){
                            opcion = true;
                        }
                        else {
                            opcion = false;            }

                    } while(opcion);

                    double total = 0;
                    double suma = precios.stream().mapToDouble(Double::doubleValue).sum();
                    System.out.println("Total: " + suma);

                    String eleccionPago;
                    Scanner entrada2 = new Scanner(System.in);

                    System.out.println("Forma de pago: "
                            + """
                    
                    1. Efectivo.
                    2. Pago con tarjeta."""
                    );

                    eleccionPago = entrada2.nextLine();

                    switch (eleccionPago){

                        case "1":

                            double pagoCliente;
                            Scanner entradaEfectivo = new Scanner(System.in);
                            try {
                                System.out.println("Ingrese la cantidad de efectivo: ");
                                pagoCliente = entradaEfectivo.nextDouble();

                                if(pagoCliente < suma) {
                                    System.out.println("El efectivo debe ser mayor a la cantidad a pagar");
                                }
                                else {
                                    total = pagoCliente - suma;

                                    insertarDatos.instertarVenta(String.valueOf(suma), String.valueOf(pagoCliente), String.valueOf(total), "Efectivo");

                                    System.out.println("Su cambio es de:" + total);

                                    System.out.println("Gracias por su compra");
                                }

                            }
                            catch (NumberFormatException e) {
                                System.out.println("Error: Ingrese un valor numerico" + e);
                            }


                            break;

                        case "2":

                            System.out.println("Ingrese el total en la terminal:" + suma);

                            Scanner entrada = new Scanner(System.in);
                            System.out.println("El pago fue exitoso  S/N");
                            String opcion2 = entrada.nextLine();
                            opcion2.toString();
                            System.out.println(opcion2);

                            if (opcion2.equals("S")){

                                insertarDatos.instertarVenta(String.valueOf(suma),String.valueOf(suma),"0","Tarjeta");

                                System.out.println("Gracias por su compra ");
                            } else if (opcion2.equals("s")) {
                                insertarDatos.instertarVenta(String.valueOf(suma),String.valueOf(suma),"0","Tarjeta");

                                System.out.println("Gracias por su compra ");

                            } else {
                                System.out.println("Intente otra forma de pago");
                            }




                            break;

                        default:
                            System.out.println("Elija una forma de pago permitida");

                            break;
                    }

                    //--
                    break;

                case 10:

                    System.out.println("Capturar autor");

                    break;

                case 11:

                    System.out.println("Capturar autor");

                    break;

                case 12:

                    System.out.println("Hasta luego.");
                    ConexionBD conexionBD = new ConexionBD();
                    conexionBD.cerrarConexion();
                    bucle = 12;
                    break;


                default:

                    System.out.println("Opcion no valida");
                    break;

            }

        }


    }

}
