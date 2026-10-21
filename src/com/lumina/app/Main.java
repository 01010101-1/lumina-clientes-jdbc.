package com.lumina.app;

import com.lumina.dao.ClienteDAO;
import com.lumina.modelo.Cliente;
import java.util.Scanner;

/** Menú de consola para probar el módulo de clientes. */
public class Main {

    private static final Scanner ENTRADA = new Scanner(System.in);
    private static final ClienteDAO CLIENTE_DAO = new ClienteDAO();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=== Lúmina: módulo de clientes ===");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente por id");
            System.out.println("4. Actualizar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("0. Salir");
            opcion = leerEntero("Elige una opción: ");
            switch (opcion) {
                case 1 -> registrarCliente();
                case 2 -> CLIENTE_DAO.consultarClientes().forEach(System.out::println);
                case 3 -> buscarCliente();
                case 4 -> actualizarCliente();
                case 5 -> eliminarCliente();
                case 0 -> System.out.println("Hasta pronto.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void registrarCliente() {
        Cliente cliente = new Cliente(leerTexto("Nombre: "), leerTexto("Teléfono: "), leerTexto("Correo: "));
        System.out.println(CLIENTE_DAO.insertarCliente(cliente) ? "Cliente registrado." : "No se pudo registrar.");
    }

    private static void buscarCliente() {
        Cliente cliente = CLIENTE_DAO.buscarClientePorId(leerEntero("Id del cliente: "));
        System.out.println(cliente != null ? cliente : "No existe un cliente con ese id.");
    }

    private static void actualizarCliente() {
        Cliente cliente = CLIENTE_DAO.buscarClientePorId(leerEntero("Id del cliente a actualizar: "));
        if (cliente == null) {
            System.out.println("No existe un cliente con ese id.");
            return;
        }
        cliente.setNombre(leerTexto("Nuevo nombre: "));
        cliente.setTelefono(leerTexto("Nuevo teléfono: "));
        cliente.setCorreo(leerTexto("Nuevo correo: "));
        System.out.println(CLIENTE_DAO.actualizarCliente(cliente) ? "Cliente actualizado." : "No se pudo actualizar.");
    }

    private static void eliminarCliente() {
        boolean eliminado = CLIENTE_DAO.eliminarCliente(leerEntero("Id del cliente a eliminar: "));
        System.out.println(eliminado ? "Cliente eliminado." : "No se encontró el cliente.");
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return ENTRADA.nextLine().trim();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(leerTexto(mensaje));
            } catch (NumberFormatException e) {
                System.out.println("Escribe un número válido.");
            }
        }
    }
}
