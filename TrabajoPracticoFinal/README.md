# CienciaDatos-Java-TpFinal

## Sistema de Gestión de Vuelos

Este proyecto es un sistema de gestión de vuelos que permite a una aerolínea gestionar reservas de vuelos y pasajeros. Fue desarrollado por **Morena Caparrós**, estudiante de **Licenciatura en Ciencia de Datos, 1° Año**.

### Funcionalidades

El sistema permite realizar las siguientes acciones:

- **Ingresar un vuelo:** Agrega nuevos vuelos al sistema (máximo de 5 vuelos).
- **Reservar un vuelo:** Permite a los pasajeros hacer una reserva en uno de los vuelos disponibles.
- **Cancelar un vuelo:** Cancela una reserva de vuelo.
- **Registrar un pasajero:** Registra un nuevo pasajero en el sistema.
- **Ver vuelos disponibles:** Muestra todos los vuelos disponibles.
- **Ver reservas:** Muestra todas las reservas actuales.
- **Eliminar un pasajero:** Elimina un pasajero del sistema.
- **Salir:** Cierra la aplicación.

### Ejecución

Para ejecutar este programa, debes compilar y ejecutar el archivo `SistemaDeVuelos.java` que contiene la lógica principal del sistema. El programa utiliza clases adicionales, como:

- `Pasajero.java`: Contiene la clase para gestionar información de los pasajeros.
- `PasajeroVIP.java`: Clase que hereda de Pasajero y maneja pasajeros VIP.
- `Vuelos.java`: Clase para gestionar la información de los vuelos.
- `Registro.java`: Clase que se encarga de gestionar todas las operaciones de registro de pasajeros y vuelos.

### Cómo usar el programa

1. Al ejecutar el programa, serás recibido con un menú de opciones.
2. Selecciona una opción del menú ingresando el número correspondiente.
3. Puedes agregar vuelos, registrar pasajeros y hacer reservas fácilmente utilizando el menú interactivo.
4. El sistema tiene validaciones, como el límite de vuelos (máximo 5) y opciones para volver atrás o salir en cada parte del menú.

