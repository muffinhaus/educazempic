package com.colegio.backendjava.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*
 * @Entity
 * 
 * @Table(name = "notas")
 * public class Nota {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * private Long id;
 * private String materia;
 * private Double calificacion;
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "usuario_id")
 * private Usuario estudiante;
 * // constructores, getters y setters...
 * }
 */