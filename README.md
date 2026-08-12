# Gestion de Reservas de Padel

> Aplicacion para la gestion eficiente de reservas de canchas de padel con control de usuarios y disponibilidad en tiempo real.

---

## Autores

**Pau** & **David**

---

## Descripcion

Este proyecto ofrece una solucion practica y eficiente para organizar las reservas de canchas de padel. La aplicacion permite a los usuarios:

- Registrarse en la plataforma
- Consultar la disponibilidad de las canchas en tiempo real
- Realizar reservas de manera sencilla
- Gestionar sus reservas existentes
- Control total sobre su experiencia

---

## Tecnologias Utilizadas

| Tecnologia | Uso |
|------------|-----|
| **IntelliJ** | Entorno de desarrollo integrado (IDE) para PHP |
| **MySQL** | Base de datos relacional |
| **phpMyAdmin** | Administracion visual de la base de datos |

---

## Manual de Instrucciones

### Requisitos Previos

- Servidor ejecutandose en el puerto `8080`
- Postman instalado para probar los endpoints

---

### Instrucciones de Uso (Postman)

1. **Iniciar el Servidor**  
   Asegurate de que el servidor este ejecutandose en el puerto `8080`.

2. **Abrir Postman**  
   Lanza la aplicacion Postman en tu computadora.

3. **Seleccionar el Metodo HTTP**  
   Elige entre `GET` o `POST` segun la operacion que desees realizar.

4. **Introducir la URL**  
   Copia y pega la URL del endpoint correspondiente.

5. **Agregar Cuerpo de Solicitud (solo para POST)**  
   - Ve a la pestaña "Body"
   - Selecciona "raw"
   - Establece el tipo como "JSON"
   - Pega el JSON correspondiente al endpoint

6. **Enviar Solicitud**  
   Haz clic en el boton "Send" para ejecutar la solicitud.

7. **Revisar Respuestas**  
   Observa la respuesta del servidor en la seccion de respuesta de Postman. Veras:
   - Nuevo registro creado
   - Lista de usuarios o pistas
   - Mensaje de error (si corresponde)

---

## Gestion de Pistas

### Obtener todas las pistas

`GET http://localhost:8080/pistas`

**Metodo:** `GET`  
**Descripcion:** Recupera una lista de todas las pistas disponibles.

---

### Crear una nueva pista

`POST http://localhost:8080/pistas`

**Metodo:** `POST`  
**Descripcion:** Registra una nueva pista en el sistema.

**Cuerpo de la Solicitud (Ejemplo):**

`{ "nombre": "Pista 1", "ubicacion": "Complejo Deportivo A", "tipo": "Padel" }`

---

## Gestion de Usuarios

### Obtener todos los usuarios

`GET http://localhost:8080/usuarios`

**Metodo:** `GET`  
**Descripcion:** Recupera una lista de todos los usuarios registrados.

---

### Registrar un nuevo usuario

`POST http://localhost:8080/usuarios/registro`

**Metodo:** `POST`  
**Descripcion:** Crea una nueva cuenta de usuario.

**Cuerpo de la Solicitud (Ejemplo):**

`{ "nombre": "Pau", "email": "Pau@example.com", "password": "contraseña123" }`

---

## Gestion de Reservas

### Obtener reservas por pista y fecha

`GET http://localhost:8080/reservas/pista/Pista 2?fecha=2024-10-10`

**Metodo:** `GET`  
**Descripcion:** Recupera las reservas de una pista especifica en una fecha determinada.

**Parametros:**
- `pista`: Nombre de la pista (en la URL)
- `fecha`: Fecha en formato `YYYY-MM-DD` (como query parameter)

---

## Notas Adicionales

- Todos los endpoints devuelven respuestas en formato **JSON**
- Asegurate de enviar el `Content-Type: application/json` en las solicitudes POST
- Los codigos de estado HTTP indican el resultado de la operacion:
  - `200 OK` → Solicitud exitosa
  - `201 Created` → Recurso creado correctamente
  - `400 Bad Request` → Error en la solicitud
  - `404 Not Found` → Recurso no encontrado

---

## Licencia

Este proyecto es de uso educativo y esta desarrollado con fines de aprendizaje.

---

**Gracias por usar nuestra aplicacion de reservas de padel!**
