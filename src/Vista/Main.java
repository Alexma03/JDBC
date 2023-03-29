package Vista;

import Controlador.ControladorJDBC;

import java.util.Scanner;

public class Main {
    static ControladorJDBC controlador = new ControladorJDBC();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("1. Ingresar Informe");
            System.out.println("2. Encontrar un Informe");
            System.out.println("3. Actualizar un Informe");
            System.out.println("4. Eliminar un Informe");
            System.out.println("5. Leer todos los informes");
            System.out.println("0. Salir");
            if (!entrada.hasNextInt()) {
                System.err.println("Introduce un numero");
                entrada.next();
                continue;
            }
            int opcion = entrada.nextInt();
            switch (opcion) {
                case 1 -> ingresarInforme();

                case 2 -> encontrarInforme();

                case 3 -> actualizarInforme();

                case 4 -> eliminarInforme();

                case 5 -> leerTodosLosInformes();

                case 0 -> {
                    System.out.println("Saliendo...");
                    System.exit(0);

                }
                default -> System.err.println("Opcion no valida");

            }
        } while (true);
    }

    private static void leerTodosLosInformes() {
        System.out.println(controlador.SelectAll());
    }

    private static void eliminarInforme() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el id del informe");
        System.out.println("O ingrese 0 para salir");
        if (!entrada.hasNextInt()) {
            System.err.println("Introduce un numero");
            entrada.next();
            return;
        }
        int idInforme = entrada.nextInt();
        if (idInforme == 0) {
            System.out.println("Saliendo...");
        } else {
            if (controlador.DeleteInformeById(idInforme)) {
                System.out.println("Informe eliminado correctamente");
            } else {
                System.err.println("No se pudo eliminar el informe");
            }
        }
    }

    private static void actualizarInforme() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el id del informe");
        if (!entrada.hasNextInt()) {
            System.err.println("Introduce un numero");
            entrada.next();
            return;
        }
        int idInforme = entrada.nextInt();
        System.out.println("Valor que quiere actualizar");
        System.out.println("1. Id del cliente");
        System.out.println("2. Id de la orden");
        System.out.println("3. Id del pago");
        System.out.println("4. Id del producto");
        System.out.println("5. Id del informe");
        int opcion = entrada.nextInt();
        switch (opcion) {
            case 1 -> {
                System.out.println("Ingrese el id del cliente");
                int idCliente = entrada.nextInt();
                if (controlador.UpdateInformeClienteById(idCliente, idInforme)) {
                    System.out.println("Informe actualizado correctamente");
                } else {
                    System.err.println("No se pudo actualizar el informe");
                }
            }
            case 2 -> {
                System.out.println("Ingrese el id de la orden");
                int idOrden = entrada.nextInt();
                if (controlador.UpdateInformeOrdenById(idOrden, idInforme)) {
                    System.out.println("Informe actualizado correctamente");
                } else {
                    System.err.println("No se pudo actualizar el informe");
                }
            }
            case 3 -> {
                System.out.println("Ingrese el id del pago");
                int idPago = entrada.nextInt();
                if (controlador.UpdateInformePagoById(idPago, idInforme)) {
                    System.out.println("Informe actualizado correctamente");
                } else {
                    System.err.println("No se pudo actualizar el informe");
                }
            }
            case 4 -> {
                System.out.println("Ingrese el id del producto");
                int idProducto = entrada.nextInt();
                if (controlador.UpdateInformeProductoById(idProducto, idInforme)) {
                    System.out.println("Informe actualizado correctamente");
                } else {
                    System.err.println("No se pudo actualizar el informe");
                }
            }
            default -> {
                System.err.println("Ingrese un valor valido");
                actualizarInforme();
            }
        }
    }

    private static void encontrarInforme() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Porque valor quiere buscar");
        System.out.println("1. Id del cliente");
        System.out.println("2. Id de la orden");
        System.out.println("3. Id del pago");
        System.out.println("4. Id del producto");
        System.out.println("5. Id del informe");
        if (!entrada.hasNextInt()) {
            System.err.println("Introduce un numero");
            entrada.next();
            return;
        }
        int opcion = entrada.nextInt();
        switch (opcion) {
            case 1 -> {
                System.out.println("Ingrese el id del cliente");
                int idCliente = entrada.nextInt();
                System.out.println(controlador.SelectByClient(idCliente));
            }
            case 2 -> {
                System.out.println("Ingrese el id de la orden");
                int idOrden = entrada.nextInt();
                System.out.println(controlador.SelectByOrder(idOrden));
            }
            case 3 -> {
                System.out.println("Ingrese el id del pago");
                int idPago = entrada.nextInt();
                System.out.println(controlador.SelectByPay(idPago));
            }
            case 4 -> {
                System.out.println("Ingrese el id del producto");
                int idProducto = entrada.nextInt();
                System.out.println(controlador.SelectByProduct(idProducto));
            }
            case 5 -> {
                System.out.println("Ingrese el id del informe");
                int idInforme = entrada.nextInt();
                System.out.println(controlador.SelectByInform(idInforme));
            }
            default -> {
                System.err.println("Ingrese un valor valido");
                encontrarInforme();
            }
        }
    }

    private static void ingresarInforme() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el id del informe");
        if (!entrada.hasNextInt()) {
            System.err.println("Introduce un numero");
            entrada.next();
            return;
        }
        int idInforme = entrada.nextInt();
        System.out.println("Ingrese el id del cliente");
        if (!entrada.hasNextInt()) {
            System.err.println("Introduce un numero");
            entrada.next();
            return;
        }
        int idCliente = entrada.nextInt();
        System.out.println("Ingrese el id de la orden");
        if (!entrada.hasNextInt()) {
            System.err.println("Introduce un numero");
            entrada.next();
            return;
        }
        int idOrden = entrada.nextInt();
        System.out.println("Ingrese el id del pago");
        if (!entrada.hasNextInt()) {
            System.err.println("Introduce un numero");
            entrada.next();
            return;
        }
        int idPago = entrada.nextInt();
        System.out.println("Ingrese el id del producto");
        if (!entrada.hasNextInt()) {
            System.err.println("Introduce un numero");
            entrada.next();
            return;
        }
        int idProducto = entrada.nextInt();
        if (controlador.InsertInforme(idInforme, idCliente, idOrden, idPago, idProducto)) {
            System.out.println("Informe ingresado correctamente");
        } else {
            System.err.println("No se pudo ingresar el informe");
        }
    }
}
