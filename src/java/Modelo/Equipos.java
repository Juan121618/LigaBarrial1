package Modelo;

public class Equipos {
    private int id;
    private String nombre;
    private int anoFundacion;
    private String colores;
    private String imagenEscudo;
    private int idRepresentante;
    private String nombreRepresentante;

    public Equipos() {
    }

    public Equipos(int id, String nombre, int anoFundacion, String colores, String imagenEscudo, int idRepresentante, String nombreRepresentante) {
        this.id = id;
        this.nombre = nombre;
        this.anoFundacion = anoFundacion;
        this.colores = colores;
        this.imagenEscudo = imagenEscudo;
        this.idRepresentante = idRepresentante;
        this.nombreRepresentante = nombreRepresentante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnoFundacion() {
        return anoFundacion;
    }

    public void setAnoFundacion(int anoFundacion) {
        this.anoFundacion = anoFundacion;
    }

    public String getColores() {
        return colores;
    }

    public void setColores(String colores) {
        this.colores = colores;
    }

    public String getImagenEscudo() {
        return imagenEscudo;
    }

    public void setImagenEscudo(String imagenEscudo) {
        this.imagenEscudo = imagenEscudo;
    }

    public int getIdRepresentante() {
        return idRepresentante;
    }

    public void setIdRepresentante(int idRepresentante) {
        this.idRepresentante = idRepresentante;
    }

    public String getNombreRepresentante() {
        return nombreRepresentante;
    }

    public void setNombreRepresentante(String nombreRepresentante) {
        this.nombreRepresentante = nombreRepresentante;
    }

}