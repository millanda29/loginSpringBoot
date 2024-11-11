# Login Spring Boot Application 🚀

Este proyecto es una aplicación básica de Spring Boot que maneja el inicio de sesión y cierre de sesión utilizando Spring Security. También incluye un formulario de login y una página de inicio protegida por autenticación. Este archivo `README.md` te guiará a través del proceso de implementación y despliegue en otros dispositivos, incluyendo el uso de Docker.

## Requisitos Previos 🛠️

Antes de comenzar, asegúrate de tener instalados los siguientes componentes en tu sistema:

- **JDK 21** o superior ☕
- **Docker** (si deseas usar el contenedor Docker) 🐳
- **Git** (para clonar el repositorio) 🧑‍💻

## Instalación ⚙️

Sigue estos pasos para clonar e implementar el proyecto en tu máquina local:

### 1. Clonar el Repositorio 📂

Clona el repositorio a tu máquina local usando Git:

```bash
git clone https://github.com/millanda29/loginSpringBoot.git
cd loginSpringBoot
```

### 2. Compilar y Ejecutar la Aplicación ⚡

#### Con Maven (Si no usas Docker)

Asegúrate de tener Maven instalado en tu máquina. Puedes compilar y ejecutar la aplicación con los siguientes comandos:

```bash
mvn clean install
mvn spring-boot:run
```

Una vez que la aplicación esté en ejecución, puedes acceder a ella en `http://localhost:8080` 🌐.

#### Con Docker (Opcional) 🐋

Si prefieres ejecutar la aplicación en un contenedor Docker, sigue estos pasos:

1. Asegúrate de tener Docker instalado en tu máquina.
2. Crea una imagen Docker usando el Dockerfile proporcionado:

   ```bash
   docker build -t login-springboot .
   ```

3. Ejecuta la aplicación en un contenedor Docker:

   ```bash
   docker run -p 8080:8080 login-springboot
   ```

La aplicación estará disponible en `http://localhost:8079` 🌐.

## Uso 💻

Una vez que la aplicación esté en ejecución, puedes acceder a las siguientes páginas:

- **Página de Login**: `http://localhost:8079/login`
    - Ingresa con el usuario **`admin`** y la contraseña **`admin123`** (configurados en el `InMemoryUserDetailsManager`) 🔑.
- **Página de Inicio (Home)**: `http://localhost:8079/`
    - Después de iniciar sesión, serás redirigido a esta página, que muestra un mensaje personalizado con el nombre de usuario 👋.

## Estructura del Proyecto 📁

El proyecto está organizado de la siguiente manera:

```
login-springboot/
├── Dockerfile              # Contenedor Docker para la aplicación 🐳
├── pom.xml                 # Archivo de configuración de Maven ⚙️
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── distribuida/
│   │   │           └── loginspringboot/
│   │   │               ├── LoginController.java  # Controlador de login/logout 👨‍💻
│   │   │               ├── SecurityConfig.java  # Configuración de seguridad 🔒
│   │   │               └── LoginSpringBootApplication.java  # Clase principal de la aplicación 🚀
│   │   └── resources/
│   │       └── templates/
│   │           ├── home.html      # Vista de la página de inicio 🏠
│   │           └── login.html     # Vista del formulario de login 🔑
└── README.md               # Este archivo 📖
```

### Archivos Principales 📄

- **`LoginController.java`**: Controla las rutas de login, home y logout 🚪.
- **`SecurityConfig.java`**: Configura la seguridad de la aplicación, incluyendo el login, logout y la autenticación 🔐.
- **`login.html`**: Vista de login con un formulario para ingresar las credenciales 📝.
- **`home.html`**: Vista de la página principal después de iniciar sesión 🏡.

## Configuración Adicional ⚙️

Si deseas modificar la configuración de seguridad o los usuarios, puedes editar la clase `SecurityConfig.java` en el proyecto. Actualmente, está configurado con un usuario **`admin`** con la contraseña **`admin123`**, utilizando un `InMemoryUserDetailsManager`.

### Configuración de Usuarios 👥

Si deseas agregar más usuarios o cambiar las credenciales, modifica el método `userDetailsService()` en `SecurityConfig.java`:

```java
@Bean
public UserDetailsService userDetailsService() {
    return new InMemoryUserDetailsManager(
        User.withUsername("admin")
            .password(passwordEncoder().encode("admin123"))
            .roles("USER")
            .build(),
        User.withUsername("user")
            .password(passwordEncoder().encode("user123"))
            .roles("USER")
            .build()
    );
}
```

## Contribuciones 💡

Si deseas contribuir al proyecto, por favor sigue estos pasos:

1. Haz un fork del repositorio 🍴.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`) 🌱.
3. Realiza tus cambios y haz commit de ellos (`git commit -am 'Añadir nueva funcionalidad'`) 📝.
4. Empuja tus cambios a tu repositorio (`git push origin feature/nueva-funcionalidad`) 🚀.
5. Abre un Pull Request en el repositorio original 🔄.

## Licencia 📜

Este proyecto está licenciado bajo la **MIT License**. Consulta el archivo `LICENSE` para más detalles.
