# ¿Quién es Quién? - Los Soprano

Juego de **¿Quién es Quién?** para un jugador, desarrollado en JavaFX y ambientado en la serie Los Soprano.

## Requisitos

- **Java 17** o superior (probado con Java 21)
- **Maven** (incluido en NetBeans o IntelliJ)

## Cómo compilar y ejecutar

### Desde la terminal

```
mvn clean compile
mvn javafx:run
```

### Desde NetBeans

1. Abrir el proyecto como proyecto Maven
2. Click derecho → Run

### Desde IntelliJ IDEA

1. Abrir la carpeta como proyecto Maven
2. Ejecutar la clase `quienesquien.QuienEsQuien`

## Estructura del proyecto

```
src/main/java/
├── module-info.java
├── quienesquien/
│   └── QuienEsQuien.java          (Clase principal)
├── Controller/
│   ├── JuegoController.java       (Controlador del juego)
│   ├── AyudaController.java       (Controlador de la ayuda)
│   └── GameEngine.java            (Motor de juego)
└── Model/
    ├── Personaje.java              (Modelo de personaje)
    ├── Pregunta.java               (Modelo de pregunta)
    └── PersonajeFactory.java       (Fábrica de personajes)

src/main/resources/
├── Vista/
│   ├── Juego.fxml                  (Vista principal)
│   ├── Ayuda.fxml                  (Vista de ayuda)
│   └── estiloJuego.css             (Estilos CSS)
└── imagenes/                       (Fotos de personajes)
```

## Cómo añadir las fotos de los personajes

Colocar las imágenes en `src/main/resources/imagenes/` con los siguientes nombres:

- tony_soprano.png
- carmela_soprano.png
- christopher_moltisanti.png
- paulie_walnuts.png
- silvio_dante.png
- junior_soprano.png
- bobby_baccalieri.png
- adriana_lacerva.png
- meadow_soprano.png
- aj_soprano.png
- dra_melfi.png
- janice_soprano.png
- livia_soprano.png
- johnny_sack.png
- phil_leotardo.png
- vito_spatafore.png
- ralph_cifaretto.png
- furio_giunta.png
- richie_aprile.png
- pussy_bonpensiero.png
- artie_bucco.png
- hesh_rabkin.png
- gloria_trillo.png
- rosalie_aprile.png
