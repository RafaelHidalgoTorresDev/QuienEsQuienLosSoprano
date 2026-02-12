package Modelo;

public class Pregunta {

    private String texto;
    private String atributo;

    public Pregunta(String texto, String atributo) {
        this.texto = texto;
        this.atributo = atributo;
    }

    public String getTexto() {
        return texto;
    }

    public String getAtributo() {
        return atributo;
    }

    @Override
    public String toString() {
        return texto;
    }
}
