# 🎭 ¿Quién es Quién? — Los Soprano

> *"Those who want respect, give respect."* — Tony Soprano

Juego de **¿Quién es Quién?** para un jugador, desarrollado en **JavaFX** y ambientado en la serie **Los Soprano**. La máquina elige al azar uno de los 24 personajes y tú debes descubrirlo haciendo preguntas de sí o no.

---

## 📋 Tabla de contenidos

- [Requisitos](#-requisitos)
- [Instalación y ejecución](#-instalación-y-ejecución)
- [Cómo jugar](#-cómo-jugar)
- [Preguntas disponibles](#-preguntas-disponibles)
- [Personajes](#-personajes)
- [Ayuda integrada](#-ayuda-integrada)
- [Consejos y estrategias](#-consejos-y-estrategias)
- [Estructura del proyecto](#-estructura-del-proyecto)
- [Solución de problemas](#-solución-de-problemas)

---

## ⚙️ Requisitos

| Requisito | Detalle |
|-----------|---------|
| **Java** | 17 o superior (probado con Java 21) |
| **Maven** | Incluido en NetBeans / IntelliJ |
| **SO** | Windows, macOS o Linux |

---

## 🚀 Instalación y ejecución

### Desde la terminal

```bash
mvn clean compile
mvn javafx:run
```

### Desde NetBeans

1. Abrir la carpeta del proyecto como proyecto Maven
2. Click derecho en el proyecto → **Run**

### Desde IntelliJ IDEA

1. Abrir la carpeta del proyecto
2. Ejecutar la clase principal `quienesquien.QuienEsQuien`

---

## 🎮 Cómo jugar

### Pantalla principal

Al abrir el juego verás:

- **🃏 Tablero central** — Grid de 4×6 con los 24 personajes
- **📋 Panel derecho** — Panel de preguntas con desplegable, botón "Preguntar", zona de respuesta, contadores y botón "Nueva Partida"
- **🔝 Barra superior** — Título del juego y botón de Ayuda

### Paso a paso

| Paso | Acción |
|:----:|--------|
| **1** | **Selecciona una pregunta** del desplegable en el panel derecho |
| **2** | Pulsa **"🔍 Preguntar"** — la máquina responderá **SÍ** o **NO** |
| **3** | Los personajes que no coincidan se **oscurecen** automáticamente |
| **4** | Sigue preguntando o, si crees saber quién es, **haz clic sobre el personaje** |
| **5** | **¿Acertaste?** → 🎉 Victoria con estadísticas · **¿Fallaste?** → Se revela el personaje secreto |
| **6** | Pulsa **"🔄 Nueva Partida"** para jugar de nuevo |

---

## ❓ Preguntas disponibles

| Nº | Pregunta |
|:--:|----------|
| 1 | ¿Es hombre? |
| 2 | ¿Tiene pelo castaño o negro? |
| 3 | ¿Tiene pelo rubio? |
| 4 | ¿Tiene pelo canoso o blanco? |
| 5 | ¿Es calvo o tiene poco pelo? |
| 6 | ¿Usa gafas? |
| 7 | ¿Es corpulento o gordo? |
| 8 | ¿Es jefe o capo? |
| 9 | ¿Es de la familia Soprano? |
| 10 | ¿Tiene bigote o perilla? |
| 11 | ¿Es joven (menos de 30)? |
| 12 | ¿Usa traje elegante? |

---

## 🎬 Personajes

<table>
<tr>
<td>1. Tony Soprano</td>
<td>2. Carmela Soprano</td>
<td>3. Christopher Moltisanti</td>
<td>4. Paulie Walnuts</td>
</tr>
<tr>
<td>5. Silvio Dante</td>
<td>6. Junior Soprano</td>
<td>7. Bobby Baccalieri</td>
<td>8. Adriana La Cerva</td>
</tr>
<tr>
<td>9. Meadow Soprano</td>
<td>10. A.J. Soprano</td>
<td>11. Dra. Melfi</td>
<td>12. Janice Soprano</td>
</tr>
<tr>
<td>13. Livia Soprano</td>
<td>14. Johnny Sack</td>
<td>15. Phil Leotardo</td>
<td>16. Vito Spatafore</td>
</tr>
<tr>
<td>17. Ralph Cifaretto</td>
<td>18. Furio Giunta</td>
<td>19. Richie Aprile</td>
<td>20. Pussy Bonpensiero</td>
</tr>
<tr>
<td>21. Artie Bucco</td>
<td>22. Hesh Rabkin</td>
<td>23. Gloria Trillo</td>
<td>24. Rosalie Aprile</td>
</tr>
</table>

---

## 📖 Ayuda integrada

El juego incluye un sistema de ayuda accesible desde el botón **"❓ Ayuda"** en la esquina superior derecha. La ventana de ayuda tiene 4 pestañas:

| Pestaña | Contenido |
|---------|-----------|
| **Cómo jugar** | Reglas e instrucciones paso a paso |
| **Personajes** | Lista completa con descripciones |
| **Preguntas** | Todas las preguntas disponibles |
| **Acerca de** | Información sobre el juego y tecnologías |

---

## 💡 Consejos y estrategias

- 🎯 **Empieza con preguntas generales** como *"¿Es hombre?"* para eliminar ~12 personajes de golpe
- 🔀 **Combina preguntas de aspecto** con preguntas de información para acotar rápido
- 📊 **Fíjate en los contadores** de personajes restantes antes de arriesgarte
- ✅ **Si quedan 2-3 personajes**, ya puedes intentar adivinar directamente

---

## 📁 Estructura del proyecto

```
src/main/java/
├── quienesquien/
│   ├── Main.java                    (Punto de entrada)
│   └── QuienEsQuien.java           (Clase principal JavaFX)
├── Controlador/
│   ├── JuegoController.java        (Controlador del juego)
│   ├── AyudaController.java        (Controlador de la ayuda)
│   └── MotorJuego.java             (Motor de juego)
└── Modelo/
    ├── Personaje.java               (Modelo de personaje)
    ├── Pregunta.java                (Modelo de pregunta)
    └── FabricaPersonajes.java       (Fábrica de personajes)

src/main/resources/
├── Vista/
│   ├── Juego.fxml                   (Vista principal)
│   ├── Ayuda.fxml                   (Vista de ayuda)
│   └── estiloJuego.css              (Estilos CSS)
└── imagenes/                        (Fotos de personajes)
```

---

## 🛠️ Solución de problemas

| Problema | Solución |
|----------|----------|
| No arranca la aplicación | Verificar que Java 17+ está instalado con `java -version` |
| Error de compilación | Ejecutar `mvn clean compile` y verificar errores |
| No se ven las imágenes | Colocar las imágenes en `src/main/resources/imagenes/` con los nombres correctos |
| Ventana demasiado pequeña | La ventana se puede redimensionar. Mínimo: 900×650 |

---

## 🛠️ Tecnologías

- **Java 17** + **JavaFX**
- **Maven** (gestión de dependencias y compilación)
- **FXML** + **CSS** (interfaz de usuario)

---

<p align="center">
  <i>Desarrollado con ☕ y 🎬</i>
</p>