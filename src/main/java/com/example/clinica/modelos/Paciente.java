package com.example.clinica.modelos;


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

    @Column (length = 20, nullable = false, unique = true)
    private String tipoSangre;

    @Column (length = 50, nullable = false)
    private String estadoCivil;

    @Column (length = 50, nullable = false)
    private String direccion;

    @OneToOne(mappedBy = "paciente")
    private HistoriaClinica historiaClinica;

    public Paciente() {
    }

    public Paciente(Integer id, String nombre, String apellido, LocalDate fechaNacimiento, String sexo, String pais, String ciudad, String tipoSangre, String estadoCivil, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.pais = pais;
        this.ciudad = ciudad;
        this.tipoSangre = tipoSangre;
        this.estadoCivil = estadoCivil;
        this.direccion = direccion;
    }
}
