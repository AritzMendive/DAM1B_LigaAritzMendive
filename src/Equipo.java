import java.util.Objects;

public class Equipo {
    private String nombre;
    private String ciudad;
    private final int numMaxJugadores = 22;
    private Jugador[] ListaJugadores;

    public Equipo(String nombre, String ciudad){
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.ListaJugadores = new Jugador[numMaxJugadores];
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }
    public int getNumJugadores(){
        int hayJugador = 0;
        for(int i = 0; i < ListaJugadores.length; i++){
            if(ListaJugadores[i] != null){
                hayJugador++;
            }
        }
        return hayJugador;
    }

    public void mostrarListaJugadores(){
        for (int i = 0; i < ListaJugadores.length; i++){
            if (ListaJugadores[i] != null) {
                String lesion ;
                if(ListaJugadores[i].getLesionado()){
                    lesion = "SI";
                }else{
                    lesion = "NO";
                }
                System.out.printf("%-20s %-10s %-4s %-10s %-8s\n", ListaJugadores[i].getNombre(), ListaJugadores[i].getPosicion(), ListaJugadores[i].getEdad(), ListaJugadores[i].getNacionalidad(), lesion);
            }
        }
    }

    public void adquirirJugador(Jugador nuevoJugador){
        for(int i = 0; i< ListaJugadores.length; i++){
            if (ListaJugadores[i] == null){
                ListaJugadores[i] = nuevoJugador;
                System.out.println("Jugador " + nuevoJugador.getNombre() + " insertado en " + getNombre());
                break;
            }else{
                System.out.println("El equipo está lleno.");
            }
        }
    }

    public void venderJugador(String nombreJugador){
        if (ListaJugadores != null){
            for (int i = 0; i < ListaJugadores.length; i++){
                if (Objects.equals(ListaJugadores[i].getNombre(), nombreJugador)){
                    System.out.println("Vendiendo jugador...");
                    ListaJugadores[i] = null;
                    System.out.println("Jugador vendido.");
                    break;
                }else{
                    System.out.println("El jugador no existe.");
                }
            }
        }
    }
}
