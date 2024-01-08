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
            System.out.println("Equipo " + i + ": " + ListadoEquipos[i].getNombre());
        }
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
        int posicion = 0;
        for (int i=0; i < ListadoEquipos.length; i++){
            if (ListadoEquipos[i].getNombre() == nombreEquipo){
                posicion = i;
            }
        }
        return ListadoEquipos[posicion];
    }

    public String getPais() {
        return pais;
    }

    public void anadirEquipo(Equipo equipo){
        for (int i = 0; i < ListadoEquipos.length; i++){
            if (ListadoEquipos[i] == null){
                ListadoEquipos[i] = equipo;
                break;
            }
        }
    }
}
