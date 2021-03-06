[![Build Status](https://travis-ci.org/lucas794/algo3_proyecto_base_tp2.svg?branch=master)](https://travis-ci.org/lucas794/algo3_proyecto_base_tp2) [![codecov](https://codecov.io/gh/lucas794/algo3_proyecto_base_tp2/branch/master/graph/badge.svg)](https://codecov.io/gh/lucas794/algo3_proyecto_base_tp2)



# TP2 Algoritmos 3: AlgoBlocks

Trabajo Práctico número 2 de la materia Algoritmos y Programación III de FIUBA

## Grupo 4 | Turno Noche

* **Integrante 1** - [Matias Gonzalez](https://github.com/matias-gonz)
* **Integrante 2** - [Luz Calixto](https://github.com/ldiazcto)
* **Integrante 3** - [Lucas Torres](https://github.com/lucas794)

Corrector: [Joaquin Gomez](https://github.com/joaqogomez)

Link al informe: [Overleaf](https://www.overleaf.com/6819117356xhdwqtrmvzyr)

Link al enunciado: [Google Docs](https://docs.google.com/document/d/1mVxDk4yDnr1ck9b-jBZ9ZcSXvRVdQCUoggX72gO6PSc/edit?usp=sharing)

### Pre-requisitos

Listado de software/herramientas necesarias para el proyecto

```
java 11
maven 3.6.0
...
```

## Ejecutando las pruebas

```bash
    git clone https://github.com/lucas794/algo3_proyecto_base_tp2
    cd algo3_proyecto_base_tp2/
    mvn test
```

Este comando crea el reporte de cobertura para CI y el reporte HTML que pueden abrir de la siguiente manera:

```bash
    <browser> ./target/site/jacoco/index.html
```

## Ejecutando la aplicación

```bashbash
    mvn compile && mvn exec:java -Dexec.mainClass="edu.fiuba.algo3.vista.App"
```

## Licencia

Este repositorio está bajo la Licencia MIT

