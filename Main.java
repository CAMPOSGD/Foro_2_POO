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
/*
    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public String getProcesador() {
        return procesador;
    }*/
}

class Desktops extends Items {
    private String GPU;
    private String dimension_de_cpu;
    private String capacidad_de_disco;

    public Desktops(String fabricante, String modelo, String procesador, String GPU, String dimension_de_cpu, String capacidad_de_disco) {
        super(fabricante, modelo, procesador); // Llama al constructor de la base
        this.GPU = GPU;
        this.dimension_de_cpu = dimension_de_cpu;
        this.capacidad_de_disco = capacidad_de_disco;
    }
}

class Laptop extends Items {
    private String memoria;
    private String tamano_pantalla;
    private String capacidad_de_disco;

    public Laptop (String fabricante, String modelo, String procesador,String memoria, String tamano_pantalla, String capacidad_de_disco){
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

    public Tablet (String fabricante, String modelo, String procesador, String tamano_pantalla, String capacitiva_resistiva, String tamano_memoria_NAND){
        super(fabricante, modelo, procesador);
        this.capacitiva_resistiva = capacitiva_resistiva;
        this.tamano_pantalla = tamano_pantalla;
        this.tamano_memoria_NAND = tamano_memoria_NAND;
    }
}

public class Main {

}
    public static void main(String[] args) {
        ArrayList<String> inventario = new ArrayList<>(); // Cambié el nombre para que tenga más sentido
        int opcion = 0;

        while (opcion != 3) {
            String lectura = JOptionPane.showInputDialog(
                    "Registro de inventario TODOPC\n" +
                            "1. Registro\n" +
                            "2. Visualización\n" +
                            "3. Salida"
            );

            if (lectura == null) break;

            opcion = Integer.parseInt(lectura); // Convertir el texto a número

            switch (opcion) { // Faltaba abrir llave
                case 1:
                    JOptionPane.showMessageDialog(null, "Proceso de registro");
                    break; // Faltaba el break

                case 2:
                    JOptionPane.showMessageDialog(null, "Visualización de productos");
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");


        /*
        String input_fabricante = JOptionPane.showInputDialog("Ingresá el nombre del fabricante: ");
        String input_modelo = JOptionPane.showInputDialog("¿Cuál es el modelo del dispositivo?");
        String input_procesador = JOptionPane.showInputDialog("¿Qué microprocesador tiene el equipo?");

        Items info_dispositivo = new Items(input_fabricante, input_modelo, input_procesador);

        JOptionPane.showMessageDialog(null,
                "¡Ya almacené los datos!\n" +
                        "Estos son los datos ingresados:\n" +
                        "Fabricante: " + info_dispositivo.getFabricante() + "\n" +
                        "Modelo: " + info_dispositivo.getModelo() + "\n" +
                        "Microprocesador: " + info_dispositivo.getProcesador()
        );

     */
            }
        }
}