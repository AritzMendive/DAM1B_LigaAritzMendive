public class Jugador {
    private String nombre;
    private String nacionalidad;
    private int edad;
    private String posicion;
    private Boolean lesionado;

    public Jugador(String nombre, String nacionalidad, int edad, String posicion){
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        if ("POR".equals(posicion) || "DEF".equals(posicion) || "CTC".equals(posicion) || "DEL".equals(posicion)) {
            this.posicion = posicion;
        }else{
            System.out.println("ERROR: formato de posicion incorrecto");
        }
        this.lesionado = false;
    }

    public String getNombre() {
        return nombre;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public int getEdad() {
        return edad;
    }
    public String getPosicion() {
        return posicion;
    }
    public Boolean getLesionado() {
        return lesionado;
    }

    public void lesionarse(){
        this.lesionado = true;
    }

    public void recuperarse(){
        this.lesionado = false;
    }
}

