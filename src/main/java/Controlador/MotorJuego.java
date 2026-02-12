package Controlador;

import Modelo.Personaje;
import Modelo.FabricaPersonajes;
import Modelo.Pregunta;
import java.util.List;
import java.util.Random;

public class MotorJuego {

    private List<Personaje> personajes;
    private List<Pregunta> preguntas;
    private Personaje personajeSecreto;
    private int numeroPreguntasHechas;
    private boolean partidaTerminada;
    private boolean haGanado;
    private Random random;

    public MotorJuego() {
        this.random = new Random();
        iniciarNuevaPartida();
    }

    public void iniciarNuevaPartida() {
        this.personajes = FabricaPersonajes.crearPersonajes();
        this.preguntas = FabricaPersonajes.crearPreguntas();
        this.numeroPreguntasHechas = 0;
        this.partidaTerminada = false;
        this.haGanado = false;

        int indice = random.nextInt(personajes.size());
        this.personajeSecreto = personajes.get(indice);
    }

    public boolean hacerPregunta(Pregunta pregunta) {
        numeroPreguntasHechas++;
        boolean respuesta = personajeSecreto.tieneAtributo(pregunta.getAtributo());

        for (Personaje p : personajes) {
            if (!p.isEliminado()) {
                boolean valor = p.tieneAtributo(pregunta.getAtributo());
                if (valor != respuesta) {
                    p.setEliminado(true);
                }
            }
        }

        return respuesta;
    }

    public boolean adivinar(Personaje personaje) {
        partidaTerminada = true;
        if (personaje.getNombre().equals(personajeSecreto.getNombre())) {
            haGanado = true;
            return true;
        } else {
            haGanado = false;
            return false;
        }
    }

    public int contarPersonajesRestantes() {
        int contador = 0;
        for (Personaje p : personajes) {
            if (!p.isEliminado()) {
                contador++;
            }
        }
        return contador;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public Personaje getPersonajeSecreto() {
        return personajeSecreto;
    }

    public int getNumeroPreguntasHechas() {
        return numeroPreguntasHechas;
    }

    public boolean isPartidaTerminada() {
        return partidaTerminada;
    }

    public boolean isHaGanado() {
        return haGanado;
    }
}
