package Main;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Inicio {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final String PACIENTES_FILE = "LISTADELOSPACIENTES.txt";
        final String DOCTORES_FILE = "LISTASDELOSDOCTORES.txt";
        final String CITAS_FILE = "LISTASDELASCITAS.txt";
        final String PASS_ADMIN_FILE = "lISTASPASSADMIN.txt";



        ArrayList<Paciente> LISTADELOSPACIENTES = new ArrayList();
        ArrayList<Doctor> LISTADELOSDOCTORES = new ArrayList();
        ArrayList<Citas> LISTASDELASCITAS = new ArrayList();
        HashMap<String, String> PASSADMIN = new HashMap();


        WriteReader writeReader = new WriteReader();

        int opc;
        boolean flag = false;

        if (new File(PACIENTES_FILE).exists()) {
            LISTADELOSPACIENTES = (ArrayList<Paciente>) writeReader.leerObjeto(PACIENTES_FILE);
            System.out.println("Se cargo el fichero" + PACIENTES_FILE);
        }

        if (new File(DOCTORES_FILE).exists()) {
            LISTADELOSDOCTORES = (ArrayList<Doctor>) writeReader.leerObjeto(DOCTORES_FILE);
            System.out.println("Se cargo el fichero" + DOCTORES_FILE);
        }
        if (new File(CITAS_FILE).exists()) {
            LISTASDELASCITAS = (ArrayList<Citas>) writeReader.leerObjeto(CITAS_FILE);
            System.out.println("se cargo el fichero" + CITAS_FILE);
        }
        if (new File(PASS_ADMIN_FILE).exists()) {
            PASSADMIN = (HashMap<String, String>) writeReader.leerObjeto(PASS_ADMIN_FILE);
            System.out.println("Se cargi el ficehro" + PASS_ADMIN_FILE);
        }

        if (new File(PASS_ADMIN_FILE).exists() == false) {
            System.out.println("porfavor registra un usuario:");
            String usuario = scanner.nextLine();
            System.out.println("porfavor ingresa una contraseña");
            String contraseña = scanner.nextLine();
            PASSADMIN.put(usuario, contraseña);
            writeReader.escribirObjeto(PASSADMIN, PASS_ADMIN_FILE);
            System.out.println("Se ha guardado con exito, reinicie el programa.");
            System.exit(0);
        }



        if (solicitarCredenciales(PASSADMIN) == true) {
            do {
                opc = desplegarMenu();
                switch (opc) {
                    case 1:
                        System.out.println("Doctores en lista:" + LISTADELOSDOCTORES.toString());
                        LISTADELOSDOCTORES.add(altaDoctor());
                        writeReader.escribirObjeto(LISTADELOSDOCTORES, DOCTORES_FILE);
                        break;

                    case 2:
                        System.out.println("Pacientes en lista:" + LISTADELOSPACIENTES.toString());
                        LISTADELOSPACIENTES.add(altaPaciente());
                        writeReader.escribirObjeto(LISTADELOSPACIENTES, PACIENTES_FILE);
                        break;
                    case 3:
                        System.out.println("Citas en lista:" + LISTASDELASCITAS.toString());
                        LISTASDELASCITAS.add(crearCita());
                        writeReader.escribirObjeto(LISTASDELASCITAS, PACIENTES_FILE);
                        break;

                    case 5:
                        flag = true;
                        break;
                }
            }while (flag == false);
        }
    }


public static int desplegarMenu(){
    String entrada;
    System.out.println("BIENVENIDO SELECCIONA UNA OPCION "
    +"1.- DAR DE ALTA A LOS DOCTORES"
    +"2.- DAR DE ALTA A LOS PASCIENTES"
    +"3.- CREAR CITAS CON FECHA Y HORA"
    +"4.- RELACIONAR CITAS CON DOCTORES"
    +"5.- SALIR");
    entrada = scanner.nextLine();
    if (procesarEntrada(entrada) == true){
        return Integer.parseInt(entrada);
    }else {
        return 0;
    }
    }

    public static boolean procesarEntrada(String opc){
        try {
            Integer.parseInt(opc);
            return true;
        }catch (NumberFormatException ex){
            System.out.println("Ingresa un numero");
            return false;
        }
    }

    public static Doctor altaDoctor(){
        Doctor doctor = new Doctor();
        System.out.println("INGRESE EL ID");
        doctor.getId(scanner.nextLine());
        System.out.println("INGRESE EL NOMBRE ");
        doctor.getNombre(scanner.nextLine());
        System.out.println("INGRESA LA ESPECIALIDAD");
        doctor.getepecialiada(scanner.nextLine());
        System.out.println("SE HA DADO DE ALTA CORRECTAMENTE");
        return doctor;
    }
    public static Paciente altaPaciente(){
        Paciente paciente = new Paciente();
        System.out.println("INGRESA EL ID");
        paciente.getId(scanner.nextLine());
        System.out.println("INGRESA EL NOMBRE ");
        paciente.getNombre(scanner.nextLine());
        System.out.println("SE HA DADO DE ALTA CORRECTAMENTE");
        return paciente;
    }

    public static Citas crearCita(){
        Citas citas = new Citas();
        System.out.println("INGRESA EL ID");
        citas.getId(scanner.nextLine());
        System.out.println("INGRESE LA FECHA");
        citas.getfecha(scanner.nextLine());
        System.out.println("INGRESE LA HORA");
        citas.getHora(scanner.nextLine());
        System.out.println("INGRESE EL MOTIVO DE LA CITA");
        citas.getmotivo(scanner.nextLine());
        System.out.println("SE HA DADO DE ALTA CORRECTAMENTE");
        return citas;
    }


    public static boolean solicitarCredenciales(HashMap passAdmin){
        String usuario;
        String contraseña;
        System.out.println("porfavor introduce un usuario");
        usuario = scanner.nextLine();
        System.out.println("PORFAVOR INTRUDECE LA CONTRASEÑA");
        contraseña = scanner.nextLine();
        if (passAdmin.containsKey(usuario) ==true){
            if (passAdmin.containsKey(contraseña) == true){
                System.out.println("Acceso correcto");
                return true;
            }else {
                System.out.println("Accseo incorrecto");
                return false;

            }
        }else {
            System.out.println("Acceso incorrecto");
            return false;
        }
    }
}

