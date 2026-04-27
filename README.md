# Spring Boot + Supabase

App web con Spring Boot 4.0.4 y base de datos PostgreSQL en Supabase.

## Qué hace

- API REST para alumnos, cursos y profesores
- Dashboard web en `/dashboard`
- Dashboard JSON en `/api/dashboard/resumen`

## Requisitos

- Java 17+
- IntelliJ IDEA
- Cuenta en Supabase

## Configuración

En `src/main/resources/application.properties` pon tus datos de Supabase:

```properties
spring.datasource.url=jdbc:postgresql://...pooler.supabase.com:5432/postgres?sslmode=require
spring.datasource.username=postgres.tu_project_ref
spring.datasource.password=TU_PASSWORD
```

## Ejecutar

Desde IntelliJ: **Maven → Plugins → spring-boot → spring-boot:run**

## URLs

| URL | Descripción |
|-----|-------------|
| `http://localhost:8080/dashboard` | Página web |
| `http://localhost:8080/api/dashboard/resumen` | JSON con totales |
| `http://localhost:8080/api/alumnos` | API alumnos |
| `http://localhost:8080/api/cursos` | API cursos |
| `http://localhost:8080/api/profesores` | API profesores |
