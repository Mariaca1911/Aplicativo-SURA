📌 Descripción del aplicativo 

El código implementa un microservicio de clientes para el Sistema de Asesores de SURA, donde: 

- Permite registrar clientes mediante un formulario.

- Guarda la información en una base de datos H2 en memoria utilizando Spring Data JPA.

- Tiene un controlador (ClienteController) que expone endpoints REST (/clientes) para crear, consultar y actualizar clientes.

- Incluye una interfaz web sencilla para registrar clientes y una tabla para listarlos.

📌 Pasos para correr el proyecto
1. Verifica que tengas instalado

- Java JDK 17 (o la versión compatible que configuraste).

- Maven (si lo usas para compilar).

- Un IDE (IntelliJ, Eclipse o VS Code con extensión Java) o bien la terminal.

2. Clona o abre el proyecto

3. Compila y levanta la aplicación
- Con Maven desde terminal: mvn spring-boot:run

4. Seguir el http que se imprime en la terminal 
