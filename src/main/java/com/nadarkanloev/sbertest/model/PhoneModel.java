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

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public int getYearOfRelease(){
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease){
        this.yearOfRelease = yearOfRelease;
    }

    public String getCompanyName(){
        return companyName;
    }

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public String getModelName(){
        return modelName;
    }

    public void setModelName(String modelName){
        this.modelName = modelName;
    }

    public int getResolution(){
        return resolution;
    }

    public void setResolution(int resolution){
        this.resolution = resolution;
    }

    public int getMemory(){
        return memory;
    }

    public void setMemory(int memory){
        this.memory = memory;
    }

    public String getProcessor(){
        return processor;
    }

    public void setProcessor(String processor){
        this.processor = processor;
    }
}
