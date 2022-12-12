# Proyecto-Semestral-Programacion-II

- [Proyecto-Semestral-Programacion-II](#proyecto-semestral-programacion-ii)
  - [Grupo Nro. 3](#grupo-nro-3)
  - [Enunciado Tema 6: Mesa de pool](#enunciado-tema-6-mesa-de-pool)
  - [Diagrama UML](#diagrama-uml)
  - [Diagrama de casos de uso](#diagrama-de-casos-de-uso)
  - [Lista y justificación de los patrones utilizados](#lista-y-justificación-de-los-patrones-utilizados)
  - [Captura de pantalla de la interfaz](#captura-de-pantalla-de-la-interfaz)
  - [Decisiones de desarrollo](#decisiones-de-desarrollo)
  - [Problemas de desarollo](#problemas-de-desarollo)

## Grupo Nro. 3

- [@PabloSanhueza1](https://github.com/PabloSanhueza1) Pablo Sanhueza Yévenes
- [@TheAmazingLife](https://github.com/TheAmazingLife) Joaquin San Martín Vargas
- [@Kano10](https://github.com/Kano10) Luciano Argomedo Solis

## Enunciado Tema 6: Mesa de pool

  En el panel central, con vista aérea, deben aparecer bolas en posiciones randómicas, una blanca y otras de color. El taco debe aparecer automáticamente apuntando a la bola blanca y debe ser manejado con troles GUI (teclado y mouse), para golpear bola blanca. Las bolas deben tener la física de impactos, inercia y roce.  En las esquinas debe haber troneras donde pueden caer. La cantidad de bolas debe ser definible por interfaz GUI. Habrá bandas para rebote de las bolas y si caen en las troneras, otorgan puntos.  Reiniciar se debe hacer por controles GUI. Si se cae la bola de color y la blanca no hay puntaje, si cae la blanca se resta puntaje.

## Diagrama UML

<p align = "center">
  <img src = "https://github.com/TheAmazingLife/Proyecto-Semestral-Programacion-II/blob/main/assets/UML.jpeg" />
</p>

## Diagrama de casos de uso

<p align = "center">
  <img src = "https://github.com/TheAmazingLife/Proyecto-Semestral-Programacion-II/blob/main/assets/Diagrama_casos_de_uso.jpeg" />
</p>

## Lista y justificación de los patrones utilizados

**Patron Holder** El patron mas utilizado y mas util usado en el proyecto, fue el patron Holder, debido a su manejo de datos entre clases y poder hacer una comunicacion efectiva entre objetos no relacionados, la utilizacion de este patron en nuestro trabajo fue el intercambio de valores entre las ventanas del juego, un ejemplo claro de este intercambio la definicion de valores entre la mesa de juego y la barra inferior, intercambiando puntaje y numero de bolas, ademas la utilizacion del patron Holder para intercambiar la cantidad de bolas elegidas por el usuario en el menu inicial y el resto del juego.

## Captura de pantalla de la interfaz

<p align = "center">
  <img src = "https://github.com/TheAmazingLife/Proyecto-Semestral-Programacion-II/blob/main/assets/menuImagen.png" />
</p>

<p align = "center">
  <img src = "https://github.com/TheAmazingLife/Proyecto-Semestral-Programacion-II/blob/main/assets/juegoImagen.png" />
</p>

## Decisiones de desarrollo

En el transcurso del desarollo del proyecto se presentaron diversas problematicas que relentizaron nuestro desarrollo, por lo cual separamos el proyecto en pequeños splits donde se dialogaba, sociabilizaba y planteaban retos en un rango determinado de tiempo, haciendo una estructura desarrollo. Entre las tareas otorgadas se encontraban la actualizacion del UML, formateo del codigo, y dentro del codigo, tareas como la optimizacion del codigo, facilitando su lectura, escritura de codigo limpia DRY (Dont Repeat Yourself) y en especial un codigo mantenible en el tiempo, el cual pueda ser optimizado y usado sin mayor dificultad en un futuro.

En el transcurso del desarrollo evidenciamos fortalezas y debilidades, las cuales aprovechamos a nuestro favor para hacer un desarrollo mas pleno, dividiendo nuestras habilidades y priorizando nuestras tareas en tareas de menor dificultad.

## Problemas de desarollo

- **Falta de tiempo**, debido a la alta carga academica de las demas asiganturas universitarias, nos hemos visto en una reduccion de tiempo considerable para el desarollo, el cual relentiza el avance split a split. Tiempo el cual es invertido no solamente en codear si no que tambien en el aprendizaje de nuevas metodologias como patrones, algoritmos, funciones, lo cual intensifica y exige mucho mas tiempo del estimado.
- **Dificultad de desarrollo** Debido a la escazes de tiempo como equipo nos hemos visto en una inmensa dificultad al momento de desarrollar, ya que al no tener un rango de trabajo muy extenso, y debido a especialmente a nuestra inexpertiz en el desarollo de este tipo de applicaciones, la puesta en marcha de ideas planteadas, de tareas de Split, etc, se vio un incremento considerable de tiempo, tiempo el cual es un recurso muy preciado en el desarollo de un proyeto como fue este.

Gracias a este trabajo, hemos podido adquirir habilidades como el desarollo de problemas complejos, el trabajo en equipo mediante a delegacion de tareas y mucho contenido antes no estudiado, podiendo aprenderlo en la practica, al poner el proyecto en marcha.
