package com.nadarkanloev.sbertest.service;

import com.nadarkanloev.sbertest.model.PhoneModel;
import com.nadarkanloev.sbertest.repository.PhoneRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Класс с бизнес-логикой приложения</p>
 * <p>Используется {@link AllArgsConstructor} из Lombok для генерации конструктора со всеми параметрами, который будет использоваться для Dependency Injection</p>
 * <p>Для логирования используется {@link Log4j2}</p>
 */
@Service
@AllArgsConstructor
@Log4j2
public class PhoneService {
    private final PhoneRepository phoneRepository;

    /**
     * Получает список всех записей из базы данных
     * @return Список всех телефонов
     */
    public List<PhoneModel> getAllPhones(){
        log.info("Извлечение всех телефонов из базы данных");
        List<PhoneModel> phones = phoneRepository.findAll();
        log.info("Из базы данных извлечено {} записей", phones.size());
        return phones;
    }

    /**
     * Получает запись из базы данных по ее идентификатору
     * @param id  идентификатор телефона
     * @return Телефон с указанным идентификатором
     * @throws EntityNotFoundException если телефон с указанным id не найден
     */
    public PhoneModel getPhoneById(Long id){
        PhoneModel existingPhone = phoneRepository.findPhoneModelById(id);
        if(existingPhone != null){
            log.info("Извлечен " + existingPhone.getCompanyName() + " " + existingPhone.getModelName());
            System.out.println(existingPhone.toString());
            return existingPhone;
        }else {
            throw new EntityNotFoundException("Телефон с ID " + id + "Не найден");
        }
    }

    /**
     * Создание новой записи в базе данных
     * @param phoneModel - телефон для создания новой записи
     * @return Созданный телефон
     */
    public PhoneModel createNewPhone(PhoneModel phoneModel){
        log.info("Создана новая запись в базе данных");
        return phoneRepository.save(phoneModel);
    }

    /**
     * Обновление информации о телефоне в базе данных
     * <p>Для обновления мы обновляем все поля существующего телефона на поля модели с обновленной информацией</p>
     * @param id идентификатор обновляемого телефона
     * @param updatedPhone модель с обновленной информацией
     * @return обновленную модель
     * @throws EntityNotFoundException если телефон с указанным id не найден
     */
    public PhoneModel updatePhone(Long id, PhoneModel updatedPhone){
        PhoneModel existingPhone = phoneRepository.findPhoneModelById(id);
        if(existingPhone != null){
            existingPhone.setYearOfRelease(updatedPhone.getYearOfRelease());
            existingPhone.setCompanyName(updatedPhone.getCompanyName());
            existingPhone.setModelName(updatedPhone.getModelName());
            existingPhone.setResolution(updatedPhone.getResolution());
            existingPhone.setMemory(updatedPhone.getMemory());
            existingPhone.setProcessor(updatedPhone.getProcessor());

            log.info("Девайс с ID " + id + " изменен в базе данных");
            return phoneRepository.save(existingPhone);
        }else {
            throw new EntityNotFoundException("Телефон с ID " + id + "Не найден");
        }
    }

    /**
     * <p> Удаление записи из базы данных</p>
     *
     * @param id идентификатор телефона
     * @throws EntityNotFoundException если телефон с указанным id не найден
     */
    public void deletePhone(Long id){
        PhoneModel existingPhone = phoneRepository.findPhoneModelById(id);
        if(existingPhone != null){
            log.info("Запись в базе данных удалена");
            phoneRepository.delete(existingPhone);
        }else {
            throw new EntityNotFoundException("Телефон с ID " + id + "Не найден");
        }
    }
}
