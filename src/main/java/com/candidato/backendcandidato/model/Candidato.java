package com.candidato.backendcandidato.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="candidato")
public class Candidato {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private Long id;

    @Column
    @Getter @Setter
    private String nombre;

    @Column
    @Getter @Setter
    private Date entrevista;

    @Column
    @Getter @Setter
    private Boolean tecnologiaJava;

    @Column
    @Getter @Setter
    private Boolean tecnologiaMicroservicios;

    @Column
    @Getter @Setter
    private Boolean tecnologiaElastic;

    public Candidato() {
    }

    public Candidato(Long id, String nombre, Date entrevista, Boolean tecnologiaJava, Boolean tecnologiaMicroservicios, Boolean tecnologiaElastic) {
        this.id = id;
        this.nombre = nombre;
        this.entrevista = entrevista;
        this.tecnologiaJava = tecnologiaJava;
        this.tecnologiaMicroservicios = tecnologiaMicroservicios;
        this.tecnologiaElastic = tecnologiaElastic;
    }
}
