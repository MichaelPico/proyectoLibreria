//Creado por Michael Pico
package Clases;

/**
 *
 * @author Michael
 */
public class Usuario {
    
    private int id;
    private String correo;
    private double saldo;
    private int tipo;

    public Usuario() {
    }

    public Usuario( String correo, double saldo, int tipo) {
        this.correo = correo;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
    
    
}
