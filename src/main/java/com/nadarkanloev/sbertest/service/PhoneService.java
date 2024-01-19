package com.nadarkanloev.sbertest.service;

import com.nadarkanloev.sbertest.model.PhoneModel;
import com.nadarkanloev.sbertest.repository.PhoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PhoneService {
    private final PhoneRepository phoneRepository;

    public List<PhoneModel> getAllPhones(){
        return phoneRepository.findAll();
    }
    public PhoneModel getPhoneById(Long id){
        return phoneRepository.findPhoneModelById(id);
    }
    public PhoneModel createNewPhone(PhoneModel phoneModel){
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

            return phoneRepository.save(existingPhone);
        }else {
            //TODO сделать обработку случая, когда такого ID нет
            return null;
        }
    }
    public void deletePhone(Long id){
        PhoneModel existingPhone = phoneRepository.findPhoneModelById(id);
        if(existingPhone != null){
            phoneRepository.delete(existingPhone);
        }else {
            //TODO тут также обработать
        }
    }
}
