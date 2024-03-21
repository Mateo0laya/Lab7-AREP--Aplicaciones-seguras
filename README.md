# TALLER 7APLICACIÓN DISTRIBUIDA SEGURA EN TODOS SUS FRENTES

Desarrolle una aplicación Web segura con los siguientes requerimientos:

1. Debe permitir un acceso seguro desde el browser a la aplicación. Es decir debe garantizar autenticación, autorización e integridad de usuarios.
2. Debe tener al menos dos computadores comunicacndose entre ellos y el acceso de servicios remotos debe garantizar: autenticación, autorización e integridad entre los servicios. Nadie puede invocar los servicios si no está autorizado.
3. Explique como escalaría su arquitectura de seguridad para incorporar nuevos servicios.

## Arquitectura 
La arquitectura debe tener las siguientes características.

![image](https://github.com/Mateo0laya/Lab7-AREP--Aplicaciones-seguras/assets/89365336/f3db1d21-1df3-4bdc-82c0-81916f87a90a)


1. El cliente Web debe ser un cliente asíncrono que corra en el browser.
2. La aplicación debe ser multiusuario.
3. Entrega archivos estáticos como páginas HTML.
4. Permite configurar el directorio de donde se leerán los archivos estáticos.
5. Permite leer parámetros del query  desde los programas.
6. SparkJava como framework para la aplicación web.
7. Debe ser accesible desde internet usando el servicio EC-2 de AWS.
8. La aplicación corre sobre el puerto 4567
9. El servicio corre sobre el puerto 5000.
10. Conexión HTTP segura mediante el uso de certificados.
11. Uso de usuarios funcionales en el servicio

## Diseño de la aplicación

- La aplicación usa SparkJava para correr el servidor Http.
- Desde la clase SparkServer.java se puede configurar las respuestas del servidor mediante el uso de funciones Lambda.
- En el directorio \scr\main\java\com\edu\lab7\resources\public se pueen añadir archivos estaticos como HTML, CSS, JS o imagenes.
- LoginService es la clase encargada de atender las peticiones, controlar la autenticación e invokar los servicios.
- Corre tanto en local como en cloud, asi como en servidores separados cada uno dedicado al login y service respectivamente.

# Extensión de la aplicación

- En SparkServer.java se pueden añadir nuevas funciones que se desean el servidor de respuesta
- Css para mejorar la vista de la aplicación

## Guia de inicio

Estas instrucciones le permitirán obtener una copia del proyecto en funcionamiento en su máquina local para fines de desarrollo y prueba.

### Prerrequisitos

- Java 8
- Maven
- Git
- Navegador web
- AWS EC-2

### Instalación

#### Local
Ubiquese en el directorio en donde desea descargar el repositorio

`git clone https://github.com/Mateo0laya/Lab7-AREP--Aplicaciones-seguras.git`

Cambie al directorio del repositorio

`cd  Lab7-AREP--Aplicaciones-seguras`

Compile el proyecto

`mvn clean install`

Inicie el login

`java -cp "target/classes:target/dependency/*" com.edu.lab7.servers.LoginService`

Inicie el service

`java -cp "target/classes:target/dependency/*" com.edu.lab7.servers.SparkServer`

Tenga en cuenta que si decide ejecutarlo en local debera modificar los certificados y la clase SecureURLReader.java, cambiando la dirección url por localhost:


![image](https://github.com/Mateo0laya/Lab7-AREP--Aplicaciones-seguras/assets/89365336/e977b588-e569-4ae6-88cc-9f2bbe125d1d)


#### AWS
Una vez tenga dos instancias de EC-2 en ejecución, realice la conexión de su preferencia, en mi caso estoy usando SSH.

Lo primero que debe hacer es actualizar en ambas máquinas los paquetes de instalación del sistema operativo

`sudo yum update -y`

Ahora debe instalar Java, Maven y Git

`sudo yum install java`

`sudo yum install maven`

`sudo yum install git`

Por último repita el proceso de instalación local en la respectiva instancia del EC-2 y debera ver algo a lo mostrado a continuación

![image](https://github.com/Mateo0laya/Lab7-AREP--Aplicaciones-seguras/assets/89365336/fc69b09f-0d37-488a-a1f1-cc84dc74b345)



## Probando la aplicación
A continuación encuentra un video donde se detalla las pruebas de la aplicación: https://www.youtube.com/watch?v=iKJNMm9ktP4

Para probar la aplicación lo podemos realizar con ejecución en local, o desde una instancia EC-2 de AWS, en este caso optaré por la segunda opción. Una vez con la aplicación corriendo podemos empezar con las pruebas

Desde el navegador accederemos a la dirección DNS proporcionada por AWS para nuestra instancia EC-2, es importante recordar que la aplicación corre sobre el puerto 4567. Del mismo modo debemos acceder usando el protocolo https, en mi caso la dirección es la siguiente, pero en su caso debe variar: https://https://ec2-54-210-145-243.compute-1.amazonaws.com:4567/

![image](https://github.com/Mateo0laya/Lab7-AREP--Aplicaciones-seguras/assets/89365336/8b69b4af-e2ee-4c9d-80cd-e7a626441dec)

Una vez en la página dispondremos de dos campos de texto donde podremos ingresar usuario y contraseña, recuerde hacer uso del botón submit dando click, no use la tecla enter

Si enviamos mal las credenciales debera enviar un mensaje de "Acceso Denegado":

![image](https://github.com/Mateo0laya/Lab7-AREP--Aplicaciones-seguras/assets/89365336/6f587466-ca7f-4b49-b3d4-fb00d97dc8be)

Si enviamos correctamente las credenciales deberá mostrar el siguiente mensaje:

![image](https://github.com/Mateo0laya/Lab7-AREP--Aplicaciones-seguras/assets/89365336/f5159301-1f58-4515-a5cc-43750169a524)

En caso de querer saltarse el inicio de sesión conectando directamente el service, al no detectar correctamente el login del usuario funcional nos arrojará "Acceso no autorizado":

![image](https://github.com/Mateo0laya/Lab7-AREP--Aplicaciones-seguras/assets/89365336/bbc097db-a8bb-4c89-9c32-cef0f5010cb1)


## Construido con

* [Java](https://www.java.com/es/) - The main programming language
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spark](https://sparkjava.com/) - MicroFramework Web
* [EC-2 AWS](https://aws.amazon.com/es/ec2/) - cloud Processing

## Version

Version 1.0.0.

## Autor

Mateo Olaya Garzon
