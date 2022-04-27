package com.aldente.dev.model;

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
@Table(name = "toothings")
@Data
@AllArgsConstructor
@SuperBuilder
public class Toothing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "toothing_id", unique = true, nullable = false)
    private Long id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id", unique = false, nullable = false)
    private Patient patient;

    @Column(name = "ul1", nullable = false)
    private Tooth ul1;
    @Column(name = "ul2", nullable = false)
    private Tooth ul2;
    @Column(name = "ul3", nullable = false)
    private Tooth ul3;
    @Column(name = "ul4", nullable = false)
    private Tooth ul4;
    @Column(name = "ul5", nullable = false)
    private Tooth ul5;
    @Column(name = "ul6", nullable = false)
    private Tooth ul6;
    @Column(name = "ul7", nullable = false)
    private Tooth ul7;
    @Column(name = "ul8", nullable = false)
    private Tooth ul8;

    @Column(name = "ll1", nullable = false)
    private Tooth ll1;
    @Column(name = "ll2", nullable = false)
    private Tooth ll2;
    @Column(name = "ll3", nullable = false)
    private Tooth ll3;
    @Column(name = "ll4", nullable = false)
    private Tooth ll4;
    @Column(name = "ll5", nullable = false)
    private Tooth ll5;
    @Column(name = "ll6", nullable = false)
    private Tooth ll6;
    @Column(name = "ll7", nullable = false)
    private Tooth ll7;
    @Column(name = "ll8", nullable = false)
    private Tooth ll8;


    @Column(name = "ur1", nullable = false)
    private Tooth ur1;
    @Column(name = "ur2", nullable = false)
    private Tooth ur2;
    @Column(name = "ur3", nullable = false)
    private Tooth ur3;
    @Column(name = "ur4", nullable = false)
    private Tooth ur4;
    @Column(name = "ur5", nullable = false)
    private Tooth ur5;
    @Column(name = "ur6", nullable = false)
    private Tooth ur6;
    @Column(name = "ur7", nullable = false)
    private Tooth ur7;
    @Column(name = "ur8", nullable = false)
    private Tooth ur8;


    @Column(name = "lr1", nullable = false)
    private Tooth lr1;
    @Column(name = "lr2", nullable = false)
    private Tooth lr2;
    @Column(name = "lr3", nullable = false)
    private Tooth lr3;
    @Column(name = "lr4", nullable = false)
    private Tooth lr4;
    @Column(name = "lr5", nullable = false)
    private Tooth lr5;
    @Column(name = "lr6", nullable = false)
    private Tooth lr6;
    @Column(name = "lr7", nullable = false)
    private Tooth lr7;
    @Column(name = "lr8", nullable = false)
    private Tooth lr8;


    
    private enum Tooth {
        EMPTY, HEALTHY, TARTAR, TOBEREMOVED, CARIES, CAVITY, CURED, FILLING, UNCUT;
    }
}