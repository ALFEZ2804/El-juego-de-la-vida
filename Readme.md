Copyright [2023] [Alberto Fernández Rodríguez]
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
either express or implied. See the License for the specific
language governing permissions and limitations under the
License.

# El juego de la vida

## Breve descripción de la aplicación
* El contenido de este repositorio permite simular el juego de la vida https://www.youtube.com/watch?v=ouipbDkwHWA
* Versión 1.0

## Intrucciones para ejecutar el programa

Se ha incluido un `makefile` que incluye las siguientes tareas:

limpiar:

```console
make limpiar
```
compilar:

```console
make compilar
```
generar el `.jar`: 

```console
make jar
```

html a partir del javadoc:

```console
make html
```

ejecutar el programa entero:

```console
make jugar
```

## Estructura del código

Tal y como se muestra en la siguiente figura
El código consta de dos clases `Tablero.java` que está en el paquete 
`dominio` que contiene el método para la simulación del juego
y la clase `Principal.java` que está en el paquete `aplicacion` 
que contiene el método que invoca al método de simulación