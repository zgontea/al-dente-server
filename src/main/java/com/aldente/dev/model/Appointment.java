package com.aldente.dev.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "appointments")
@Data
@AllArgsConstructor
@SuperBuilder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "date", unique = false, nullable = false)
    private Date date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "toothing_id", unique = false, nullable = false)
    private Toothing toothing;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id", unique = false, nullable = false)
    private Patient patient;

}
