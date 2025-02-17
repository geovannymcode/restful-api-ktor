<p align="center">
  <a href="#"><img src="https://img.shields.io/badge/Ktor-3.0.2-brightgreen" alt="Ktor"></a>
  <a href="#"><img src="https://img.shields.io/badge/Kotlin-2.1.10-blue" alt="Kotlin"></a>
  <a href="#"><img src="https://img.shields.io/badge/Database-postgresql-orange" alt="Postgresql Database"></a>
  <a href="#"><img src="https://img.shields.io/badge/Exposed-DAO-red" alt="Exposed"></a>
  <a href="#"><img src="https://img.shields.io/badge/Testing-JUnit5-purple" alt="JUnit 5"></a>
  <a href="#"><img src="https://img.shields.io/badge/DI-Koin-green" alt="Koin"></a>
</p>

# Restful-API-Ktor

Este es un proyecto de una API RESTful construida con [Ktor](https://ktor.io/) y escrita en [Kotlin](https://kotlinlang.org/). Utiliza [PostgreSQL](https://www.postgresql.org/) como base de datos y [Exposed](https://github.com/JetBrains/Exposed) como ORM. La inyección de dependencias se maneja con [Koin](https://insert-koin.io/).

## 🚀 Tecnologías Utilizadas

- **Ktor**: Framework para construir aplicaciones web en Kotlin.
- **Kotlin**: Lenguaje de programación moderno y conciso.
- **PostgreSQL**: Base de datos relacional utilizada en el backend.
- **Exposed**: ORM ligero para Kotlin.
- **Koin**: Inyección de dependencias.
- **JUnit 5**: Framework de pruebas unitarias.

## 📂 Estructura del Proyecto

```
restful-api-ktor/
│── src/
│   ├── main/
│   │   ├── kotlin/
│   │   │   ├── com.geovannycode/
│   │   │   │   ├── Application.kt
│   │   │   │   ├── Routing.kt
│   │   │   │   ├── Serialization.kt
│   │   │   │   ├── routes/
│   │   │   │   ├── services/
│   │   │   │   ├── repository/
│   │   │   │   ├── datasource/
│   │   │   │   ├── entity/
│   │   │   │   ├── model/
│   │   │   │   ├── di/
│   │   ├── resources/
│   │   │   ├── application.yaml
│── build.gradle.kts
│── Dockerfile
│── README.md
```

## 🔧 Configuración y Ejecución

### 1️⃣ Clonar el Repositorio
```sh
 git clone https://github.com/geovannymcode/restful-api-ktor.git
 cd restful-api-ktor
```

### 2️⃣ Levantar PostgreSQL con Docker

```sh
docker-compose up -d
```

### 3️⃣ Ejecutar la Aplicación
```sh
./gradlew run
```

## 📌 Endpoints Disponibles

### 🔹 Obtener todos los speakers
```sh
curl --location 'http://0.0.0.0:8080/api/speakers'
```

### 🔹 Crear un nuevo speaker
```sh
curl --location 'http://0.0.0.0:8080/api/speakers' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Geovanny Mendoza",
    "country": "USA",
    "biography": "Software Engineer and Kotlin enthusiast. Speaker at various tech conferences.",
    "email": "geovanny@geovannycode.com",
    "twitterHandle": "@geovannycode"
}'
```

### 🔹 Actualizar un speaker existente
```sh
curl --location --request PUT 'http://0.0.0.0:8080/api/speakers/1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Geovanny Mendoza",
    "country": "Colombia",
    "biography": "Software Engineer and Kotlin enthusiast. Speaker at various tech conferences.",
    "email": "geovanny@geovannycode.com",
    "twitterHandle": "@geovannycode"
}'
```

## 📜 Licencia

Este proyecto está bajo la licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

---

📌 **Autor**: [Geovanny Mendoza](https://github.com/GeovannymCode)  
📌 **Sitio Web**: [geovannycode.com](https://geovannycode.com)

