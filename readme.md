# Proyecto de Registro de Estudiantes

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

## Descripción

Este proyecto consiste en una aplicación de registro de estudiantes que incluye una API y un cliente distribuidos en dos proyectos independientes, ambos realizados con spting cómo pŕactica final del Bootcamp de Taletnto Digital para  🇨🇱. 

La API proporciona los servicios necesarios para gestionar los datos de los estudiantes utilizando JsonWebtokens y Spring Security para validar las peticiones realizadas desde la aplicación cliente, mientras que el cliente permite a los usuarios interactuar con la aplicación a través de una interfaz web.

## Estructura del Proyecto

El proyecto está dividido en dos módulos principales:

- **API**: Implementada en Spring Boot, proporciona endpoints para la gestión de estudiantes, materias y usuarios y persistencia en una db postgres mediante JPA.
- **Cliente**: Implementado en Spring Boot con Thymeleaf, permite a los usuarios interactuar con la API a través de una interfaz web.

## Requisitos

- Java 17
- Maven 3.9.9
- PostgreSQL

## Configuración

### API

La configuración de la API se encuentra en el archivo [application.properties](estudiantes-api/src/main/resources/application.properties). Asegúrate de configurar la base de datos PostgreSQL con las credenciales adecuadas.

### Cliente

La configuración del cliente se encuentra en el archivo [application.properties](estudiantes-front/src/main/resources/application.properties).

## Ejecución

### API

Para ejecutar la API, navega al directorio `estudiantes-api` y ejecuta el siguiente comando:

```sh
./mvnw spring-boot:run