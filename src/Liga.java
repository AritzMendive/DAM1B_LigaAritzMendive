public class Liga {
    private String pais;
    private final int numMaxEquipos = 20;
    private Equipo[] ListadoEquipos;

    public Liga(String pais){
        this.pais = pais;
        ListadoEquipos = new Equipo[numMaxEquipos];
    }

    public void mostrarListadoEquipos(){
        for (int i = 0; i < ListadoEquipos.length; i++){
            if (ListadoEquipos[i] != null) {
                System.out.printf("%-20s %-20s %-15s\n",
                        ListadoEquipos[i].getNombre(),
                        ListadoEquipos[i].getCiudad(),
                        ListadoEquipos[i].getNumJugadores());
            }        }
    }

    public int getNumEquipos(){
        int hayEquipo= 0;
        for (int i = 0; i < ListadoEquipos.length; i++){
            if (ListadoEquipos[i] != null){
                hayEquipo++;
            }
        }
        return hayEquipo;
    }

    public Equipo getEquipo(String nombreEquipo){
        for (int i=0; i < ListadoEquipos.length; i++){
            if (ListadoEquipos[i] != null && ListadoEquipos[i].getNombre().equals(nombreEquipo)) {
                return ListadoEquipos[i];
            }
        }
        return null;
    }

    public String getPais() {
        return pais;
    }

    public void anadirEquipo(Equipo equipo){
        if(getNumEquipos() < numMaxEquipos){
        for (int i = 0; i < ListadoEquipos.length; i++){
            if (ListadoEquipos[i] == null){
                ListadoEquipos[i] = equipo;
                System.out.println("Equipo "+ equipo.getNombre() +" insertado");
                break;
                }
            }
        }else{
            System.out.println("Error: La liga está llena");
        }
    }
}
