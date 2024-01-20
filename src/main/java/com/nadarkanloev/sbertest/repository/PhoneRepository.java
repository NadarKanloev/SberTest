package com.nadarkanloev.sbertest.repository;

import com.nadarkanloev.sbertest.model.PhoneModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p> Интерфейс репозитория для работы с сущностью {@link PhoneModel}</p>
 * <p>Использует Spring Data JPA для доступа к базе данных</p>
 * <p> Расширяет интерфейс {@link JpaRepository}</p>
 *
 */
@Repository
public interface PhoneRepository extends JpaRepository<PhoneModel, Long> {
    /**
     * Извлекает все записи из базы данных
     * @return Список всех телефонов
     */
    List<PhoneModel> findAll();

    /**
     * Сохраняет или обновляет запись телефона в базе данных
     * @param phoneModel Телефон, который нужно сохранить или обновить
     * @return Сохраненная или обновленная запись телефона
     */
    PhoneModel save(PhoneModel phoneModel);

    /**
     * Ищет телефон по идентификатору
     *
     * @param id Уникальный идентификатор телефона
     * @return Сохраненная или обновленная запись телефона
     */
    PhoneModel findPhoneModelById(Long id);

    /**
     * Удаляет запись телеона по идентификатору
     *
     * @param id Уникальный идентификатор телефона
     */
    void deleteById(Long id);

    /**
     * Удаляет запись телефона
     *
     * @param phoneModel Телефон для удаления
     */
    void delete(PhoneModel phoneModel);


}
