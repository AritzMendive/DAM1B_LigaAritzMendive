import java.util.Scanner;
public class Main {
    public static void main(String [] Args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Empiece creando una liga: ");
        System.out.println("Inserte el país de la liga:");
        String pais = scanner.nextLine();
        Liga nuevaLiga = new Liga(pais);

        //Menú del programa
        int opcion;
        do{
            System.out.println("MENU DE LA LIGA");
            System.out.println("1- Insertar Equipo");
            System.out.println("2- Insertar Jugador");
            System.out.println("3- Ver equipos de la liga");
            System.out.println("4- Ver jugadores de un equipo");
            System.out.println("5- Vender jugador");
            System.out.println("6- Salir");

            opcion = scanner.nextInt();

            switch(opcion){
                case 1:
                    insertarEquipo(nuevaLiga, scanner);
                    break;
                case 2:
                    insertarJugador(nuevaLiga, scanner);
                    break;
                case 3:
                    VerLiga(nuevaLiga, scanner);
                    break;
                case 4:
                    verJugadores(nuevaLiga, scanner);
                    break;
                case 5:
                    venderJugador(nuevaLiga, scanner);
            }
        }
        while (opcion != 6);
    }

    public static void insertarEquipo(Liga liga, Scanner scanner){
        scanner.nextLine();
        System.out.println("Inserte el nombre del equipo:");
        String nombreEquipo = scanner.nextLine();
        System.out.println("Inserte la ciudad del equipo:");
        String ciudadEquipo = scanner.nextLine();
        System.out.println("Creando equipo...");
        Equipo nuevoEquipo = new Equipo(nombreEquipo, ciudadEquipo);
        System.out.println("Insertando equipo...");
        liga.anadirEquipo(nuevoEquipo);
        System.out.println("");
    }

    public static void insertarJugador(Liga liga, Scanner scanner){
        scanner.nextLine();
        System.out.println("Indique el nombre del equipo donde quiere insertar el jugador:");
        String nombreEquipo = scanner.nextLine();
        Equipo miEquipoliga = liga.getEquipo(nombreEquipo);
        if (miEquipoliga == null) {
            System.out.println("El equipo indicado no existe.");
            return;
        }
        System.out.println("Indique el nombre del jugador:");
        String nombreJugador = scanner.nextLine();
        System.out.println("Indique la nacionalidad del jugador");
        String nacionalidadJugador = scanner.nextLine();
        System.out.println("Indique la edad del jugador:");
        int edadJugador = scanner.nextInt();
        scanner.nextLine();
        String posicionJugador;
        boolean posicionValida = false;
        do {
            System.out.println("Indique la posicion del jugador:");
            posicionJugador = scanner.nextLine();
            if ("POR".equals(posicionJugador) || "DEF".equals(posicionJugador) || "CTC".equals(posicionJugador) || "DEL".equals(posicionJugador)) {
                posicionValida = true;
            } else {
                System.out.println("Posición no válida.");
            }
        } while (!posicionValida);
        System.out.println("Creando jugador...");
        Jugador jugador = new Jugador(nombreJugador, nacionalidadJugador, edadJugador, posicionJugador);
        System.out.println("Insertando jugador...");
        miEquipoliga.adquirirJugador(jugador);

    }

    public static void VerLiga(Liga liga, Scanner scanner){
        System.out.println("**********COMPOSICIÓN DE LA LIGA*************************");
        System.out.printf("%-20s %-20s %-15s\n", "EQUIPO", "CIUDAD", "NUMERO JUGADORES");
        liga.mostrarListadoEquipos();
        System.out.println("*********************************************************");

    }

    public static void verJugadores(Liga liga, Scanner scanner){
        scanner.nextLine();
        System.out.println("Indique el equipo que quiere visualizar:");
        String nomEquipo = scanner.nextLine();
        Equipo equipo = liga.getEquipo(nomEquipo);
        if(equipo == null){
            System.out.println("El equipo indicado no existe.");
            return;
        }
        System.out.println("********* " + equipo.getNombre() + " ****************************");
        System.out.printf("%-20s %-10s %-4s %-10s %-8s\n", "NOMBRE", "POSICIÓN", "EDAD", "NAC", "LESIONADO");
        equipo.mostrarListaJugadores();
        System.out.println("*****************************************************************");

    }

    public static void venderJugador(Liga liga, Scanner scanner){
        scanner.nextLine();
        System.out.println("Inserte el nombre del equipo donde quiere vender el jugador:");
        String nomEquipo = scanner.nextLine();
        Equipo equipo = liga.getEquipo(nomEquipo);
        if (equipo == null) {
            System.out.println("El equipo indicado no existe.");
            return;
        }
        System.out.println("Inserte el nombre del jugador: ");
        String nomJugador = scanner.nextLine();
        equipo.venderJugador(nomJugador);

}



























}