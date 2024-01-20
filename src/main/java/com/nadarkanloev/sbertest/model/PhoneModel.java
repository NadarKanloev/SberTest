package com.nadarkanloev.sbertest.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

/**
 *<p>Класс представляет собой модель телефона, в которой хранится информации о его характеристиках</p>
 * <p>Этот класс - сущность, которая хранится в базе данных в таблице "phones"</p>
 * <p>Используются аннотации Spring Data JPA для маппинга полей на столбцы базы данных</p>
 * <p>Используется аннотация {@link NoArgsConstructor} из Lombok, которая генерирует конструктор без аргументов</p>
 */
@Entity
@Table(name = "phones")
@NoArgsConstructor
public class PhoneModel {
    /**
     * Идентификатор телефона
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    /**
     * Год выпуска
     */
    @Column
    private int yearOfRelease;
    /**
     * Компания производителя
     */
    @Column
    private String companyName;
    /**
     * Модель
     */
    @Column
    private String modelName;
    /**
     * Разрешение экрана(по вертикали), например - 720, 1080, 1440
     */
    @Column
    private int resolution;
    /**
     * Объем памяти
     */
    @Column
    private int memory;
    /**
     * Модель процессора
     */
    @Column
    private String processor;

    /**
     * Гетеры и сеттеры всех полей
     */
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
