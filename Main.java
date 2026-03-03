/*
Ingresen acá sus nombres !!

Foro 2, integrantes del equipo:
1-
2-
3-
4-
5- Gabriel de Jesús Campos Romero CR162707
*/
// -------------------------------------------------
// Librerías
// -------------------------------------------------
import javax.swing.JOptionPane;
import java.util.ArrayList;

// -------------------------------------------------
// Clase principal + constructor
// -------------------------------------------------
class Items {
    protected String fabricante;
    protected String modelo;
    protected String procesador;

    public Items(String fabricante, String modelo, String procesador) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.procesador = procesador;
    }

    public String getFabricante() { return fabricante; }
    public String getModelo() { return modelo; }
}


// -------------------------------------------------
// Sub clases, herencias y retornos de datos
// -------------------------------------------------
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

    public String getGPU() { return GPU; }
    public String getDimension() { return dimension_de_cpu; }
    public String getCapacidad() { return capacidad_de_disco; }
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

    public String getMemoria() { return memoria; }
    public String getTamanoPantalla() { return tamano_pantalla; }
    public String getCapacidad() { return capacidad_de_disco; }
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

    public String getcapacitiva_resistiva() { return capacitiva_resistiva; }
    public String getTamanoPantalla() { return tamano_pantalla; }
    public String getMemoriaNAND() { return tamano_memoria_NAND; }
}

public class Main {
    static ArrayList<Items> menu_registro = new ArrayList<>();


    // -------------------------------------------------
    // Lógica de registros
    // -------------------------------------------------

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
                    ver();
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

                    JOptionPane.showMessageDialog(null, "¡La Torre está registrada!\n");

                    break;

                case 2:

                    fabricante = JOptionPane.showInputDialog("Fabricante: ");
                    modelo = JOptionPane.showInputDialog("Modelo:");
                    procesador = JOptionPane.showInputDialog("Procesador: ");

                    String memoria = JOptionPane.showInputDialog("Memoria :");
                    String tamano_pantalla = JOptionPane.showInputDialog("Tamaño de pantalla: ");
                    String capacidad_de_disco = JOptionPane.showInputDialog("Capacidad de disco:");

                    menu_registro.add(new Laptop(fabricante, modelo, procesador, memoria, tamano_pantalla, capacidad_de_disco));

                    JOptionPane.showMessageDialog(null, "¡La Laptop ya está registrada!\n");

                    break;

                case 3:

                    fabricante = JOptionPane.showInputDialog("Fabricante: ");
                    modelo = JOptionPane.showInputDialog("Modelo:");
                    procesador = JOptionPane.showInputDialog("Procesador: ");


                    String capacitiva_resistiva = JOptionPane.showInputDialog("¿Es capacitiva o resistiva?: "); // debería dar solo esas opciones?
                    tamano_pantalla = JOptionPane.showInputDialog("Tamaño de pantalla: ");
                    String NAND = JOptionPane.showInputDialog("Capacidad de disco:");

                    menu_registro.add(new Tablet(fabricante, modelo, procesador, tamano_pantalla, capacitiva_resistiva, NAND));

                    JOptionPane.showMessageDialog(null, "¡La Tablet ya está registrada!\n");

                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
                    break;
            }
        }
    }


    // -------------------------------------------------
    // Impresión al usuario
    // -------------------------------------------------

    public static void ver() {
        int opcion = 0;
        while (opcion != 4) {
            String lectura = JOptionPane.showInputDialog(
                    "Visualización de Inventario TODOPC\n" +
                            "1. Ver torres\n" +
                            "2. Ver laptops\n" +
                            "3. Ver tablets\n" +
                            "4. Menú anterior"
            );

            if (lectura == null) break;
            opcion = Integer.parseInt(lectura);
            //Desktops torre = (Desktops) item;

            String reporte = "";

            switch (opcion) {
                case 1:
                    reporte = "Estas son las torres que tenemos en inventario: \n";
                    for (Items item : menu_registro) {
                        if (item instanceof Desktops) {

                            Desktops torre = (Desktops) item;

                            reporte += "Fabricante: " + torre.fabricante + "\n" +
                                    "Modelo: " + torre.modelo + "\n" +
                                    "Microprocesador: " + torre.procesador + "\n" +
                                    "Tarjeta grafica: " + torre.getGPU() + "\n" +
                                    "Tamaño de torre: " + torre.getDimension() + "\n" +
                                    "Capacidad de disco duro: " + torre.getCapacidad() + "\n" ;
                        }
                    }
                    break;

                case 2:
                    reporte = "Estas son las laptops que tenemos en inventario: \n";
                    for (Items item : menu_registro) {
                        if (item instanceof Laptop) {

                            Laptop lap = (Laptop) item;

                            reporte += "Fabricante: " + lap.fabricante + "\n" +
                                    "Modelo: " + lap.modelo + "\n" +
                                    "Microprocesador: " + lap.procesador + "\n" +
                                    "Memoria: " + lap.getMemoria() + "\n" +
                                    "Tamaño de pantalla: " + lap.getTamanoPantalla() + "\n" +
                                    "Capacidad de disco duro: " + lap.getCapacidad() + "\n"
                            ;
                        }
                    }


                    break;

                case 3:

                    reporte = "Estas son las tablets que tenemos en inventario: \n";
                    for (Items item : menu_registro) {
                        if (item instanceof Tablet) {

                            Tablet tab = (Tablet) item;

                            reporte += "Fabricante: " + tab.fabricante + "\n" +
                                    "Modelo: " + tab.modelo + "\n" +
                                    "Microprocesador: " + tab.procesador + "\n" +
                                    "Memoria: " + tab.getcapacitiva_resistiva() + "\n" +
                                    "Tamaño de pantalla: " + tab.getTamanoPantalla() + "\n" +
                                    "Capacidad de disco duro: " + tab.getMemoriaNAND() + "\n"
                                    ;
                        }
                    }

                    /*
                        public Tablet(String fabricante, String modelo, String procesador, String tamano_pantalla, String capacitiva_resistiva, String tamano_memoria_NAND) {
                        super(fabricante, modelo, procesador);

                        this.capacitiva_resistiva = capacitiva_resistiva;
                        this.tamano_pantalla = tamano_pantalla;
                        this.tamano_memoria_NAND = tamano_memoria_NAND;

                    * */

                    break;
            }

            if (opcion >= 1 && opcion <= 3) {
                if (reporte.length() < 30) {
                    JOptionPane.showMessageDialog(null, "No hay equipos registrados en esta categoría.");
                } else {
                    JOptionPane.showMessageDialog(null, reporte);
                }
            }
        }
    }
}




