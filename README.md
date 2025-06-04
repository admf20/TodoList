# 📝 TodoList
 TodoList es una aplicación web desarrollada en Java utilizando Spring Boot, que permite a los usuarios gestionar sus tareas de manera eficiente. La aplicación ofrece funcionalidades como creación, edición, eliminación y visualización de tareas pendientes.

## 🚀 Tecnologías Utilizadas
- Java 17
- Spring Boot
- Spring Security con autenticación JWT
- JPA (Hibernate) con MySQL
- MapStruct para mapeo de DTOs
- Maven como herramienta de construcción

## ⚙️ Funcionalidades
- Registro e inicio de sesión de usuarios con JWT
- Gestión de tareas: crear, editar, eliminar y listar
- Asignación de prioridades y fechas de vencimiento a las tareas
- Paginación y validación de entradas
- Manejo global de excepciones

## 🛠️ Requisitos Previos
- Java 17 o superior
- Maven 3.6 o superior
- MySQL 8.0 o superior

## 🧪 Configuración del Entorno
1. Clonar el repositorio:

```bash
git clone https://github.com/admf20/TodoList.git
cd TodoList
```
2. Configurar la base de datos:

Crea una base de datos en MySQL:

```bash
CREATE DATABASE todolist_db;
```
Actualiza el archivo application.properties con tus credenciales de base de datos:

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/todolist_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```
Construir el proyecto:

```bash
mvn clean install
```
Ejecutar la aplicación:
```bash
mvn spring-boot:run
```
- La aplicación estará disponible en http://localhost:8080.

## 📦 Estructura del Proyecto
```css
Copiar
Editar
TodoList/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── admf20/
│   │   │           └── todolist/
│   │   │               ├── controller/
│   │   │               ├── dto/
│   │   │               ├── model/
│   │   │               ├── repository/
│   │   │               ├── service/
│   │   │               └── TodoListApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   │           └── index.html
├── pom.xml
└── README.md
```
## 🔐 Seguridad
La aplicación implementa seguridad utilizando Spring Security y JWT para la autenticación y autorización de usuarios. Asegúrate de configurar correctamente las claves secretas y los filtros de seguridad según las necesidades de tu proyecto.

## 🤝 Contribuciones
¡Las contribuciones son bienvenidas! Si deseas colaborar:

1. Haz un fork del repositorio.
2. Crea una nueva rama: git checkout -b feature/nueva-funcionalidad.
3. Realiza tus cambios y haz commit: git commit -m 'Agregar nueva funcionalidad'.
4. Haz push a la rama: git push origin feature/nueva-funcionalidad.
5. Abre un Pull Request.

## 📄 Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.



