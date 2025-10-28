package com.example.clinica.modelos;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (length = 50, nullable = false)
    private String nombre;

    @Column (length = 50, nullable = false)
    private String apellido;

    @Column (nullable = false)
    private LocalDate fechaNacimiento;

    @Column (length = 20, nullable = false)
    private String sexo;

    @Column (length = 50, nullable = false)
    private String pais;

    @Column (length = 50, nullable = false)
    private String ciudad;

    @Column (length = 20, nullable = false)
    private String profesion;

    @Column (length = 50, nullable = false)
    private String estadoCivil;

    @Column (length = 50, nullable = false)
    private String direccion;

    @OneToOne (mappedBy = "medico")
    private TarjetaProfesional tarjetaProfesional;

    public Medico() {
    }

    public Medico(Integer id, String nombre, String apellido, LocalDate fechaNacimiento, String sexo, String pais, String ciudad, String profesion, String estadoCivil, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.pais = pais;
        this.ciudad = ciudad;
        this.profesion = profesion;
        this.estadoCivil = estadoCivil;
        this.direccion = direccion;
    }
}
