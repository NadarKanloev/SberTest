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

@Service
@AllArgsConstructor
@Log4j2
public class PhoneService {
    private final PhoneRepository phoneRepository;

    public List<PhoneModel> getAllPhones(){
        log.info("Извлечение всех телефонов из базы данных");
        List<PhoneModel> phones = phoneRepository.findAll();
        log.info("Из базы данных извлечено {} записей", phones.size());
        return phones;
    }
    public PhoneModel getPhoneById(Long id){
        PhoneModel existingPhone = phoneRepository.findPhoneModelById(id);
        if(existingPhone != null){
            log.info("Извлечен " + existingPhone.getCompanyName() + " " + existingPhone.getModelName());
            return existingPhone;
        }else {
            throw new EntityNotFoundException("Телефон с ID " + id + "Не найден");
        }
    }
    public PhoneModel createNewPhone(PhoneModel phoneModel){
        log.info("Создана новая запись в базе данных");
        return phoneRepository.save(phoneModel);
    }
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
