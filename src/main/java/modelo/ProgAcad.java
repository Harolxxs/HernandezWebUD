package modelo;

import java.io.Serializable;
import java.util.Objects;

public class ProgAcad implements Serializable {
    private static final long serialVersionUID = 1L;

    private int cod;
    private String nombre_prog;

    // Constructor vacío
    public ProgAcad() {
        this.cod = -1; // valor por defecto (opcional pero útil)
    }

    // Constructor con parámetros
    public ProgAcad(int cod, String nombre_prog) {
        this.cod = cod;
        this.nombre_prog = nombre_prog;
    }

    // Getters y Setters
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre_prog() {
        return nombre_prog;
    }

    public void setNombre_prog(String nombre_prog) {
        this.nombre_prog = nombre_prog;
    }

    // hashCode SOLO con cod
    @Override
    public int hashCode() {
        return Objects.hash(cod);
    }

    // equals SOLO con cod (clave para JSF)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ProgAcad)) return false;
        ProgAcad other = (ProgAcad) obj;
        return cod == other.cod;
    }

    @Override
    public String toString() {
        return nombre_prog; // más útil para mostrar
    }
}
