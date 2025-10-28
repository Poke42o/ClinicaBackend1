🏥 Proyecto: Clínica Spring Boot - Modelado de Entidades 1:1
Este proyecto estudiantil, desarrollado con Spring Boot y JPA, aborda el modelado de un dominio de clínica médica, centrándose en la creación de entidades y la correcta implementación de relaciones uno a uno (1:1), cumpliendo con los requisitos del parcial práctico de Programación Backend.

🛠️ Tecnologías y Dependencias
El proyecto fue inicializado utilizando Spring Initializr y configurado con las siguientes dependencias clave en el archivo pom.xml, asegurando la funcionalidad de persistencia, desarrollo y conectividad a bases de datos.
XML<dependencies>
    <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-devtools</artifactId>
       <scope>runtime</scope>
    </dependency>
    
    <dependency>
       <groupId>com.h2database</groupId>
       <artifactId>h2</artifactId>
       <scope>runtime</scope>
    </dependency>
    <dependency>
       <groupId>com.mysql</groupId>
       <artifactId>mysql-connector-j</artifactId>
       <scope>runtime</scope>
    </dependency>
    
    <dependency>
       <groupId>org.projectlombok</groupId>
       <artifactId>lombok</artifactId>
       <optional>true</optional>
    </dependency>
    
    <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-test</artifactId>
       <scope>test</scope>
    </dependency>
</dependencies>
📦 Modelado de Entidades (JPA)Todas las entidades fueron creadas en el paquete com.example.clinica.modelos. Cada entidad (tabla) cuenta con un mínimo de diez atributos, incluyendo su identificador. Se utilizaron tipos de datos adecuados como String, Integer, y LocalDate para un modelado preciso del dominio.
🔑 Uso de Anotaciones JPASe implementó el mapeo Objeto-Relacional (ORM) usando las siguientes anotaciones de Jakarta Persistence API (JPA):@Entity: Marca la clase como una entidad persistente que representa una tabla en la base de datos.@Table: Especifica el nombre de la tabla en la base de datos (por ejemplo, Pacientes).@Id: Define el atributo como la clave primaria de la entidad.@GeneratedValue(strategy = GenerationType.IDENTITY): Configura la estrategia para que la base de datos se encargue de generar automáticamente los IDs.@Column: Permite refinar el mapeo de los atributos, especificando propiedades como longitud (length), unicidad (unique) y si el valor puede ser nulo (nullable).Ejemplo de Estructura de Entidad (Paciente.java)A continuación, se presenta la estructura de la clase Paciente, que ilustra la configuración de atributos y el inicio de la relación 1:1.Javapackage com.example.clinica.modelos;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (length = 50, nullable = false)
    private String nombre;
    
    // ... otros 8 atributos (apellido, fechaNacimiento, sexo, pais, etc.)
    @Column (nullable = false)
    private LocalDate fechaNacimiento;
    
    // ... otros
    
    // 🔗 Definición del Lado Inverso de la Relación 1:1
    // Indica que el mapeo es realizado por el campo 'paciente' en la entidad HistoriaClinica.
    @OneToOne(mappedBy = "paciente")
    private HistoriaClinica historiaClinica;

    // ... Constructores, Getters y Setters
}
🤝 Relaciones Uno a Uno (1:1)El objetivo principal del proyecto fue establecer y configurar dos relaciones bidireccionales uno a uno, utilizando las anotaciones @OneToOne y @JoinColumn.1. Paciente $\leftrightarrow$ HistoriaClinicaDueño de la Relación (Llave Foránea): Se estableció que la entidad HistoriaClinica es la dueña, conteniendo la llave foránea (FK) que apunta a Paciente. Esto es lógico, ya que una Historia Clínica "pertenece a" un Paciente.EntidadAnotaciónPropósitoHistoriaClinica@OneToOne y @JoinColumn(name = "paciente_id")Define la columna FK y establece el lado propietario.Paciente@OneToOne(mappedBy = "paciente")Define el lado inverso, indicando que la propiedad está mapeada por el campo paciente en la entidad HistoriaClínica.2. Medico $\leftrightarrow$ TarjetaProfesionalDueño de la Relación (Llave Foránea): Se establece que la entidad TarjetaProfesional es la dueña, conteniendo la llave foránea (FK) que apunta a Medico. Una Tarjeta Profesional existe para identificar a un Médico.EntidadAnotaciónPropósitoTarjetaProfesional@OneToOne y @JoinColumn(name = "medico_id")Define la columna FK y establece el lado propietario.Medico@OneToOne(mappedBy = "medico")Define el lado inverso, indicando que la propiedad está mapeada por el campo medico en la entidad TarjetaProfesional.▶️ Ejecución del ProyectoEl proyecto está configurado para conectarse a una base de datos (por defecto H2 en memoria, o MySQL según la configuración de application.properties).Para levantar la aplicación y permitir que JPA cree automáticamente el esquema de la base de datos (si está configurado con ddl-auto: create), simplemente ejecute la clase principal:Bashcom.example.clinica.ClinicaSpringBootApellidosApplication
