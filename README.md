## Práctica de spring boot usando intellij idea y java11

### iniciando proyecto
* se puede iniciar con Spring Initializr https://start.spring.io/
* cuando se crea un proyecto normalmente se usan librerias de terceros.
#### Maven - Gradle
* También son librerias del proyecto pero estos nos permiten descargar otras librerias para compartir más facilmente.
* Ambos son bastante buenos.
* Gradle suele ser un poco más rápido y está un poco mas optimizado.

#### creando proyecto Spring Initializr
* Project      = Maven
* lenguage     = Java
* Spring Boot  = 2.5.2
* Group        = com.cursojava
* Artifact     = curso
* Name         = curso
* Description  = Demo project for Spring Boot
* Package name = com.cursojava.curso
* Packaging    = War
* Add dependencies:
* Spring web
* GENERATE

#### Download and install Maven
* apache-maven-3.8.1-bin.zip
* descomprimir en c://
* agregar en variable de entorno
* system variables -> New... -> variable name = MAVEN_HOME -> VARIABLE VALUE = C:/maven
* editar PATH -> new -> %MAVEN_HOME%\bin

#### install jdk
* jdk oracle -> jdk-16-0-2_windows
* añadir a variable de entorno -> New... -> JAVA_HOME -> c:\Program Files\Java\jdk-16.0.2
* editar PATH -> new -> %JAVA_HOME%\BIN

### Intellij IDEA
* abrir proecto
* descargar recursos
* en pom.xml tenemos la estructura principal del proyecto 
* las dependencias se descargan automaticamente, de igual forma aquí podemos añadir más.
* en src tenemos todo nuestro código fuente

### notas
* las anotaciones van con el simbolo de @ se usan para indicar alguna funcionalidad y tambien para las funciones.
* dentro de src\main\resources\static vamos a poner los archivos publicos que podran acceder los usuarios.
* los controllers sirven principalmente para controlar/manejar nuestras direcciones de url -> usar @RestController
* @RequestMapping(value = 'prueba') para indicar la url para devoler el contenido
#### DAO
* hace referencia a data access object, aqui van todas las clases que harán las conección a la base de datos y cada clase va a representar una tabla.
* básicamente una interface es como un archivo en la que indicamos que funciones debe tener una clase, si una clase implementa un interface está obligado a usar esas funciones, sino las usa no se podrá compilar. entre otras funcionalidades.
* @Transactional le da la funcionalidad a la clase de poder armar las consultas de sql a la base de datos.
* @Repository hace referencia a la conexion con la base de datos. que puede acceder al repositorio de la base de datos.
#### Maven lombok

#### Inyección de dependencias 
* se trata de de un patrón usado en el diseño orientado a objetos de una aplicación, tiene como finalidad manterner los componentes o capas de una aplicación lo mas desacopladas posible.

#### configuración de la base de datos
* se debe registrar la configuración en src->main->resources->application.properties

### TODO:
* Spring Security
* control de erroes: ej. 401 = autorization
* cerrar sesión
* editar usuarios
