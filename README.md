# Conversor de Divisas - Java Application

## Tabla de Contenido
1. [Descripción del Proyecto](#descripción-del-proyecto)
2. [Características](#características)
3. [Requisitos](#requisitos)
4. [Instalación](#instalación)
5. [Uso](#uso)
6. [Estructura del Proyecto](#estructura-del-proyecto)
7. [API Utilizada](#api-utilizada)
8. [Notas](#notas)
9. [Imágenes de Ejemplo](#imágenes-de-ejemplo)

## Descripción del Proyecto
Este proyecto es una aplicación de consola que permite realizar conversiones de divisas utilizando una API de tasas de cambio. El sistema permite validar códigos de divisas, realizar conversiones entre ellas, y consultar las divisas soportadas por la API.

## Características
- **Validación de códigos de divisas**: Verifica si un código de divisa es válido y está soportado por la API.
- **Conversión de divisas**: Permite convertir un monto específico entre dos divisas.
- **Consulta de divisas soportadas**: Muestra la lista de códigos de divisas soportados por la API.

## Requisitos previos
Para ejecutar esta aplicación, necesitas tener instalados:
- **Java 11** o una versión superior.
- **Acceso a Internet** para conectarse a la API de tasas de cambio.

## Estructura del Proyecto
El proyecto está organizado de la siguiente manera:

 ```plaintext
src/
├── com/alura/condivisas/
│   ├── main/
│   │   └── main.java
│   ├── modelos/
│   │   └── ApiResponseC.java
│   ├── records/
│   │   └── PairConversion.java
│   ├── services/
│   │   └── ApiERService.java
│   └── utils/
│       ├── UserInterface.java
│       └── Validator.java
 ```

## Uso
1. **Inicio de la aplicación**: Al iniciar la aplicación, se te mostrará un menú con las siguientes opciones:
    1. Validar si el código de una divisa existe.
    2. Realizar una conversión de divisas.
    3. Consultar los códigos de divisas soportados.
    4. Salir de la aplicación.

2. **Validar código de divisa**: Esta opción permite ingresar un código de divisa para verificar si es válido. El sistema mostrará el nombre de la divisa correspondiente si es soportado.

3. **Realizar conversión de divisas**: Ingresando el código de la divisa base, la divisa objetivo y el monto, se obtendrá el valor convertido según la tasa de cambio actual.

4. **Consultar códigos soportados**: Muestra una lista de todos los códigos de divisas soportados por la API.

## Ejecución
Para ejecutar la aplicación, compila el proyecto y ejecuta el archivo `main.java`.

## API Utilizada
Esta aplicación utiliza la [API de ExchangeRate](https://www.exchangerate-api.com/) para obtener las tasas de cambio y los códigos de divisas soportados.

- Endpoint de tasas de cambio: `https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/BASE_CODE/TARGET_CODE/AMOUNT`
- Endpoint de códigos de divisas: `https://v6.exchangerate-api.com/v6/YOUR-API-KEY/codes`

## Personalización
Para usar la API, debes sustituir `YOUR-API-KEY` por una clave válida en el archivo `ApiERService.java`.

```java
private static final String KEY = "e303dda9ee4fa7a1918781b5";  // Reemplaza este valor con tu propia clave
 ```
## Notas
- La API soporta una gran variedad de divisas, pero puede tener limitaciones en el número de solicitudes dependiendo del plan que se use.

## Imágenes y video de Ejemplo

A continuación se presentan algunas capturas de pantalla del proyecto:

![Imagen demostrativa 1](media/images/img-1.png)
*Menú principal - parte 1*

![Imagen demostrativa 2](media/images/img-2.png)
*Menú principal - parte 2*

[Video de demostración del proyecto](media/video/video-1.mp4)