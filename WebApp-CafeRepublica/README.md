<<<<<<< HEAD
=======
# 📦 Proyecto:Gestor para la cadena de mini-market Tienda-Ya! - Grupo 8

### Descripción del Proyecto
Este proyecto es un sistema de gestión de inventario desarrollado para **resolver los desafíos de TiendaYa en la gestión de inventarios**. La empresa enfrenta problemas críticos debido a la dependencia de métodos tradicionales que resultan en errores humanos, falta de visibilidad en tiempo real y costos operativos elevados. Estos problemas generan ineficiencias, sobrecarga en el almacenamiento y una planificación inadecuada, lo que afecta directamente la rentabilidad y la satisfacción del cliente. 

Implementado en **Java** con **JSP**, **Tomcat**, y **Maven**, este sistema sigue principios de arquitectura avanzados y metodologías de desarrollo como **MVC**, **DAO**, **TDD**, y **SOLID**, asegurando una solución modular, escalable y fácil de mantener.


## 📑 Tabla de Contenidos
- [📑 Tabla de Contenidos](#-tabla-de-contenidos)
- [🎯 Características](#-características)
- [📐 Estructura y Principios de Arquitectura](#-estructura-y-principios-de-arquitectura)
- [📚 Librerías Utilizadas](#-librerías-utilizadas)
- [🔒 Consideraciones de Seguridad](#-consideraciones-de-seguridad)
- [📊 Control de Versiones y Evidencia en GitHub](#-control-de-versiones-y-evidencia-en-github)
- [🎨 Interfaces Gráficas (UI/UX)](#-interfaces-gráficas-uiux)
- [🧪 Pruebas Unitarias y de Librerías](#-pruebas-unitarias-y-de-librerías)
- [🌐 Versión en PHP + BD](#-versión-en-php--bd)
- [🚀 Instrucciones de Ejecución](#-instrucciones-de-ejecución)
- [📌 Conclusiones y Observaciones](#-conclusiones-y-observaciones)

## 🎯 Características

- **Gestión de Productos**: Agregar, editar y eliminar productos del inventario.
- **Monitoreo de Stock**: Alertas automáticas para productos con bajo stock.
- **Generación de Reportes en PDF** 📄.
- **Interfaz de Usuario Amigable**: Diseño intuitivo y fácil de usar.

## 📐 Estructura y Principios de Arquitectura

El sistema se ha desarrollado bajo una arquitectura modular que permite su escalabilidad y mantenibilidad. A continuación se describen los principios y patrones aplicados:

### Modelo-Vista-Controlador (MVC)
Cada funcionalidad se organiza en tres capas: **Modelo**, **Vista** y **Controlador**. Esta separación facilita el mantenimiento del sistema y permite una fácil escalabilidad.

### Data Access Object (DAO)
Se ha implementado el patrón DAO para encapsular la lógica de acceso a datos, permitiendo una gestión segura y eficiente de las operaciones **CRUD**.

### Principios SOLID
Se han aplicado principios de diseño **SOLID** para garantizar que el código sea modular y mantenible:
- **Responsabilidad Única (SRP)**: Cada clase tiene una única responsabilidad, ya sea de acceso a datos, lógica de negocio o interfaz.
- **Inversión de Dependencias (DIP)**: Las dependencias están abstraídas mediante interfaces, facilitando cambios en las implementaciones.

### Desarrollo Guiado por Pruebas (TDD)
El proyecto incluye pruebas unitarias para cada componente crítico, permitiendo asegurar la calidad del código y detectar errores desde las primeras fases del desarrollo.

## 📚 Librerías Utilizadas

Para optimizar la eficiencia y funcionalidad del proyecto, se han realizado pruebas de las siguientes librerías para poder evaluar su integraciòn en el proyecto:

- **Google Guava**: Para colecciones inmutables, validación de precondiciones y optimización de colecciones.
- **Apache POI**: Para la lectura y escritura de archivos **Excel**, permitiendo la generación y manipulación de reportes en el sistema.
- **Apache Commons**: Librerías de utilidades para manejo de strings, validaciones de datos y otras funciones comunes.
- **Logback**: Implementado para el registro de logs y auditorías, proporcionando una gestión segura y estructurada de eventos y errores en el sistema.

## 🔒 Consideraciones de Seguridad

Se han incorporado medidas de seguridad para el tratamiento de la información en el sistema:
- **Control de acceso y autenticación**: Restricciones en las **JSPs** y controladores para asegurar que solo los usuarios autenticados accedan a ciertas funcionalidades.
- **Gestión de excepciones**: Con **Logback**, los eventos y errores se registran sin exponer información sensible en la consola.

## 📊 Control de Versiones y Evidencia en GitHub

Todo el proyecto se ha trabajado bajo control de versiones con **Git**. Los cambios y actualizaciones están documentados en el repositorio de **GitHub**, proporcionando evidencia completa del proceso de desarrollo. Puedes acceder al repositorio [aquí]((https://github.com/s-Baez/WebApp_TiendaYa.git)).

## 🎨 Interfaces Gráficas (UI/UX)

Se han desarrollado interfaces gráficas en **JSP** que cubren el 100% del alcance funcional del proyecto. Las pantallas principales incluyen:

- **Inicio de sesión y registro de usuario**.
- **Dashboard principal**.
- [Otras pantallas y funcionalidades específicas].

## 🧪 Pruebas Unitarias y de Librerías

El proyecto incluye pruebas unitarias y de integración para garantizar su correcto funcionamiento:
- **Pruebas de funcionalidades principales (TDD)**: Validación de la lógica de negocio y los controladores.
- **Pruebas de librerías**: Tests específicos para cada librería utilizada (Guava, POI, Commons, Logback) para asegurar su correcta implementación.
  
## 🌐 Version en PhP + BD

El proyecto incluye pruebas unitarias y de integración para garantizar su correcto funcionamiento:
Además de la implementación en Java, el proyecto cuenta con una versión en PHP. Esta alternativa PHP permite su despliegue en entornos de hosting compartido o configuraciones de bajo costo, donde el stack Java puede resultar excesivo. La versión en PHP fue desarrollada para cumplir con los mismos objetivos funcionales del sistema Java, adaptando la estructura y arquitectura a las necesidades de un entorno PHP.

## 🚀 Instrucciones de Ejecución

1. Clona el repositorio:🤝
   ```bash
   git clone (https://github.com/s-Baez/WebApp_TiendaYa.git)
2. Compila y ejecuta el proyecto con Maven:
   mvn clean install
3. Despliega la aplicación en Tomcat y configura el servidor.
4. Accede a la aplicación en tu navegador:
http://localhost:8080/
📌 Conclusiones y Observaciones
Este proyecto es una implementación práctica de principios avanzados de desarrollo de software, integrando una arquitectura modular, pruebas unitarias, librerías de soporte y control de versiones. El sistema cumple con los requisitos establecidos, proporcionando una solución robusta, segura y escalable para la gestión de inventarios.

<div align="center"> <h2 style="color:white; ">¡Gracias por tu interés!</h2> <p>Para más información, consulta la documentación en el repositorio.</p> </div> ```
  [Mira este video de la version Aplicaciòn Web en YouTube](https://www.youtube.com/watch?v=YYIENkK9QYc&ab_channel=baez)
>>>>>>> 3df13f1235290191e0482df2d44295d9a9ae0e95
