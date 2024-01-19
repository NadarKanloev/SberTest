package com.nadarkanloev.sbertest.repository;

import com.nadarkanloev.sbertest.model.PhoneModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<PhoneModel, Long> {
    List<PhoneModel> findAll();

    PhoneModel save(PhoneModel phoneModel);

    PhoneModel findPhoneModelById(Long id);

    void deleteById(Long id);

    void delete(PhoneModel phoneModel);


}
