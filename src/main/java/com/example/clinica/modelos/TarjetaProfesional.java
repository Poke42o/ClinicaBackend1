package com.example.clinica.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="TarjetasProfecionales")
public class TarjetaProfesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false, unique = true)
    private String registroProfesional;

    @Column (length = 100, nullable = false)
    private String entidadExpedidora;

    @Column (nullable = false)
    private LocalDate fechaExpedicion;

    @Column (nullable = false)
    private LocalDate fechaVencimiento;

    @Column (length = 100, nullable = false)
    private String paisExpedicion;

    @Column (name = "esta activo", nullable = false)
    private Boolean estaActivo;


    @Column (nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer añosExperiencia;

    @Column (nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer cantidadDiplomas;


    @Column (length = 100, nullable = false)
    private String especialidad;

    @OneToOne
    @JoinColumn(name = "fk_medico", referencedColumnName = "id")
    private Medico medico;

    public TarjetaProfesional() {
    }

    public TarjetaProfesional(Integer id, String registroProfesional, String entidadExpedidora, LocalDate fechaExpedicion, LocalDate fechaVencimiento, String paisExpedicion, Boolean estaActivo, Integer añosExperiencia, Integer cantidadDiplomas, String especialidad) {
        this.id = id;
        this.registroProfesional = registroProfesional;
        this.entidadExpedidora = entidadExpedidora;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaVencimiento = fechaVencimiento;
        this.paisExpedicion = paisExpedicion;
        this.estaActivo = estaActivo;
        this.añosExperiencia = añosExperiencia;
        this.cantidadDiplomas = cantidadDiplomas;
        this.especialidad = especialidad;
    }
}
