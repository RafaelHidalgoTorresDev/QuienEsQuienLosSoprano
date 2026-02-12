package Modelo;

import java.util.HashMap;
import java.util.Map;

public class Personaje {

    private String nombre;
    private String rutaImagen;
    private Map<String, Boolean> atributos;
    private boolean eliminado;

    public Personaje(String nombre, String rutaImagen) {
        this.nombre = nombre;
        this.rutaImagen = rutaImagen;
        this.atributos = new HashMap<>();
        this.eliminado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public Map<String, Boolean> getAtributos() {
        return atributos;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public void agregarAtributo(String clave, boolean valor) {
        atributos.put(clave, valor);
    }

    public boolean tieneAtributo(String clave) {
        if (atributos.containsKey(clave)) {
            return atributos.get(clave);
        }
        return false;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
