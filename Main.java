/*

-------- Programación Orientada a Objetos --------
Integrantes del equipo:
    1- José Benjamín Valencia Rivera – VR251194
    2- Alexis Ernesto Hernández Monge – HM253055
    3- Jimmy Asdrubal Canales Zelaya – CZ253631
    4- José Ángel Hernández Sánchez – HS240400
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
    private String memoria;
    private String GPU;
    private String dimension_de_cpu;
    private String capacidad_de_disco;

    public Desktops(String fabricante, String modelo, String procesador, String GPU, String dimension_de_cpu, String capacidad_de_disco, String memoria) {
        super(fabricante, modelo, procesador);
        this.memoria = memoria;
        this.GPU = GPU;
        this.dimension_de_cpu = dimension_de_cpu;
        this.capacidad_de_disco = capacidad_de_disco;
    }

    public String getMemoria () {return memoria;}
    public String getGPU() {return GPU;}
    public String getDimension() {return dimension_de_cpu;}
    public String getCapacidad() {return capacidad_de_disco;}
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
    private String sos;

    public Tablet(String fabricante, String modelo, String procesador, String tamano_pantalla, String capacitiva_resistiva, String tamano_memoria_NAND, String sos) {
        super(fabricante, modelo, procesador);
        this.capacitiva_resistiva = capacitiva_resistiva;
        this.tamano_pantalla = tamano_pantalla;
        this.tamano_memoria_NAND = tamano_memoria_NAND;
        this.sos = sos;
    }
    public String getSos() {return sos;}
    public String getcapacitiva_resistiva() { return capacitiva_resistiva; }
    public String getTamanoPantalla() { return tamano_pantalla; }
    public String getMemoriaNAND() { return tamano_memoria_NAND; }
}


// -------------------------------------------------
// Lógica de registros
// -------------------------------------------------
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

            try {
                opcion = Integer.parseInt(lectura);
            } catch (NumberFormatException e){
                continue;
            }

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


    private static String leerDato(String mensaje) {
        String dato;
        do {
            dato = JOptionPane.showInputDialog(mensaje);
            if (dato == null) return "";
            if (dato.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo no puede estar vacío.");
            }
        } while (dato.trim().isEmpty());
        return dato;
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

            try {
                opcion = Integer.parseInt(lectura);
            } catch (NumberFormatException e){
                continue;
            }

            opcion = Integer.parseInt(lectura);

            switch (opcion) {
                case 1:
                    String fabricante = leerDato("Fabricante: ");
                    String modelo = leerDato("Modelo: ");
                    String procesador = leerDato("Microprocesador: ");
                    String memoriar = leerDato("Tamaño de memoria: ");
                    String gpu = leerDato("Tarjeta gráfica :");
                    String dimension = leerDato("Dimensión de torre:");
                    String capacidad_disco = leerDato("Capacidad de disco:");

                    menu_registro.add(new Desktops(fabricante, modelo, procesador, gpu, dimension, capacidad_disco, memoriar));

                    JOptionPane.showMessageDialog(null, "¡La Torre está registrada!\n");

                    break;

                case 2:

                    fabricante = leerDato("Fabricante: ");
                    modelo = leerDato("Modelo: ");
                    procesador = leerDato("Microprocesador: ");
                    String memoria = leerDato("Memoria: ");
                    String tamano_pantalla = leerDato("Tamaño de pantalla: ");
                    String capacidad_de_disco = leerDato("Capacidad de disco: ");

                    menu_registro.add(new Laptop(fabricante, modelo, procesador, memoria, tamano_pantalla, capacidad_de_disco));

                    JOptionPane.showMessageDialog(null, "¡La Laptop ya está registrada!\n");

                    break;

                case 3:

                    fabricante = leerDato("Fabricante: ");
                    modelo = leerDato("Modelo:");
                    procesador = leerDato("Microprocesador: ");
                    tamano_pantalla = leerDato("Tamaño de pantalla: ");
                    String capacitiva_resistiva = leerDato("¿Es capacitiva o resistiva?: ");
                    String NAND = leerDato("Capacidad de disco: ");
                    String SOS = leerDato("Sistema Operativo: ");

                    menu_registro.add(new Tablet(fabricante, modelo, procesador, tamano_pantalla, capacitiva_resistiva, NAND, SOS));

                    JOptionPane.showMessageDialog(null, "¡La Tablet ya está registrada!\n");

                    break;

                case 4:
                    break;


                default:
                    JOptionPane.showMessageDialog(null, "No seleccionaste una opcion valida, regresando al menú principal...");

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

            try {
                opcion = Integer.parseInt(lectura);
            } catch (NumberFormatException e){
                continue;
            }

            String reporte = "";

            switch (opcion) {
                case 1:
                    reporte =
                            "========================================" + "\n" +
                                    "Estas son las torres que tenemos en inventario: \n";
                    for (Items item : menu_registro) {
                        if (item instanceof Desktops) {

                            Desktops torre = (Desktops) item;

                            reporte +=
                                    "========================================" + "\n" +
                                            "Fabricante: " + torre.fabricante + "\n" +
                                            "Modelo: " + torre.modelo + "\n" +
                                            "Microprocesador: " + torre.procesador + "\n" +
                                            "Memoria: " + torre.getMemoria() + "\n" +
                                            "Tarjeta grafica: " + torre.getGPU() + "\n" +
                                            "Tamaño de torre: " + torre.getDimension() + "\n" +
                                            "Capacidad de disco duro: " + torre.getCapacidad() + "\n" ;
                        }
                    }
                    break;

                case 2:
                    reporte =
                            "========================================" + "\n" +
                                    "Estas son las laptops que tenemos en inventario: \n";
                    for (Items item : menu_registro) {
                        if (item instanceof Laptop) {

                            Laptop lap = (Laptop) item;

                            reporte +=
                                    "========================================" + "\n" +
                                            "Fabricante: " + lap.fabricante + "\n" +
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

                    reporte =
                            "========================================" + "\n" +
                                    "Estas son las tablets que tenemos en inventario: \n";
                    for (Items item : menu_registro) {
                        if (item instanceof Tablet) {

                            Tablet tab = (Tablet) item;

                            reporte +=
                                    "========================================" + "\n" +
                                            "Fabricante: " + tab.fabricante + "\n" +
                                            "Modelo: " + tab.modelo + "\n" +
                                            "Microprocesador: " + tab.procesador + "\n" +
                                            "Tamaño diagonal de pantalla: " + tab.getTamanoPantalla() + "\n" +
                                            "¿Capacitiva/Resistiva?: " + tab.getcapacitiva_resistiva() + "\n" +
                                            "Tamaño de memoria NAND: " + tab.getMemoriaNAND() + "\n" +
                                            "Sistema Operativo: " + tab.getSos() + "\n"
                            ;
                        }
                    }

                    break;
            }

            if (opcion >= 1 && opcion <= 3) {
                if (reporte.length() < 100) {
                    JOptionPane.showMessageDialog(null, "No hay equipos registrados en esta categoría.");
                } else {
                    JOptionPane.showMessageDialog(null, reporte);
                }
            }
        }
    }
}