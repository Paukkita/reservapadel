Entra en /code para leer el Read.me correctamente:
Proyecto: Gestión de Reservas de Pádel
----------------------------------------------------------------------------------------
Autores: Pau y David

Descripción: Este proyecto ofrece una solución práctica y eficiente para organizar las reservas de canchas de pádel. La aplicación permite a los usuarios registrarse, consultar la disponibilidad de las canchas en tiempo real y realizar reservas de manera sencilla. Además, los usuarios pueden gestionar sus reservas existentes, lo que les proporciona un control total sobre su experiencia.

Tecnologías Utilizadas:

Backend: IntelliJ (como entorno de desarrollo integrado para PHP)
Base de datos: MySQL (accedido a través de phpMyAdmin)

----------------------------------------------------------------------------------------
Manual de instrucciones del proyecto: 
Instrucciones de Uso:

1- Iniciar el Servidor: Asegúrate de que el servidor esté ejecutándose en el puerto 8080.
2.- Abrir Postman: Lanza la aplicación Postman en tu computadora.
3.- Seleccionar el Método HTTP: Escoge el método correspondiente (GET o POST) según la operación que deseas realizar.
4.- Introducir la URL: Copia y pega la URL del endpoint que deseas utilizar.
5.- Agregar Cuerpo de Solicitud: Para métodos POST, selecciona la pestaña “Body”, elige “raw” y establece el tipo como “JSON”. Luego, pega el JSON correspondiente.
6.-Enviar Solicitud: Haz clic en el botón “Send” para ejecutar la solicitud.
7.-Revisar Respuestas: Observa la respuesta del servidor en la sección de respuesta de Postman. Esta mostrará el resultado de tu solicitud, ya sea un nuevo registro, una lista de usuarios o pistas, o un mensaje de error.

1. Gestión de Pistas

Obtener Pistas (GET)
URL: http://localhost:8080/pistas
Método: GET
Descripción: Recupera una lista de todas las pistas disponibles.

Crear Pista (POST)
URL: http://localhost:8080/pistas
Método: POST
Cuerpo de la Solicitud(Ejemplo): 
{
  "nombre": "Pista 1",
  "ubicacion": "Complejo Deportivo A",
  "tipo": "Pádel"
}

----->
2. Gestión de Usuarios
Obtener Usuarios (GET)
URL: http://localhost:8080/usuarios
Método: GET
Descripción: Recupera una lista de todos los usuarios registrados.

Registrar Usuario (POST)
URL: http://localhost:8080/usuarios/registro
Método: POST
Cuerpo de la Solicitud(Ejemplo):
{
  "nombre": "Pau",
  "email": "Pau@example.com",
  "password": "contraseña123"
}

---->
 3.Gestion de reservas
 Obtener Reservas (GET)
 URL:http://localhost:8080/reservas/pista/Pista 2?fecha=2024-10-10
 Método: GET
Descripción: Recupera las reservas de una pista más la fecha introducida.
      
Crear Reserva (POST)
URL: http://localhost:8080/reservas
Método: POST
Cuerpo de la Solicitud:
{
  "usuarioEmail": "pau@example.com",
  "pistaNombre": "Pista 2",
  "fechaReserva": "2024-10-10",
  "horaInicio": "09:00",
  "horaFin": "10:30"
}
--------------------------------------------------------------------------------
Estado del Proyecto: Finalizado, pendiente de revisión.
