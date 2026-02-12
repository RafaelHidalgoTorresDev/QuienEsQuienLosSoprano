# Manual de Usuario - ¿Quién es Quién? (Los Soprano)

## 1. Introducción

**¿Quién es Quién?** es un juego de adivinanza para un jugador. La máquina selecciona al azar uno de los 24 personajes de la serie Los Soprano, y el jugador debe descubrir quién es haciendo preguntas de sí o no.

## 2. Requisitos del sistema

- Sistema operativo: Windows, macOS o Linux
- Java 17 o superior instalado
- Maven instalado (o usar el incluido en NetBeans/IntelliJ)

## 3. Instalación y ejecución

### Opción 1: Desde terminal
```
mvn clean compile
mvn javafx:run
```

### Opción 2: Desde NetBeans
1. Abrir la carpeta del proyecto como proyecto Maven
2. Click derecho en el proyecto → Run

### Opción 3: Desde IntelliJ
1. Abrir la carpeta del proyecto
2. Ejecutar la clase principal `QuienEsQuien.java`

## 4. Pantalla principal

Al abrir el juego verás:

- **Tablero central**: Grid de 4x6 con los 24 personajes de Los Soprano
- **Panel derecho**: Panel de preguntas con:
  - Desplegable para seleccionar pregunta
  - Botón "Preguntar"
  - Zona de respuesta
  - Contador de preguntas y personajes restantes
  - Botón "Nueva Partida"
- **Barra superior**: Título del juego y botón de Ayuda

## 5. Cómo jugar

### Paso 1: Seleccionar una pregunta
En el panel derecho, abre el desplegable y selecciona una de las 12 preguntas disponibles (por ejemplo: "¿Es hombre?", "¿Tiene pelo canoso?").

### Paso 2: Hacer la pregunta
Pulsa el botón **"🔍 Preguntar"**. La máquina responderá **SÍ** o **NO** en la zona de respuesta.

### Paso 3: Observar eliminaciones
Los personajes que no coincidan con la respuesta se oscurecerán automáticamente en el tablero. Esto te ayuda a eliminar candidatos.

### Paso 4: Repetir o adivinar
Puedes seguir haciendo preguntas para reducir candidatos, o si crees saber quién es, haz clic directamente sobre el personaje en el tablero.

### Paso 5: Resultado
- **Si aciertas**: Se muestra un mensaje de victoria con tus estadísticas (preguntas realizadas, personajes restantes).
- **Si fallas**: Se muestra quién era realmente el personaje secreto.

### Paso 6: Nueva partida
Pulsa **"🔄 Nueva Partida"** para empezar de nuevo con un personaje secreto diferente.

## 6. Lista de preguntas disponibles

| Nº | Pregunta |
|----|----------|
| 1  | ¿Es hombre? |
| 2  | ¿Tiene pelo castaño o negro? |
| 3  | ¿Tiene pelo rubio? |
| 4  | ¿Tiene pelo canoso o blanco? |
| 5  | ¿Es calvo o tiene poco pelo? |
| 6  | ¿Usa gafas? |
| 7  | ¿Es corpulento o gordo? |
| 8  | ¿Es jefe o capo? |
| 9  | ¿Es de la familia Soprano? |
| 10 | ¿Tiene bigote o perilla? |
| 11 | ¿Es joven (menos de 30)? |
| 12 | ¿Usa traje elegante? |

## 7. Lista de personajes

1. Tony Soprano
2. Carmela Soprano
3. Christopher Moltisanti
4. Paulie Walnuts
5. Silvio Dante
6. Junior Soprano
7. Bobby Baccalieri
8. Adriana La Cerva
9. Meadow Soprano
10. A.J. Soprano
11. Dra. Melfi
12. Janice Soprano
13. Livia Soprano
14. Johnny Sack
15. Phil Leotardo
16. Vito Spatafore
17. Ralph Cifaretto
18. Furio Giunta
19. Richie Aprile
20. Pussy Bonpensiero
21. Artie Bucco
22. Hesh Rabkin
23. Gloria Trillo
24. Rosalie Aprile

## 8. Sistema de ayuda integrado

El juego incluye un sistema de ayuda accesible desde el botón **"❓ Ayuda"** en la esquina superior derecha. La ventana de ayuda tiene 4 pestañas:

- **Cómo jugar**: Reglas e instrucciones paso a paso
- **Personajes**: Lista completa con descripciones de cada personaje
- **Preguntas**: Todas las preguntas disponibles
- **Acerca de**: Información sobre el juego y tecnologías usadas

## 9. Consejos y estrategias

- **Empieza con preguntas generales** como "¿Es hombre?" para eliminar muchos personajes de golpe (elimina ~12 de los 24).
- **Combina preguntas de aspecto** y de información para acotar rápido.
- **Fíjate en los contadores** de personajes restantes antes de arriesgarte a adivinar.
- **Si quedan 2-3 personajes**, ya puedes intentar adivinar directamente.

## 10. Solución de problemas

| Problema | Solución |
|----------|----------|
| No arranca la aplicación | Verificar que Java 17+ está instalado con `java -version` |
| Error de compilación | Ejecutar `mvn clean compile` y verificar errores |
| No se ven las imágenes | Colocar las imágenes en `src/main/resources/imagenes/` con los nombres correctos |
| Ventana demasiado pequeña | La ventana se puede redimensionar. Mínimo: 900x650 |
