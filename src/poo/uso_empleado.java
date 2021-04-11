package poo;

import java.util.*;

public class uso_empleado {
    public static void main(String[] args) {
        /*Empleado empleado1 = new Empleado("Maicol Pérez", 85000, 1990, 12, 17);
        Empleado empleado2 = new Empleado("Bairon Suárez", 95000, 1995, 06, 02);
        Empleado empleado3 = new Empleado("Yeimi Sánchez", 105000, 2002, 03, 15);
        empleado1.subeSueldo(5);
        empleado2.subeSueldo(5);
        empleado3.subeSueldo(5);
        System.out.println("Nombre: " + empleado1.dameNombre() +
        ". Sueldo: " + empleado1.dameSueldo() + ". Fecha de alta: " + empleado1.dameFechaContrato());
        System.out.println("Nombre: " + empleado2.dameNombre() +
        ". Sueldo: " + empleado2.dameSueldo() + ". Fecha de alta: " + empleado2.dameFechaContrato());
        System.out.println("Nombre: " + empleado3.dameNombre() +
        ". Sueldo: " + empleado3.dameSueldo() + ". Fecha de alta: " + empleado3.dameFechaContrato());*/

        Jefatura jefe_RRHH = new Jefatura("Juan", 55000, 2006, 9, 25);
        jefe_RRHH.estableceIncentivo(2570);

        Empleado[] misEmpleados = new Empleado[6];

        misEmpleados[0] = new Empleado("Maicol Pérez", 85000, 1990, 12, 17);
        misEmpleados[1] = new Empleado("Bairon Suárez", 95000, 1995, 06, 02);
        misEmpleados[2] = new Empleado("Yeimi Sánchez", 105000, 2002, 03, 1);
        misEmpleados[3] = new Empleado("Coraima Moya");
        misEmpleados[4] = jefe_RRHH;
        misEmpleados[5] = new Jefatura("María Montoya", 95000, 1999, 5, 26);
        /*
         * Polimorfismo en acción, principio de sustitución.
         * Se puede utilizar un objeto de la subclase siempre que el programa espere un objeto de la superclase
         */
        /*for (int i = 0; i < misEmpleados.length; i++) {
            misEmpleados[i].subeSueldo(5);
        }*/

        for (Empleado e: misEmpleados) {
            e.subeSueldo(5);
        }

        /*for (int i = 0; i < misEmpleados.length; i++) {
            System.out.println("Nombre: " + misEmpleados[i].dameNombre()
            + ". Sueldo: " + misEmpleados[i].dameSueldo()
            + ". Fecha de alta: " + misEmpleados[i].dameFechaContrato());
        }*/

        for (Empleado e: misEmpleados) {
            System.out.println("Nombre: " + e.dameNombre()
            + ". Sueldo: " + e.dameSueldo()
            + ". Fecha de alta: " + e.dameFechaContrato());
            /*
             * En el índice 4 y 5, el bucle llama al método dameSueldo de la clase Jefatura. Esto es polimorfismo.
             * El enlazado dinámico es la capácidad de la MV de java de llamar el método correspondiente según el objeto.
             */
        }
    }
}

class Empleado {
    public Empleado(String nom, double sue, int agno, int mes, int dia) {
        nombre = nom;
        sueldo = sue;
        GregorianCalendar calendario = new GregorianCalendar(agno, mes - 1, dia);
        altaContrato = calendario.getTime();
        Id = IdSiguiente;
        IdSiguiente++;
    }

    public Empleado(String nom) {
        this(nom, 30000, 2000, 01, 01);
    }

    public String dameNombre() { //GETTER
        return nombre + " Id: " + Id;
    }

    public double dameSueldo() { //GETTER
        return sueldo;
    }

    public Date dameFechaContrato() { //GETTER
        return altaContrato;
    }

    public void subeSueldo(double porcentaje) {//SETTER
        double aumento = sueldo * porcentaje / 100;
        sueldo += aumento;
    }

    private String nombre;
    private double sueldo;
    private Date altaContrato;
    private int Id;
    private static int IdSiguiente = 1;

}

class Jefatura extends Empleado {
    public Jefatura(String nom, double sue, int agno, int mes, int dia) {
        super(nom, sue, agno, mes, dia);
    }

    public void estableceIncentivo(double b) { //SETTER
        incentivo = b;
    }

    public double dameSueldo() { //GETTER
        double sueldoJefe = super.dameSueldo();
        return sueldoJefe + incentivo;
    }

    // declaración de variables
    private double incentivo;
}
