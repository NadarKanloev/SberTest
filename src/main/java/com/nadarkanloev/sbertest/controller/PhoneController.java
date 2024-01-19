package com.nadarkanloev.sbertest.controller;

import com.nadarkanloev.sbertest.model.PhoneModel;
import com.nadarkanloev.sbertest.repository.PhoneRepository;
import com.nadarkanloev.sbertest.service.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class PhoneController {
    private final PhoneService phoneService;

    @GetMapping
    public List<PhoneModel> getAllPhones(){
        return phoneService.getAllPhones();
    }
    @GetMapping("{id}")
    public PhoneModel getPhoneById(@PathVariable Long id){
        return phoneService.getPhoneById(id);
    }
    @PostMapping
    public PhoneModel createNewPhone(@RequestBody PhoneModel phoneModel){
        return phoneService.createNewPhone(phoneModel);
    }
    @PutMapping("/{id}")
    public PhoneModel update(@PathVariable Long id, @RequestBody PhoneModel updatedPhone){
        return phoneService.updatePhone(id, updatedPhone);
    }
    @DeleteMapping("/{id}")
    public void deletePhone(@PathVariable Long id){
        phoneService.deletePhone(id);
    }
}
