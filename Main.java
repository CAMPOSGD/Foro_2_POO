/*
Ingresen acá sus nombres !!

Foro 2, integrantes del equipo:
1-
2-
3-
4-
5- Gabriel de Jesús Campos Romero CR162707
*/

import javax.swing.JOptionPane;
import java.util.ArrayList;

class Items {
    protected String fabricante;
    protected String modelo;
    protected String procesador;

    public Items(String fabricante, String modelo, String procesador) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.procesador = procesador;
    }
}

class Desktops extends Items {
    private String GPU;
    private String dimension_de_cpu;
    private String capacidad_de_disco;

    public Desktops(String fabricante, String modelo, String procesador, String GPU, String dimension_de_cpu, String capacidad_de_disco) {
        super(fabricante, modelo, procesador);
        this.GPU = GPU;
        this.dimension_de_cpu = dimension_de_cpu;
        this.capacidad_de_disco = capacidad_de_disco;
    }
}

class Laptop extends Items {
    private String memoria;
    private String tamano_pantalla;
    private String capacidad_de_disco;

    public Laptop(String fabricante, String modelo, String procesador, String memoria, String tamano_pantalla, String capacidad_de_disco) {
        super(fabricante, modelo, procesador);
        this.memoria = memoria;
        this.tamano_pantalla = tamano_pantalla;
        this.capacidad_de_disco = capacidad_de_disco;
    }
}

class Tablet extends Items {
    private String capacitiva_resistiva;
    private String tamano_pantalla;
    private String tamano_memoria_NAND;

    public Tablet(String fabricante, String modelo, String procesador, String tamano_pantalla, String capacitiva_resistiva, String tamano_memoria_NAND) {
        super(fabricante, modelo, procesador);
        this.capacitiva_resistiva = capacitiva_resistiva;
        this.tamano_pantalla = tamano_pantalla;
        this.tamano_memoria_NAND = tamano_memoria_NAND;
    }
}

public class Main {
    static ArrayList<Items> menu_registro = new ArrayList<>();

    public static void main(String[] args) {
        int opcion = 0;

        while (opcion != 3) {
            String lectura = JOptionPane.showInputDialog(
                    "Registro de inventario TODOPC\n" +
                            "1. Registro\n" +
                            "2. Visualización\n" +
                            "3. Salida"
            );

            if (lectura == null) break;
            opcion = Integer.parseInt(lectura);

            switch (opcion) {
                case 1:
                    registro();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Visualización de productos...");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        }
    }

    public static void registro() {
        int opcion = 0;
        while (opcion != 4) {
            String lectura = JOptionPane.showInputDialog(
                    "Registro de dispositivos TODOPC\n" +
                            "1. Registro de torres\n" +
                            "2. Registro de laptops\n" +
                            "3. Registro de tablets \n" +
                            "4. Menú anterior"
            );

            if (lectura == null) break;
            opcion = Integer.parseInt(lectura);

            switch (opcion) {
                case 1:
                    String fabricante = JOptionPane.showInputDialog("Fabricante:");
                    String modelo = JOptionPane.showInputDialog("Modelo:");
                    String procesador = JOptionPane.showInputDialog("Procesador:");
                    String gpu = JOptionPane.showInputDialog("Tarjeta gráfica:");
                    String dimension = JOptionPane.showInputDialog("Dimensión de torre:");
                    String capacidad_disco = JOptionPane.showInputDialog("Capacidad de disco:");

                    menu_registro.add(new Desktops(fabricante, modelo, procesador, gpu, dimension, capacidad_disco));

                    JOptionPane.showMessageDialog(null, "Torre registrada con éxito");

                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "Lógica para laptop");
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Lógica para tablet");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
                    break;
            }
        }
    }
}







/*
public static void ver(){
    JOptionPane.showMessageDialog(null, "Proceso de visualización de productos");
}

*/





