package Modelo;

import java.util.ArrayList;
import java.util.List;

public class FabricaPersonajes {

    public static List<Personaje> crearPersonajes() {
        List<Personaje> lista = new ArrayList<>();

        lista.add(crearPersonaje("Tony Soprano", "tony.png",
                true, true, false, false, true, false, true, true, true, false, false, true));
        lista.add(crearPersonaje("Carmela Soprano", "carmela.jpg",
                false, false, true, false, false, false, false, false, true, false, false, true));
        lista.add(crearPersonaje("Christopher Moltisanti", "cristopher.jpg",
                true, true, false, false, false, false, false, false, false, false, true, true));
        lista.add(crearPersonaje("Paulie Walnuts", "paulie.jpg",
                true, false, false, true, false, false, false, false, false, false, false, true));
        lista.add(crearPersonaje("Silvio Dante", "silvio.png",
                true, true, false, false, false, false, false, true, false, false, false, true));
        lista.add(crearPersonaje("Junior Soprano", "junior.png",
                true, false, false, true, true, true, false, true, true, false, false, true));
        lista.add(crearPersonaje("Bobby Baccalieri", "bobby.jpg",
                true, true, false, false, false, false, true, false, false, false, false, false));
        lista.add(crearPersonaje("Adriana La Cerva", "adriana.png",
                false, false, true, false, false, false, false, false, false, false, true, true));
        lista.add(crearPersonaje("Meadow Soprano", "meadow.png",
                false, true, false, false, false, false, false, false, true, false, true, false));
        lista.add(crearPersonaje("A.J. Soprano", "aj soprano.jpg",
                true, true, false, false, false, false, false, false, true, false, true, false));
        lista.add(crearPersonaje("Dra. Melfi", "melfi.png",
                false, true, false, false, false, false, false, false, false, false, false, true));
        lista.add(crearPersonaje("Janice Soprano", "janice.png",
                false, true, false, false, false, false, false, false, true, false, false, false));
        lista.add(crearPersonaje("Livia Soprano", "livia.png",
                false, false, false, true, false, false, false, false, true, false, false, false));
        lista.add(crearPersonaje("Johnny Sack", "johny sack.png",
                true, true, false, false, false, false, false, true, false, true, false, true));
        lista.add(crearPersonaje("Phil Leotardo", "phil leotardo.png",
                true, false, false, true, false, false, false, true, false, false, false, true));
        lista.add(crearPersonaje("Vito Spatafore", "vito.png",
                true, true, false, false, false, false, true, true, false, false, false, false));
        lista.add(crearPersonaje("Ralph Cifaretto", "ralph.png",
                true, false, true, false, false, false, false, true, false, true, false, true));
        lista.add(crearPersonaje("Furio Giunta", "furio.png",
                true, true, false, false, false, false, false, false, false, false, false, false));
        lista.add(crearPersonaje("Richie Aprile", "richie.jpg",
                true, true, false, false, true, false, false, true, false, false, false, false));
        lista.add(crearPersonaje("Pussy Bonpensiero", "pussy.png",
                true, true, false, false, false, false, true, false, false, false, false, false));
        lista.add(crearPersonaje("Artie Bucco", "artie.jpg",
                true, true, false, false, false, true, false, false, false, true, false, false));
        lista.add(crearPersonaje("Hesh Rabkin", "hesh.png",
                true, false, false, true, true, true, false, false, false, false, false, false));
        lista.add(crearPersonaje("Gloria Trillo", "gloria.jpg",
                false, true, false, false, false, false, false, false, false, false, false, true));
        lista.add(crearPersonaje("Rosalie Aprile", "rosalie.jpg",
                false, false, true, false, false, false, false, false, false, false, false, true));

        return lista;
    }

    public static List<Pregunta> crearPreguntas() {
        List<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(new Pregunta("¿Es hombre?", "esHombre"));
        preguntas.add(new Pregunta("¿Tiene pelo castaño o negro?", "peloCastano"));
        preguntas.add(new Pregunta("¿Tiene pelo rubio?", "peloRubio"));
        preguntas.add(new Pregunta("¿Tiene pelo canoso o blanco?", "peloCanoso"));
        preguntas.add(new Pregunta("¿Es calvo o tiene poco pelo?", "calvo"));
        preguntas.add(new Pregunta("¿Usa gafas?", "usaGafas"));
        preguntas.add(new Pregunta("¿Es corpulento o gordo?", "gordo"));
        preguntas.add(new Pregunta("¿Es jefe o capo?", "esBoss"));
        preguntas.add(new Pregunta("¿Es de la familia Soprano?", "esFamilia"));
        preguntas.add(new Pregunta("¿Tiene bigote o perilla?", "bigote"));
        preguntas.add(new Pregunta("¿Es joven (menos de 30)?", "joven"));
        preguntas.add(new Pregunta("¿Usa traje elegante?", "trajeElegante"));
        return preguntas;
    }

    private static Personaje crearPersonaje(String nombre, String imagen,
            boolean esHombre, boolean peloCastano, boolean peloRubio, boolean peloCanoso,
            boolean calvo, boolean usaGafas, boolean gordo, boolean esBoss,
            boolean esFamilia, boolean bigote, boolean joven, boolean trajeElegante) {

        Personaje p = new Personaje(nombre, imagen);
        p.agregarAtributo("esHombre", esHombre);
        p.agregarAtributo("peloCastano", peloCastano);
        p.agregarAtributo("peloRubio", peloRubio);
        p.agregarAtributo("peloCanoso", peloCanoso);
        p.agregarAtributo("calvo", calvo);
        p.agregarAtributo("usaGafas", usaGafas);
        p.agregarAtributo("gordo", gordo);
        p.agregarAtributo("esBoss", esBoss);
        p.agregarAtributo("esFamilia", esFamilia);
        p.agregarAtributo("bigote", bigote);
        p.agregarAtributo("joven", joven);
        p.agregarAtributo("trajeElegante", trajeElegante);
        return p;
    }
}
