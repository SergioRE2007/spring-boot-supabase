# Restaurante - Spring Boot + Supabase

App web de gestión de un restaurante con Spring Boot 4.0.4 y base de datos PostgreSQL en Supabase.

## Qué hace

- Gestión de chefs, categorías y platos desde formularios web
- Dashboard con el menú completo del restaurante
- API REST para chefs, categorías y platos
- Dashboard JSON con totales en `/api/dashboard/resumen`

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
| `http://localhost:8080/dashboard` | Página principal con el menú |
| `http://localhost:8080/chefs` | Listado de chefs |
| `http://localhost:8080/chefs/nuevo` | Formulario nuevo chef |
| `http://localhost:8080/categorias` | Listado de categorías |
| `http://localhost:8080/categorias/nuevo` | Formulario nueva categoría |
| `http://localhost:8080/platos` | Listado de platos |
| `http://localhost:8080/platos/nuevo` | Formulario nuevo plato |
| `http://localhost:8080/api/dashboard/resumen` | JSON con totales |
| `http://localhost:8080/api/chefs` | API chefs |
| `http://localhost:8080/api/categorias` | API categorías |
| `http://localhost:8080/api/platos` | API platos |
