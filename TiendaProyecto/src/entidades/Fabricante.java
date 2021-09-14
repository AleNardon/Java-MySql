package entidades;

public class Fabricante {
    private int codigoFabricante;
    private String nombreFabricante;

    public Fabricante(int codigoFabricante, String nombreFabricante) {
        this.codigoFabricante = codigoFabricante;
        this.nombreFabricante = nombreFabricante;
    }

    public String getNombreFabricante() {
        return nombreFabricante;
    }

    public void setNombreFabricante(String nombreFabricante) {
        this.nombreFabricante = nombreFabricante;
    }

    public int getCodigoFabricante() {
        return codigoFabricante;
    }

    public void setCodigoFabricante(int codigoFabricante) {
        this.codigoFabricante = codigoFabricante;
    }

    @Override
    public String toString() {
        return "Fabricante{" + "codigoFabricante=" + codigoFabricante + ", nombreFabricante=" + nombreFabricante + '}';
    }


    
}