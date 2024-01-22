package com.nadarkanloev.sbertest.controller;

import com.nadarkanloev.sbertest.model.PhoneModel;
import com.nadarkanloev.sbertest.repository.PhoneRepository;
import com.nadarkanloev.sbertest.service.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.*;

/**
 *<p> Контроллер для управления записями телефонов в базе данных</p>
 * <p>Предоставляет эндопйнты для получения, создания, обновления и удаления информации о телефонах</p>
 * <p>Используется AllArgsConstructor из Lombok для генерации конструктора со всеми параметрами, который будет использоваться для Dependency Injection</p>
 *
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class PhoneController {
    private final PhoneService phoneService;

    /**
     * <p>Получение списка всех телефонов</p>
     * <p>Пример запроса : </p>
     * <pre>{@code GET http://localhost:8080/api}</pre>
     * @return Список объектов {@link PhoneModel}
     */
    @GetMapping
    public List<PhoneModel> getAllPhones(){
        return phoneService.getAllPhones();
    }

    /**
     * <p>Получение информации о телефоне по его id</p>
     * <p>Пример запроса:</p>
     * <pre>{@code GET http://localhost:8080/api/1}</pre>
     * @param id Идентификатор телефона
     * @return Объект {@link PhoneModel} с информацией о телефоне
     */
    @GetMapping("{id}")
    public PhoneModel getPhoneById(@PathVariable Long id){
        return phoneService.getPhoneById(id);
    }

    /**
     * Создание новой записи в базе данных.
     * Пример запроса:
     * <pre>
     * {@code
     * POST http://localhost:8080/api
     * Body:
     * {
     *   "yearOfRelease": 2022,
     *   "companyName": "Samsung",
     *   "modelName": "Galaxy S21",
     *   "resolution": 1080,
     *   "memory": 128,
     *   "processor": "Exynos 2100"
     * }
     * }
     * </pre>
     *
     * @param phoneModel Объект {@link PhoneModel} с данными нового телефона
     * @return Объект {@link PhoneModel} с информацией о созданном телефоне
     */
    @PostMapping
    public PhoneModel createNewPhone(@RequestBody PhoneModel phoneModel){
        return phoneService.createNewPhone(phoneModel);
    }

    /**
     * <p>Обновление информации о телефоне по его id</p>
     * <p>Пример запроса:</p>
     * <pre>{@code PUT http://localhost:8080/api/1
     * {
     *   "yearOfRelease": 2023,
     *   "companyName": "Samsung",
     *   "modelName": "Galaxy S22",
     *   "resolution": 1440,
     *   "memory": 256,
     *   "processor": "Exynos 2200"
     * }}</pre>
     * @param id Идентификатор телефона, который требуется обновить
     * @param updatedPhone Обновленные данные телефона в виде объекта {@link PhoneModel}
     * @return объект {@link PhoneModel} с информацией об обновленной телефоне
     */
    @PutMapping("/{id}")
    public PhoneModel update(@PathVariable Long id, @RequestBody PhoneModel updatedPhone){
        return phoneService.updatePhone(id, updatedPhone);
    }

    /**
     * Удаление записи о телефоне по его id
     * <p>Пример запроса :</p>
     * <pre>{@code DELETE http://localhost:8080/api/1}</pre>
     * @param id Идентификатор телефона, который требуется удалить
     */
    @DeleteMapping("/{id}")
    public void deletePhone(@PathVariable Long id){
        phoneService.deletePhone(id);
    }
}
