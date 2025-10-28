package com.example.clinica.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="HistoriasClinicas")
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String motivoConsulta;

    @Column (nullable = false, unique = true)
    private LocalDate fechaApertura;

    @Column (nullable = false)
    private LocalDate ultimaAtualizacion;

    @Column (length = 200, nullable = false)
    private String diagnosticoPrincipal;

    @Column (length = 255, nullable = false)
    private String tratamientoIndicado;

    @Column (length = 200, nullable = false)
    private String medicamentosAcutales;

    @Column (length = 200, nullable = false)
    private String antecedentesFamiliares;

    @Column (length = 255, nullable = false)
    private String notasAdicionales;

    @Column (nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer peso;

    @OneToOne
    @JoinColumn(name = "fk_paciente", referencedColumnName = "id")
    private Paciente paciente;

    public HistoriaClinica() {
    }

    public HistoriaClinica(Integer id, String motivoConsulta, LocalDate fechaApertura, LocalDate ultimaAtualizacion, String diagnosticoPrincipal, String tratamientoIndicado, String medicamentosAcutales, String antecedentesFamiliares, String notasAdicionales, Integer peso) {
        this.id = id;
        this.motivoConsulta = motivoConsulta;
        this.fechaApertura = fechaApertura;
        this.ultimaAtualizacion = ultimaAtualizacion;
        this.diagnosticoPrincipal = diagnosticoPrincipal;
        this.tratamientoIndicado = tratamientoIndicado;
        this.medicamentosAcutales = medicamentosAcutales;
        this.antecedentesFamiliares = antecedentesFamiliares;
        this.notasAdicionales = notasAdicionales;
        this.peso = peso;
    }
}
