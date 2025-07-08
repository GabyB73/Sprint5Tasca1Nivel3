# 🚀 Sprint 5 · Tasca 1 · Nivel 3: API Rest Client con WebClient y Swagger (Spring Boot)

---

## 📄 Descripción

Esta aplicación es una API REST **cliente** desarrollada con Spring Boot que **consume otra API REST** (la del Nivel 2) utilizando WebClient. Permite realizar operaciones CRUD (crear, leer, actualizar y eliminar) sobre una base de datos MySQL de flores a través de llamadas HTTP a otra API.

La API utiliza Swagger para documentar los endpoints y facilitar su prueba e integración.

El modelo incluye una entidad `FlorEntity` y un DTO `FlorDTO`, que añade lógica adicional para determinar si una flor pertenece a un país de la Unión Europea (UE) o fuera de ella.

La arquitectura sigue el patrón MVC, separando responsabilidades entre controlador, servicio, repositorio y modelo de datos.

---

## 🎯 Objetivos

- Protocolo HTTP / REST.
- JPA.
- CRUD con Spring.
- MySQL.
- Swagger.

---

## 💻 Tecnologías utilizadas

- **Java 17**
- **Spring Boot** (última versión estable)
- **Maven** (gestor de dependencias)
- **IntelliJ IDEA**
- **MySQL Workbench**
- **Swagger**

---

## 📋 Requisitos

- Java JDK 17 instalado
- Maven instalado y configurado en el sistema
- IntelliJ IDEA o Eclipse
- MySQL Drivers
- Navegador web moderno (para acceder a la interfaz Swagger)

---

## 📁 Estructura del proyecto

```bash
S05T01N03BustamanteGabriela/
├── .idea/
├── .mvn/
├── screenshots/
│   ├── add_flor_client.png
│   ├── delete_flor_client.png
│   ├── get_all_flores_client.png
│   ├── get_one_flor_client.png
│   ├── mysql_flordb_table_after_update_client.png
│   └── update_flor_client.png
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── cat/itacademy/barcelonactiva/bustamante/gabriela/s05/t01/n03/S05T01N03BustamanteGabriela/
│   │   │       ├── config/
│   │   │       │   └── WebClientConfig.java
│   │   │       ├── controller/
│   │   │       │   └── FlorController.java
│   │   │       ├── exception/
│   │   │       │   ├── FlorNotFoundException.java
│   │   │       │   └── GlobalExceptionHandler.java
│   │   │       ├── model/
│   │   │       │   ├── domain/
│   │   │       │   │   └── Flor.java
│   │   │       │   └── dto/
│   │   │       │       └── FlorDto.java
│   │   │       ├── repository/
│   │   │       │   └── FlorRepositorio.java
│   │   │       ├── services/
│   │   │       │   ├── FlorServicio.java
│   │   │       │   └── FlorServicioImpl.java
│   │   │       └── S05T01N03BustamanteGabrielaApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── cat/itacademy/barcelonactiva/bustamante/gabriela/s05/t01/n03/S05T01N03BustamanteGabriela/
│               └── S05T01N03BustamanteGabrielaApplicationTests.java
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

---

## 🚀 Funcionalidades de la API

- ➕ **POST** `/flor/add`  
  Crea una nueva flor.
- ✏️ **PUT** `/flor/update/{id}`  
  Actualiza una flor existente por su ID.
- ❌ **DELETE** `/flor/delete/{id}`  
  Elimina una flor por su ID.
- 🔍 **GET** `/flor/getOne/{id}`  
  Obtiene una flor por ID.
- 📋 **GET** `/flor/getAll`  
  Lista todas las flores.


---

## 🧰 Comandos Maven importantes

Desde la terminal, en el directorio del proyecto, se pueden ejecutar:

- `mvn compile` — Compila el proyecto
- `mvn package` — Empaqueta el proyecto
- `mvn clean` — Limpia los archivos compilados
- `mvn spring-boot:run` — Ejecuta la aplicación Spring Boot

---
## 🛠️ Instalación

1. Clona el repositorio:  
   `git clone https://github.com/GabyB73/Sprint5Tasca1Nivel3.git`
2. Abre el proyecto en IntelliJ o Eclipse.
3. Verifica que el archivo `pom.xml` está presente y correctamente configurado.
4. Asegúrate de tener una base de datos MySQL en ejecución.
5. Crea la base de datos si no existe (nombre según el `application.properties`).
6. Configura las credenciales de conexión a MySQL en el archivo `src/main/resources/application.properties`.
7. Ejecuta la aplicación:
   `mvn spring-boot:run`
   o desde el botón de "Run" en tu IDE.

---

## ▶️ Ejecución

### 📛 Documentación Swagger

En este caso se deben ejecutar las dos aplicaciones a la vez, la API del nivel 2 en el puerto 9001 y ésta en el puerto 9002. Puedes ejecutar ambas aplicaciones con `mvn spring-boot:run` o desde el IDE. Luego accede a la documentación interactiva en::

[http://localhost:9002/swagger-ui/index.html](http://localhost:9002/swagger-ui/index.html)
#### Endpoints disponibles

```bash
POST    http://localhost:9002/flor/add
PUT     http://localhost:9002/flor/update/{id}
DELETE  http://localhost:9002/flor/delete/{id}
GET     http://localhost:9002/flor/getOne/{id}
GET     http://localhost:9002/flor/getAll
```

Swagger permite explorar y probar todos los endpoints fácilmente, sin necesidad de herramientas externas.

---
### 📸 Capturas de pantalla

#### ➕ Añadir flor
![add_flor_client](screenshots/add_flor_client.png)

#### ✏️ Actualizar flor
![update_flor_client](screenshots/update_flor_client.png)

#### ❌ Eliminar flor
![delete_flor_client](screenshots/delete_flor_client.png)

#### 🔍 Obtener una flor
![get_one_flor_client](screenshots/get_one_flor_client.png)

#### 📋 Obtener todas las flores
![get_all_flores_client](screenshots/get_all_flores_client.png)

#### 🧪 MySQL Workbench
![mysql_flordb_table_after_update_client](screenshots/mysql_flordb_table_after_update_client.png)

---

## 📝 Notas técnicas

> **Nota sobre la documentación de Swagger**: En los métodos POST y PUT aparece el campo `pk_FlorID` en el cuerpo de la petición. Esto se debe a que el controlador recibe la entidad completa `Flor` en lugar de un DTO específico. Este campo es opcional y gestionado automáticamente por la aplicación.

---

## 🔗 Recursos utilizados

1- https://bushansirgur.in/spring-responseentity-example/

2- https://howtodoinjava.com/swagger2/swagger-spring-mvc-rest-example/

---

## 🤝 Contribuciones

Este es un proyecto de práctica del bootcamp IT Academy.    
Las contribuciones no son necesarias, pero puedes hacer un fork o dejar comentarios si lo deseas.
  
---

## 👩‍💻 Autora

Desarrollado por **[Gabriela Bustamante](https://github.com/GabyB73)**  
Bootcamp de Desarrollo Java - IT Academy  

