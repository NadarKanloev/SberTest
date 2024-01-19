package com.nadarkanloev.sbertest.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "phones")
@NoArgsConstructor
public class PhoneModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private int yearOfRelease;
    @Column
    private String companyName;
    @Column
    private String modelName;
    @Column
    private int resolution;
    @Column
    private int memory;
    @Column
    private String processor;
}
