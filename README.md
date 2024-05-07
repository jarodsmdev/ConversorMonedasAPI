# Proyecto Java de Conversión de Monedas

---

Este proyecto Java implementa un sistema de conversión de monedas utilizando la API de tipo de cambio de [ExchangeRate-API](https://www.exchangerate-api.com/). El programa permite al usuario convertir una cantidad de una moneda a otra seleccionando las monedas de origen y destino, y proporcionando el monto a convertir.

## Estructura del Proyecto

El proyecto está estructurado de la siguiente manera:

- `src/main/model/`: Contiene las clases Java relacionadas con la conversión de monedas.
- `src/main/Utils/`: Contiene la clase con utilidades para la conversión de monedas.
- `src/config.properties`: Archivo de configuración que contiene la API key y otras configuraciones.
- `src/main/Principal.java`: Clase principal para ejecutar el programa de conversión de monedas.

## Requisitos

- JDK 17 o superior.
- Gson 2.10.1

## Configuración

1. Clona el repositorio o descarga el código fuente.
2. Configura la API key en el archivo `config.properties`. (Ver instrucciones más abajo)
3. Descarga la dependencia Gson 2.10.1 y agrégala al proyecto. Puedes obtenerla desde [aquí](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.10.1).

## Uso

1. Ejecuta la aplicación.
2. Selecciona la conversión de moneda deseada según las opciones proporcionadas en el menú.
3. Ingresa el monto a convertir.
4. La aplicación mostrará el resultado de la conversión de moneda por la consola del IDE.

## Dependencias

- Gson: Utilizado para el manejo de objetos JSON en la versión 2.10.1
- HttpClient: Utilizado para realizar llamadas HTTP a la API de tipo de cambio.

## Capturas de Pantalla

## Configuración de la API Key para el Proyecto

Este proyecto utiliza una API Key para acceder a servicios externos. Sigue estos pasos para configurar correctamente la API Key y hacer que el proyecto funcione correctamente:

1. **Obtener la API Key**
    - Contacta al proveedor de la API para obtener tu propia API Key en la siguiente URL: [ExchangeRate-API](https://www.exchangerate-api.com/)
    - Copia la API Key proporcionada.

2. **Crear el archivo `config.properties`**
    - En el directorio `src/` del proyecto, crea un archivo llamado `config.properties` si no existe.
    - Abre el archivo `config.properties` con un editor de texto.

3. **Agregar la API Key al archivo `config.properties`**
    - En el archivo `config.properties`, añade la siguiente línea:
      ```
      EXCHANGE_RATE_API_KEY=<tu API Key>
      ```
      Reemplaza `<tu API Key>` con la API Key que obtuviste en el paso 1.

4. **Guardar y cerrar el archivo `config.properties`**

5. **Comprobar la configuración**
    - Abre el proyecto en tu entorno de desarrollo.
    - Ejecuta el proyecto y verifica que la API Key se está utilizando correctamente para acceder a los servicios externos.

¡Listo! Ahora el proyecto está configurado correctamente para funcionar con la API Key proporcionada.
