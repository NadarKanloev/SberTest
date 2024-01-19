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
    PhoneRepository phoneRepository;

    public List<PhoneModel> getAllPhones(){
        return phoneRepository.findAll();
    }
    public PhoneModel getPhoneById(Long id){
        return phoneRepository.findbyId(id);
    }
    public PhoneModel createNewPhone(){
        return phoneRepository.save(new PhoneModel());
    }
    public PhoneModel updatePhone(Long id, PhoneModel updatedPhone){
        PhoneModel existingPhone = phoneRepository.findbyId(id);
        if(existingPhone != null){
            return phoneRepository.save(existingPhone);
        }else {
            //TODO сделать обработку случая, когда такого ID нет
            return null;
        }
    }
    public void deletePhone(Long id){
        PhoneModel existingPhone = phoneRepository.findbyId(id);
        if(existingPhone != null){
            phoneRepository.delete(existingPhone);
        }else {
            //TODO тут также обработать
        }
    }
}
